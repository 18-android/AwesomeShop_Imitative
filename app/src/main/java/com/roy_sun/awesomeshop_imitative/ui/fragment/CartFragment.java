package com.roy_sun.awesomeshop_imitative.ui.fragment;


import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.base.BaseFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment {


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public View createView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void init() {

    }

}
