package com.demo.demo3_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    //定义飞机的移动速度
    private int speed=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //创建PlaneView组件
        final PlainView plainView=new PlainView(this);
        setContentView(plainView);
        plainView.setBackgroundResource(R.drawable.back);
        //获取窗口管理器
        WindowManager windowManager=getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        //获取屏幕宽和高
        int screenWidth=display.getWidth();
        int screentHeight=display.getHeight();
        //设置飞机的初始位置
        plainView.currentX=screenWidth/2;
        plainView.currentY=screentHeight-40;
        //为draw组件键盘事件绑定监听器
        plainView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //获取由哪个键触发的事件
                switch (event.getKeyCode()){
                    //控制飞机下移
                    case  KeyEvent.KEYCODE_DPAD_DOWN:
                    plainView.currentY+=speed;
                    break;
                    case  KeyEvent.KEYCODE_DPAD_UP:
                        plainView.currentY-=speed;
                        break;
                    case  KeyEvent.KEYCODE_DPAD_LEFT:
                        plainView.currentX-=speed;
                        break;
                    case  KeyEvent.KEYCODE_DPAD_DOWN_RIGHT:
                        plainView.currentX+=speed;
                        break;
                }
                //通知planeView组件重绘
                plainView.invalidate();
                return true;
            }
        });
        setContentView(plainView);
    }
}
