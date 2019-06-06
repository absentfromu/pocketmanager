package com.kt.sangsang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderSalesActivity extends ParentActivity implements AdapterView.OnItemClickListener {

    public Toolbar toolbar;
    public FloatingActionButton fltAction;
    public ListView listView;

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sales);

        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.listView);
        fltAction = findViewById(R.id.fltAction);
        fltAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(OrderSalesActivity.this, OrderAddActivity.class),0);
            }
        });
        mAdapter = new MyAdapter(DummyManager.getOrdersItem());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

        updateToolbar(toolbar, "상품목록");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Order order = mAdapter.getItem(position);
        if(order != null) {
            Intent intent = new Intent(this, OrderAddActivity.class);
            intent.putExtra("item", order);
            startActivityForResult(intent,0);
        }
    }


    public class MyAdapter extends BaseAdapter {

        private ArrayList<Order> data;

        public MyAdapter(ArrayList<Order> data) {
            this.data = data;
        }

        public void init(ArrayList<Order> data) {
            this.data = data;
            notifyDataSetChanged();
        }


        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Order getItem(int position) {
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
            lblDate.setVisibility(View.GONE);

            Order order = getItem(position);
            if(order != null) {
                lblContent.setText(order.title);
            }

            return convertView ;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mAdapter.init(DummyManager.getOrdersItem());
    }
}
