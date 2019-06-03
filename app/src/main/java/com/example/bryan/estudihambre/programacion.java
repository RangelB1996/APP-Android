package com.example.bryan.estudihambre;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class programacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacion);
        final Button mega =(Button) findViewById(R.id.mega);
        final Button mega1 =(Button) findViewById(R.id.mega2);
        final Button mega2 =(Button) findViewById(R.id.mega3);
        mega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!aMojWRjA!HLlyvIUGj_ZsRnkPwbFl9DCVlK9pM7dQoHmicMTWALI"));
                startActivity(browserIntent);
            }
        });
        mega1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!Hcx0zTzS!QlpccWXtRp-yWY3SpzCilcOcoCLO1L_qBgiZAwmX4hs"));
                startActivity(browserIntent);
            }
        });

        mega2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!fUhyTbaY!veTL8PuRQKlL8ZdTCnPP9TUpWUm0dwTqO8ldQeuguqY"));
                startActivity(browserIntent);
            }
        });
    }
}
