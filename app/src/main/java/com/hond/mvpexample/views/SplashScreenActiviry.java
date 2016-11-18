package com.hond.mvpexample.views;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.hond.mvpexample.R;

/**
 * Created by hond on 11/17/2016.
 */

public class SplashScreenActiviry extends Activity {
    private static long SPLASH_MILLIS = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActiviry.this,
                        LoginActivity.class);
                startActivity(intent);
            }
        }, SPLASH_MILLIS);
    }
}
