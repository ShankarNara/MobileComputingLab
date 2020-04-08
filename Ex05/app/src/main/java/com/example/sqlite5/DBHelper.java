package com.example.sqlite5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_SALARY = "salary";
    public static final String COLUMN_DEPARTMENT = "department";
    public static final String CONTACTS_TABLE_NAME = "contact";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table contact (id integer,name text, gender text, department text, salary text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }

    public boolean insertContact(Integer id,String name,String gender, String department, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("id",id);
        contentValues.put("gender",gender);
        contentValues.put("department",department);
        contentValues.put("salary",salary);
        db.insert(CONTACTS_TABLE_NAME,null,contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACTS_TABLE_NAME + " where id="+id+"",null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact(Integer id,String name,String gender, String department, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("id",id);
        contentValues.put("gender",gender);
        contentValues.put("department",department);
        contentValues.put("salary",salary);
        db.update(CONTACTS_TABLE_NAME,contentValues,"id = ? ", new String[] { Integer.toString(id) });
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
}
