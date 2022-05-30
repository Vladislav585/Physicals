package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Objects;

public class ConvertS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_s);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public String Find() {
        Spinner sp = findViewById(R.id.spinnerConverterAnswerS);
        return sp.getSelectedItem().toString();
    }

    public String SpinnerS() {
        Spinner Spinner = findViewById(R.id.SpinnerConverterS);
        return Spinner.getSelectedItem().toString();
    }

    public float GetS() {
        EditText mas = this.findViewById(R.id.InputConverterS);
        String mass = mas.getText().toString();
        return (float) Double.parseDouble(mass);
    }

    public String Converter(String find, String ploshad, String S) {
        Double s = Double.parseDouble(S);
        if (find.equals("м²") && ploshad.equals("м²")) {
            s += 0;
            S = Double.toString(s);
        } else if (find.equals("м²") && ploshad.equals("см²")) {
            s /= 10000;
            S = Double.toString(s);
        } else if (find.equals("м²") && ploshad.equals("км²")) {
            s *= 1000000;
            S = Double.toString(s);
        } else if (find.equals("м²") && ploshad.equals("Га")) {
            s *= 10000;
            S = Double.toString(s);
        } else if (find.equals("м²") && ploshad.equals("Ар")) {
            s *= 100;
            S = Double.toString(s);
        } else if (find.equals("см²") && ploshad.equals("м²")) {
            s *= 10000;
            S = Double.toString(s);
        } else if (find.equals("см²") && ploshad.equals("см²")) {
            s += 0;
            S = Double.toString(s);
        } else if (find.equals("см²") && ploshad.equals("км²")) {
            s *= 1000000000;
            S = Double.toString(s);
        } else if (find.equals("см²") && ploshad.equals("Га")) {
            s *= 100000000;
            S = Double.toString(s);
        } else if (find.equals("см²") && ploshad.equals("Ар")) {
            s *= 1000000;
            S = Double.toString(s);
        } else if (find.equals("км²") && ploshad.equals("м²")) {
            s /= 1000000;
            S = Double.toString(s);
        } else if (find.equals("км²") && ploshad.equals("см²")) {
            s /= 1000000000;
            S = Double.toString(s);
        } else if (find.equals("км²") && ploshad.equals("км²")) {
            s += 0;
            S = Double.toString(s);
        } else if (find.equals("км²") && ploshad.equals("Га")) {
            s /= 100;
            S = Double.toString(s);
        } else if (find.equals("км²") && ploshad.equals("Ар")) {
            s /= 10000;
            S = Double.toString(s);
        } else if (find.equals("Га") && ploshad.equals("м²")) {
            s /= 10000;
            S = Double.toString(s);
        } else if (find.equals("Га") && ploshad.equals("см²")) {
            s /= 100000000;
            S = Double.toString(s);
        } else if (find.equals("Га") && ploshad.equals("км²")) {
            s *= 100;
            S = Double.toString(s);
        } else if (find.equals("Га") && ploshad.equals("Га")) {
            s += 0;
            S = Double.toString(s);
        } else if (find.equals("Га") && ploshad.equals("Ар")) {
            s /= 100;
            S = Double.toString(s);
        } else if (find.equals("Ар") && ploshad.equals("м²")) {
            s /= 100;
            S = Double.toString(s);
        } else if (find.equals("Ар") && ploshad.equals("см²")) {
            s /= 1000000;
            S = Double.toString(s);
        } else if (find.equals("Ар") && ploshad.equals("км²")) {
            s *= 10000;
            S = Double.toString(s);
        } else if (find.equals("Ар") && ploshad.equals("Га")) {
            s *= 100;
            S = Double.toString(s);
        } else if (find.equals("Ар") && ploshad.equals("Ар")) {
            s += 0;
            S = Double.toString(s);
        }
        return S;
    }
    @SuppressLint("DefaultLocale")
    public void ConverNuton(View v){
        Button btn = findViewById(R.id.ConverterButtonS);
        btn.setOnClickListener(v1 -> {
            try {
                String find = Find();
                String ploshad = SpinnerS();
                float S = GetS();
                String s = Double.toString(S);
                String Ansmas = Converter(find, ploshad, s);
                S = (float) Double.parseDouble(Ansmas);
                s = BigDecimal.valueOf(Double.parseDouble(String.valueOf(S))).toPlainString();
                String Answer = ("S = " + s + " " + find);
                final TextView ans = findViewById(R.id.ConverterSAnswer);
                ans.setText(Answer);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Введите правильно данные и уберите лишние данные", Toast.LENGTH_LONG).show();
            }
        });
    }
}