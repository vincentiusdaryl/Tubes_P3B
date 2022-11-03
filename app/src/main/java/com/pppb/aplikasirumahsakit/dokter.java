package com.pppb.aplikasirumahsakit;

import android.os.Parcel;
import android.os.Parcelable;

public class dokter{
    private String nama;
    private String id;
    private String noTelp;
    private String spesialis;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public dokter(String nama, String noTelp, String id, String spesialis) {
        this.nama = nama;
        this.id = id;
        this.noTelp = noTelp;
        this.spesialis = spesialis;

    }




}

