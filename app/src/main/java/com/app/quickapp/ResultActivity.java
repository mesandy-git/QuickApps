package com.app.quickapp;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private TabLayout tabLayout;
    private ImageButton next;
    private TextView address;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        next = findViewById(R.id.nxt);
        back = findViewById(R.id.prv);
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
            Toast.makeText(this,""+i.getStringExtra("id"),Toast.LENGTH_SHORT);
            //address.setText(i.getStringExtra("id"));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this , HomeActivity.class));
        overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_right);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nxt:
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
                back.setVisibility(View.VISIBLE);
                if (viewPager.getCurrentItem() == 2)
                    next.setVisibility(View.GONE);
                break;
            case R.id.prv:
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1, true);
                next.setVisibility(View.VISIBLE);
                if (viewPager.getCurrentItem() == 0)
                    back.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition( R.anim.slide_out_right, R.anim.slide_in_left);
    }
}

