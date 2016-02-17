package com.roy_sun.awesomeshop_imitative.ui.activity;

import com.roy_sun.awesomeshop_imitative.MainActivity;
import com.roy_sun.awesomeshop_imitative.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Roy_Sun on 2016/2/16 0016.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },2000);
    }
}
