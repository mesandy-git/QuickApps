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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private ImageButton next;
    private Button submit;
    private TextView address;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        submit = findViewById(R.id.submit);
        next = findViewById(R.id.nxt);
        back = findViewById(R.id.prv);
        address = findViewById(R.id.address);
        viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
        Intent in = getIntent();
        if(in.getStringExtra("id") != null)
            Toast.makeText(this,""+in.getStringExtra("id"),Toast.LENGTH_SHORT);
            //address.setText(in.getStringExtra("id"));
        LinearLayout tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
        tabStrip.setEnabled(false);
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setClickable(false);
        }
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
                if (viewPager.getCurrentItem() == 2){
                    next.setVisibility(View.GONE);
                    submit.setVisibility(View.VISIBLE);}
                break;
            case R.id.prv:
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1, true);
                next.setVisibility(View.VISIBLE);
                submit.setVisibility(View.GONE);
                if (viewPager.getCurrentItem() == 0)
                    back.setVisibility(View.GONE);
                break;
            case R.id.submit:
                startActivity(new Intent(ResultActivity.this , ThankYou.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition( R.anim.slide_out_right, R.anim.slide_in_left);
    }
}

