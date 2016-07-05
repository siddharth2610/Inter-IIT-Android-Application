package com.abhishek.interiit2016.fragments;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.SimpleRecyclerAdapter;
import com.abhishek.interiit2016.model.ScheduleDTO;
import com.abhishek.interiit2016.model.VersionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNDA ABHISHEK on 24-06-2016.
 */
public class ScheduleFragment extends Fragment{
    Drawable color;
    SimpleRecyclerAdapter adapter;

    public ScheduleFragment() {
    }

    @SuppressLint("ValidFragment")
    public ScheduleFragment(Drawable color) {
        this.color = color;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
        frameLayout.setBackground(color);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        List<ScheduleDTO> scheduleDTOList=new ArrayList<>();
        scheduleDTOList.add(new ScheduleDTO("KANPUR","CHENNAI","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS"));
        scheduleDTOList.add(new ScheduleDTO("MUMBAI","CHENNAI","6:30PM","THURSDAY 30 DEC","CRICKET GROUND","MATCH 26, FINALS"));
        scheduleDTOList.add(new ScheduleDTO("MANDI","DELHI","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS"));
        scheduleDTOList.add(new ScheduleDTO("KANPUR","HYDERABAD","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS"));
        scheduleDTOList.add(new ScheduleDTO("VARANASI","PATNA","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS"));
        scheduleDTOList.add(new ScheduleDTO("KANPUR","CHENNAI","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS"));
        adapter = new SimpleRecyclerAdapter(scheduleDTOList);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
