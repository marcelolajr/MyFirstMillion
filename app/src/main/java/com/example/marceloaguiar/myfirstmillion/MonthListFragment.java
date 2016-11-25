package com.example.marceloaguiar.myfirstmillion;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marceloaguiar.myfirstmillion.Adapter.MonthAdapter;
import com.example.marceloaguiar.myfirstmillion.Adapter.MonthListener;
import com.example.marceloaguiar.myfirstmillion.Model.Month;

public class MonthListFragment extends Fragment implements MonthListener {

    public MonthListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_months_list,container,false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.list);
        rv.setAdapter(new MonthAdapter(this));

        return view;
    }

    @Override
    public void onMonthSelected(Month month) {
        Intent intent = new Intent(getActivity(), MonthActivity.class);

        getActivity().startActivity(intent);
    }

}
