package com.app.quickapp;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;


public class ResultActivity extends FragmentActivity {
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private TabLayout tabLayout;
    private ImageButton next;
    private TextView address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        next = findViewById(R.id.nxt);
        address = findViewById(R.id.address);
        viewPager = findViewById(R.id.viewPager);
        Intent intent = getIntent();
        if (intent.getStringExtra("id") != null)
            address.setText(intent.getStringExtra("id"));
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
                if (viewPager.getCurrentItem() == 2)
                    startActivity(new Intent(ResultActivity.this , ThankYou.class));
            }
        });

    }

}
