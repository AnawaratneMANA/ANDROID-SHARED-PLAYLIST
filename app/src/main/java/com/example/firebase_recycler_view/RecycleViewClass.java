package com.example.firebase_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.firebase_recycler_view.Adapters.CardItemAdapter;
import com.example.firebase_recycler_view.Mode.CardItem;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewClass extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    CardItemAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recycle_view);


        //Add items to the category item model class.
        List<CardItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));

        setMainCategoryRecycler(categoryItems);
    }

    private void setMainCategoryRecycler(List<CardItem> allCategoriesList){
        mainCategoryRecycler = findViewById(R.id.search_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new CardItemAdapter(this, allCategoriesList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}