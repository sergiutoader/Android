package com.example.tema1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    LayoutInflater mInflater;
    List<String> mItems;

    public MyListAdapter(Context context, LinkedList<String> items) {
        mInflater = LayoutInflater.from(context);
        this.mItems = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyViewHolder holder, int position) {
        String mCurrent = mItems.get(position);
        holder.mItem.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button mItem;
        MyListAdapter mAdapter;

        public MyViewHolder(@NonNull View itemView, MyListAdapter adapter) {
            super(itemView);
            mItem = itemView.findViewById(R.id.item);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        // onClick doar pe buton, nu pe tot View-ul
        @Override
        public void onClick(View view) {}
    }
}
