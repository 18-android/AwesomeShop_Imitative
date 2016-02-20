package com.roy_sun.awesomeshop_imitative.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.base.BaseFragment;
import com.roy_sun.awesomeshop_imitative.bean.HomeBean;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.HotActivity;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.NewActivity;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.ProductInfoActivity;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.RecommendActivity;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.SaleActivity;
import com.roy_sun.awesomeshop_imitative.ui.activity.Home.TimeActivity;
import com.roy_sun.awesomeshop_imitative.utils.UIUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * HomeFragment界面的初步代码
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";
    private Context mContext;
    private Handler mHandler = new Handler();

    @Bind(R.id.fragment_home_viewpager)
    ViewPager   mHomeViewpager;
    @Bind(R.id.fragment_home_iv_time)
    ImageButton mIvTime;
    @Bind(R.id.fragment_home_iv_sale)
    ImageButton mIvSale;
    @Bind(R.id.fragment_home_iv_new)
    ImageButton mIvNew;
    @Bind(R.id.fragment_home_iv_hot)
    ImageButton mIvHot;
    @Bind(R.id.fragment_home_iv_recommend)
    ImageButton mIvRecommend;
    @Bind(R.id.fragment_home_fashion_iv_left)
    ImageView   mTitleIvLeft;
    @Bind(R.id.fragment_home_fashion_iv_right)
    ImageView   mTitleIvRight;

    private FragmentManager     manager;
    private FragmentTransaction mTranscation;
    private HomePicPagerAdapter mAdapter;

    private List<HomeBean.HomeTopicPicBean> mHomeData;

    public HomeFragment() {
        // Required empty public constructor
        mHomeData = new ArrayList<>();
        Log.d(TAG, "HomeFragment(): 进入首页");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = getFragmentManager();

    }

    /**
     * 初始化布局界面
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View titleView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, titleView);
        return titleView;
    }

    /**
     * 页面加载后回调的方法
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        //开启异步线程访问网络
        OkHttpClient client  = new OkHttpClient();
        String       url     = "http:188.188.1.6:8080/market/home";
        Request      request = new Request.Builder().get().url(url).build();
        Call         call    = client.newCall(request);
        call.enqueue(new Callback() {//开启网络异步加载数据
            @Override
            public void onFailure(Call call, IOException e) {
                //加载失败
                Log.d(TAG, "onFailure: 连接失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //加载成功
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    Gson     gson     = new Gson();
                    HomeBean homeBean = gson.fromJson(result, HomeBean.class);
                    mHomeData = homeBean.homeTopic;
                    //在主线程更新UI
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "run: 在主线程更新UI");
                            mHomeViewpager.setAdapter(new HomePicPagerAdapter());
                        }
                    });
                }
            }
        });

        mIvTime.setOnClickListener(this);
        mIvSale.setOnClickListener(this);
        mIvNew.setOnClickListener(this);
        mIvHot.setOnClickListener(this);
        mIvRecommend.setOnClickListener(this);
        mTitleIvLeft.setOnClickListener(this);
        mTitleIvRight.setOnClickListener(this);

        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 界面销毁，取消绑定
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 设置点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fragment_home_iv_time://点击跳转到限时抢购界面
                /*---------- 测试跳转fragment ------------*/
               /* HotFragment hotFragment = new HotFragment();
                mTranscation = manager.beginTransaction();
                mTranscation.replace(getId(), hotFragment);
                mTranscation.addToBackStack(null);
                mTranscation.commit();*/
                Intent intent = new Intent(getContext(), TimeActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_home_iv_sale://跳转促销快报界面
                Intent saleIntent = new Intent(getContext(), SaleActivity.class);
                startActivity(saleIntent);
                break;
            case R.id.fragment_home_iv_new://跳转新品上架界面
                Intent newIntent = new Intent(getContext(), NewActivity.class);
                startActivity(newIntent);
                break;
            case R.id.fragment_home_iv_hot://热门单品界面
                Intent hotIntent = new Intent(getContext(), HotActivity.class);
                startActivity(hotIntent);
                break;
            case R.id.fragment_home_iv_recommend://推荐品牌界面
                Intent recommendIntent = new Intent(getContext(), RecommendActivity.class);
                startActivity(recommendIntent);
                break;
            case R.id.fragment_home_fashion_iv_left://潮流前线界面
                Intent hotIntent1 = new Intent(getContext(), HotActivity.class);
                startActivity(hotIntent1);
                break;
            case R.id.fragment_home_fashion_iv_right://潮流前线界面
                Intent hotIntent2 = new Intent(getContext(), HotActivity.class);
                startActivity(hotIntent2);
                break;
            default:
                break;
        }
    }

    /**
     * 轮播图的数据适配器
     */
    class HomePicPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mHomeData != null) {
                return mHomeData.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            //初始化轮播图的视图
            //实现无限轮播 TODO:

            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);

            //为子view添加点击事件
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //ToastUtils.show(getContext(), "商品详情" + position, Toast.LENGTH_SHORT);
                    //跳转到商品详情界面
                    Intent intent = new Intent(UIUtils.getContext(), ProductInfoActivity.class);
                    startActivity(intent);
                }
            });

            //网络加载图片
            String homeUrl = "http://188.188.1.6:8080/market"+mHomeData.get(position).pic;
            String result = mHomeData.get(position).title + mHomeData.get(position).id;
            Log.d(TAG, "图片的地址" + homeUrl+result);

            Picasso.with(UIUtils.getContext()).load(homeUrl).into(iv);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 加载首页的顶部ToolBar TODO:
     */
    @Override
    public void initToolBar() {
        super.initToolBar();
    }

    /**
     * 初始化数据 TODO:
     */
    @Override
    public void init() {

    }
}
