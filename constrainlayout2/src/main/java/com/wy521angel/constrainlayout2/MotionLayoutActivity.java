package com.wy521angel.constrainlayout2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MotionLayoutActivity extends ListActivity {


    private String[] titles = {"基本的使用", "位置关键帧", "属性关键帧", "ImageFilterButton与ImageFilterView", "MockView", "MotionLayout"};

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
                intent.putExtra(DemoActivity.TYPE, DemoActivity.IMAGE);
                break;
            case 4:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOCKVIEW);
                break;
            case 5:
                break;
        }
        startActivity(intent);
    }
}
