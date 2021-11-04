package com.example.firebase_recycler_view;
import androidx.annotation.NonNull;
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

        //Database connection.
        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");

        //Add items to the category item model class.
        List<CardItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));
        categoryItems.add(new CardItem("Name", R.drawable.image_3, "This is sample description", "subheading"));

        //Firebase Datastore.
        fireArrayItems = new ArrayList<>();
        //Firebase Listening Method.
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    CardItem cardItem = new CardItem(upload.getName(), upload.getDescription(), upload.getSubName(), upload.getImageUrl());
                    fireArrayItems.add(cardItem);
                }
                mainRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Error | RecycleViewClass Firebase Listener");
            }
        });
        setMainCategoryRecycler();
    }

    private void setMainCategoryRecycler(){
        mainCategoryRecycler = findViewById(R.id.search_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new CardItemAdapter(this, fireArrayItems);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}