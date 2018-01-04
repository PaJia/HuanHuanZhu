package com.jiyun.shixun.personaldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LianXiDiZhiActivity extends AppCompatActivity {

    @Bind(R.id.iv_lxdz_back)
    ImageView ivLxdzBack;
    @Bind(R.id.tv_lxdz_submit)
    TextView tvLxdzSubmit;
    @Bind(R.id.ll_lxdz_ll2)
    LinearLayout llLxdzLl2;
    @Bind(R.id.et_lxdz_edit)
    EditText etLxdzEdit;
    @Bind(R.id.ll_lxdz_ll3)
    LinearLayout llLxdzLl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lian_xi_di_zhi);
        ButterKnife.bind(this);
    }
}
