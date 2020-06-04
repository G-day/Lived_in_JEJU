package com.example.gday_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//-------------------구글맵
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//-------------------구글맵
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //구글맵
        FragmentManager fragmentManager = getFragmentManager();
        //구글맵
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);


    }
    @Override//구글맵이 준비가 되면 호출
    public void onMapReady(GoogleMap googleMap) {
        //마커 찍기(핀)
        LatLng location=new LatLng(33.506109, 126.510333);//위도 경도(제주도 보물섬)
        MarkerOptions markerOptions= new MarkerOptions();
        markerOptions.title("제주도 보물섬");
        markerOptions.snippet("자전거 대여소!");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);//마커옵션 생성

        //실제 마커를 비추고 있는 화면
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));

    }
    @Override
    public void onStart() {
        super.onStart();
    }

    private void updateUI(FirebaseUser currentUser) {
    }


    // 회원가입 버튼 클릭 시
    public void joinBtn(View v){

    }
}
