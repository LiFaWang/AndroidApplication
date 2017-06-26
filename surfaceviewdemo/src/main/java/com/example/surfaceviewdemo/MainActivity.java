package com.example.surfaceviewdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;
    private boolean flag;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = (SurfaceView) findViewById(R.id.sv);
        mButton= (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("22",55+"");
                Toast.makeText(getApplicationContext(), "22", Toast.LENGTH_SHORT).show();
            }
        });
        System.out.println("111");
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(final SurfaceHolder holder) {
                flag=true;
                System.out.println("flag1"+flag);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <100 ; i++) {
                            if (!flag){
                                System.out.println("flag"+flag+222);
                                return;
                            }
                        Canvas canvas = holder.lockCanvas();
                        Paint paint=new Paint();
                        paint.setColor(Color.GREEN);
                            int radius=5+i;
                            canvas.drawCircle(200,200,radius,paint);
                            holder.unlockCanvasAndPost(canvas);
                            SystemClock.sleep(100);
                            System.out.println("333");
                        }
                    }
                }).start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                flag=false;

                System.out.println("surfaceDestroyed");
            }
        });
    }
}
