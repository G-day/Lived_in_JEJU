package com.example.boardtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class WritePostActivity extends AppCompatActivity {
    private static final String TAG = "WritePostActivity";

    private String formatDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        findViewById(R.id.imageBtn).setOnClickListener(onClickListener);
        findViewById(R.id.videoBtn).setOnClickListener(onClickListener);
        findViewById(R.id.completeBtn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.completeBtn:
                    profileUpdate();
                    myStartActivity(SocialBoardActivity.class);
                    break;
                case R.id.imageBtn:

                    break;
                case R.id.videoBtn:

                    break;
            }
        }
    };

    private void dateNow() {
        //현재시간을 msec으로 구함.
        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장
        Date date = new Date(now);
        // 시간을 나타낼 포맷을 정함 (yyyy/MM/dd)
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy.MM.dd");
        // String 변수에 값을 저장
        formatDate = sdfNow.format(date);
    }


    private void profileUpdate() {
        String title = ((EditText) findViewById(R.id.titleEditText)).getText().toString();
        String content = ((EditText) findViewById(R.id.contentEditText)).getText().toString();
        dateNow();
        String userName = "Moon";


        if (title.length() > 0 && content.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            // Access a Cloud Firestore instance from your Activity
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            PostInfo postInfo = new PostInfo(title, content, userName, formatDate);

            if( user!= null){
                db.collection("SocialPost").document(user.getUid()).set(postInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("게시글 등록을 성공하였습니다.");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("게시글 등록에 실패하였습니다.");

                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }

        } else {
            startToast("게시글을 입력해주세요");
        }
    }


    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent (this, c);
        startActivity(intent);
    }
}
