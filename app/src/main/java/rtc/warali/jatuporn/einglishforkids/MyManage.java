package rtc.warali.jatuporn.einglishforkids;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 12/4/2016 AD.
 */

public class MyManage {

    public static final String database_table = "kidTABLE";
    public static final String column_id = "_id";
    public static final String column_score = "Score";
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public MyManage(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }

    public long addValue(String strScore) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_score, strScore);

        return sqLiteDatabase.insert(database_table, null, contentValues);
    }

}   // Main Class
