package com.pppb.aplikasirumahsakit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class dbDokterAdapter extends SQLiteOpenHelper{

    private static final String DB_Name = "Dokters.db";
    private static final String DB_TABLE = "DOKTERS_TABLE";

    //Kolom
    public static final String KEY_ID = "_id";
    public static final String KEY_NAMA = "namaTEXT";
    public static final String KEY_SPESIALIS = "spesialis";
    public static final String KEY_NOTELP = "noTelponTEXT";

    public static final String[] ALL_KEYS = new String[]{KEY_ID,KEY_NAMA,KEY_SPESIALIS,KEY_NOTELP};
    //bikinTabel
    public static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (" +
            KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            KEY_NAMA+ " TEXT,"+
            KEY_SPESIALIS+ " TEXT,"+
            KEY_NOTELP+ " TEXT"+
            ")" ;

    public dbDokterAdapter(Context context){
        super(context,DB_Name,null,6);
    }
    public void open(){
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long insertBaris(String nama,String spesialis,String noTelp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAMA,nama);
        initialValues.put(KEY_SPESIALIS,spesialis);
        initialValues.put(KEY_NOTELP,noTelp);
        //Insert data ke DB
        return db.insert(DB_TABLE,null,initialValues);
    }

    public boolean deleteBaris(long rowID){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = KEY_ID + "=" + rowID;
        return db.delete(DB_TABLE,where,null)!=0;
    }

    public boolean deleteBarisNama(String namaDokter){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DB_TABLE, KEY_NAMA + "=?", new String[]{String.valueOf(namaDokter)})>0;
    }

    public void deleteAll(){

        Cursor c = getSemuaBaris();
        long rowID = c.getColumnIndexOrThrow(KEY_ID);
        if(c.moveToFirst()){
            do{
                deleteBaris(c.getLong((int) rowID));
            } while (c.moveToNext());
        }
        c.close();
    }
    //Return data-data di DB
    public Cursor getSemuaBaris(){
        SQLiteDatabase db = this.getReadableDatabase();
        String where = null;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS, where ,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public ArrayList<dokter> getDokterData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<dokter> arrayList = new ArrayList<>();
        String query = "Select * from " + DB_TABLE;
        Cursor cursor = db.query(true,DB_TABLE,ALL_KEYS, null ,null,null,null,null,null);
        while (cursor.moveToNext()){
            String id = cursor.getString(3);
            String name = cursor.getString(0);
            String spesialis = cursor.getString(1);
            String noTelpon = cursor.getString(2);
            dokter dokters = new dokter(id,name,spesialis,noTelpon);
            arrayList.add(dokters);
        }
        return arrayList;
    }

    public Cursor getBaris(long rowID){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = KEY_ID + "=" + rowID;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS,where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public boolean updateBaris(long rowID,String nama,String spesialisasi,String noTelp){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = KEY_ID + "=" + rowID;
        ContentValues isi = new ContentValues();
        isi.put(KEY_NAMA,nama);
        isi.put(KEY_SPESIALIS,spesialisasi);
        isi.put(KEY_NOTELP,noTelp);
        //insert ke DB
        return db.update(DB_TABLE,isi,where,null)!=0;
    }

}
