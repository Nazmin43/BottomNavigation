package com.example.bottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridRecyclerView extends RecyclerView.Adapter<GridRecyclerView.MyViewHolder> {
    private ArrayList<DataModel1> dataset;
    Context context;

    public static   class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView textViewDesc;
        ImageView imageViewDrawabal;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageViewDrawabal = (ImageView) itemView.findViewById(R.id.imageView);
            this.textViewDesc = (TextView) itemView.findViewById(R.id.textView);

        }
    }
    public GridRecyclerView(ArrayList<DataModel1> data) {
        this.dataset = data;
    }

 @NonNull
 @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
 {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
     MyViewHolder myViewHolder= new MyViewHolder(view);
     return myViewHolder;
 }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final ImageView imageViewDrawabal=holder.imageViewDrawabal;
        TextView textViewDesc=holder.textViewDesc;
        imageViewDrawabal.setImageResource(dataset.get(position).getImage());

        textViewDesc.setText("image no"+ position);

        holder.imageViewDrawabal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), DescriptionFragment.class);
                i.putExtra("desc",dataset.get(position).desc);
                /*imageView.buildDrawingCache();
                Bitmap image= imageView.getDrawingCache();
                Bundle b=new Bundle();
                b.putParcelable("imagebitmap", image);*/
                Bundle bundle=new Bundle();
                bundle.putInt("image",dataset.get(position).image);
                i.putExtras(bundle);
                // startActivity(intent);

                v.getContext().startActivity(i);
            }
        });


    }




    @Override
    public int getItemCount()
 {
     return dataset.size();
 }

 }


