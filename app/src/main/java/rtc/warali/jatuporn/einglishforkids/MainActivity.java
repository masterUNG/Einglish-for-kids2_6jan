package rtc.warali.jatuporn.einglishforkids;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView ConsonantImageView,numberImageView;
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        ConsonantImageView = (ImageView) findViewById(R.id.imageView);
        numberImageView = (ImageView) findViewById(R.id.imageView2);

        //Image Controller
        ConsonantImageView.setOnClickListener(this);
        numberImageView.setOnClickListener(this);

        myManage = new MyManage(this);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.database_table, null, null);
        myManage.addValue("0");


    }// Main Method

    @Override
    public void onClick(View v) {


        int index = 0;
        switch (v.getId()) {
            case R.id.imageView:
                index = 0;


                Intent intent = new Intent(MainActivity.this, ContantActivity.class);
                intent.putExtra("Index", index);
                startActivity(intent);
                break;
            case R.id.imageView2:
                index = 1;

                Intent intent1 = new Intent(MainActivity.this, NumberActivity.class);
                intent1.putExtra("Index", index);
                startActivity(intent1);
                break;

        } //switch



    }// onclik

}// Main Class
