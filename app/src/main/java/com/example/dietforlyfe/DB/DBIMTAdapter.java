package com.example.dietforlyfe.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dietforlyfe.Model.ModelIMT;
import com.example.dietforlyfe.Model.ModelKalori;

import java.util.ArrayList;
import java.util.List;

public class DBIMTAdapter extends SQLiteOpenHelper{


    static final String COLUMN_BBI = "bbi";
    static final String COLUMN_IMT = "imt";
    static final String COLUMN_KET = "ket";
    static final String DATABASE_NAME = "db_diet";
    static final String TABEL_IMT = "t_imt";
    static final int DATABASE_VERSION =1;

    public DBIMTAdapter(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_IMT_TABLE = "CREATE TABLE "+ TABEL_IMT + "("
                + COLUMN_BBI + " TEXT," + COLUMN_IMT + " TEXT," +COLUMN_KET + " TEXT"+ ")";
        db.execSQL(CREATE_IMT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABEL_IMT);
        onCreate(db);
    }

    public void tambahIMT(ModelIMT modelIMT){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BBI, modelIMT.getBbi());
        values.put(COLUMN_IMT, modelIMT.getImt());
        values.put(COLUMN_KET, modelIMT.getKet());

        db.insert(TABEL_IMT ,null,values);
        db.close();
    }

    public List<ModelIMT> getSemuaIMT(){
        List<ModelIMT> imtList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABEL_IMT;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                ModelIMT modelIMT = new ModelIMT(cursor.getString(0),cursor.getString(1),cursor.getString(2));
                imtList.add(modelIMT);
            }while (cursor.moveToNext());
        }
        return imtList;
    }


}


