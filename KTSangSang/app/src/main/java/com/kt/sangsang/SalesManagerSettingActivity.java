package com.kt.sangsang;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SalesManagerSettingActivity extends ParentActivity {

    public Toolbar toolbar;
    public View layoutDelete;
    public TextView lblExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_manager_setting);

        toolbar = findViewById(R.id.toolbar);
        updateToolbar(toolbar, "판매관리설정");

        layoutDelete = findViewById(R.id.layoutDelete);
        layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //삭제처리
                Toast.makeText(SalesManagerSettingActivity.this,
                        "DDB에서 정보 완전 삭제",
                        Toast.LENGTH_LONG).show();
            }
        });
        lblExit = findViewById(R.id.lblExit);
        lblExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SalesManagerSettingActivity.this,
                        "행사가 끝났다는 것을 DB에 저장하기 위한 기능",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
