package com.example.orangestatus.ui.market;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.orangestatus.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarketFragment extends Fragment {
//
//    private MarketViewModel marketViewModel;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        marketViewModel =
//                ViewModelProviders.of(this).get(MarketViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_market, container, false);
//        final TextView textView = root.findViewById(R.id.text_market);
//        marketViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
//}

    private List<items> items_List =new ArrayList<>();

    private MarketViewModel mViewModel;

    public static MarketFragment newInstance() {
        return new MarketFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.market_fragment, container, false);
        FloatingActionButton floatingActionButton =root.findViewById(R.id.floatingActionButton1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), newpost.class);
                startActivity(i);
            }
        });

        inititems();
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        itemAdapter adapter = new itemAdapter(items_List);
        recyclerView.setAdapter(adapter);
        return root;
    }
    private void inititems(){
        for(int i =0; i <2;i++){
            items apple = new items("Apple", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(apple);
            items banana = new items("Banana", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(banana);
            items cherry = new items("Cherry", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(cherry);
            items grape = new items("Grape", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(grape);
            items mango = new items("Mango", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(mango);
            items orange = new items("Orange", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(orange);
            items pear = new items("Pear", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(pear);
            items pineapple = new items("Pineapple", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(pineapple);
            items strawberry = new items("Strawberry", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(strawberry);
            items watermelon = new items("Watermelon", R.drawable.common_google_signin_btn_icon_dark_focused);
            items_List.add(watermelon);
        }
    }



    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        // TODO: Use the ViewModel
    }

}
