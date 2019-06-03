package com.example.bryan.estudihambre;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        final Button julio =(Button) findViewById(R.id.videos4);
        final Button derivando =(Button) findViewById(R.id.videos3);
        final Button ciencia =(Button) findViewById(R.id.videos2);
        final Button codigo =(Button) findViewById(R.id.videos1);

        julio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/julioprofe"));
                startActivity(browserIntent);
            }
        });
        derivando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCH-Z8ya93m7_RD02WsCSZYA"));
                startActivity(browserIntent);
            }
        });
        ciencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/CdeCiencia"));
                startActivity(browserIntent);
            }
        });
        codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/codigofacilito"));
                startActivity(browserIntent);
            }
        });
    }
}
