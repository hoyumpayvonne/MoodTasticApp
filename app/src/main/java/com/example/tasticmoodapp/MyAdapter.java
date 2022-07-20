package com.example.tasticmoodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User2> list;


    public MyAdapter(Context context, ArrayList<User2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User2 user = list.get(position);
        holder.age_num.setText(user.getAge_num());
        holder.date1.setText(user.getDate1());
        holder.emotion.setText(user.getEmotion());
        holder.names.setText(user.getNames());
        holder.type1.setText(user.getType1());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView emotion, names, age_num,type1,date1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            age_num = itemView.findViewById(R.id.get_age);
            date1 = itemView.findViewById(R.id.get_date);
            emotion = itemView.findViewById(R.id.get_mood);
            names = itemView.findViewById(R.id.get_name);
            type1 = itemView.findViewById(R.id.get_reason);


        }
    }

}