package com.example.llw.demo_mymyviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewpagerId;

    int[] image = new int[]{R.mipmap.a1, R.mipmap.a1, R.mipmap.a2, R.mipmap.a3, R.mipmap.a4, R.mipmap.a5, R.mipmap.a6, R.mipmap.a7, R.mipmap.a8, R.mipmap.a9,
            R.mipmap.a9};


    List<ImageView> list = new ArrayList<>();

    private void assignViews() {
        viewpagerId = (ViewPager) findViewById(R.id.viewpager_id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        // Toast.makeText(MainActivity.this, " " + image.length, Toast.LENGTH_SHORT).show();
        viewpagerId.setOnPageChangeListener(this);
        viewpagerId.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return image.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
               /* List<ImageView> list = new ArrayList<>();*/

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(image[position]);
                list.add(imageView);
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }
        });
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Toast.makeText(MainActivity.this, "这是：" + position, Toast.LENGTH_SHORT).show();
        Log.e("这是：", "zheshi" + position);
    }

    @Override
    public void onPageSelected(int position) {
        if (list.size() > 1) {
            if (position <= 0) {
                position = image.length - 2;//A
                viewpagerId.setCurrentItem(position, false);
                //   Toast.makeText(MainActivity.this, "这是：" + position, Toast.LENGTH_SHORT).show();
            } else if (position >= image.length - 1) {
                position = 1;//B
                viewpagerId.setCurrentItem(position, false);
                //Toast.makeText(MainActivity.this, "这是：" + position, Toast.LENGTH_SHORT).show();
            }
        }//注意不能在同一张图片之间滑动，如：A中image.length-1,和B中postion=0;同时出现


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
