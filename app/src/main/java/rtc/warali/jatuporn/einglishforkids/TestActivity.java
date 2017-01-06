package rtc.warali.jatuporn.einglishforkids;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private int timesAnInt, scoreAnInt;
    private MyConstant myConstant;
    private int[][] choiceInts;
    private ImageView firstImageView, secondImageView, thirdImageView;
    private TextView questionTextView, scoreTextView;
    private String[] questionStrings;
    private MyManage myManage;
    private int[] trueAnswerInts;
    private int[] soundInts = new int[]{R.raw.mytrue, R.raw.myfalse};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        myManage = new MyManage(TestActivity.this);

        timesAnInt = getIntent().getIntExtra("Times", 0);
        Log.d("4decV1", "timesAnInt ที่รับได้ ==> " + timesAnInt);

        myConstant = new MyConstant();
        choiceInts = myConstant.getChoiceInts();
        trueAnswerInts = myConstant.getTrueAnserInts();

        bindWidget();

        //Show View
        showView();

        //ShowQuestion
        questionStrings = myConstant.getQurstionStrings();
        questionTextView.setText(questionStrings[timesAnInt]);

        //Image Controller
        firstImageView.setOnClickListener(this);
        secondImageView.setOnClickListener(this);
        thirdImageView.setOnClickListener(this);





    }   // Main Method

    private void showView() {

        firstImageView.setImageResource(choiceInts[timesAnInt][0]);
        secondImageView.setImageResource(choiceInts[timesAnInt][1]);
        thirdImageView.setImageResource(choiceInts[timesAnInt][2]);


        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM kidTABLE", null);
            cursor.moveToFirst();
            String strScore = cursor.getString(cursor.getColumnIndex(MyManage.column_score));
            scoreTextView.setText(strScore);
            scoreAnInt = Integer.parseInt(strScore);

            if (scoreAnInt == 10) {
               // myAlert();
            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void bindWidget() {

        firstImageView = (ImageView) findViewById(R.id.imageView4);
        secondImageView = (ImageView) findViewById(R.id.imageView5);
        thirdImageView = (ImageView) findViewById(R.id.imageView6);
        questionTextView = (TextView) findViewById(R.id.textView4);
        scoreTextView = (TextView) findViewById(R.id.textView3);

        scoreTextView.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View view) {

        int intChoose = 1;

        switch (view.getId()) {
            case R.id.imageView4:
                intChoose = 1;
                break;
            case R.id.imageView5:
                intChoose = 2;
                break;
            case R.id.imageView6:
                intChoose = 3;
                break;
        }   // switch

        Log.d("4decV2", "You Choose ==> " + intChoose);
        Log.d("4decV2", "True Answer ==> " + trueAnswerInts[timesAnInt]);

        if (intChoose == trueAnswerInts[timesAnInt]) {
            //Answer True
            scoreAnInt += 1;

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            sqLiteDatabase.delete(MyManage.database_table, null, null);

            myManage.addValue(Integer.toString(scoreAnInt));

            Log.d("4decV3", "scoreAnInt ==> " + scoreAnInt);

            soundTrueFalse(soundInts[0]);

            Toast.makeText(TestActivity.this, "ยินดีด้วยคุณตอบถูก คะ", Toast.LENGTH_SHORT).show();

            finish();

        } else {
            //Answer False
            soundTrueFalse(soundInts[1]);

            Toast.makeText(TestActivity.this, "ลองใหม่ คุณตอบผิด คะ", Toast.LENGTH_SHORT).show();

        }

        //finish();

    }   // onClick

    private void soundTrueFalse(int soundInt) {
        MediaPlayer mediaPlayer = MediaPlayer.create(TestActivity.this, soundInt);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    private void myAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle("ยินดีด้วย ได้ 10 เหลียนแว้ว");
        builder.setMessage("ไป Shop ไหม ?");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(TestActivity.this, Shop.class));
            }
        });
        builder.show();

    }

}   // Main Class
