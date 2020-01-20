package com.app.quickapp;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private TabLayout tabLayout;
    private ImageButton next;
    private TextView address;
    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        next = findViewById(R.id.nxt);
        back = findViewById(R.id.back);
        address = findViewById(R.id.address);
        viewPager = findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        Intent i = getIntent();
        if(i.getStringExtra("id") != null)
            address.setText(i.getStringExtra("id"));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this , HomeActivity.class));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nxt:
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
                if (viewPager.getCurrentItem() == 2)
                    startActivity(new Intent(ResultActivity.this , ThankYou.class));
                break;
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}

