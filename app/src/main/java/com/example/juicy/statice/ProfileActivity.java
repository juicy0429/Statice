package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Activity a;
    Context ctx;
    TextView cancel, confirm;
    EditText name, hp, birth, mail, firstdate;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp",MODE_PRIVATE);

        cancel = (TextView) findViewById(R.id.cancel);
        confirm = (TextView) findViewById(R.id.confirm);
        name = (EditText) findViewById(R.id.name);
        hp = (EditText) findViewById(R.id.hp);
        birth = (EditText) findViewById(R.id.birth);
        mail = (EditText) findViewById(R.id.mail);
        firstdate = (EditText) findViewById(R.id.firstdate);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);

        String sp_name = sp.getString("change_name","");
        String sp_hp = sp.getString("change_hp","");
        String sp_birth = sp.getString("change_birth","");
        String sp_mail = sp.getString("change_mail","");
        String sp_firstdate = sp.getString("change_firstdate","");

        name.setText(sp_name);
        hp.setText(sp_hp);
        birth.setText(sp_birth);
        mail.setText(sp_mail);
        firstdate.setText(sp_firstdate);
//        Toast.makeText(ctx, sp_name, Toast.LENGTH_SHORT).show();
    }
//            @Override
//            public void onClick(View view) {
////                finish();
//                aaaaaaaaaaaa("취소");
//            }
//        });

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm:
                String change_name = name.getText().toString();
                sp.edit().putString("change_name",change_name).commit();
                sp.edit().putString("change_hp",hp.getText().toString()).commit();
                sp.edit().putString("change_birth",birth.getText().toString()).commit();
                sp.edit().putString("change_mail",mail.getText().toString()).commit();
                sp.edit().putString("change_firstdate",firstdate.getText().toString()).commit();

                Toast.makeText(ctx, "수정이 완료되었습니다!", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

//    public void aaaaaaaaaaaa(String msg){
//        Toast.makeText(ctx, msg+"",Toast.LENGTH_SHORT).show();
//    }
}
