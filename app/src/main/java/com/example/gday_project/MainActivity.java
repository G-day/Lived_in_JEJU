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
    GoogleMap mMap;

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
        mMap=googleMap;

        //구글맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions markerOptions= new MarkerOptions();
        markerOptions.position(new LatLng(33.506109, 126.510333))//위도 경도(제주도 보물섬)위치설정
                .title("제주도 보물섬")
                .snippet("자전거 대여소!")
                .alpha(0.7f);//마커의 투명도 설정
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.516262, 126.505955))//
                .title("제주도 2")
                .snippet("자전거 2!")
                .alpha(0.7f);//마커의 투명도 설정

        mMap.addMarker(markerOptions);//마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.516262, 126.505955),16));
        //카메라가 보이는 위치
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    private void updateUI(FirebaseUser currentUser) {
    }

}
