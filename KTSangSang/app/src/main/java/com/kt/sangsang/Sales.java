package com.kt.sangsang;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created By sinhyeongseob on 2019-06-02
 */
public class Sales implements Parcelable {

    public int id;
    public String content;
    public long startDate;
    public long endDate;
    public String date;

    public Sales(int id,String content, long startDate, long endDate) {
        this.id= id;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.date = getRangeDate();
    }

    public Sales(int id, String content, long startDate, long endDate, String date) {
        this.id = id;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.date = date;
    }

    public Sales(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getRangeDate() {
        if(startDate > 0 && endDate > 0) {
            return Util.format(new Date(startDate), "M/dd") + "~" +
                    Util.format(new Date(endDate), "M/dd");
        }
        return "";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.content);
        dest.writeLong(this.startDate);
        dest.writeLong(this.endDate);
        dest.writeString(this.date);
    }

    protected Sales(Parcel in) {
        this.id = in.readInt();
        this.content = in.readString();
        this.startDate = in.readLong();
        this.endDate = in.readLong();
        this.date = in.readString();
    }

    public static final Creator<Sales> CREATOR = new Creator<Sales>() {
        @Override
        public Sales createFromParcel(Parcel source) {
            return new Sales(source);
        }

        @Override
        public Sales[] newArray(int size) {
            return new Sales[size];
        }
    };
}
