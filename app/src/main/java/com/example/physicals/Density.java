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

public class Density extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerFindDensity);
        return sp.getSelectedItem().toString();
    }
    public float MassaTela(){
        EditText mas = this.findViewById(R.id.inputMD);
        String mass = mas.getText().toString();
        return (float) Double.parseDouble(mass);
    }
    public float Volume(){
        EditText vol = this.findViewById(R.id.inputV);
        String volu = vol.getText().toString();
        return (float) Double.parseDouble(volu);
    }
    public float Density(){
        EditText den = this.findViewById(R.id.inputPO);
        String dens = den.getText().toString();
        return (float) Double.parseDouble(dens);
    }
    public String SpinnerWeightForDensity(){
        Spinner Spinner = findViewById(R.id.spinnerForWeightD);
        return Spinner.getSelectedItem().toString();
    }
    public String SpinnerDensity(){
        Spinner Spinner = findViewById(R.id.spinnerForDensity);
        return Spinner.getSelectedItem().toString();
    }
    public String SpinnerVolume(){
        Spinner spinner = findViewById(R.id.spinnerForVolume);
        return spinner.getSelectedItem().toString();
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
    public String konverterDensity(String density, String p){
        float den = (float) Double.parseDouble(p);
        if(density.equals("Кг/м³")){
            den += 0;
        }
        else if(density.equals("Г/см³")){
            den *= 1000;
        }
        return p = Double.toString(den);
    }
    public String konverterVolume(String volume, String v){
        float vol = (float) Double.parseDouble(v);
        if(volume.equals("м³")){
            vol += 0;
        }
        else if(volume.equals("см³")){
            vol /= 1000000;
        }
        else if(volume.equals("Л")){
            vol /= 1000;
        }
        v = Double.toString(vol);
        return v;
    }
    public void SolveDensity(View v){
        Button btn = (Button) findViewById(R.id.solvingButtonDensity);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    String find = Find();
                    switch(find){
                        case "ρ":{
                            float m = MassaTela();
                            float V = Volume();
                            String weight = SpinnerWeightForDensity();
                            String mew = Double.toString(m);
                            String mas = konverterWeight(weight, mew);
                            m = (float) Double.parseDouble(mas);
                            String volume = SpinnerVolume();
                            String vol = Double.toString(V);
                            String vo = konverterVolume(volume, vol);
                            V = (float) Double.parseDouble(vo);
                            float Answe = (float) (m / V);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("ρ = " + result + "  Кг/м³ " + " (≈" + b + " Кг/м³)");
                            final TextView ans = (TextView) findViewById(R.id.Answ);
                            ans.setText(answer);
                            break;
                        }
                        case "m" :{
                            float V = Volume();
                            String volume = SpinnerVolume();
                            String vol = Double.toString(V);
                            String vo = konverterVolume(volume, vol);
                            V = (float) Double.parseDouble(vo);
                            float po = Density();
                            String density = SpinnerDensity();
                            String den = Double.toString(po);
                            String de = konverterDensity(density, den);
                            po = (float) Double.parseDouble(de);
                            float Answe = (float) (V * po);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("m = " + result + "  Кг " + " (≈" + b + " Кг)");
                            final TextView ans = (TextView) findViewById(R.id.Answ);
                            ans.setText(answer);
                            break;
                        }
                        case "V" :{
                            float po = Density();
                            String density = SpinnerDensity();
                            String den = Double.toString(po);
                            String de = konverterDensity(density, den);
                            po = (float) Double.parseDouble(de);
                            float m = MassaTela();
                            String weight = SpinnerWeightForDensity();
                            String mew = Double.toString(m);
                            String mas = konverterWeight(weight, mew);
                            m = (float) Double.parseDouble(mas);
                            float Answe = (float) (m / po);
                            String result = String.format("%.3f", Answe);
                            int b = Math.round(Answe);
                            String answer = ("V = " + result + "  м³ " + " (≈" + b + " м³)");
                            final TextView ans = (TextView) findViewById(R.id.Answ);
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