package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Activity a;
    Context ctx;
    TextView cancel, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        a = this;
        ctx = this;

        cancel = (TextView)findViewById(R.id.cancel);
        confirm = (TextView)findViewById(R.id.confirm);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel:
                finish();
                break;
            case R.id.confirm:
                Toast.makeText(ctx, "비밀번호가 설정되었습니다!",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
