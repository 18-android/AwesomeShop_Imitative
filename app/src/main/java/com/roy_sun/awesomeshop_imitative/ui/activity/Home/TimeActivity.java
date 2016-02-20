package com.roy_sun.awesomeshop_imitative.ui.activity.Home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.roy_sun.awesomeshop_imitative.R;
import com.roy_sun.awesomeshop_imitative.bean.TimeLimitBuyBean;
import com.roy_sun.awesomeshop_imitative.bean.TimeLimitBuyBean.ProduceListBean;
import com.roy_sun.awesomeshop_imitative.conf.Constants;
import com.roy_sun.awesomeshop_imitative.utils.ToastUtils;
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
 * @创建者：Fox
 * @创建时间：2016/2/18
 * @描述： ${TODO}
 * @修改者：$TODO
 * @修改时间：2016/2/18 19:42
 */
public class TimeActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "TimeActivity";
    @Bind(R.id.activity_sale_iv_back)
    ImageView mSaleIvBack;
    @Bind(R.id.activity_sale_iv_buy)
    ImageView mSaleIvBuy;
    @Bind(R.id.activity_sale_lv)
    GridView  mSaleGv;

    private List<ProduceListBean> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);
        initData();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        mSaleIvBack.setOnClickListener(this);
        mSaleIvBuy.setOnClickListener(this);

        //为每个条目设置点击事件
        mSaleGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击，跳转到商品详情界面
                Log.d(TAG, "onItemClick: "+position);
                ToastUtils.show(UIUtils.getContext(),"图"+position,Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mListData = new ArrayList<>();
        //网络访问数据
        OkHttpClient client = new OkHttpClient();
        String url = Constants.URL.BASE_HOME_URL+"/limitbuy?page=1&pageNum=10";
        Request request = new Request.Builder().get().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.show(UIUtils.getContext(),"访问网络失败",Toast.LENGTH_SHORT);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    Gson gson = new Gson();
                    TimeLimitBuyBean timeBean = gson.fromJson(json, TimeLimitBuyBean.class);
                    mListData = timeBean.productList;
                    Log.d(TAG, "onResponse: 返回的数据为"+json);
                    //在主线程更新UI
                    UIUtils.post(new Runnable() {
                        @Override
                        public void run() {
                            mSaleGv.setAdapter(new SaleItemAdapter());
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_sale_iv_back:
                onBackPressed();
                break;
            case R.id.activity_sale_iv_buy:
                ToastUtils.show(UIUtils.getContext(),"购买", Toast.LENGTH_SHORT);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    class SaleItemAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mListData != null) {
                return mListData.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mListData != null) {
                return mListData.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(UIUtils.getContext(), R.layout.item_activity_time, null);
                holder = new ViewHolder();
                convertView.setTag(holder);
                holder.ivIcon = (ImageView) convertView.findViewById(R.id.item_sale_ivIcon);
                holder.tvDesc = (TextView) convertView.findViewById(R.id.item_sale_tvDesc);
                holder.mButton = (Button) convertView.findViewById(R.id.item_sale_btn);
                holder.tvOldPrice = (TextView) convertView.findViewById(R.id.item_time_tv_oldPrice);
                holder.tvNewPrice = (TextView) convertView.findViewById(R.id.item_time_tv_newPrice);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //从网络上获取数据
            ProduceListBean tlistBean = mListData.get(position);
            Picasso.with(UIUtils.getContext())
                    .load(Constants.URL.BASE_HOME_URL+tlistBean.pic)
                    .into(holder.ivIcon);
            holder.tvDesc.setText(tlistBean.name);
            holder.tvOldPrice.setText(tlistBean.price+"");
            holder.tvNewPrice.setText(tlistBean.limitPrice+"");
            return convertView;
        }
    }
    class ViewHolder{
        ImageView ivIcon;
        TextView tvDesc;
        TextView tvNewPrice;
        TextView tvOldPrice;
        Button mButton;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
