package com.example.sqlitesignin.Activity.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sqlitesignin.Activity.ActivityModel.User_Details;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_Details.db";
    private static final String TABLE_NAME = "user";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final int VERSION_NO = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) NOT NULL, "+EMAIL+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL )";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private  Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NO);
        this.context = context ;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context,"database created",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Log.d("exp","",e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context,"database dropped",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Log.d("exp","",e);
        }

    }

    public long InsertsignupDetails (User_Details user_details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,user_details.getName());
        contentValues.put(EMAIL,user_details.getEmail());
        contentValues.put(PASSWORD,user_details.getPassword());

        long rowId =  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return rowId;
    }
}