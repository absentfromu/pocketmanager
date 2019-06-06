package com.kt.sangsang;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class OrderAddActivity extends ParentActivity {

    public Toolbar toolbar;
    public TextView lblOk;
    public EditText editPrice;
    public EditText editItem;
    public Order item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_add);
        toolbar = findViewById(R.id.toolbar);
        updateToolbar(toolbar, "상품관리");

        item = getIntent().getParcelableExtra("item");

        editItem = findViewById(R.id.editItem);
        editPrice = findViewById(R.id.editPrice);
        lblOk = findViewById(R.id.lblOk);
        lblOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                App.mPrefEdit.putString("sales_content",editArea.getText().toString()).commit();
//                App.mPrefEdit.putString("sales_start",editStart.getText().toString()).commit();
//                App.mPrefEdit.putString("sales_end",editEnd.getText().toString()).commit();
                if(item != null) {
                    item.title = editItem.getText().toString();
                    item.price = Integer.valueOf(editPrice.getText().toString());
                    DummyManager.modifyOrder(item.id, item);
                } else {
                    DummyManager.addOrder(new Order(DummyManager.getSalesItem().size(), editItem.getText().toString(), Integer.valueOf(editPrice.getText().toString())));
                }
                finish();
            }
        });

        updateUI();
    }

    public void updateUI() {
        if(item != null) {
            editItem.setText(item.title);
            editPrice.setText(item.price+"");
        }
    }

}
