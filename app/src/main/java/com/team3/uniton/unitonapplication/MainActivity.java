package com.team3.uniton.unitonapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MainResignationItem> mDatas = new ArrayList<>();

    LinearLayout mListLayout;

    Button mWriteResignationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mWriteResignationButton = findViewById(R.id.write_button);

        mWriteResignationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteResignationActivity.class);
                startActivity(intent);
            }
        });

        for (int i = 0 ;i< 10 ; i++) {
            MainResignationItem data = new MainResignationItem();
            ArrayList<String> contents = new ArrayList<>();
            contents.add("contents 0");
            contents.add("contents 1");
            contents.add("contents 2");
            data.setContents(contents);
            data.setDate("2018-06-20");

            mDatas.add(data);
        }

        mListLayout = findViewById(R.id.list_layout);


        for (MainResignationItem item : mDatas) {

            CustomMainItemView view = new CustomMainItemView(this);
            view.setData(item);
            mListLayout.addView(view);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
