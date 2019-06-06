package com.kt.sangsang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button screenshot_1;
    public Button screenshot_2;
    public Button screenshot_3;
    public Button screenshot_4;
    public Button screenshot_5;
    public Button screenshot_6;
    public Button screenshot_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenshot_1 = findViewById(R.id.screenshot_1);
        screenshot_2 = findViewById(R.id.screenshot_2);
        screenshot_3 = findViewById(R.id.screenshot_3);
        screenshot_4 = findViewById(R.id.screenshot_4);
        screenshot_5 = findViewById(R.id.screenshot_5);
        screenshot_6 = findViewById(R.id.screenshot_6);
        screenshot_7 = findViewById(R.id.screenshot_7);
    }

    public void screenshot_1(View view) {
        startActivity(new Intent(this, SalesManagerActivity.class));
    }

    public void screenshot_2(View view) {
        startActivity(new Intent(this, SalesManagerSettingActivity.class));
    }

    public void screenshot_3(View view) {
        startActivity(new Intent(this, SalesManagerMainActivity.class));
    }

    public void screenshot_4(View view) {
        startActivity(new Intent(this, SalesManagerModifyActivity.class));
    }

    public void screenshot_5(View view) {
        startActivity(new Intent(this, OrderManagerActivity.class));
    }

    public void screenshot_6(View view) {
        startActivity(new Intent(this, OrderRegisterActivity.class));
    }

    public void screenshot_7(View view) {
        startActivity(new Intent(this, SalesManagerActivity.class));
    }

}
