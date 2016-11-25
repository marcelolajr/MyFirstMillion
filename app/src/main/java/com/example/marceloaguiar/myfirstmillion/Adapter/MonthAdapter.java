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
    MonthListener listener;

    public MonthAdapter(MonthListener monthListener) {
        this.listener = monthListener;
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
        final Month month = this.dummy.months.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMonthSelected(month);
            }
        });
        holder.txtViewMonth.setText(month.getMonthValue().toString());
        holder.txtViewYear.setText(month.getYear().toString());
        holder.txtViewTotalBalance.setText(month.getTotalBalanceFormatted().toString());
    }

    @Override
    public int getItemCount() {
        return this.dummy.months.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtViewMonth;
        public final TextView txtViewYear;
        public final TextView txtViewTotalBalance;
        public final View view;

        public ViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            txtViewMonth = (TextView) itemView.findViewById(R.id.month);
            txtViewYear = (TextView) itemView.findViewById(R.id.year);
            txtViewTotalBalance = (TextView) itemView.findViewById(R.id.TotalBalance);
        }
    }

}
