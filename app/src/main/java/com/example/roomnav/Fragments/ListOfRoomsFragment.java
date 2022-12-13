package com.example.roomnav.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.roomnav.R;
import com.example.roomnav.Room;
import com.example.roomnav.RoomAdapter;
import com.example.roomnav.RoomDialog;

import java.util.ArrayList;

public class ListOfRoomsFragment extends Fragment {
    View fragmentView;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_list_of_rooms, container, false);
        listView = fragmentView.findViewById(R.id.frag_lor_listView);

        ArrayList<Room> rooms = new ArrayList<>();

        ArrayList<Integer> imageIds = new ArrayList<>();
        imageIds.add(R.drawable.nav_available_rooms_icon);
        imageIds.add(R.drawable.nav_occupied_rooms_icons);

        ArrayList<Integer> backgroundIds = new ArrayList<>();
        backgroundIds.add(R.drawable.room_item_available_room_shape);
        backgroundIds.add(R.drawable.room_item_occupied_room_shape);

        for (int i = 0; i < 10; i++) {
            int randIndex = (int) (Math.random() * imageIds.size());
            rooms.add(new Room("Room 50" + i, imageIds.get(randIndex), backgroundIds.get(randIndex)));
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