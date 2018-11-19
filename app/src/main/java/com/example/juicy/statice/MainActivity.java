package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Activity a;
    Context ctx;
    ImageView my_pic, your_pic, menu;
    TextView chat,calendar;
   // EditText profile_name;
    SharedPreferences sp;
   // String pr_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp",MODE_PRIVATE);

        my_pic = (ImageView)findViewById(R.id.my_pic);
        my_pic.setOnClickListener(this);
        your_pic = (ImageView)findViewById(R.id.your_pic);
        your_pic.setOnClickListener(this);
        menu = (ImageView)findViewById(R.id.menu);
        menu.setOnClickListener(this);
        chat = (TextView)findViewById(R.id.chat);
        chat.setOnClickListener(this);
        calendar = (TextView)findViewById(R.id.calendar);
        calendar.setOnClickListener(this);

    }
        //String pr_name = sp.getString("profile_name","");
       // sp.edit().putString("pr_name",profile_name).commit();

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_pic:
                startActivity(new Intent(ctx, ProfileActivity.class));
                break;

            case R.id.your_pic:
                startActivity(new Intent(ctx, SettingsActivity.class));
                break;

            case R.id.menu:
                startActivity(new Intent(ctx, MenuActivity.class));
                break;
            case R.id.chat:
                startActivity(new Intent(ctx, ChatActivity.class));
                break;
            case R.id.calendar:
                startActivity(new Intent(ctx, CalendarActivity.class));
                break;
        }
    }
}
