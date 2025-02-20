package com.example.signinandsignupusingsqlite;

import static android.icu.lang.UProperty.AGE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="user.db";
    private static final String TABLE_NAME="user_details";
    private static final String NAME="name";
    private static final String GMAIL="gmail";
    private static final String USER_NAME="user_name";
    private static final String PASSWORD="password";
    private static final int VERSION_CONTROL=1;
    private Context context;

    private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+" ("+USER_NAME+" VARCHAR(30) PRIMARY KEY , "+NAME+" VARCHAR(50), "+GMAIL+" VARCHAR(30) UNIQUE , "+PASSWORD+" VARCHAR(30) UNIQUE )";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL="SELECT * FROM "+TABLE_NAME;

    public myDatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_CONTROL);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception :"+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context,"OnUpgrade is called",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }


    }

    public long insertData(String name, String gmail, String user_name, String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(USER_NAME,user_name);
        contentValues.put(NAME,name);
        contentValues.put(GMAIL,gmail);
        contentValues.put(PASSWORD,password);

        long insertMethodReturn=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return  insertMethodReturn;

    }

    public Cursor display(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(SELECT_ALL, null);
        return  cursor;
    }

    public int Delete(String user_name){

        SQLiteDatabase value=this.getWritableDatabase();
        return value.delete(TABLE_NAME,USER_NAME+"= ?",new String[]{user_name});

    }

}
