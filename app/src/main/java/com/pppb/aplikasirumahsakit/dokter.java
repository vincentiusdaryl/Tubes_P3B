package com.pppb.aplikasirumahsakit;

import android.os.Parcel;
import android.os.Parcelable;

public class dokter implements Parcelable{
    private String nama;
    private String id;
    private String noTelp;

    public dokter(){

    }

    protected dokter(Parcel in) {
        this.id = in.readString();
        this.nama = in.readString();
        this.noTelp = in.readString();
    }

    public void setId(String id){
        this.id=id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNoTelp(String noTelpon) {
        this.noTelp = noTelpon;
    }
    public String getid() {
        return this.id;
    }
    public String getNama() {
        return this.nama;
    }
    public String getNoTelp(){
        return this.noTelp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.noTelp);
    }

    public static final Parcelable.Creator<dokter> CREATOR = new Parcelable.Creator<dokter>() {
        @Override
        public dokter createFromParcel(Parcel in) {
            return new dokter(in);
        }

        @Override
        public dokter[] newArray(int size) {
            return new dokter[size];
        }
    };


}

