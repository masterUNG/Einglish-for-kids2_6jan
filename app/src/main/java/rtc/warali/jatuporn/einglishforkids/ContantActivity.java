package rtc.warali.jatuporn.einglishforkids;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContantActivity extends AppCompatActivity {


    // Explicit
    private TextView textView;
    private int anInt,timesAnInt = 0;
    private String[] titleStrings = new String[]{"ตัวพยัญชนะ", "ตัวเลข"};
    private ImageView imageView;
    private Button backButton, playButton;

    private int[] soundInts = new int[]{R.raw.aa,R.raw.bb,R.raw.cc,
            R.raw.dd, R.raw.ee,R.raw.ff,R.raw.gg,R.raw.hh,R.raw.ii,
            R.raw.jj, R.raw.kk,R.raw.ll,R.raw.mm,R.raw.nn,R.raw.oo,
            R.raw.pp, R.raw.qq,R.raw.rr,R.raw.ss,R.raw.tt,R.raw.uu,
            R.raw.vv, R.raw.ww,R.raw.xx,R.raw.yy,R.raw.zz};

    private int[] imageInts = new int[]{R.drawable.a, R.drawable.b,
            R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,
            R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,
            R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,
            R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contant);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView3);
        backButton = (Button) findViewById(R.id.button);
        playButton = (Button) findViewById(R.id.button2);


        //Show Text
        anInt = getIntent().getIntExtra("Index", 0);
        textView.setText(titleStrings[anInt]);
        //sound Effect
        soundEffect(timesAnInt);

        //Button Controller
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContantActivity.this, TestActivity.class);
                intent.putExtra("Times", timesAnInt);
                timesAnInt += 1;



                startActivity(intent);
            }
        });

    }// Main Method




    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("engV1", "Timess ==> " + timesAnInt);

        changeImage();

        soundEffect(timesAnInt);

    }

    private void changeImage() {

        imageView.setImageResource(imageInts[timesAnInt]);
    }


    private void soundEffect(int index) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), soundInts[index]);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }

}// Main Class
