package com.example.bryan.estudihambre;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sql extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        final Button mega =(Button) findViewById(R.id.mega1);
        final Button mega1 =(Button) findViewById(R.id.mega2);
        final Button mega2 =(Button) findViewById(R.id.mega3);
        mega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#F!jI5WEa5T!uUwRL4aReturI8mxsKzZqg"));
                startActivity(browserIntent);
            }
        });
        mega1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!aYBSCb7K!pRw7QxwwQkVjWC24jLv81mQ3VM31Y59EboiEos40cQ4"));
                startActivity(browserIntent);
            }
        });

        mega2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!fMpS0DjS!ErLY5xZ7xhITIrYSwuXPXGrCpCzSjLAbqWyWvo3Yaec"));
                startActivity(browserIntent);
            }
        });
    }
}
