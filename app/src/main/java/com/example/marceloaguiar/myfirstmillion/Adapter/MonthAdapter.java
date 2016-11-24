package com.example.marceloaguiar.myfirstmillion.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marceloaguiar.myfirstmillion.DummyData.DummyData;
import com.example.marceloaguiar.myfirstmillion.Model.Month;
import com.example.marceloaguiar.myfirstmillion.R;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder> {

    DummyData dummy;

    public MonthAdapter() {
        this.dummy = new DummyData();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_months, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Month month = this.dummy.months.get(position);
        holder.txtViewMonth.setText(month.getMonthValue().toString());
        holder.txtViewMonth.setText(month.getYear().toString());
    }

    @Override
    public int getItemCount() {
        return this.dummy.months.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtViewMonth;
        public final TextView txtViewYear;


        public ViewHolder(View itemView) {
            super(itemView);
            txtViewMonth = (TextView) itemView.findViewById(R.id.month);
            txtViewYear = (TextView) itemView.findViewById(R.id.year);
        }
    }

}
