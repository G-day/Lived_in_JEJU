package com.example.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Loading extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
