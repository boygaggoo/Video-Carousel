package com.assignment.carouselonvideoexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.assignment.carouselonvideoexample.adapters.ImagesCarouselRecyclerViewAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    private String URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    ArrayList<String> imagesUrls = new ArrayList<>();

    @BindView(R.id.easyVideoPlayer)
    EasyVideoPlayer easyVideoPlayer;

    @BindView(R.id.rvImages)
    DiscreteScrollView rvImages;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeVideoPlayer();
        initializeCarouselImages();
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

    private void initializeCarouselImages()
    {
        rvImages = (DiscreteScrollView) findViewById(R.id.rvImages);
        rvImages.setOffscreenItems(3);
        rvImages.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.7f).build());

        rvImages.setHasFixedSize(true);
        rvImages.setNestedScrollingEnabled(false);

        rvImages.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
        {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
            {
                int action = e.getAction();
                switch (action)
                {
                    case MotionEvent.ACTION_MOVE:
                        rv.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e)
            {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)
            {

            }
        });

        for (int index = 0; index < 7; index++)
        {
            imagesUrls.add("https://picsum.photos/300/200");
        }


        rvImages.setAdapter(new ImagesCarouselRecyclerViewAdapter(imagesUrls, MainActivity.this));
    }
}
