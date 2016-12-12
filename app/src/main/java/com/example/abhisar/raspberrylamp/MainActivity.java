package com.example.abhisar.raspberrylamp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.R.id.toggle;
import static com.example.abhisar.raspberrylamp.R.styleable.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        iv.setImageResource(R.drawable.bulboff);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String link = "http://192.168.43.105/PiHome/lampon.php";
                    new updateData().execute(link);
                    Toast.makeText(MainActivity.this, "Lights ON!", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.bulbon);
                } else {
                    String link = "http://192.168.43.105/PiHome/lampoff.php";
                    new updateData().execute(link);
                    Toast.makeText(MainActivity.this, "Lights OFF!", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.bulboff);
                }
            }
        });
    }



}
