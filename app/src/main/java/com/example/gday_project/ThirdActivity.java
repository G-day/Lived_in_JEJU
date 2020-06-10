package com.example.gday_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ThirdActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("산책로");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //구글맵
        FragmentManager fragmentManager = getFragmentManager();
        //구글맵
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //구글맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(33.389713, 126.235304))//위도 경도(고살리숲길)위치설정
                .title("금능으뜸원해변")
                .snippet("제주도 산책로 : 해변")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.385831, 126.227402))//
                .title("금능 식물원")
                .snippet("제주도 산책로 : 식물원")
                .alpha(0.7f)//마커의 투명도 설정
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경

        mMap.addMarker(markerOptions);//마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.387026, 126.231737), 14));
        //카메라가 보이는 위치
    }
}