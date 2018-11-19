package com.example.juicy.statice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Activity a;
    Context ctx;
    TextView sign_up, login;
    EditText id, pw;

    String server_id="test@test.co.kr";
    String server_pw="1234";
//임시로 아이디와 비밀번호를 string으로 받아 저장해놓은 상태

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        a = this;
        ctx = this;
        sp = getSharedPreferences("sp", MODE_PRIVATE);
        //왜 이렇게 쓰는지 모른다. 그냥 받아들여라

        sign_up = (TextView)findViewById(R.id.sign_up);
        login = (TextView)findViewById(R.id.login);
        id = (EditText)findViewById(R.id.id);
        pw = (EditText)findViewById(R.id.pw);

        login.setOnClickListener(this);
        sign_up.setOnClickListener(this);

        String sp_id = sp.getString("login_id","");
        String sp_pw = sp.getString("login_pw","");

//sp_id = login_id와 기본값을 getString한다.


        if(!sp_id.equals("")){
            if(!sp_pw.equals("")){
                login(sp_id, sp_pw);
                //sp_id와 sp_pw가 기본값과 같지 않다면, 즉 저장해놓은 정보와 같다면 login함수를 실행한다.
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login:
                String email = id.getText().toString();
                //id 내용을, getText() 말 그대로 받는다.
                //getText 로 텍스트를 가져오면, 데이터 형태 String
                //원래 EditText라는넘이 텍스트 뿐만 아니라 이미지, 링크 같은것도 입력할 수 있도록 되어 있습니다.
                //그래서 getText로 나온 Editable은 Charsequence를 인자로 받는 곳에는 바로 넣을 수 있지만,
                //String을 인자로 받는 곳에는 바로 쓸 수 없기 때문에 Charsequence의 toString을 사용하여 String으로 바꿔주는 겁니다.

                String password = pw.getText().toString();
                if(email.equals("")){
                    Toast.makeText(ctx,"이메일이 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("")){
                    Toast.makeText(ctx,"비밀번호가 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(pw)){
                    Toast.makeText(ctx,"이메일이나 비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show();
                }
                else if(email.equals(id)&&password.equals(pw)){
                    Toast.makeText(ctx, "로그인되었습니다.", Toast.LENGTH_SHORT).show();
                }


//                Toast.makeText(ctx, "id:"+email, Toast.LENGTH_SHORT).show();
                login(email,password);

                //startActivity(new Intent(ctx, MainActivity.class));
                //finish();
                break;
            case R.id.sign_up:
                startActivity(new Intent(ctx, SignUpActivity.class));
                break;
        }
    }

    public void login(String id, String pw){
        if(server_id.equals(id)){
            //Toast.makeText(ctx, "일치합니다", Toast.LENGTH_SHORT).show();
            if(server_pw.equals(pw)){
                sp.edit().putString("login_id",id).commit();
                sp.edit().putString("login_pw",pw).commit();

                startActivity(new Intent(ctx, MainActivity.class));
                finish();


            }
            else
                Toast.makeText(ctx,"일치하지 않습니다",Toast.LENGTH_SHORT).show();

        //    if(!server_id.equals(id)){
         //       Toast.makeText(ctx,"이메일이 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
         //   }
         //   if(!server_pw.equals(pw)){
          //      Toast.makeText(ctx,"이메일이나 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
          //  }
        }

    }
}