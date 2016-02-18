package com.roy_sun.awesomeshop_imitative.ui.fragment;


import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.base.BaseFragment;
import com.roy_sun.awesomeshop_imitative.utils.UIUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {

    private TextView me_baobei;

    ImageButton btn_head;
    private View byId;
    private View byId1;


    @Override
    public View createView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        btn_head = (ImageButton) view.findViewById(R.id.btn_head);
        btn_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"111",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void init() {


    }


}
