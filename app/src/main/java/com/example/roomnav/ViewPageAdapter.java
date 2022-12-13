package com.example.roomnav;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.roomnav.Fragments.AvailableRoomsFragment;
import com.example.roomnav.Fragments.ListOfRoomsFragment;
import com.example.roomnav.Fragments.OccupiedRoomsFragment;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new AvailableRoomsFragment();
            case 2:
                return new OccupiedRoomsFragment();
            case 0:
            default:
                return new ListOfRoomsFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
