package com.wy521angel.constrainlayout2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MotionLayoutActivity extends ListActivity {


    private String[] titles = {"基本的使用", "位置关键帧", "属性关键帧", "自定义属性", "KeyCycle", "KeyTimeCycle", "KeyTrigger", "Constraint中Transform的使用", "使用代码控制"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, DemoActivity.class);
        switch (position) {
            case 0:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_1);
                break;
            case 1:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_2);
                break;
            case 2:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_3);
                break;
            case 3:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_4);
                break;
            case 4:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_KEYCYCLE);
                break;
            case 5:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_KEYTIMECYCLE);
                break;
            case 6:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_KEYTRIGGER);
                break;
            case 7:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_TRANSFORM);
                break;
            case 8:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOTIONLAYOUT_JAVA);
                break;
        }
        startActivity(intent);
    }
}
