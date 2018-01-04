package com.example.a110.myhuangchong;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a110.myhuangchong.base.BaseActivity;
import com.example.a110.myhuangchong.tmvp.Model;
import com.example.a110.myhuangchong.tmvp.Presenter;
import com.example.a110.myhuangchong.ui.SetUpActivity;
import com.example.a110.myhuangchong.ui.UserActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

public class MainActivity extends BaseActivity<Presenter, Model> implements View.OnClickListener{


    @Bind(R.id.user)
    LinearLayout user;
    @Bind(R.id.information)
    LinearLayout information;
    @Bind(R.id.pet)
    LinearLayout pet;
    @Bind(R.id.order)
    LinearLayout order;
    @Bind(R.id.wallet)
    LinearLayout wallet;
    @Bind(R.id.know)
    LinearLayout know;
    @Bind(R.id.setup)
    LinearLayout setup;
    @Bind(R.id.apply)
    Button apply;
    private Context contxt;
    private ImageView image_q;
    private TextView text_name;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        user =(LinearLayout)findViewById(R.id.user);
        user.setOnClickListener(this);

        information =(LinearLayout)findViewById(R.id.information);
        information.setOnClickListener(this);

        pet =(LinearLayout)findViewById(R.id.pet);
        pet.setOnClickListener(this);

        order =(LinearLayout)findViewById(R.id.order);
        order.setOnClickListener(this);

        wallet =(LinearLayout)findViewById(R.id.wallet);
        wallet.setOnClickListener(this);

        know =(LinearLayout)findViewById(R.id.know);
        know.setOnClickListener(this);

        setup =(LinearLayout)findViewById(R.id.setup);
        setup.setOnClickListener(this);

        apply =(Button) findViewById(R.id.apply);
        apply.setOnClickListener(this);

        image_q =(ImageView) findViewById(R.id.image);
        text_name =(TextView) findViewById(R.id.name);

        String iconurl = getIntent().getStringExtra("iconurl");
        String name = getIntent().getStringExtra("name");
        text_name.setText(name);
        Picasso.with(MainActivity.this).load(iconurl).into(image_q);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            //个人
            case R.id.user:
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);

                break;
            //消息
            case R.id.information:
                Toast.makeText(this, "消息", Toast.LENGTH_SHORT).show();
                break;
            //宠物
            case R.id.pet:

                Toast.makeText(this, "宠物", Toast.LENGTH_SHORT).show();
                break;
            //订单
            case R.id.order:

                Toast.makeText(this, "订单", Toast.LENGTH_SHORT).show();
                break;

            //钱包
            case R.id.wallet:

                Toast.makeText(this, "钱包", Toast.LENGTH_SHORT).show();
                break;
            //需知
            case R.id.know:

                Toast.makeText(this, "需知", Toast.LENGTH_SHORT).show();
                break;
            //设置
            case R.id.setup:

               Intent intent1 = new Intent(MainActivity.this,SetUpActivity.class);
                startActivity(intent1);
                break;

            //申请成为寄养家庭
            case R.id.apply:
                Toast.makeText(this, "申请成为寄养家庭", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
