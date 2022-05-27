package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MomentOfPower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment_of_power);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerFindMomentOfPower);
        return sp.getSelectedItem().toString();
    }
    public float GetLength(){
        EditText le = this.findViewById(R.id.inputL);
        String l = le.getText().toString();
        return (float) Double.parseDouble(l);
    }
    public float GetModulPower(){
        EditText mod = this.findViewById(R.id.inputF);
        String F = mod.getText().toString();
        return (float) Double.parseDouble(F);
    }
    public float GetMomentOfPower(){
        EditText mod = this.findViewById(R.id.inputMoment);
        String M = mod.getText().toString();
        return (float) Double.parseDouble(M);
    }
    public String spinnerForModulPower(){
        Spinner spinner = findViewById(R.id.spinnerForModulPower);
        return spinner.getSelectedItem().toString();
    }
    public String spinnerForLength(){
        Spinner spinner = findViewById(R.id.spinnerForLength);
        return spinner.getSelectedItem().toString();
    }
    public String konverterLength(String length, String l){
        float le = (float) Double.parseDouble(l);
        if(length.equals("М")){
            le += 0;
        }
        else if(length.equals("СМ")){
            le /= 100;
        }
        return l = Double.toString(le);
    }
    public String konverterNuton(String Modul, String f){
        float modul = (float) Double.parseDouble(f);
        if(Modul.equals("Н")){
            modul += 0;
        }
        else if(Modul.equals("кН")){
            modul *= 1000;
        }
        else if(Modul.equals("МН")){
            modul *= 1000000;
        }
        else if(Modul.equals("ГН")){
            modul *= 1000000000;
        }
        return f = Double.toString(modul);
    }
    public void SolveMomentOfPower(View v){
        Button btn = (Button) findViewById(R.id.solvingButtonMomentOfPower);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String find = Find();
                    switch(find){
                        case "M" :{
                            float f = GetModulPower();
                            float l = GetLength();
                            String modul = spinnerForModulPower();
                            String length = spinnerForLength();
                            String mod = Double.toString(f);
                            String Modul = konverterNuton(modul, mod);
                            f = (float) Double.parseDouble(Modul);
                            String le = Double.toString(l);
                            String len = konverterLength(length, le);
                            l = (float) Double.parseDouble(len);
                            float Answe = (float) (f * l);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("M = " + result + "  Нм " + " (≈" + b + " Нм)");
                            final TextView ans = (TextView) findViewById(R.id.An);
                            ans.setText(answer);
                            break;
                        }
                        case "F" :{
                            float M = GetMomentOfPower();
                            float l = GetLength();
                            String length = spinnerForLength();
                            String le = Double.toString(l);
                            String len = konverterLength(length, le);
                            l = (float) Double.parseDouble(len);
                            float Answe = (float) (M / l);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("F = " + result + "  Н " + " (≈" + b + " Н)");
                            final TextView ans = (TextView) findViewById(R.id.An);
                            ans.setText(answer);
                            break;
                        }
                        case "l":{
                            float M = GetMomentOfPower();
                            float f = GetModulPower();
                            String modul = spinnerForModulPower();
                            String mod = Double.toString(f);
                            String Modul = konverterNuton(modul, mod);
                            f = (float) Double.parseDouble(Modul);
                            float Answe = (float) (M / f);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("l = " + result + "  М " + " (≈" + b + " М)");
                            final TextView ans = (TextView) findViewById(R.id.An);
                            ans.setText(answer);
                            break;
                        }
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Введите правильно данные и уберите лишние данные", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}