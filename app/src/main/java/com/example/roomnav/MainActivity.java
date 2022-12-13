package com.example.roomnav;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.act_main_toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        TabLayout tabLayout = findViewById(R.id.act_main_tab_layout);
        ViewPager2 viewPager = findViewById(R.id.act_main_viewPager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);

        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);
            switch (id) {
                default:
                    return true;
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 1:
                        toolbar.setTitle("Available Rooms");
                        break;
                    case 2:
                        toolbar.setTitle("Occupied Rooms");
                        break;
                    case 0:
                    default:
                        toolbar.setTitle("List of Rooms");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}