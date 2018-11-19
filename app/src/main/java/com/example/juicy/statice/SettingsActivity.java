package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    Activity a;
    Context ctx;
    TextView logout;
    RelativeLayout profile, password, reset;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp",MODE_PRIVATE);

        profile=(RelativeLayout) findViewById(R.id.change_profile);
        profile.setOnClickListener(this);
        password=(RelativeLayout)findViewById(R.id.password);
        password.setOnClickListener(this);
        reset=(RelativeLayout)findViewById(R.id.reset);
        reset.setOnClickListener(this);
        logout=(TextView)findViewById(R.id.logout);
        logout.setOnClickListener((this));

    }


    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.change_profile:
              startActivity(new Intent(ctx, ProfileActivity.class));
              break;
          case R.id.password:
              startActivity(new Intent(ctx, PasswordActivity.class));
              break;
          case R.id.reset:
              startActivity(new Intent(ctx, ResetActivity.class));
              break;
          case R.id.logout:
              sp.edit().putString("login_id","").commit();
              sp.edit().putString("login_pw","").commit();
              startActivity(new Intent(ctx, SplashActivity.class));
              finishAffinity();//동일 패지지 내 모든 액티비티 종료
              break;

      }
    }
}
