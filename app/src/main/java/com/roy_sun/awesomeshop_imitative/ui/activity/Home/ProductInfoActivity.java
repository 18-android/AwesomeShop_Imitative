package com.roy_sun.awesomeshop_imitative.ui.activity.Home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.bean.ProductBean;
import com.roy_sun.awesomeshop_imitative.conf.Constants;
import com.roy_sun.awesomeshop_imitative.utils.UIUtils;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @创建者：Fox
 * @创建时间：2016/2/19
 * @描述： 商品详情界面
 * @修改者：$TODO
 * @修改时间：2016/2/19 22:34
 */
public class ProductInfoActivity extends Activity {
    @Bind(R.id.activity_product_viewpager)
    ViewPager mViewpager;
    @Bind(R.id.activity_product_btn_save)
    Button    mBtnSave;
    @Bind(R.id.activity_product_btn_buy)
    Button    mBtnBuy;

    private List<ProductBean.ProductBigPicBean> mListPicData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        ButterKnife.bind(this);
        initData();
        initEvent();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //根据商品的 pId值，从网络上获取相对应的商品的详情数据
        OkHttpClient client = new OkHttpClient();
        String url = Constants.URL.BASE_HOME_URL+"/product?pId=3";
        Request request = new Request.Builder().get().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //连接服务器失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //连接服务器成功
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    Gson gson = new Gson();
                   /* ProductBean productBean = gson.fromJson(json, ProductBean.class);
                    mListPicData = (ProductBean.ProductInfoBean)productBean.product.;
                    mListPicData = productBean.product.bigPic;
                    //在主线程更新UI*/
                    UIUtils.post(new Runnable() {
                        @Override
                        public void run() {
                            mViewpager.setAdapter(new ProductPicAdapter());
                        }
                    });
                }
            }
        });
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        //处理点击事件
        mBtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击开始购买

            }
        });
    }

    /**
     * 商品详情界面的显示大图的viewpager数据适配器
     */
    class ProductPicAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            if (mListPicData != null) {
                return mListPicData.size();
            }
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //获取数据

            /*Picasso.with(UIUtils.getContext())
                    .load(Constants.URL.BASE_HOME_URL+mListPicData.get(position).pic)
                    .into(iv);*/
            iv.setImageResource(R.mipmap.bigcar8);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
