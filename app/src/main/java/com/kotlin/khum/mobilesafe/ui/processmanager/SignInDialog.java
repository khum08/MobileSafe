package com.kotlin.khum.mobilesafe.ui.processmanager;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.kotlin.khum.mobilesafe.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.WINDOW_SERVICE;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/8/16
 *     desc   :
 * </pre>
 */
public class SignInDialog extends DialogFragment {

    private Unbinder mBind;

    public static SignInDialog newInstance(){
        return new SignInDialog();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_FRAME, R.style.CustomInputDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_signin, container, false);
        mBind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int SCREEN_W = dm.widthPixels;
        int SCREEN_H = dm.heightPixels;
        getDialog().getWindow().setLayout(SCREEN_W * 4 / 5, SCREEN_H * 3 / 4);
    }

    private void initView() {

    }

}
