package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class BackgroundChangingActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.background_changing_activity);

        Intent intent = getIntent();
        String color = intent.getStringExtra("color");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(color));
    }
}