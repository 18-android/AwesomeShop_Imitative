package com.roy_sun.awesomeshop_imitative.ui.fragment;


import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.base.BaseFragment;
import com.roy_sun.awesomeshop_imitative.ui.activity.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {

    private ImageView like;


    @Override
    public View createView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        like = (ImageView) view.findViewById(R.id.btn_head);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
        return view;
    }

    @Override
    public void init() {


    }


}
