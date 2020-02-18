package com.demo.demo2.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    public float currentX=40;
    public float currentY=50;
    public DrawView(Context context){
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //创建画笔
        Paint p=new Paint();
        //设置画笔颜色
        p.setColor(Color.RED);
        //绘制一个小圆（作为小球）
        canvas.drawCircle(currentX,currentY,15,p);
    }
}
