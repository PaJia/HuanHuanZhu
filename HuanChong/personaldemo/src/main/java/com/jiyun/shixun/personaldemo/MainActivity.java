package com.jiyun.shixun.personaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.iv_gr_back)
    ImageView ivGrBack;
    @Bind(R.id.ll_gr_ll2)
    LinearLayout llGrLl2;
    @Bind(R.id.ll_gr_ll3)
    LinearLayout llGrLl3;
    @Bind(R.id.ll_gr_ll4)
    LinearLayout llGrLl4;
    @Bind(R.id.ll_gr_ll5)
    LinearLayout llGrLl5;
    @Bind(R.id.ll_gr_ll6)
    LinearLayout llGrLl6;
    @Bind(R.id.ll_gr_ll7)
    LinearLayout llGrLl7;
    @Bind(R.id.ll_gr_ll8)
    LinearLayout llGrLl8;
    @Bind(R.id.ll_gr_ll9)
    LinearLayout llGrLl9;
    private PopupWindow popupWindow;
    private TextView tv_tx_text4;
    private View xingbie;
    private View touxiang;
    private TextView tv_xb_text2;
    private TextView tv_xb_text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ivGrBack.setOnClickListener(this);
        llGrLl2.setOnClickListener(this);
        llGrLl3.setOnClickListener(this);
        llGrLl4.setOnClickListener(this);
        llGrLl5.setOnClickListener(this);
        llGrLl6.setOnClickListener(this);
        llGrLl7.setOnClickListener(this);
        llGrLl8.setOnClickListener(this);
        llGrLl9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        View parent = MainActivity.this.findViewById(R.id.rl_main_rl1);
        switch (view.getId()){
            //返回上一页
            case R.id.iv_gr_back:
                finish();
                break;
            //头像
            case R.id.ll_gr_ll2:
                touxiang = LayoutInflater.from(MainActivity.this).inflate(R.layout.pupop_touxiang, null);
                tv_tx_text4 = touxiang.findViewById(R.id.tv_tx_text4);
                tv_tx_text4.setOnClickListener(this);
                popupWindow = new PopupWindow(touxiang, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
//                popupWindow.setTouchable(true);
                //对popupWindow设置背景
//                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                //外侧不可被点击
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                //显示到控件下方
                // popupWindow.showAsDropDown(tv_welcome);
                //第一个参数 View parent 父窗体对象

                //第二个参数 int gravity 子控件对于父控件的显示方式
                //第三/四个参数   int x/y 在X/Y轴上的偏移量
                popupWindow.showAtLocation(parent, Gravity.LEFT | Gravity.BOTTOM, 0, 0);
                //设置的样式,进入/退出
                //android:windowEnterAnimation
                //android:windowExitAnimation
                popupWindow.setAnimationStyle(R.style.showPopAnimation);

//                让外侧变灰
                backgroundAlpha(0.6f);
                break;
            //名称
            case R.id.ll_gr_ll3:
                Intent mc = new Intent(MainActivity.this, MingChengActivity.class);
                startActivity(mc);
                break;
            //性别
            case R.id.ll_gr_ll4:
                xingbie = LayoutInflater.from(MainActivity.this).inflate(R.layout.pupop_xingbie, null);
                tv_xb_text2 = xingbie.findViewById(R.id.tv_xb_text2);
                tv_xb_text3 = xingbie.findViewById(R.id.tv_xb_text3);
                popupWindow = new PopupWindow(xingbie, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(parent, Gravity.LEFT | Gravity.BOTTOM, 0, 0);
                popupWindow.setAnimationStyle(R.style.showPopAnimation);
                popupWindow.setAnimationStyle(R.style.showPopAnimation);
                backgroundAlpha(0.6f);
                break;
            //出生日期

            case R.id.ll_gr_ll5:
                break;
            //手机
            case R.id.ll_gr_ll6:
                break;
            //微信
            case R.id.ll_gr_ll7:
                Intent wx = new Intent(MainActivity.this, WeiXinActivity.class);
                startActivity(wx);
                break;
            //QQ
            case R.id.ll_gr_ll8:
                Intent qq = new Intent(MainActivity.this, QQActivity.class);
                startActivity(qq);
                break;
            //联系地址
            case R.id.ll_gr_ll9:
                Intent lxdz = new Intent(MainActivity.this, LianXiDiZhiActivity.class);
                startActivity(lxdz);
                break;
            //popup_touxiang取消
            case R.id.tv_tx_text4:
                // 让外侧变灰
                backgroundAlpha(1.0f);
                popupWindow.dismiss();
                break;
            //popup_xingbie男
            case R.id.tv_xb_text2:
                backgroundAlpha(1.0f);
                popupWindow.dismiss();
                break;
            //popup_xingbie女
            case R.id.tv_xb_text3:
                backgroundAlpha(1.0f);
                popupWindow.dismiss();
                break;
        }
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
}
