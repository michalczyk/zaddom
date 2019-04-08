package com.example.zaddom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewActivity1 extends AppCompatActivity {

    RadioGroup rad_group;
    RadioButton rad_butt1, rad_butt2, rad_butt3, rad_butt4, rad_butt5, rad_butt6;
    boolean checked = false;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);

        rad_group = findViewById(R.id.rad_group);
        rad_butt1 = findViewById(R.id.rad_butt1);
        rad_butt2 = findViewById(R.id.rad_butt2);
        rad_butt3 = findViewById(R.id.rad_butt3);
        rad_butt4 = findViewById(R.id.rad_butt4);
        rad_butt5 = findViewById(R.id.rad_butt5);
        rad_butt6 = findViewById(R.id.rad_butt6);

        rad_butt1.setText("Sound 1");
        rad_butt2.setText("Sound 2");
        rad_butt3.setText("Sound 3");
        rad_butt4.setText("Sound 4");
        rad_butt5.setText("Sound 5");
        rad_butt6.setText("Sound 6");
    }

    public void cancel(View view) {
        finish();
    }

    public void ok(View view) {
        if(checked) {
            Intent i = new Intent();
            i.putExtra("sound", soundID);
            setResult(RESULT_OK, i);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Select sound", Toast.LENGTH_LONG).show();
        }
    }

    public void choose(View view) {
        checked = ((RadioButton) view).isChecked();

        if(checked) {
            switch (view.getId()) {
                case R.id.rad_butt1:
                    soundID = R.raw.mario;
                    break;
                case R.id.rad_butt2:
                    soundID = R.raw.ring01;
                    break;
                case R.id.rad_butt3:
                    soundID = R.raw.ring02;
                    break;
                case R.id.rad_butt4:
                    soundID = R.raw.ring03;
                    break;
                case R.id.rad_butt5:
                    soundID = R.raw.ring04;
                    break;
                case R.id.rad_butt6:
                    soundID = R.raw.ringd;
                    break;
            }
        }
    }
}