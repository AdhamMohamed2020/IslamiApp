package com.route.islamiApp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.route.islamiApp.Constants;
import com.route.islamiApp.R;
import com.route.islamiApp.adapters.SurasRecyclerAdapter;


public class QuranFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SurasRecyclerAdapter adapter;

    public QuranFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getContext(),3,RecyclerView.HORIZONTAL,false);
        adapter=new SurasRecyclerAdapter(Constants.ArSuras);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {
                Intent intent=new Intent(getContext(),SuraDetailsActivity.class);
                intent.putExtra(Constants.EXTRA_POSITION,pos);
                intent.putExtra(Constants.EXTRA_TITLE,name);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
