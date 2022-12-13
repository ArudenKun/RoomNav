package com.example.roomnav.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.roomnav.R;
import com.example.roomnav.Room;
import com.example.roomnav.RoomAdapter;
import com.example.roomnav.RoomDialog;

import java.util.ArrayList;

public class OccupiedRoomsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_occupied_rooms, container, false);
        ListView listView = fragmentView.findViewById(R.id.frag_or_listView);
        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            rooms.add(new Room("Room 60" + i, R.drawable.nav_occupied_rooms_icons, R.drawable.room_item_occupied_room_shape));
        }

        RoomAdapter roomAdapter = new RoomAdapter(fragmentView.getContext(), R.layout.room_item, rooms);
        listView.setAdapter(roomAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            RoomDialog roomDialog = new RoomDialog(fragmentView.getContext());
            Dialog dialog = roomDialog.makeDialog();
            dialog.show();
        });
        return fragmentView;
    }
}