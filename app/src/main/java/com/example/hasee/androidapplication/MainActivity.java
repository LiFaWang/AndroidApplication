package com.example.hasee.androidapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.btn_start)
    Button mBtnStart;
    @InjectView(R.id.btn_pause)
    Button mBtnPause;
    @InjectView(R.id.btn_stop)
    Button mBtnStop;
    @InjectView(R.id.et_path)
    EditText mEtPath;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.inject(this);
        mMediaPlayer = new MediaPlayer();
    }

    @OnClick({R.id.btn_start, R.id.btn_pause, R.id.btn_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_start:

                mMediaPlayer.reset();
                try {
                    mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath()+"/回忆里的那个人-妍妍.mp3");
                    mMediaPlayer.prepare();
//                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mp) {
//                            mMediaPlayer.start();
//                        }
//                    });
                    mMediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_pause:
                if(mMediaPlayer!=null&&mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                }
                if (mMediaPlayer!=null){
                    mMediaPlayer.start();
                }
                break;
            case R.id.btn_stop:
//                Toast.makeText(getApplicationContext(), "1223", Toast.LENGTH_SHORT).show();
                if (mMediaPlayer!=null){
                    mMediaPlayer.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "2222", Toast.LENGTH_SHORT).show();
    }
}
