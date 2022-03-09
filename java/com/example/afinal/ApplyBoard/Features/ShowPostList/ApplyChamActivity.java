package com.example.afinal.ApplyBoard.Features.ShowPostList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.afinal.ApplyBoard.Features.CreatePost.ApplyPostCreateActivity;
import com.example.afinal.R;

import androidx.appcompat.app.AppCompatActivity;

public class ApplyChamActivity extends AppCompatActivity {

    private String phoneNum;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_click);

        phoneNum = "01012345677";

        findViewById(R.id.call).setOnClickListener(onClickListener);
        findViewById(R.id.message).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.call:
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phoneNum)));
                    break;
                case R.id.message:
                    Uri n = Uri.parse("smsto: " + phoneNum);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, n);
                    startActivity(intent);
                    break;
            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
