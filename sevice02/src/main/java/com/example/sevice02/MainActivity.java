package com.example.sevice02;

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

    @InjectView(R.id.onBind)
    Button mOnBind;
    @InjectView(R.id.unBind)
    Button mUnBind;
    @InjectView(R.id.startBind)
    Button mStartBind;
    @InjectView(R.id.destroyBind)
    Button mDestroyBind;
    private MyServiceConnection mCoon;
    private IService mIService;
    private Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }
  private class MyServiceConnection implements ServiceConnection{


        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIService= (IService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @OnClick({R.id.onBind, R.id.unBind, R.id.startBind, R.id.destroyBind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.onBind:
                mIntent = new Intent(this,TestService.class);
                mCoon = new MyServiceConnection();
                bindService(mIntent, mCoon,BIND_AUTO_CREATE);
                break;
            case R.id.unBind:
                unbindService(mCoon);
                break;
            case R.id.startBind:
             mIService.callMethodFromService();
                break;
            case R.id.destroyBind:
                onDestroy();
                break;
        }
    }
}
