package com.aspire.onlineshopping.databaseModels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aspire.onlineshopping.utils.User;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OnlineShopping.db";
    private static final String TABLE_NAME = "User";
    private static  final String COLUMN_USER_ID = "user_id";
    private static  final String COLUMN_USER_NAME = "user_name";
    private static  final String COLUMN_USER_EMAIL = "user_email";
    private static  final String COLUMN_USER_PASSWORD = "user_password";

    //creating sqlite table

    private  String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            +COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    //drop table sql Query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        onCreate(sqLiteDatabase);
    }


    //creating user record
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_EMAIL,user.getEmail());
        values.put(COLUMN_USER_PASSWORD,user.getPassword());
        //Row insertion
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Cursor getUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from User",null);
        return cursor;
    }

    //checking if user exists

    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        //selection
        String selection = COLUMN_USER_EMAIL + " = ?";
        //selection parameter
        String[] selectionArgs = {email};
        //Query table with condition

        Cursor cursor = db.query(TABLE_NAME,
                columns,        //columns to return
                selection,      //column for WHERE clause
                selectionArgs,  //Values for above clause
                null,           //groups the rows
                null,           //filter by row  groups
                null);          //sorted order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkPass(String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from User where user_email = ? and user_password = ?",new String[] {email,pass});
        if(cursor.getCount()>0){
            return true;
        }else return false;

        }


}
