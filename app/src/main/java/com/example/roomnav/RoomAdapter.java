package com.example.roomnav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RoomAdapter extends ArrayAdapter<Room> {
    public RoomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Room> rooms) {
        super(context, resource, rooms);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.room_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.room_item_name);
        ImageView imageView = convertView.findViewById(R.id.room_item_image);
        textView.setText(getItem(position).name);
        imageView.setImageResource(getItem(position).imageId);
        imageView.setBackground(convertView.getResources().getDrawable(getItem(position).backgroundId));

        return convertView;
    }
}
