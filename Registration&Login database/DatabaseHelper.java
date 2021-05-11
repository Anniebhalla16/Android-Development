package com.example.registrationdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "user.db",
            TABLE_NAME="Credentials",
            COLUMN_1 = "USERNAME",
            COLUMN_2="PASSWORD";
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME+"(USERNAME VARCHAR(50),PASSWORD VARCHAR(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String uname,String pass){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues content= new ContentValues();

        content.put(COLUMN_1,uname);
        content.put(COLUMN_2,pass);

        long result=db.insert(TABLE_NAME ,null,content);
        return result!=-1;
    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }

    public boolean checkusername(String vorname){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * from Credentials where USERNAME=?", new String[]{vorname});
        if(cursor.getCount()>0)
            return true;
        else return false;

    }

    public boolean checkusernamepassword(String vorname,String passcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from Credentials where USERNAME=? AND PASSWORD=?", new String[]{vorname, passcode});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
}
