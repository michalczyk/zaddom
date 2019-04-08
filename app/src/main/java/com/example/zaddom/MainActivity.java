package com.example.zaddom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;
    String[] pic;
    String name;
    int rand = 0, soundID = R.raw.mario;
    MediaPlayer mp;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);

        tv.setText("Hello");

        pic = getResources().getStringArray(R.array.pictures);
        uri = Uri.parse(pic[0]);
        iv.setImageResource(getApplicationContext().getResources().getIdentifier
                ("" + uri, null, getApplicationContext().getPackageName()));

        Toast.makeText(getApplicationContext(), ""+uri, Toast.LENGTH_LONG).show();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp != null){
                    mp.stop();
                    mp = null;
                }else{
                    mp = MediaPlayer.create(getApplicationContext(), soundID);
                    mp.start();
                }

                Snackbar.make(view, "music...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void contact(View view) {
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        startActivityForResult(intent, 1);
    }

    public void sound(View view) {
        Intent intent = new Intent(getApplicationContext(), NewActivity1.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                name = data.getStringExtra("contact");
                tv.setText(name);
                choosePic();
            }
            else if(requestCode == 2){
                soundID = data.getIntExtra("sound", 0);
            }
        }else{
            Toast.makeText(getApplicationContext(), " <-", Toast.LENGTH_LONG).show();
        }
    }

    public void choosePic(){
        Random r = new Random();
        rand = r.nextInt(5);

        uri = Uri.parse(pic[rand]);
        iv.setImageResource(getApplicationContext().getResources().getIdentifier
                ("" + uri, null, getApplicationContext().getPackageName()));


    }
}