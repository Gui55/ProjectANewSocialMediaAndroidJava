package com.example.anewsocialmedia.ui.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.anewsocialmedia.ui.view.fragment.AnimesFragment;
import com.example.anewsocialmedia.ui.view.fragment.GamesFragment;

public class SecondACTViewPagerAdapter extends FragmentPagerAdapter {

    public SecondACTViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new GamesFragment();

            case 1:
                return new AnimesFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Games";

            case 1:
                return "Animes";
        }

        return null;

    }
}
