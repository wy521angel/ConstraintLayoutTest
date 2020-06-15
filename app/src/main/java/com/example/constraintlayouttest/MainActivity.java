package com.example.constraintlayouttest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    private String[] titles = {"Enforcing constraints", "Percent Dimensions", "Barrier", "Group", "围绕旋转", "点击布局重新排列", "模板功能", "动态替换"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, EnforcingConstraintsActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, PercentDimensionsActivity.class));
                break;
            case 2:
            case 3:
                startActivity(new Intent(this, BarrierActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, CircleConstraintsActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, ClickActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, MainActivity1.class));
                break;
            case 7:
                startActivity(new Intent(this, MainActivity2.class));
                break;

        }
    }
}
