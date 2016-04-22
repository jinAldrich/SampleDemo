package com.yujin.demo;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.EditText;

import com.yujin.demo.utils.LogUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 监听短信,自动填充验证码,免去用户输入,此方式是监听数据库变化,占用资源较大,不可取
 *
 * @author: yujin on 16/4/22.
 */
public class SmsContent extends ContentObserver {

    public static final String SMS_URI_INBOX = "content://sms/inbox";
    private Activity activity = null;
    private String smsContent = "";
    private EditText verifyText = null;

    public SmsContent(Activity activity, Handler handler, EditText verifyText) {
        super(handler);
        this.activity = activity;
        this.verifyText = verifyText;
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Cursor cursor = null;
        // 读取收件箱中指定号码的短信
        // 106903022073是百代发送验证码的电话号码
        cursor = activity.managedQuery(Uri.parse(SMS_URI_INBOX), new String[]{"_id", "address", "body", "read"}, "address=? and read=?",
                new String[]{"106903022073", "0"}, "date desc");
        if (cursor != null) {// 如果短信为未读模式
            cursor.moveToFirst();
            if (cursor.moveToFirst()) {
                String smsbody = cursor.getString(cursor.getColumnIndex("body"));
                LogUtils.LOGE("smsbody: " + smsbody);
//                String regEx = "[^0-9]{4}";
//                String regEx = "^(?<!\\d)\\d{4}(?!\\d)$";
//                String regEx = "\\d{4}";
//                Pattern p = Pattern.compile(regEx);
//                Matcher m = p.matcher(smsbody.toString());
//                smsContent = m.replaceAll("").trim().toString();
                verifyText.setText(verificationCodeMatchEx(smsbody, 4));
            }
        }
    }

    /**
     * 从短信字符窜提取验证码
     * @param body 短信内容
     * @param charCount  验证码的长度 一般6位或者4位
     * @return 接取出来的验证码
     */
    public static String verificationCodeMatchEx(String body, int charCount) {
        /**
         *  ([a-zA-Z0-9]{charCount})  是得到一个连续的四位数字字母组合
         *  ([0-9]{charCount})        是得到一个连续的四位数字组合
         *  (?<![a-zA-Z0-9])          负向断言([0-9]{YZMLENGTH})前面不能有数字
         *  (?![a-zA-Z0-9])           断言([0-9]{YZMLENGTH})后面不能有数字出现
         */
        Pattern p = Pattern.compile("(?<![0-9])([0-9]{" + charCount + "})(?![0-9])");
        Matcher m = p.matcher(body);
        if (m.find()) {
            System.out.println(m.group());
            return m.group(0);
        }
        return null;
    }

    @Override
    public boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    public SmsContent(Handler handler) {
        super(handler);
    }
}
