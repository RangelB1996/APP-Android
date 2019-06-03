package com.example.bryan.estudihambre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class calculadora extends AppCompatActivity {
    private Button btn_todo;
    private EditText editTextnum1,editTextnum2;
    private CheckBox ch_sum,ch_div,ch_res,ch_mult;
    private float num1,num2,resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        editTextnum1 = (EditText) findViewById(R.id.editText);
        editTextnum2 = (EditText) findViewById(R.id.editText2);
        btn_todo = (Button) findViewById(R.id.btn_todo);
        ch_sum=(CheckBox) findViewById(R.id.ch_sum);
        ch_div=(CheckBox) findViewById(R.id.ch_div);
        ch_res=(CheckBox) findViewById(R.id.ch_res);
        ch_mult=(CheckBox) findViewById(R.id.ch_mult);
    }
    public void operaciones(View v){

        if(ch_sum.isChecked()==true){
            float r;
            try{
                num1 = Float.parseFloat(editTextnum1.getText().toString());
                num2 = Float.parseFloat(editTextnum2.getText().toString());
                r = (num1+num2);
                resultado=r;
                Toast.makeText(this,"El resultado de la suma es:" + r,Toast.LENGTH_SHORT).show();
            }catch(Exception e){ Toast.makeText(this,"ERROR EXISTEN CAMPOS VACIOS" ,Toast.LENGTH_SHORT).show();}

        }
        if (ch_div.isChecked()==true){
            float r;
            try{
                num1 = Float.parseFloat(editTextnum1.getText().toString());
                num2 = Float.parseFloat(editTextnum2.getText().toString());
                r = (num1/num2);
                resultado=r;
                Toast.makeText(this,"El resultado de la division es:" + r,Toast.LENGTH_SHORT).show();
            }catch (Exception e){Toast.makeText(this,"ERROR EXISTEN CAMPOS VACIOS",Toast.LENGTH_SHORT).show();}
        }
        if(ch_mult.isChecked()==true){
            float r;
            try{
                num1 = Float.parseFloat(editTextnum1.getText().toString());
                num2 = Float.parseFloat(editTextnum2.getText().toString());
                r = (num1*num2);
                resultado=r;
                Toast.makeText(this,"El resultado de la multiplicacion es" + r,Toast.LENGTH_SHORT).show();
            }catch (Exception e){Toast.makeText(this,"ERROR EXISTEN CAMPOS VACIOS" ,Toast.LENGTH_SHORT).show(); }
        }
        if (ch_res.isChecked()==true){
            float r;
            try {
                num1 = Float.parseFloat(editTextnum1.getText().toString());
                num2 = Float.parseFloat(editTextnum2.getText().toString());
                r = (num1-num2);
                resultado=r;
                Toast.makeText(this,"El resultado de la resta es:" + r,Toast.LENGTH_SHORT).show();
            }catch (Exception e){Toast.makeText(this,"ERROR EXISTEN CAMPOS VACIOS",Toast.LENGTH_SHORT).show();}
        }
    }
}
