package com.example.bryan.estudihambre;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tablero extends AppCompatActivity implements Runnable {
    EditText c1,c2,c3,c4,c5,c6,c7,c8,c9,
            c10,c11,c12,c13,c14,c15,c16,c17, c19,
            c18,c20,c21,c22,c23,c24,c25,c26,c27,
            c28,c29,c30,c31,c32,c33,c34,c35,c36,
            c37,c38,c39,c40,c41,c42,c43,c44,c45,
            c46,c47,c48,c49,c50,c51,c52,c53,c54,
            c55,c56,c57,c58,c59,c60,c61,c62,c63,
            c64,c65,c66,c67,c68,c69,c70,c71,c72,
            c73,c74,c75,c76,c77,c78,c79,c80,c81;
    private int mfra;
    private TextView etiq;
    private String nombrecronometro;
    private int segundos, minutos, horas;
    private Handler escribirenUI;
    private Boolean pausado;
    private  String salida;
    Thread hilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        etiq = findViewById(R.id.etiqueta);
        salida = "";
        segundos = 0;
        minutos = 0;
        horas = 0;
        nombrecronometro = "CRONOMETRO";
        escribirenUI = new Handler();
        pausado = Boolean.FALSE;

        declaration();
        clean();
        Intent intent=getIntent();
        Bundle datos = intent.getExtras();
        if(datos != null){
            int variable_nivel = datos.getInt("variable_nivel");
            mfra = variable_nivel;
            fill(variable_nivel);
            hilo = new Thread(this);
            hilo.start();
        }

    }

    public void declaration(){
        c1 = findViewById(R.id.txt1);
        c2 = findViewById(R.id.txt2);
        c3 = findViewById(R.id.txt3);
        c4 = findViewById(R.id.txt4);
        c5 = findViewById(R.id.txt5);
        c6 = findViewById(R.id.txt6);
        c7 = findViewById(R.id.txt7);
        c8 = findViewById(R.id.txt8);
        c9 = findViewById(R.id.txt9);
        c10 = findViewById(R.id.txt10);
        c11 = findViewById(R.id.txt11);
        c12 = findViewById(R.id.txt12);
        c13 = findViewById(R.id.txt13);
        c14 = findViewById(R.id.txt14);
        c15 = findViewById(R.id.txt15);
        c16 = findViewById(R.id.txt16);
        c17 = findViewById(R.id.txt17);
        c18 = findViewById(R.id.txt18);
        c19 = findViewById(R.id.txt19);
        c20 = findViewById(R.id.txt20);
        c21 = findViewById(R.id.txt21);
        c22 = findViewById(R.id.txt22);
        c23 = findViewById(R.id.txt23);
        c24 = findViewById(R.id.txt24);
        c25 = findViewById(R.id.txt25);
        c26 = findViewById(R.id.txt26);
        c27 = findViewById(R.id.txt27);
        c28 = findViewById(R.id.txt28);
        c29 = findViewById(R.id.txt29);
        c30 = findViewById(R.id.txt30);
        c31 = findViewById(R.id.txt31);
        c32 = findViewById(R.id.txt32);
        c33 = findViewById(R.id.txt33);
        c34 = findViewById(R.id.txt34);
        c35 = findViewById(R.id.txt35);
        c36 = findViewById(R.id.txt36);
        c37 = findViewById(R.id.txt37);
        c38 = findViewById(R.id.txt38);
        c39 = findViewById(R.id.txt39);
        c40 = findViewById(R.id.txt40);
        c41 = findViewById(R.id.txt41);
        c42 = findViewById(R.id.txt42);
        c43 = findViewById(R.id.txt43);
        c44 = findViewById(R.id.txt44);
        c45 = findViewById(R.id.txt45);
        c46 = findViewById(R.id.txt46);
        c47 = findViewById(R.id.txt47);
        c48 = findViewById(R.id.txt48);
        c49 = findViewById(R.id.txt49);
        c50 = findViewById(R.id.txt50);
        c51 = findViewById(R.id.txt51);
        c52 = findViewById(R.id.txt52);
        c53 = findViewById(R.id.txt53);
        c54 = findViewById(R.id.txt54);
        c55 = findViewById(R.id.txt55);
        c56 = findViewById(R.id.txt56);
        c57 = findViewById(R.id.txt57);
        c58 = findViewById(R.id.txt58);
        c59 = findViewById(R.id.txt59);
        c60 = findViewById(R.id.txt60);
        c61 = findViewById(R.id.txt61);
        c62 = findViewById(R.id.txt62);
        c63 = findViewById(R.id.txt63);
        c64 = findViewById(R.id.txt64);
        c65 = findViewById(R.id.txt65);
        c66 = findViewById(R.id.txt66);
        c67 = findViewById(R.id.txt67);
        c68 = findViewById(R.id.txt68);
        c69 = findViewById(R.id.txt69);
        c70 = findViewById(R.id.txt70);
        c71 = findViewById(R.id.txt71);
        c72 = findViewById(R.id.txt72);
        c73 = findViewById(R.id.txt73);
        c74 = findViewById(R.id.txt74);
        c75 = findViewById(R.id.txt75);
        c76 = findViewById(R.id.txt76);
        c77 = findViewById(R.id.txt77);
        c78 = findViewById(R.id.txt78);
        c79 = findViewById(R.id.txt79);
        c80 = findViewById(R.id.txt80);
        c81 = findViewById(R.id.txt81);
    }

    public void fill(int nivel){
        switch (nivel){
            case 1:levelOne();break;
            case 2:levelTwo();break;
            case 3:levelThree();break;
            case 4:levelFour();break;
            case 5:levelFive();break;
        }
    }

    public void clean(){
        c1.setText("");
        c2.setText("");
        c3.setText("");
        c4.setText("");
        c5.setText("");
        c6.setText("");
        c7.setText("");
        c8.setText("");
        c9.setText("");
        c10.setText("");
        c11.setText("");
        c12.setText("");
        c13.setText("");
        c14.setText("");
        c15.setText("");
        c16.setText("");
        c17.setText("");
        c18.setText("");
        c19.setText("");
        c20.setText("");
        c21.setText("");
        c22.setText("");
        c23.setText("");
        c24.setText("");
        c25.setText("");
        c26.setText("");
        c27.setText("");
        c28.setText("");
        c29.setText("");
        c30.setText("");
        c31.setText("");
        c32.setText("");
        c33.setText("");
        c34.setText("");
        c35.setText("");
        c36.setText("");
        c37.setText("");
        c38.setText("");
        c39.setText("");
        c40.setText("");
        c41.setText("");
        c42.setText("");
        c43.setText("");
        c44.setText("");
        c45.setText("");
        c46.setText("");
        c47.setText("");
        c48.setText("");
        c49.setText("");
        c50.setText("");
        c51.setText("");
        c52.setText("");
        c53.setText("");
        c54.setText("");
        c55.setText("");
        c56.setText("");
        c57.setText("");
        c58.setText("");
        c59.setText("");
        c60.setText("");
        c61.setText("");
        c62.setText("");
        c63.setText("");
        c64.setText("");
        c65.setText("");
        c66.setText("");
        c67.setText("");
        c68.setText("");
        c69.setText("");
        c70.setText("");
        c71.setText("");
        c72.setText("");
        c73.setText("");
        c74.setText("");
        c75.setText("");
        c76.setText("");
        c77.setText("");
        c78.setText("");
        c79.setText("");
        c80.setText("");
        c81.setText("");
    }

    public void disableEditText(EditText editText){
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }

    public void setCellNonEditable(EditText editText, String valor){
        editText.setText(valor);
        disableEditText(editText);
    }

    public void levelOne(){
        setCellNonEditable(c2,"7");
        setCellNonEditable(c3,"2");
        setCellNonEditable(c4,"4");
        setCellNonEditable(c12,"8");
        setCellNonEditable(c18,"4");
        setCellNonEditable(c22,"2");
        setCellNonEditable(c27,"9");
        setCellNonEditable(c28,"2");
        setCellNonEditable(c30,"9");
        setCellNonEditable(c31,"7");
        setCellNonEditable(c38,"3");
        setCellNonEditable(c40,"8");
        setCellNonEditable(c41,"4");
        setCellNonEditable(c43,"9");
        setCellNonEditable(c44,"6");
        setCellNonEditable(c45,"2");
        setCellNonEditable(c47,"6");
        setCellNonEditable(c48,"4");
        setCellNonEditable(c49,"5");
        setCellNonEditable(c51,"2");
        setCellNonEditable(c52,"3");
        setCellNonEditable(c53,"8");
        setCellNonEditable(c55,"5");
        setCellNonEditable(c57,"6");
        setCellNonEditable(c58,"3");
        setCellNonEditable(c60,"8");
        setCellNonEditable(c62,"4");
        setCellNonEditable(c64,"3");
        setCellNonEditable(c65,"4");
        setCellNonEditable(c66,"7");
        setCellNonEditable(c68,"2");
        setCellNonEditable(c69,"6");
        setCellNonEditable(c70,"5");
        setCellNonEditable(c72,"8");
        setCellNonEditable(c74,"2");
        setCellNonEditable(c78,"4");
    }

    public void levelTwo(){
        setCellNonEditable(c2,"3");
        setCellNonEditable(c3,"7");
        setCellNonEditable(c9,"9");
        setCellNonEditable(c10,"9");
        setCellNonEditable(c11,"6");
        setCellNonEditable(c12,"2");
        setCellNonEditable(c14,"3");
        setCellNonEditable(c15,"7");
        setCellNonEditable(c17,"8");
        setCellNonEditable(c21,"4");
        setCellNonEditable(c23,"5");
        setCellNonEditable(c24,"2");
        setCellNonEditable(c25,"3");
        setCellNonEditable(c27,"6");
        setCellNonEditable(c28,"3");
        setCellNonEditable(c31,"8");
        setCellNonEditable(c34,"7");
        setCellNonEditable(c36,"5");
        setCellNonEditable(c39,"9");
        setCellNonEditable(c42,"3");
        setCellNonEditable(c43,"4");
        setCellNonEditable(c46,"2");
        setCellNonEditable(c47,"7");
        setCellNonEditable(c49,"4");
        setCellNonEditable(c51,"5");
        setCellNonEditable(c53,"3");
        setCellNonEditable(c60,"8");
        setCellNonEditable(c64,"4");
        setCellNonEditable(c66,"1");
        setCellNonEditable(c71,"9");
        setCellNonEditable(c72,"3");
        setCellNonEditable(c73,"6");
        setCellNonEditable(c80,"5");

    }

    public void levelThree(){
        setCellNonEditable(c2,"2");
        setCellNonEditable(c3,"7");
        setCellNonEditable(c6,"4");
        setCellNonEditable(c10,"8");
        setCellNonEditable(c15,"2");
        setCellNonEditable(c16,"5");
        setCellNonEditable(c17,"9");
        setCellNonEditable(c20,"9");
        setCellNonEditable(c22,"8");
        setCellNonEditable(c23,"5");
        setCellNonEditable(c30,"5");
        setCellNonEditable(c33,"3");
        setCellNonEditable(c34,"2");
        setCellNonEditable(c35,"7");
        setCellNonEditable(c36,"8");
        setCellNonEditable(c40,"5");
        setCellNonEditable(c41,"6");
        setCellNonEditable(c44,"4");
        setCellNonEditable(c46,"4");
        setCellNonEditable(c47,"7");
        setCellNonEditable(c51,"8");
        setCellNonEditable(c56,"5");
        setCellNonEditable(c61,"8");
        setCellNonEditable(c62,"6");
        setCellNonEditable(c65,"3");
        setCellNonEditable(c68,"7");
        setCellNonEditable(c69,"6");
        setCellNonEditable(c71,"1");
        setCellNonEditable(c72,"5");
        setCellNonEditable(c73,"2");
        setCellNonEditable(c80,"3");
    }

    public void levelFour(){
        setCellNonEditable(c2,"6");
        setCellNonEditable(c5,"7");
        setCellNonEditable(c11,"7");
        setCellNonEditable(c12,"4");
        setCellNonEditable(c13,"6");
        setCellNonEditable(c17,"3");
        setCellNonEditable(c19,"3");
        setCellNonEditable(c22,"2");
        setCellNonEditable(c26,"7");
        setCellNonEditable(c27,"4");
        setCellNonEditable(c29,"2");
        setCellNonEditable(c31,"7");
        setCellNonEditable(c35,"5");
        setCellNonEditable(c36,"6");
        setCellNonEditable(c38,"4");
        setCellNonEditable(c39,"8");
        setCellNonEditable(c43,"9");
        setCellNonEditable(c45,"7");
        setCellNonEditable(c56,"9");
        setCellNonEditable(c58,"8");
        setCellNonEditable(c59,"2");
        setCellNonEditable(c63,"3");
        setCellNonEditable(c68,"3");
        setCellNonEditable(c69,"7");
        setCellNonEditable(c70,"5");
        setCellNonEditable(c73,"7");
        setCellNonEditable(c76,"5");
        setCellNonEditable(c77,"6");
        setCellNonEditable(c80,"1");
        setCellNonEditable(c81,"8");

    }

    public void levelFive(){
        setCellNonEditable(c2,"4");
        setCellNonEditable(c4,"9");
        setCellNonEditable(c7,"6");
        setCellNonEditable(c9,"1");
        setCellNonEditable(c10,"7");
        setCellNonEditable(c11,"8");
        setCellNonEditable(c17,"3");
        setCellNonEditable(c19,"1");
        setCellNonEditable(c21,"5");
        setCellNonEditable(c24,"4");
        setCellNonEditable(c25,"9");
        setCellNonEditable(c38,"9");
        setCellNonEditable(c40,"5");
        setCellNonEditable(c41,"4");
        setCellNonEditable(c43,"2");
        setCellNonEditable(c45,"6");
        setCellNonEditable(c51,"1");
        setCellNonEditable(c54,"7");
        setCellNonEditable(c56,"7");
        setCellNonEditable(c59,"8");
        setCellNonEditable(c60,"9");
        setCellNonEditable(c61,"1");
        setCellNonEditable(c67,"1");
        setCellNonEditable(c68,"2");
        setCellNonEditable(c72,"4");
        setCellNonEditable(c73,"8");
        setCellNonEditable(c80,"9");
    }

    public int solution(int nivel){
        String answer[] = new String[81];
        int error = 0;
        try {
            switch (nivel) {
                case 1: {
                    answer = new String[]{"6", "7", "2", "4", "1", "9", "8", "5", "3",
                            "9", "5", "8", "6", "3", "7", "1", "2", "4",
                            "4", "1", "3", "2", "8", "5", "6", "7", "9",
                            "2", "8", "9", "7", "6", "3", "4", "1", "5",
                            "7", "3", "5", "8", "4", "1", "9", "6", "2",
                            "1", "6", "4", "5", "9", "2", "3", "8", "7",
                            "5", "9", "6", "3", "7", "8", "2", "4", "1",
                            "3", "4", "7", "1", "2", "6", "5", "9", "8",
                            "8", "2", "1", "9", "5", "4", "7", "3", "6"};
                }
                break;
                case 2: {
                    answer = new String[]{"5", "3", "7", "6", "8", "4", "2", "1", "9",
                            "9", "6", "2", "1", "3", "7", "5", "8", "4",
                            "8", "1", "4", "9", "5", "2", "3", "7", "6",
                            "3", "4", "6", "8", "9", "1", "7", "2", "5",
                            "1", "5", "9", "7", "2", "3", "4", "6", "8",
                            "2", "7", "8", "4", "6", "5", "9", "3", "1",
                            "7", "9", "5", "3", "1", "8", "6", "4", "2",
                            "4", "2", "1", "5", "7", "6", "8", "9", "3",
                            "6", "8", "3", "2", "4", "9", "1", "5", "7"};
                }
                break;
                case 3: {
                    answer = new String[]{"5", "2", "7", "6", "9", "4", "3", "8", "1",
                            "8", "4", "1", "7", "3", "2", "5", "9", "6",
                            "6", "9", "3", "8", "5", "1", "7", "2", "4",
                            "1", "6", "5", "9", "4", "3", "2", "7", "8",
                            "3", "8", "2", "5", "6", "7", "1", "4", "9",
                            "4", "7", "9", "1", "2", "8", "6", "5", "3",
                            "7", "5", "4", "3", "1", "9", "8", "6", "2",
                            "9", "3", "8", "2", "7", "6", "4", "1", "5",
                            "2", "1", "6", "4", "8", "5", "9", "3", "7"};
                }
                break;
                case 4: {
                    answer = new String[]{"2", "6", "9", "4", "7", "3", "1", "8", "5",
                            "8", "7", "4", "6", "1", "5", "2", "3", "9",
                            "3", "1", "5", "2", "9", "8", "6", "7", "4",
                            "9", "2", "3", "7", "4", "1", "8", "5", "6",
                            "1", "4", "8", "3", "5", "6", "9", "2", "7",
                            "6", "5", "7", "9", "8", "2", "3", "4", "1",
                            "5", "9", "1", "8", "2", "4", "7", "6", "3",
                            "4", "8", "6", "1", "3", "7", "5", "9", "2",
                            "7", "3", "2", "5", "6", "9", "4", "1", "8"};
                }
                break;
                case 5: {
                    answer = new String[]{"2", "4", "3", "9", "5", "8", "6", "7", "1",
                            "7", "8", "9", "6", "1", "2", "4", "3", "5",
                            "1", "6", "5", "7", "3", "4", "9", "2", "8",
                            "4", "1", "7", "2", "6", "3", "8", "5", "9",
                            "3", "9", "8", "5", "4", "7", "2", "1", "6",
                            "6", "5", "2", "8", "9", "1", "3", "4", "7",
                            "5", "7", "4", "3", "8", "9", "1", "6", "2",
                            "9", "3", "6", "1", "2", "5", "7", "8", "4",
                            "8", "2", "1", "4", "7", "6", "5", "9", "3"};
                }
                break;
            }

            if (!c1.getText().toString().equals(answer[0])) error++;
            if (!c2.getText().toString().equals(answer[1])) error++;
            if (!c3.getText().toString().equals(answer[2])) error++;
            if (!c4.getText().toString().equals(answer[3])) error++;
            if (!c5.getText().toString().equals(answer[4])) error++;
            if (!c6.getText().toString().equals(answer[5])) error++;
            if (!c7.getText().toString().equals(answer[6])) error++;
            if (!c8.getText().toString().equals(answer[7])) error++;
            if (!c9.getText().toString().equals(answer[8])) error++;
            if (!c10.getText().toString().equals(answer[9])) error++;
            if (!c11.getText().toString().equals(answer[10])) error++;
            if (!c12.getText().toString().equals(answer[11])) error++;
            if (!c13.getText().toString().equals(answer[12])) error++;
            if (!c14.getText().toString().equals(answer[13])) error++;
            if (!c15.getText().toString().equals(answer[14])) error++;
            if (!c16.getText().toString().equals(answer[15])) error++;
            if (!c17.getText().toString().equals(answer[16])) error++;
            if (!c18.getText().toString().equals(answer[17])) error++;
            if (!c19.getText().toString().equals(answer[18])) error++;
            if (!c20.getText().toString().equals(answer[19])) error++;
            if (!c21.getText().toString().equals(answer[20])) error++;
            if (!c22.getText().toString().equals(answer[21])) error++;
            if (!c23.getText().toString().equals(answer[22])) error++;
            if (!c24.getText().toString().equals(answer[23])) error++;
            if (!c25.getText().toString().equals(answer[24])) error++;
            if (!c26.getText().toString().equals(answer[25])) error++;
            if (!c27.getText().toString().equals(answer[26])) error++;
            if (!c28.getText().toString().equals(answer[27])) error++;
            if (!c29.getText().toString().equals(answer[28])) error++;
            if (!c30.getText().toString().equals(answer[29])) error++;
            if (!c31.getText().toString().equals(answer[30])) error++;
            if (!c32.getText().toString().equals(answer[31])) error++;
            if (!c33.getText().toString().equals(answer[32])) error++;
            if (!c34.getText().toString().equals(answer[33])) error++;
            if (!c35.getText().toString().equals(answer[34])) error++;
            if (!c36.getText().toString().equals(answer[35])) error++;
            if (!c37.getText().toString().equals(answer[36])) error++;
            if (!c38.getText().toString().equals(answer[37])) error++;
            if (!c39.getText().toString().equals(answer[38])) error++;
            if (!c40.getText().toString().equals(answer[39])) error++;
            if (!c41.getText().toString().equals(answer[40])) error++;
            if (!c42.getText().toString().equals(answer[41])) error++;
            if (!c43.getText().toString().equals(answer[42])) error++;
            if (!c44.getText().toString().equals(answer[43])) error++;
            if (!c45.getText().toString().equals(answer[44])) error++;
            if (!c46.getText().toString().equals(answer[45])) error++;
            if (!c47.getText().toString().equals(answer[46])) error++;
            if (!c48.getText().toString().equals(answer[47])) error++;
            if (!c49.getText().toString().equals(answer[48])) error++;
            if (!c50.getText().toString().equals(answer[49])) error++;
            if (!c51.getText().toString().equals(answer[50])) error++;
            if (!c52.getText().toString().equals(answer[51])) error++;
            if (!c53.getText().toString().equals(answer[52])) error++;
            if (!c54.getText().toString().equals(answer[53])) error++;
            if (!c55.getText().toString().equals(answer[54])) error++;
            if (!c56.getText().toString().equals(answer[55])) error++;
            if (!c57.getText().toString().equals(answer[56])) error++;
            if (!c58.getText().toString().equals(answer[57])) error++;
            if (!c59.getText().toString().equals(answer[58])) error++;
            if (!c60.getText().toString().equals(answer[59])) error++;
            if (!c61.getText().toString().equals(answer[60])) error++;
            if (!c62.getText().toString().equals(answer[61])) error++;
            if (!c63.getText().toString().equals(answer[62])) error++;
            if (!c64.getText().toString().equals(answer[63])) error++;
            if (!c65.getText().toString().equals(answer[64])) error++;
            if (!c66.getText().toString().equals(answer[65])) error++;
            if (!c67.getText().toString().equals(answer[66])) error++;
            if (!c68.getText().toString().equals(answer[67])) error++;
            if (!c69.getText().toString().equals(answer[68])) error++;
            if (!c70.getText().toString().equals(answer[69])) error++;
            if (!c71.getText().toString().equals(answer[70])) error++;
            if (!c72.getText().toString().equals(answer[71])) error++;
            if (!c73.getText().toString().equals(answer[72])) error++;
            if (!c74.getText().toString().equals(answer[73])) error++;
            if (!c75.getText().toString().equals(answer[74])) error++;
            if (!c76.getText().toString().equals(answer[75])) error++;
            if (!c77.getText().toString().equals(answer[76])) error++;
            if (!c78.getText().toString().equals(answer[77])) error++;
            if (!c79.getText().toString().equals(answer[78])) error++;
            if (!c80.getText().toString().equals(answer[79])) error++;
            if (!c81.getText().toString().equals(answer[80])) error++;
        }catch (Exception e){
            Toast.makeText(this, ""+e, Toast.LENGTH_LONG).show();
        }
        return error;
    }

    public void end(View view){
        try {
            int errores = solution(mfra);
            if (errores > 0) {
                Toast.makeText(this, "Existen errores en " + errores + " casillas", Toast.LENGTH_SHORT).show();
            } else {
                pause();
                Toast.makeText(this, "GANASTE", Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(this, "end:"+e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void run() {
        try
        {
            while(Boolean.TRUE)
            {
                Thread.sleep(1000);
                salida = "";
                if( !pausado )
                {
                    segundos++;
                    if(segundos == 60)
                    {
                        segundos = 0;
                        minutos++;
                    }
                    if(minutos == 60)
                    {
                        minutos = 0;
                        horas++;
                    }
                    // Formateo la salida
                    salida += "0";
                    salida += horas;
                    salida += ":";
                    if( minutos <= 9 )
                    {
                        salida += "0";
                    }
                    salida += minutos;
                    salida += ":";
                    if( segundos <= 9 )
                    {
                        salida += "0";
                    }
                    salida += segundos;
                    // Modifico la UI
                    try
                    {
                        escribirenUI.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                etiq.setText(salida);
                            }
                        });
                    }
                    catch (Exception e)
                    {
                        Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + " al escribir en la UI: " + e.toString());
                    }
                }
            }
        }
        catch (InterruptedException e)
        {
            Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + ": " + e.toString());
        }

    }
    public void reiniciar()
    {
        segundos = 0;
        minutos = 0;
        horas = 0;
        pausado = Boolean.FALSE;
    }
    public void pause()
    {
        pausado = !pausado;
    }

    public void  pausarJuego(View view){
        Button pausa = findViewById(R.id.imageContinuar);
        pausa.setVisibility(View.VISIBLE);
        pause();
    }

    public void reiniciarJuego(View view){
        clean();
        fill(mfra);
        reiniciar();
    }
    public void continuarJuego(View view){
        Button pausa = findViewById(R.id.imageContinuar);
        pausa.setVisibility(View.GONE);
        pause();
    }
}
