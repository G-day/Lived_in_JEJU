package com.example.gday_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("살어리랏다 in JEJU");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button mappage=(Button)findViewById(R.id.mappage);//자전거 대여소 맵으로 이동

       mappage.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"자전거 대여소 페이지 입니다.",Toast.LENGTH_LONG).show();;
               //페이지 넘길때 안내말말
              Intent myintent=new Intent(MainActivity.this,SecondActivity.class);
              //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
               startActivity(myintent);
               finish();

           }
       });
       //----------------------------------------------------------------------------------자전거대여소:송히
        Button mappage2=(Button)findViewById(R.id.mappage2);//산책로 맵으로 이동

        mappage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"산책로 페이지 입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent2=new Intent(MainActivity.this,ThirdActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent2);
                finish();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void updateUI(FirebaseUser currentUser) {
    }

}
