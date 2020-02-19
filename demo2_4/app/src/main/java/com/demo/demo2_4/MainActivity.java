package com.demo.demo2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个BaseExpandableListAdapter对象
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            int []logos=new int[]{
                    R.drawable.p,
                    R.drawable.z,
                    R.drawable.t
            };
            private String[]armTypes=new String[]{
                    "神族兵种","虫族兵种","人族兵种"
            };
            private String[][]arms=new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电兵"},
                    {"小狗","刺蛇","飞龙","自爆飞机"},
                    {"机枪兵","护士mm","幽灵"}
            };

            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(MainActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            //获取指定组位置处的数据
            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }
            @Override
            public int getGroupCount(){
                return armTypes.length;
            }
            //获取指定组位置、指定子列表项处的子列表项数据
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            //该方法决定每个组选项的外观
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll=new LinearLayout(MainActivity.this);
                ll.setOrientation(groupPosition);
                ImageView logo=new ImageView(MainActivity.this);
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView textView=getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return  ll;
            }

            //该方法决定每个子选项的外观
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView=getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
    }
}
