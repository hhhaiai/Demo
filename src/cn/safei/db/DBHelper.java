package cn.safei.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory, int version) {
        super(new CpathContext(context, getDirPath()), name, factory, version);
    }

    /**
     * 存放数据库的路径
     * 
     * @return
     */
    private static String getDirPath() {
        return DBContent.DB_PATH;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
