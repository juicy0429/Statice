package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    Activity a;
    Context ctx;
    ImageView back;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp", MODE_PRIVATE);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                startActivity(new Intent(ctx, MainActivity.class));
                finish();
        }
    }
}



