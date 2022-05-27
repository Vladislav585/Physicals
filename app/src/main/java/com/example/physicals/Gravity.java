package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Gravity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public float MassaTela(){
        EditText mas = this.findViewById(R.id.inputMf);
        String mass = mas.getText().toString();
        return (float) Double.parseDouble(mass);
    }
    public float Gravity(){
        EditText ge = this.findViewById(R.id.inputGF);
        String ga = ge.getText().toString();
        return (float) Double.parseDouble(ga);
    }
    public float PowerF(){
        EditText pe = this.findViewById(R.id.inputFgravity);
        String pa = pe.getText().toString();
        return (float) Double.parseDouble(pa);
    }
    public String SpinnerWeightt(){
        Spinner Spinner = findViewById(R.id.spinnerForWeight);
        return Spinner.getSelectedItem().toString();
    }
    public String SpinnerNuton(){
        Spinner spinner = findViewById(R.id.spinnerForGravity);
        return spinner.getSelectedItem().toString();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerFindGravity);
        return sp.getSelectedItem().toString();
    }
    public String konverterWeight(String weight, String mexapmle){
        float masa = (float) Double.parseDouble(mexapmle);
        if(weight.equals("Кг")){
            masa += 0;
        }
        else if(weight.equals("Г")){
            masa = masa/1000;
        }
        else if(weight.equals("Ц")){
            masa = masa * 100;
        }
        else if(weight.equals("Т")){
            masa = masa * 1000;
        }
        mexapmle = Double.toString(masa);
        return mexapmle;
    }
    public String konverterGravity(String ves, String gravity){
        float ve = (float) Double.parseDouble(ves);
        if(gravity.equals("Н")){
            ve += 0;
        }
        else if(gravity.equals("кН")){
            ve = ve * 1000;
        }
        else if(gravity.equals("МН")){
            ve = ve * 1000000;
        }
        else if(gravity.equals("ГН")){
            ve = ve * 1000000000;
        }
        ves = Double.toString(ve);
        return ves;
    }
    public void SolvePowerF(View v){
        Button btn = (Button) findViewById(R.id.solvingButtonF);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                String find = Find();
                    switch (find) {
                        case "Fтяж": {
                            float m = MassaTela();
                            float g = Gravity();
                            String weight = SpinnerWeightt();
                            String mexapmle = Double.toString(m);
                            String mas = konverterWeight(weight, mexapmle);
                            m = (float) Double.parseDouble(mas);
                            float Answe = (float) (m * g);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("P = " + result + " Н " + " (≈" + b + " Н)");
                            final TextView ans = (TextView) findViewById(R.id.Answe);
                            ans.setText(answer);
                            break;
                        }
                        case "m": {
                            String gravity = SpinnerNuton();
                            float g = Gravity();
                            float p = PowerF();
                            String ves = Double.toString(p);
                            String pe = konverterGravity(ves, gravity);
                            p = (float) Double.parseDouble(pe);
                            float Answe = (float) (p / g);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("m = " + result + " Кг " + " (≈" + b + " Кг)");
                            final TextView ans = (TextView) findViewById(R.id.Answe);
                            ans.setText(answer);
                            break;
                        }
                        case "g": {
                            String weight = SpinnerWeightt();
                            String gravity = SpinnerNuton();
                            float massa = MassaTela();
                            float f = PowerF();
                            String ves = Double.toString(f);
                            String pe = konverterGravity(ves, gravity);
                            f = (float) Double.parseDouble(pe);
                            String mas = Double.toString(massa);
                            String mass = konverterWeight(weight, mas);
                            massa = (float) Double.parseDouble(mass);
                            float Answe = (float) (f / massa);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("g = " + result + "  м/с² " + " (≈" + b + " м/с²)");
                            final TextView ans = (TextView) findViewById(R.id.Answer);
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