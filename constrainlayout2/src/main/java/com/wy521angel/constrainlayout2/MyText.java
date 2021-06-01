package com.wy521angel.constrainlayout2;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MyText extends AppCompatTextView {

    public MyText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void p0() {
        setText("20%");
    }

    public void p1() {
        setText("50%");
    }

    public void p2() {
        setText("80%");
    }
}
