package com.example.bryan.estudihambre;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class biblioteca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);
        final Button mega =(Button) findViewById(R.id.mega);
        final Button mega1 =(Button) findViewById(R.id.mega2);
        final Button mega2 =(Button) findViewById(R.id.mega3);
        final Button mega3 =(Button) findViewById(R.id.mega4);
        final Button mega4 =(Button) findViewById(R.id.mega5);
        mega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!6ZhljI6R!QPR11ip3sPtXuS764YFJH3U38ue02UnTafwso9iMot0"));
                startActivity(browserIntent);
            }
        });
        mega1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!PE5SlYob!XjGzgEXviAfb_5EoXgz9qA_n4y2LhnDFWY2Bggk3Kx0"));
                startActivity(browserIntent);
            }
        });

        mega2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!yEg1iY7Y!0kDPFhdrlzMcFPkJFuxT-BtSZohshBd3k3tgrqMOpQ8"));
                startActivity(browserIntent);
            }
        });
        mega3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!eFwAkKoA!7NC5R3XHzf6VYhathnuupuPieMNEQ7h6TLyXQTVy34A"));
                startActivity(browserIntent);
            }
        });

        mega4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://mega.nz/#!PARUWS6J!-Hk-dM-macAdGVDE_8MitRP3tguHq5L-XSINgpMeUhI"));
                startActivity(browserIntent);
            }
        });
    }
}
