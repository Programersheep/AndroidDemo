package com.demo.demo2.codeview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.demo2.R;

public class CodeView extends Activity {
    //当第一次创建该Activity时回调该方法
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //创建一个线性布局管理器
        LinearLayout layout=new LinearLayout(this);
        //设置该Activity显示layout
        super.setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);
        //创建一个TextView
        final TextView show=new TextView(this);
        //创建一个按钮
        Button bn=new Button(this);
        bn.setText(R.string.ok);
        bn.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        //向Layout容器添加TextView
        layout.addView(bn);
        //为按钮绑定一个事件监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("Hellow,Android,"+new java.util.Date());
            }
        });
    }
}
