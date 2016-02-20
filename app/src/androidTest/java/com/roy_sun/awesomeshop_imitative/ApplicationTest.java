package com.roy_sun.awesomeshop_imitative;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String TAG = "ApplicationTest";

    public ApplicationTest() {
        super(Application.class);
        try {
            Log.d(TAG, "ApplicationTest: "+getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData() throws IOException {
        String       url     = "localhost:8080/market/home";
        OkHttpClient client  = new OkHttpClient();
        Request      request = new Request.Builder().get().url(url).build();

        Response response = client.newCall(request).execute();
        String   result   = response.body().string();
        Log.d(TAG, "getData: " + result);


        return result;
    }

}
