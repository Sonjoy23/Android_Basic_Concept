package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="student.db";
    private static final String TABLE_NAME="student_details";
    private static final String ID="_id";
    private static final String NAME="Name";
    private static final String AGE="Age";
    private static final String GENDER="Gender";
    private static final int  VERSION_NUMBER=2;
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(50), "+AGE+" INTEGER, "+GENDER+" VARCHAR(50) )";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL="SELECT * FROM "+TABLE_NAME;
    private Context context;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    // ekhane table toiri kora hoiche
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, " onCreate is called ", Toast.LENGTH_SHORT).show();
            // ekhane (CREATE_TABLE) name variable e sob sqlite command lekha hoiche esecSQL mothod e madhome table create kora hoiche
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }


    }

    // ekhane table update kora hoiche
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "OnUpgrade is called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch(Exception  e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }

    }
    // ekhane data insert kora hoiche
    public long insert(String name,String age, String gender){
        // insert korte (SQLiteDatabase) nicher line 2 ta lekha most important
        // (SQLiteDatabase) er getWritableDatabase() ei method ti data write mode niye jate sahajo kore
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        // jodi data sothik vabe insert hoy tahole rowId(long) 1 er ceye boro value return korbe
        // sqLiteDatabase.insert() method ti data insert kore jekhane prothom paramiter table_name
        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    // ei method er madhome database er data select kora hoiche
    //eita display korar jonno banano hoiche 
    public Cursor displayData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        //(SELECT_ALL) variable o rawQuery er madhome data select kora hosche ar cursor er modhe data rakha hosche
        Cursor cursor=sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }

    // eita update korar jonno banano hoiche
    public boolean updateData(String id, String name, String age, String gender){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+"= ?",new String[]{id});
        return  true;
    }

    // eita delete korar jonno banano hoiche
    public int deleteData(String id){
        SQLiteDatabase value=this.getWritableDatabase();
        return value.delete(TABLE_NAME,ID+"= ?", new String[]{id});
    }
}
