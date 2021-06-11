package com.wy521angel.constrainlayout2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemFragment extends Fragment {

    private static final String AVATAR_ID = "avatar_id";
    private int avatarId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            avatarId = getArguments().getInt(AVATAR_ID, R.drawable.avatar1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(avatarId);
        return view;
    }


    public static ItemFragment newInstance(@DrawableRes int resId) {
        ItemFragment itemFragment = new ItemFragment();
        Bundle arges = new Bundle();
        arges.putInt(AVATAR_ID, resId);
        itemFragment.setArguments(arges);
        return itemFragment;
    }
}
