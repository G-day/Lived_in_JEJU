package com.example.boardtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//DB와 안드로이드 중간 역할하는 어댑터
public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.CustomViewHolder> {

    private ArrayList<SocialPost> arrayList;
    private Context context;

    public SocialAdapter(ArrayList<SocialPost> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.social_list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(String.valueOf(arrayList.get(position).getContent()));
        holder.userName.setText(arrayList.get(position).getUserName());
        holder.date.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        TextView userName;
        TextView date;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.content = itemView.findViewById(R.id.content);
            this.userName = itemView.findViewById(R.id.userName);
            this.date = itemView.findViewById(R.id.date);
        }
    }
}

