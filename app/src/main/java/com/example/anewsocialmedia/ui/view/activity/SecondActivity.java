package com.example.anewsocialmedia.ui.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.anewsocialmedia.R;
import com.example.anewsocialmedia.ui.adapters.SecondACTViewPagerAdapter;
import com.example.anewsocialmedia.viewmodel.SecondActivityViewModel;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    SecondActivityViewModel viewModel;
    TabLayout tabLayout;
    ViewPager viewPager;
    SecondACTViewPagerAdapter vpAdapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        configureToolbar("Início");

        configureTabAndViewPager();

        configureDrawer();

        viewModel = new ViewModelProvider(this).get(SecondActivityViewModel.class);
    }

    private void configureDrawer() {

        drawerLayout = findViewById(R.id.drawerLayout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.addDrawerListener(toggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void configureTabAndViewPager() {

        tabLayout = findViewById(R.id.secondACTTabLayout);
        viewPager = findViewById(R.id.secondsACTViewpager);
        vpAdapter = new SecondACTViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void configureToolbar(String title){
        toolbar = findViewById(R.id.include);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.little_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.itemA:
                //Deslogar
                viewModel.signOUtUser();
                startActivity(new Intent(this, MainActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
