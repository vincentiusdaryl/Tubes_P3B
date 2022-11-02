package com.pppb.aplikasirumahsakit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbDokterAdapter {

    private static final String DB_Name = "Dokters.db";
    private static final String DB_TABLE = "Dokters_Table";

    //Kolom
    public static final String ID = "ID";
    public static final String NAMA = "NAMA";
    public static final String SPESIALIS = "SPESIALIS";
    public static final String NOTELP = "NOTELPON";

    public static final String[] ALL_KEYS = new String[]{ID,NAMA,SPESIALIS,NOTELP};
    //bikinTabel
    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (" +
            ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAMA+ " TEXT, "+
            SPESIALIS+ " TEXT,"+
            NOTELP+ "TEXT"+
            ")" ;
    private final Context context;
    private dbHelper myDBHelper;
    private SQLiteDatabase db;

    public dbDokterAdapter(Context context){
        this.context = context;
        myDBHelper = new dbHelper(context);
    }

    public dbDokterAdapter open(){
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }
    public long insertBaris(String nama,String spesialis,String noTelp){
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAMA,nama);
        initialValues.put(SPESIALIS,spesialis);
        initialValues.put(NOTELP,noTelp);

        //Insert data ke DB
        return db.insert(DB_TABLE,null,initialValues);
    }

    public boolean deleteRow(long rowID){
        String where = ID + "=" + rowID;
        return db.delete(DB_TABLE,where,null)!=0;
    }
    public void deleteAll(){
        Cursor c = getSmuaBaris();
        long rowID = c.getColumnIndexOrThrow(ID);
        if(c.moveToFirst()){
            do{
                deleteRow(c.getLong((int) rowID));
            } while (c.moveToNext());
        }
        c.close();
    }
    //Return data-data di DB
    public Cursor getSmuaBaris(){
        String where = null;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS,where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getBaris(long rowID){
        String where = ID + "=" + rowID;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS,where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public boolean updateRow(long rowID,String nama,String spesialisasi,String noTelp){
        String where = ID + "=" + rowID;
        ContentValues isi = new ContentValues();
        isi.put(NAMA,nama);
        isi.put(SPESIALIS,spesialisasi);
        isi.put(NOTELP,noTelp);
        //insert ke DB
        return db.update(DB_TABLE,isi,where,null)!=0;
    }


    private static class dbHelper extends SQLiteOpenHelper{

        dbHelper(Context context){
            super(context,DB_Name,null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //AncurinDB
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

            //Recreate DB
            onCreate(db);
        }
    }

}
