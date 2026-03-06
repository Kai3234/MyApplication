package com.example.vocab;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class VocabDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_detail);


        Intent intent = getIntent();
        ArrayList<Vocab> vocabList = (ArrayList<Vocab>) intent.getSerializableExtra("vocabList");
        int position = intent.getIntExtra("position", 0); // Lấy vị trí từ Intent, mặc định là 0 nếu không có giá trị được truyền


        ViewPager2 viewPager = findViewById(R.id.viewPager);
        VocabPagerAdapter adapter = new VocabPagerAdapter(this, vocabList);
        viewPager.setAdapter(adapter);
        // Hiển thị bắt đầu ở vị trí position
        viewPager.setCurrentItem(position);
    }
}


