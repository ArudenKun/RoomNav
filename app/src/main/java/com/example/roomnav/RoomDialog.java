package com.example.roomnav;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class RoomDialog {

    private Context mContext;

    public RoomDialog(Context context) {
        mContext = context;
    }

    public Dialog makeDialog() {
        Dialog dialog = new Dialog(mContext);

        dialog.setContentView(R.layout.room_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

        return dialog;
    }

}
