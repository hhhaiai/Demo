package cn.safei.db;

import java.io.File;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CpathContext extends ContextWrapper {

    private String mDirPath;

    public CpathContext(Context base, String path) {
        super(base);
        mDirPath = path;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name).getAbsolutePath(), factory);
    }

    @Override
    public File getDatabasePath(String name) {
        File result = new File(mDirPath + File.separator + name);
        if (!result.getParentFile().exists()) {
            result.getParentFile().mkdir();
        }
        return result;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name).getAbsolutePath(), factory, errorHandler);
    }
}
