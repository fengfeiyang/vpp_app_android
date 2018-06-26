package com.baotianqi.custom.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baotianqi.custom.R;


/**
 * Created by kuanglingbo on 2018/3/7.
 */

public class VpNavigationView extends RelativeLayout implements View.OnClickListener {

    public final static int NAV_TYPE_NORMAL = 0;

    public final static int NAV_TYPE_HINT = NAV_TYPE_NORMAL + 1;

    public final static int NAV_TYPE_SHOW_RIGHT = NAV_TYPE_HINT + 1;

    public final static int NAV_TYPE_ONLY_SHOW_TITLE = NAV_TYPE_SHOW_RIGHT + 1;

    private int mType = NAV_TYPE_NORMAL;

    private final Context mContext;

    private TextView mTvTitle;
    private View     mBtnLeft;
    private Button   mBtnRight;
    private CallBack mCallBack;

    public VpNavigationView (Context context) {
        super(context);
        mContext = context;
    }

    public VpNavigationView (Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public VpNavigationView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VpNavigationView (Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    @Override
    protected void onFinishInflate () {
        super.onFinishInflate();
    }

    public void initBarUi (int type, String title) {
        mType = type;
        if (mType == NAV_TYPE_HINT) {
            setVisibility(GONE);
            return;
        } else {
            setVisibility(VISIBLE);
        }

        if (mType == NAV_TYPE_NORMAL) {
            mBtnLeft = findViewById(R.id.btn_nav_left);
            mTvTitle = findViewById(R.id.tv_nav_title);
            mBtnRight = findViewById(R.id.btn_nav_right);
            mTvTitle.setText(title);

            mBtnLeft.setOnClickListener(this);
            mBtnRight.setOnClickListener(this);
            return;
        }

        if (mType == NAV_TYPE_SHOW_RIGHT) {
            mBtnLeft = findViewById(R.id.btn_nav_left);
            mTvTitle = findViewById(R.id.tv_nav_title);
            mBtnRight = findViewById(R.id.btn_nav_right);
            mBtnRight.setVisibility(VISIBLE);

            mTvTitle.setText(title);

            mBtnLeft.setOnClickListener(this);
            mBtnRight.setOnClickListener(this);
            return;
        }

        if (mType == NAV_TYPE_ONLY_SHOW_TITLE) {
            mBtnLeft = findViewById(R.id.btn_nav_left);
            mTvTitle = findViewById(R.id.tv_nav_title);
            mBtnRight = findViewById(R.id.btn_nav_right);
            mBtnRight.setVisibility(GONE);
            mBtnLeft.setVisibility(GONE);

            mTvTitle.setText(title);
        }
    }

    @Override
    public void onClick (View v) {
        final int id = v.getId();

        if (id == R.id.btn_nav_left) {
            ((Activity) mContext).finish();
            return;
        }

        if (id == R.id.btn_nav_right) {
            if (mCallBack != null) {
                mCallBack.call();
            }
            return;
        }
    }

    public void setTitle (String title) {
        if (TextUtils.isEmpty(title) || mTvTitle == null) {
            return;
        }

        mTvTitle.setText(title);
    }

    public void setBlueBg () {
//        setVisibility(GONE);
        setBackgroundColor(mContext.getResources().getColor(R.color.color_bule));
        if (mTvTitle != null) {
            mTvTitle.setTextColor(Color.WHITE);
        }
    }

    public void setBlueBgRightBtn (VpNavigationView.CallBack callBack) {
        mCallBack = callBack;
//        setVisibility(GONE);
        mBtnRight.setVisibility(View.VISIBLE);
        mBtnRight.setText("注册");
        mBtnRight.setTextColor(Color.parseColor("#1BA5FD"));
    }

    public void setNavBg () {
        setVisibility(VISIBLE);
//        setBackgroundColor(mContext.getResources().getColor(R.color.color_nav_bg));
    }

   public interface CallBack {
        abstract void call ();
    }

}
