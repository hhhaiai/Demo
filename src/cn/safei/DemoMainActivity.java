package cn.safei;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import cn.safei.db.DBContent;
import cn.safei.db.DBHelper;
import cn.safei.jitter.WindowJitter;

public class DemoMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // testCustonPathDB();

        testJitter();
    }

    /**
     * 测试界面抖动
     */
    private void testJitter() {
        this.findViewById(R.id.bunJitter).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), WindowJitter.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 测试自定义的路径的数据库
     */
    private void testCustonPathDB() {
        DBHelper dbhelper = new DBHelper(getApplicationContext(), DBContent.DB_NAME, null, DBContent.DB_VERSION);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
