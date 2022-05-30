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

public class Pressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerFindPressure);
        return sp.getSelectedItem().toString();
    }
    public float GetModulPower(){
        EditText mod = this.findViewById(R.id.inputPower);
        String F = mod.getText().toString();
        return (float) Double.parseDouble(F);
    }
    public String spinnerForModulPower(){
        Spinner spinner = findViewById(R.id.spinnerForPower);
        return spinner.getSelectedItem().toString();
    }
    public float GetPressure(){
        EditText mod = this.findViewById(R.id.inputPressure);
        String p = mod.getText().toString();
        return (float) Double.parseDouble(p);
    }
    public String spinnerForPressure(){
        Spinner spinner = findViewById(R.id.spinnerForPaskal);
        return spinner.getSelectedItem().toString();
    }
    public float GetS(){
        EditText mod = this.findViewById(R.id.inputS);
        String S = mod.getText().toString();
        return (float) Double.parseDouble(S);
    }
    public String spinnerForS(){
        Spinner spinner = findViewById(R.id.spinnerForS);
        return spinner.getSelectedItem().toString();
    }
    public String konverterS(String length, String S){
        float le = (float) Double.parseDouble(S);
        switch (length) {
            case "М²":
                le += 0;
                break;
            case "СМ²":
                le /= 10000;
                break;
            case "КМ²":
                le *= 1000000;
                break;
        }
        return Double.toString(le);
    }
    public String konverterPaskal(String Modul, String f){
        float modul = (float) Double.parseDouble(f);
        switch (Modul) {
            case "Па":
                modul += 0;
                break;
            case "гПа":
                modul *= 100;
                break;
            case "кПа":
                modul *= 1000;
                break;
            case "МПа":
                modul *= 1000000;
                break;
        }
        return Double.toString(modul);
    }
    public String konverterNuton(String Modul, String f){
        float modul = (float) Double.parseDouble(f);
        switch (Modul) {
            case "Н":
                modul += 0;
                break;
            case "кН":
                modul *= 1000;
                break;
            case "МН":
                modul *= 1000000;
                break;
            case "ГН":
                modul *= 1000000000;
                break;
        }
        return Double.toString(modul);
    }
    public void SolvePressure(View v){
        Button btn = findViewById(R.id.solvingButtonPressure);
        btn.setOnClickListener(v1 -> {
            try{
                String find = Find();
                switch(find){
                    case "p" :{
                        float S = GetS();
                        float F = GetModulPower();
                        String modul = spinnerForModulPower();
                        String length = spinnerForS();
                        String le = Double.toString(S);
                        String fe = Double.toString(F);
                        String L = konverterS(length, le);
                        String f = konverterNuton(modul, fe);
                        F = (float) Double.parseDouble(f);
                        S = (float) Double.parseDouble(L);
                        float Answe = F / S;
                        String result = String.format("%.3f", Answe);
                        int b = Math.round(Answe);
                        String answer = ("p = " + result + "  Па " + " (≈" + b + " Па)");
                        final TextView ans = (TextView) findViewById(R.id.AnswerToQuestion);
                        ans.setText(answer);
                        break;
                    }
                    case "F" :{
                        float P = GetPressure();
                        float S = GetS();
                        String length = spinnerForS();
                        String paskal = spinnerForPressure();
                        String pa = Double.toString(P);
                        String le = Double.toString(S);
                        String pas = konverterPaskal(paskal, pa);
                        String L = konverterS(length, le);
                        P = (float) Double.parseDouble(pas);
                        S = (float) Double.parseDouble(L);
                        float Answe = (float) (P * S);
                        String result = String.format("%.3f", Answe);
                        int b = Math.round(Answe);
                        String answer = ("F = " + result + "  Н " + " (≈" + b + " Н)");
                        final TextView ans = (TextView) findViewById(R.id.AnswerToQuestion);
                        ans.setText(answer);
                        break;
                    }
                    case "S":{
                        float P = GetPressure();
                        float F = GetModulPower();
                        String modul = spinnerForModulPower();
                        String paskal = spinnerForPressure();
                        String pa = Double.toString(P);
                        String fe = Double.toString(F);
                        String pas = konverterPaskal(paskal, pa);
                        String f = konverterNuton(modul, fe);
                        P = (float) Double.parseDouble(pas);
                        F = (float) Double.parseDouble(f);
                        float Answe = (float) (F / P);
                        String result = String.format("%.3f", Answe);
                        int b = Math.round(Answe);
                        String answer = ("S = " + result + "  М² " + " (≈" + b + " М²)");
                        final TextView ans = (TextView) findViewById(R.id.AnswerToQuestion);
                        ans.setText(answer);
                        break;
                    }
                }
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Введите правильно данные и уберите лишние данные", Toast.LENGTH_LONG).show();
            }
        });
    }
}