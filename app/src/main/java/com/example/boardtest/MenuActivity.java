package com.example.boardtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null) { // 만약 로그인이 안되어있으면 로그인화면으로
           myStartActivity(LoginActivity.class);
        }

        else { //로그인 되었으면 회원정보 가져옴
                for (UserInfo profile : user.getProviderData()) {
                    // Name, email address, and profile photo Url
                    String name = profile.getDisplayName();
                    Log.e("이름: ", "이름: " + name);
                    if (name != null) {
                        if (name.length() == 0) {
                            myStartActivity(MemberInfoActivity.class);
                        }
                    }
                }

        }


        findViewById(R.id.logoutBtn).setOnClickListener(onClickListener);
        findViewById(R.id.recruitBotton).setOnClickListener(onClickListener);
        findViewById(R.id.applyButton).setOnClickListener(onClickListener);
        findViewById(R.id.communicateBotton).setOnClickListener(onClickListener);
        findViewById(R.id.lookAroundButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() { // 뒤로가기 버튼 클릭했을 때 홈으로 이동하기
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.logoutBtn:
                    FirebaseAuth.getInstance().signOut();
                    startToast("로그아웃 되었습니다.");
                    myStartActivity(LoginActivity.class);
                    finish();
                    break;
                case R.id.recruitBotton:
                    myStartActivity(RecuritBoardActivity.class);
                    break;
                case R.id.applyButton:
                    myStartActivity(ApplyBoardActivity.class);
                    break;
                case R.id.communicateBotton:
                    myStartActivity(CommunicateBoardActivity.class);
                    break;
            }
        }
    };

    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent (this, c);
        startActivity(intent);
    }
}
