package com.yujin.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by yujin on 16/4/6.
 */
public class BaseFragment extends Fragment {
    Bundle savedState;

    public BaseFragment() {
        super();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Restore State Here
        if (!restoreStateFromArguments()) {
            // First Time, Initialize something here
            onFirstTimeLaunched();
        }
    }

    /**
     * 当Fragment是第一次运行
     */
    protected void onFirstTimeLaunched() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save State Here
        saveStateToArguments();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Save State Here
        saveStateToArguments();
    }

    /**
     * Don't Touch !!
     * @return
     */
    private void saveStateToArguments() {
        if (getView() != null)
            savedState = saveState();
        if (savedState != null) {
            Bundle b = getArguments();
            if (b != null) {
                b.putBundle("internalSavedViewState8954201239547", savedState);
            }
        }
    }

    /**
     * Don't Touch !!
     * @return
     */
    private boolean restoreStateFromArguments() {
        Bundle b = getArguments();
        if (b != null) {
            savedState = b.getBundle("internalSavedViewState8954201239547");
        }
        if (savedState != null) {
            restoreState();
            return true;
        }
        return false;
    }

    /**
     * Restore Instance State Here
     */
    private void restoreState() {
        if (savedState != null) {
            // For Example
            //tv1.setText(savedState.getString("text"));
            onRestoreState(savedState);
        }
    }

    protected void onRestoreState(Bundle savedInstanceState) {

    }

    /**
     * Save Instance State Here
     * @return
     */
    private Bundle saveState() {
        Bundle state = new Bundle();
        // For Example
        //state.putString("text", tv1.getText().toString());
        onSaveState(state);
        return state;
    }

    protected void onSaveState(Bundle outState) {

    }
}
