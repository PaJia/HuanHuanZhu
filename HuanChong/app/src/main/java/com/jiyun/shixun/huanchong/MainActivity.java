package com.jiyun.shixun.huanchong;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_tongzhi;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    String obj = (String) msg.obj;
                    //获取PendingIntent，
                    Intent mainIntent = new Intent(MainActivity.this, SecondActivity.class);
                    PendingIntent mainPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    //获取NotificationManager实例
                    NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    //实例化NotificationCompat.Builde并设置相关属性
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                            //设置小图标
                            .setSmallIcon(R.mipmap.ic_launcher)
                            //设置通知标题
                            .setContentTitle("最简单的Notification")
                            //设置通知内容
                            .setContentText(obj)
//                            .setSubText("呵呵，给我骚起来")
                            //通知提示
                            .setTicker("走过路过千万不要错多，过了这个村就没这个店了")
                            .setContentIntent(mainPendingIntent)
                            //设置通知时间，默认为系统发出通知的时间，通常不用设置
                            .setWhen(System.currentTimeMillis());
                    //通过builder.build()方法生成Notification对象,并发送通知,id=1
                    notifyManager.notify(1, builder.build());

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        btn_tongzhi = (Button) findViewById(R.id.btn_tongzhi);

        btn_tongzhi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tongzhi:

                int numcode = (int) ((Math.random() * 9 + 1) * 1000);
                Message msg = handler.obtainMessage();
                msg.what = 100;
                msg.obj = "" + numcode;
                handler.sendMessageDelayed(msg, 3000);


                break;
        }
    }
}
