package com.example.bottomnavigation;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DescriptionFragment extends AppCompatActivity {

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main1);

        String str = getIntent().getStringExtra("desc");
        TextView text = findViewById(R.id.textView1);
        text.setText(str);

        Bundle bundle=this.getIntent().getExtras();
        ImageView image=findViewById(R.id.imageView1);
        int pic=bundle.getInt("image");
        image.setImageResource(pic);



    }
}
