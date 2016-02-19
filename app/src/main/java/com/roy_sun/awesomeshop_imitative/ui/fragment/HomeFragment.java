package com.roy_sun.awesomeshop_imitative.ui.fragment;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.base.BaseFragment;
import com.roy_sun.awesomeshop_imitative.utils.UIUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.TintTypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import butterknife.Bind;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.slider)
    protected SliderLayout      mSliderLayout;
    private   DefaultSliderView mSliderView;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void init() {
        mSliderView = new DefaultSliderView(UIUtils.getContext());

    }

    private void requestImage() {


        //        OkHttpClient client = new OkHttpClient();
        //
        //        Request.Builder builder = new Request.Builder().get().url(url);
        //
        //        Request request = builder.build();
        //        Response response = client.newCall(request).execute();
        //
        //        if (response.isSuccessful()) {
        //            String json = response.body().string();
        //
        //            return response.body().string();
        //        }


    }
}
