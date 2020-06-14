package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridFragment extends Fragment {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    GridRecyclerView recyclerViewAdapter;
    private static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel1> data;
  //  int []arr={R.drawable.afgan1,R.drawable.bangala,R.drawable.brazil,R.drawable.canada,R.drawable.china,R.drawable.england,R.drawable.flag,R.drawable.france,R.drawable.iraq,R.drawable.nepal,R.drawable.pakistan};
   // static String[] Desc = {"India is a country of Asia. It has an area of 3,287,263 square kilometres (1,269,219 sq mi). It is at the center of South Asia. India has more than 1.2 billion (1,210,000,000) people, which is the second largest population in the world.[15]", "Afganistan is  a country located in Central Asia and South Asia.[9][10] It has borders with Pakistan in the south and east, Iran in the west, Turkmenistan, Uzbekistan and Tajikistan in the north, and China in the far northeast.[10]", "Iraq is a country in southwestern Asia. Iraq borders with Saudi Arabia and Kuwait to the south, Turkey to the north, Syria to the north-west, Jordan to the west, and Iran to the east. The capital of Iraq is Baghdad.", "Bangladesh is next to the North-east Indian provincial regions of India, which converges with Southeast Asia to the east. Its full name is The People's Republic of Bangla-Desh.", "Brazil is the largest country in both South America and Latin America. At 8.5 million square kilometers (3.2 million square miles)[10] and with over 211 million people, Brazil is the world's fifth-largest country by area and the sixth most populous.", "Canada is a country in North America. It is north of the United States. Its land reaches from the Atlantic Ocean in the east to the Pacific Ocean in the west and the Arctic Ocean to the north. Canada's area is 9.98 million square kilometres (3.85 million square miles), so it is the world's second largest country by total area but only the fourth largest country by land area.", "China is a country in East Asia and is the world's most populous country, with a population of around 1.428 billion in 2017. Covering approximately 9,600,000 square kilometers (3,700,000 sq mi), it is the third largest country by area.", "England is one of the four countries that make up the United Kingdom (UK). It is a country with over 60 counties in it. It is in a union with Scotland, Wales and Northern Ireland. All four countries are in the British Isles and are part of the UK.", " France is a country whose metropolitan territory is located in Western Europe and that also comprises various overseas islands and territories located in other continents.", "Nepal, country of Asia, lying along the southern slopes of the Himalayan mountain ranges. It is a landlocked country located between India to the east, south, and west and the Tibet Autonomous Region of China to the north.","Pakistan is a country in southern Asia. It is next to India, Iran, Afghanistan, and China. It is officially called the Islamic Republic of Pakistan. It has a long coastline along the Arabian Sea in the south. Pakistan has the fifth largest population (207.77 million) in the world. "};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_main, null);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data=new ArrayList<DataModel1>();
        for (int i = 0; i < MyData1.Desc.length; i++) {
            data.add(new DataModel1(

                    MyData1.drawableArray[i],
                    MyData1.Desc[i]

            ));
        }
        /*adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
        return view;*/

        adapter = new GridRecyclerView(data);
        recyclerView.setAdapter(adapter);
        return view;
    }
}