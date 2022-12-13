package com.example.roomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv_appName = findViewById(R.id.act_login_tv_appName);
        Button btn_officeLogin = findViewById(R.id.act_login_btn_officeLogin);

        SetAppNameColor(tv_appName);

        btn_officeLogin.setOnClickListener(view ->
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void SetAppNameColor(TextView textView) {
        SpannableString appNameSpannable = new SpannableString(textView.getText().toString());
        appNameSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#fbaf17")),
                4,
                8,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(appNameSpannable);
    }
}