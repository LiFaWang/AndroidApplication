package com.example.service_01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Tony on 2017/6/17.
 * 16:37
 */

public class TestService extends Service {
    private class MyBinder extends Binder implements ISevice{
        public void callServiceMethod(String name,int mony){
            if (mony>200){
                serviceMethod(name);
            }else {
                Toast.makeText(getApplicationContext(), "钱不够，建议卖肾凑。。", Toast.LENGTH_SHORT).show();
            }
        }
        public void study(){
            Toast.makeText(getApplicationContext(), "一起学习吧", Toast.LENGTH_SHORT).show();
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "服务绑定成功", Toast.LENGTH_SHORT).show();
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(), "服务创建的成功", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "服务销毁的成功", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }
    private void serviceMethod(String name){
        Toast.makeText(getApplicationContext(), name+"办证成功", Toast.LENGTH_SHORT).show();
    }
}
