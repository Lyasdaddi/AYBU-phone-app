package com.example.think.hw;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import static com.example.think.hw.R.drawable.food;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private  SectionsPageAdapter mSection;
    private ViewPager mViewPager;
    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Starting.");
        mSection = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager= (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.food);
        tabLayout.getTabAt(1).setIcon(R.drawable.news);
        tabLayout.getTabAt(2).setIcon(R.drawable.ann);

    }


 private void setupViewPager(ViewPager viewPager){

     SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
     adapter.addFragment(new Food(),"FOOD");
     adapter.addFragment(new News(),"News");
     adapter.addFragment(new Ann(),"announcement");
     viewPager.setAdapter(adapter);}


     ////Food.setIcon(R.drawable.food);
     //News.setIcon(R.drawable.News);
     //Ann.setIcon(R.drawable.ann);





}
