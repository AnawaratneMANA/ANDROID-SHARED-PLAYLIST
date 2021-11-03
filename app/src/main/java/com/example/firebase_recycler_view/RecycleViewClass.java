package com.example.firebase_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.firebase_recycler_view.Adapters.CardItemAdapter;
import com.example.firebase_recycler_view.Mode.CardItem;
import com.example.firebase_recycler_view.Mode.Upload;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewClass extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    CardItemAdapter mainRecyclerAdapter;
    DatabaseReference database;
    List<CardItem> fireArrayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recycle_view);

        /** Database connection to the Schema **/
        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");


        //Add items to the category item model class.
        List<CardItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));

        //Firebase method to Get the data.
        // Calling the layout setting method.
        fireArrayItems = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    // Transfer the objects into CategoryItems.
                    CardItem categoryItem = new CardItem(upload.getName(), upload.getDescription(), upload.getSubName(), upload.getImageUrl());
                    /** Conditionally Adding the Items to the Array Respect to the Category name **/
                    fireArrayItems.add(categoryItem);
                }
                mainRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        setMainCategoryRecycler(categoryItems);
    }

    private void setMainCategoryRecycler(List<CardItem> allCategoriesList){
        mainCategoryRecycler = findViewById(R.id.search_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new CardItemAdapter(this, fireArrayItems);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}