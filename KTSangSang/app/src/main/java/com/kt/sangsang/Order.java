package com.kt.sangsang;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    public int id;
    public String title;
    public int price;
    public boolean checked;

    public Order(String title) {
        this.title = title;
    }

    public Order(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.price);
        dest.writeByte(this.checked ? (byte) 1 : (byte) 0);
    }

    protected Order(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.price = in.readInt();
        this.checked = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
