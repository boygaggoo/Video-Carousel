package com.assignment.carouselonvideoexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    private String URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    @BindView(R.id.easyVideoPlayer)
    EasyVideoPlayer easyVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeVideoPlayer();
    }

    private void initializeVideoPlayer()
    {
        easyVideoPlayer = (EasyVideoPlayer) findViewById(R.id.easyVideoPlayer);
        easyVideoPlayer.setSource(Uri.parse(URL));
        easyVideoPlayer.start();
        easyVideoPlayer.setAutoPlay(true);
        easyVideoPlayer.setLoop(true);
        easyVideoPlayer.hideControls();
        easyVideoPlayer.disableControls();
        easyVideoPlayer.setCallback(new EasyVideoCallback()
        {
            @Override
            public void onStarted(EasyVideoPlayer player)
            {

            }

            @Override
            public void onPaused(EasyVideoPlayer player)
            {

            }

            @Override
            public void onPreparing(EasyVideoPlayer player)
            {

            }

            @Override
            public void onPrepared(EasyVideoPlayer player)
            {
                player.setVolume(0f, 0f);
            }

            @Override
            public void onBuffering(int percent)
            {

            }

            @Override
            public void onError(EasyVideoPlayer player, Exception e)
            {

            }

            @Override
            public void onCompletion(EasyVideoPlayer player)
            {

            }

            @Override
            public void onRetry(EasyVideoPlayer player, Uri source)
            {

            }

            @Override
            public void onSubmit(EasyVideoPlayer player, Uri source)
            {

            }
        });
    }
}
