package com.kt.sangsang;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SalesManagerActivity extends ParentActivity {

    public Toolbar toolbar;
    public TextView editStart;
    public TextView editEnd;
    public TextView lblOk;
    public EditText editArea;
    public Sales item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_manager);
        toolbar = findViewById(R.id.toolbar);
        updateToolbar(toolbar, "판매관리");

        item = getIntent().getParcelableExtra("item");

        editStart = findViewById(R.id.editStart);
        editStart.setTag(0L);
        editStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker((TextView) v);
            }
        });
        editEnd = findViewById(R.id.editEnd);
        editEnd.setTag(0L);
        editEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker((TextView) v);
            }
        });
        editArea = findViewById(R.id.editArea);
        lblOk = findViewById(R.id.lblOk);
        lblOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                App.mPrefEdit.putString("sales_content",editArea.getText().toString()).commit();
//                App.mPrefEdit.putString("sales_start",editStart.getText().toString()).commit();
//                App.mPrefEdit.putString("sales_end",editEnd.getText().toString()).commit();
                if(item != null) {
                    item.content = editArea.getText().toString();
                    item.startDate = (long) editStart.getTag();
                    item.endDate = (long) editEnd.getTag();
                    item.date = item.getRangeDate();
                    DummyManager.modifySalesItem(item.id, item);
                } else {
                    DummyManager.addSalesItem(new Sales(DummyManager.getSalesItem().size(), editArea.getText().toString(), (Long)editStart.getTag(), (Long)editEnd.getTag()));
                }
                startActivity(new Intent(SalesManagerActivity.this, SalesManagerMainActivity.class));
                finish();
            }
        });

        updateUI();
    }

    public void updateUI() {
//        String content = App.mPref.getString("sales_content", "");
//        String start = App.mPref.getString("sales_start", "");
//        String end = App.mPref.getString("sales_end", "");
        if(item != null) {
            editArea.setText(item.content);

            if(item.startDate > 0) {
                Calendar startCal = Calendar.getInstance();
                startCal.setTimeInMillis(item.startDate);
                editStart.setText(Util.format(startCal, "yyyy-MM-dd"));
                editStart.setTag(item.startDate);
            }

            if(item.endDate > 0) {
                Calendar startCal = Calendar.getInstance();
                startCal.setTimeInMillis(item.endDate);
                editEnd.setText(Util.format(startCal, "yyyy-MM-dd"));
                editEnd.setTag(item.endDate);
            }
        }

    }

    public void showDatePicker(final TextView target) {

        Calendar startCal = Calendar.getInstance();
        if(target == editEnd ) {
            if(editStart.getTag() == null) {
                Toast.makeText(this, "시작날짜를 입력해 주세요.", Toast.LENGTH_LONG).show();
                return;
            }

            startCal = Calendar.getInstance();
            startCal.setTimeInMillis((Long) editStart.getTag());
        }


        // DatePickerDialog
        final Calendar finalStartCal = startCal;
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                if(target == editEnd && calendar.getTimeInMillis() <= finalStartCal.getTimeInMillis()) {
                    Toast.makeText(SalesManagerActivity.this, "시작날짜보다 커야합니다", Toast.LENGTH_LONG).show();
                    return;
                }

                target.setText(Util.format(calendar,"yyyy-MM-dd"));
                target.setTag(calendar.getTimeInMillis());
            }
        }, startCal.get(Calendar.YEAR),
                startCal.get(Calendar.MONTH),
                startCal.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}
