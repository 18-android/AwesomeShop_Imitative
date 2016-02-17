package com.roy_sun.awesomeshop_imitative;

import com.roy_sun.awesomeshop_imitative.bean.TabHostBean;
import com.roy_sun.awesomeshop_imitative.ui.FragmentTabHost;
import com.roy_sun.awesomeshop_imitative.ui.fragment.CartFragment;
import com.roy_sun.awesomeshop_imitative.ui.fragment.CategoryFragment;
import com.roy_sun.awesomeshop_imitative.ui.fragment.HomeFragment;
import com.roy_sun.awesomeshop_imitative.ui.fragment.HotFragment;
import com.roy_sun.awesomeshop_imitative.ui.fragment.MineFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater  mInflater;
    private List<TabHostBean> mTabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabs();

    }

    private void initTabs() {
        TabHostBean tab_home = new TabHostBean(HomeFragment.class, R.string.home,
                                               R.drawable.selector_icon_home);
        TabHostBean tab_hot = new TabHostBean(HotFragment.class, R.string.hot,
                                              R.drawable.selector_icon_hot);
        TabHostBean tab_category = new TabHostBean(CategoryFragment.class, R.string.category,
                                                   R.drawable.selector_icon_category);
        TabHostBean tab_cart = new TabHostBean(CartFragment.class, R.string.cart,
                                               R.drawable.selector_icon_cart);
        TabHostBean tab_mine = new TabHostBean(MineFragment.class, R.string.mine,
                                               R.drawable.selector_icon_mine);


        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);


        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (TabHostBean tab : mTabs) {
            TabHost.TabSpec tabSpec  = mTabHost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabHost.addTab(tabSpec,tab.getFragment(),null);
        }

        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(TabHostBean tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView tabImg = (ImageView) view.findViewById(R.id.tab_icon);

        TextView tabDesc = (TextView) view.findViewById(R.id.tab_desc);

        tabImg.setBackgroundResource(tab.getIcon());
        tabDesc.setText(tab.getTitle());

        return view;
    }


    //    @Override
    //    public void onBackPressed() {
    //        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    //        if (drawer.isDrawerOpen(GravityCompat.START)) {
    //            drawer.closeDrawer(GravityCompat.START);
    //        } else {
    //            super.onBackPressed();
    //        }
    //    }
    //
    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        // Inflate the menu; this adds items to the action bar if it is present.
    //        getMenuInflater().inflate(R.menu.main, menu);
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item) {
    //        // Handle action bar item clicks here. The action bar will
    //        // automatically handle clicks on the Home/Up button, so long
    //        // as you specify a parent activity in AndroidManifest.xml.
    //        int id = item.getItemId();
    //
    //        //noinspection SimplifiableIfStatement
    //        if (id == R.id.action_settings) {
    //            return true;
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }

    //    @Override
    //    public boolean onNavigationItemSelected(MenuItem item) {
    //        // Handle navigation view item clicks here.
    //        int id = item.getItemId();
    //
    //        if (id == R.id.nav_home) {
    //            ToastUtils.show(this, "点击了首页");
    //
    //            // Handle the camera action
    //        } else if (id == R.id.nav_gallery) {
    //            ToastUtils.show(this, "点击了分类");
    //
    //        } else if (id == R.id.nav_slideshow) {
    //            ToastUtils.show(this, "点击了发现");
    //
    //        } else if (id == R.id.nav_cart) {
    //            ToastUtils.show(this, "点击了购物车");
    //
    //        } else if (id == R.id.nav_share) {
    //            ToastUtils.show(this, "点击了分享");
    //
    //        } else if (id == R.id.nav_manage) {
    //            ToastUtils.show(this, "点击了设置");
    //        }
    //        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    //        drawer.closeDrawer(GravityCompat.START);
    //        return true;
    //    }
}
