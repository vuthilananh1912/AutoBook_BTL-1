package com.vtlallklmc.autobook_btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        navigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);

        setUpViewPager();

        navigationView.setOnNavigationItemSelectedListener(item ->  {
                switch (item.getItemId()){
                    case R.id.newCarItem:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bestSelledItem:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.brandItem:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
        });
    }
    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.newCarItem).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.bestSelledItem).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.brandItem).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}