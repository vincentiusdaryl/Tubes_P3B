package com.pppb.aplikasirumahsakit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseDokter extends SQLiteOpenHelper {

    private static final String DB_Name = "Dokters.db";
    private static final String DB_TABLE = "Dokters_Table";

    //Kolom
    private static final String ID = "ID";
    private static final String NAMA = "NAMA";
    private static final String SPESIALIS = "SPESIALIS";

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (" +
            ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAMA+ " TEXT, "+
            SPESIALIS+ " TEXT "+ ")" ;

    public databaseDokter(Context context){
        super(context, DB_Name, null, 1);
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

    public boolean insertData(String nama, String spesialis){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA,nama);
        contentValues.put(SPESIALIS,spesialis);

        long result = db.insert(DB_TABLE,null,contentValues);

        return result != -1; //kalau -1 data gangeinsert
    }

}
