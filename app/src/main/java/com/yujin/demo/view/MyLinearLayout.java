package com.yujin.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujin on 4/7/16.
 */
public class MyLinearLayout extends LinearLayout {
    public static final String TAG = MyLinearLayout.class.getSimpleName();

    private Context mContext;
    private int mCellWidth = 150;
    private int mCellHeight = 50;
    /**
     * 子View之间的左右间距
     */
    private int span = 10;
    public MyLinearLayout(Context context) {
        super(context, null);
        mContext = context;
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defineStyle) {
        super(context, attrs, defineStyle);

    }

    public void setmCellHeight(int mCellHeight) {
        this.mCellHeight = mCellHeight;
    }

    public void setmCellWidth(int mCellWidth) {
        this.mCellWidth = mCellWidth;
    }

    public void setSpan(int span) {
        this.span = span;
    }

    /**
     * 用来确定子View在容器中的布局,也就是位置
     * @param changed
     * @param l left坐村
     * @param t top坐标
     * @param r right坐标
     * @param b bottom坐标
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, "(" + getWidth() + "," + getHeight() + ")");
        int containerWidth = getMeasuredWidth();
        int containerHeight = getMeasuredHeight();
        int count = getChildCount();
        int x = (containerWidth - newLine(count))/2; //x轴起始坐标
        int y = 0; //y轴起始坐标
        int i = 0; //
        for (int j = 0; j < count; j++) {
            final View childView = getChildAt(j);
            // 获取子控件Child的宽高
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();
            int a = newLine(j);
            Log.i(TAG, "a:" + a);
            int left = x;
            int top = y;
            int right = left + childWidth;
            int bottom = top + childHeight;
            // 布局子控件
            Log.i(TAG, "第" + j + "个view: (" + left +","+ top +","+ right +","+ bottom +")");
            childView.layout(left + span, top, right + span, bottom);

            Log.i(TAG, (right + span) + ">=" + containerWidth);
            if ((right + childWidth) >= containerWidth) {
                i = 0;
                //x = 0;
                x = (containerWidth - newLine(count - j))/2;
                //y += cellHeight;
                y += childHeight + span;
            } else {
                i++;
                //x += cellWidth;
                x += childWidth + span;
            }
        }
    }

    /**
     * 用来计算控件以及子控件所占用的区域
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 记录ViewGroup中Child的总个数
        int count = getChildCount();
        // 设置子空间Child的宽高
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            childView.measure(childView.getWidth(), childView.getHeight());
        }
        // 设置容器控件所占区域大小
        // 注意setMeasuredDimension和resolveSize的用法
//        setMeasuredDimension(resolveSize(mCellWidth * count, widthMeasureSpec),
//                resolveSize(mCellHeight * count, heightMeasureSpec));
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

        // 不需要调用父类的方法
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     *
     * 为控件添加边框
     *
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        /*LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.toolbar, null);
        view.findViewById(R.id.viewpager);*/
    }

    /**
     * 检测是否换行
     * @param count 需要计算的子View个数
     * @return
     */
    private int newLine(int count) {
        int parentWidth = getMeasuredWidth();
        int width = 0;
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            int w = view.getMeasuredWidth();
            width += w + span;
            if (width >= parentWidth) {
                return  width - w;
            }
        }
        return width;
    }
}
