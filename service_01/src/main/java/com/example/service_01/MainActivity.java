package com.example.service_01;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button mButton;
    @InjectView(R.id.button2)
    Button mButton2;
    ISevice mBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this,TestService.class);

                MyCoon coon = new MyCoon();
                bindService(intent, coon, BIND_AUTO_CREATE);
                break;
            case R.id.button2:
                mBinder.callServiceMethod("小花花", 250);
                mBinder.study();
                break;
        }
    }

    private class MyCoon implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = (ISevice) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

}
