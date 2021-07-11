package com.example.q2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private Activity mActivity;
    private ArrayList<BillModel> mContentList;

    public BillAdapter(Context mContext, Activity mActivity, ArrayList<BillModel> mContentList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mContentList = mContentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_bill_item, parent, false);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewholder = (ViewHolder) holder;
        final BillModel model = mContentList.get(position);
        viewholder.name.setText(model.getCustomerName());
        viewholder.bill.setText(model.getBillNo());

        viewholder.detail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity,ViewDetail.class);
                intent.putExtra("cName",model.getCustomerName());
                intent.putExtra("cBillNo",model.getBillNo());
                intent.putExtra("meterNo",model.getcMeterNo());
                intent.putExtra("amount",model.getmAmount());
                intent.putExtra("lastUnits",model.getcLastUnits());
                intent.putExtra("currentUnits",model.getcUnits());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView name,bill;
         Button detail;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            // Find all views ids
            name = (TextView) itemView.findViewById(R.id.name_title);
            bill = (TextView) itemView.findViewById(R.id.bill_title);
            detail=(Button) itemView.findViewById(R.id.button_detail);

        }

    }

}
