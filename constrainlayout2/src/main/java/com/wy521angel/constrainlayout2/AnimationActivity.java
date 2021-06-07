package com.wy521angel.constrainlayout2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AnimationActivity extends ListActivity {


    private String[] titles = {"几种方法实现平移", "属性动画与过渡动画比较", "过渡动画示例", "ConstraintLayout场景过渡", "MotionLayout场景过渡"};

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
                intent.putExtra(DemoActivity.TYPE, DemoActivity.ANIMATION_1);
                break;
            case 1:
                intent.putExtra(DemoActivity.TYPE, DemoActivity.ANIMATION_2);
                break;
            case 2:
                startActivity(new Intent(this, FilmActivity.class));
                return;
            case 3:
                startActivity(new Intent(this, FilmActivity2.class));
                return;
            case 4:
                startActivity(new Intent(this, FilmActivity3.class));
                return;
        }
        startActivity(intent);
    }
}
