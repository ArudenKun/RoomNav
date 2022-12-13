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

public class AvailableRoomsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_available_rooms, container, false);
        ListView listView = fragmentView.findViewById(R.id.frag_ar_listView);
        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            rooms.add(new Room("Room 30" + i, R.drawable.nav_available_rooms_icon, R.drawable.room_item_available_room_shape));
        }

        RoomAdapter roomAdapter = new RoomAdapter(getActivity().getApplicationContext(), R.layout.room_item, rooms);
        listView.setAdapter(roomAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            RoomDialog roomDialog = new RoomDialog(fragmentView.getContext());
            Dialog dialog = roomDialog.makeDialog();
            dialog.show();
        });
        return fragmentView;
    }
}