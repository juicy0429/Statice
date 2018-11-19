package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    Activity a;
    Context ctx;
    ImageView setting;
    // EditText profile_name;
    SharedPreferences sp;
    // String pr_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp",MODE_PRIVATE);

        setting = (ImageView)findViewById(R.id.settings);
        setting.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settings:
                startActivity(new Intent(ctx, SettingsActivity.class));
                break;
        }
    }
}
