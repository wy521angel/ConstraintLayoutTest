package com.wy521angel.constrainlayout2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    private String[] titles = {"Flow的使用", "Layer的使用", "自定义ConstraintHelper", "ImageFilterButton与ImageFilterView", "MockView", "点击布局重新排列", "模板功能", "动态替换", "Baseline 对齐"};

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
                intent.putExtra(DemoActivity.TYPE, DemoActivity.FLOW);
                break;
            case 1:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.LAYER);
                break;
            case 2:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.HELPER);
                break;
            case 3:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.IMAGE);
                break;
            case 4:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.MOCKVIEW);
                break;
//            case 5:
//                startActivity(new Intent(this, ClickActivity.class));
//                break;
//            case 6:
//                startActivity(new Intent(this, MainActivity1.class));
//                break;
//            case 7:
//                startActivity(new Intent(this, MainActivity2.class));
//                break;
//            case 8:
//                startActivity(new Intent(this, TestActivity.class).putExtra(TestActivity.TYPE, TestActivity.BASELINE));
//                break;

        }
        startActivity(intent);
    }
}
