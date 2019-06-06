package com.kt.sangsang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SalesManagerModifyActivity extends ParentActivity implements AdapterView.OnItemClickListener {

    public Toolbar toolbar;
    public View layoutItem1;
    public View layoutItem2;
    public ListView listView;

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_manager_modify);

        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.listView);
        layoutItem1 = findViewById(R.id.layoutItem1);
        layoutItem2 = findViewById(R.id.layoutItem2);
        mAdapter = new MyAdapter(DummyManager.getSalesItem());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

        updateToolbar(toolbar, "판매관리 편집");

        Toast.makeText(this, "항목을 선택하시면 수정할 수 있습니다", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Sales sales = mAdapter.getItem(position);
        if(sales != null) {
            Intent intent = new Intent(this, SalesManagerActivity.class);
            intent.putExtra("item", sales);
            startActivity(intent);
        }
    }


    public class MyAdapter extends BaseAdapter {

        private ArrayList<Sales> data;

        public MyAdapter(ArrayList<Sales> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Sales getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_sales_modify, null, false);;
            }
            TextView lblContent = convertView.findViewById(R.id.lblContent);
            TextView lblDate = convertView.findViewById(R.id.lblDate);
            Sales sales = getItem(position);
            if(sales != null) {
                lblContent.setText(sales.content);
                lblDate.setText(sales.date);
            }

            return convertView ;
        }
    }


}
