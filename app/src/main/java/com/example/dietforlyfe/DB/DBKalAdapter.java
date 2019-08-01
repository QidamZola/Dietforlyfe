package com.example.dietforlyfe.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dietforlyfe.Model.ModelKalori;

import java.util.ArrayList;
import java.util.List;

public class DBKalAdapter extends SQLiteOpenHelper {

    static final String COLUMN_BMR = "bmr";
    static final String COLUMN_KALORI = "kalori";
    static final String DATABASE_NAME = "db_diet1";
    static final String TABEL_KALORI = "t_kalori";
    static final int DATABASE_VERSION = 1;

    public DBKalAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){

        String CREATE_KALORI_TABLE = "CREATE TABLE "+ TABEL_KALORI + "("
                + COLUMN_BMR + " TEXT," + COLUMN_KALORI + " TEXT" + ")";
        db.execSQL(CREATE_KALORI_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABEL_KALORI);
        onCreate(db);
    }

    public void tambahKalori(ModelKalori modelKalori){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BMR, modelKalori.getBmr());
        values.put(COLUMN_KALORI, modelKalori.getKalori());

        db.insert(TABEL_KALORI ,null,values);
        db.close();
    }

    public List<ModelKalori> getSemuaKalori(){
        List<ModelKalori> kaloriList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABEL_KALORI;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                ModelKalori modelKalori = new ModelKalori(cursor.getString(0),cursor.getString(1));
                kaloriList.add(modelKalori);
            }while (cursor.moveToNext());
        }
        return kaloriList;
    }

}
