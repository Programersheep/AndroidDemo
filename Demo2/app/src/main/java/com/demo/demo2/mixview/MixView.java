package com.demo.demo2.mixview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.demo2.R;

public class MixView extends Activity {
    //定义一个访问图片的数组
    int[]images=new int[]{
            R.drawable.z,
            R.drawable.zz,
            R.drawable.z,
            R.drawable.zz,
            R.drawable.z
    };
    int currentImg=0;
    @Override
    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.main);
        //获取LinearLayout布局容器
        LinearLayout main=(LinearLayout)findViewById(R.id.root);
        //程序创建ImageView组件
        final ImageView image=new ImageView(this);
        //将ImageView组件添加到LinearLayout布局容器中
        main.addView(image);
        //初始化时显示第一张图片
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentImg>=4){
                    currentImg=-1;
                }
                //改变ImageView里显示的图片
                image.setImageResource(images[++currentImg]);
            }
        });
    }
}
