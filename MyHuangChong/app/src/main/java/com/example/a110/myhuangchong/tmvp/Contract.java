package com.example.a110.myhuangchong.tmvp;


import com.example.a110.myhuangchong.base.BaseModel;
import com.example.a110.myhuangchong.base.BasePresenter;
import com.example.a110.myhuangchong.base.BaseView;

/**
 * Created by 110 on 2018/1/3.
 */

public class Contract  {

    interface View extends BaseView {
        void show(String url);
    }

    interface Model extends BaseModel {
        void getLunData(String url, Callback callBack);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void isLunNet(String str);
    }
}