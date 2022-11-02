package com.pppb.aplikasirumahsakit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbDokterAdapter {

    private static final String DB_Name = "Dokters.db";
    private static final String DB_TABLE = "DOKTERS_TABLE";

    //Kolom
    public static final String KEY_ID = "_id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_SPESIALIS = "spesialis";
    public static final String KEY_NOTELP = "noTelpon";

    public static final String[] ALL_KEYS = new String[]{KEY_ID,KEY_NAMA,KEY_SPESIALIS,KEY_NOTELP};
    //bikinTabel
    public static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (" +
            KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            KEY_NAMA+ " TEXT, "+
            KEY_SPESIALIS+ " TEXT,"+
            KEY_NOTELP+ "TEXT"+
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
        initialValues.put(KEY_NAMA,nama);
        initialValues.put(KEY_SPESIALIS,spesialis);
        initialValues.put(KEY_NOTELP,noTelp);

        //Insert data ke DB
        return db.insert(DB_TABLE,null,initialValues);
    }

    public boolean deleteBaris(long rowID){
        String where = KEY_ID + "=" + rowID;
        return db.delete(DB_TABLE,where,null)!=0;
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
        String where = null;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS,where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getBaris(long rowID){
        String where = KEY_ID + "=" + rowID;
        Cursor c = db.query(true,DB_TABLE,ALL_KEYS,where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public boolean updateBaris(long rowID,String nama,String spesialisasi,String noTelp){
        String where = KEY_ID + "=" + rowID;
        ContentValues isi = new ContentValues();
        isi.put(KEY_NAMA,nama);
        isi.put(KEY_SPESIALIS,spesialisasi);
        isi.put(KEY_NOTELP,noTelp);
        //insert ke DB
        return db.update(DB_TABLE,isi,where,null)!=0;
    }


    private static class dbHelper extends SQLiteOpenHelper{

        dbHelper(Context context){
            super(context,DB_Name,null,5);
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
