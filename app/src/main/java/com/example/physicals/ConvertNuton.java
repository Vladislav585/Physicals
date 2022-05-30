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

public class ConvertNuton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_nuton);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerConverterAnswerS);
        return sp.getSelectedItem().toString();
    }
    public String SpinnerNuton(){
        Spinner Spinner = findViewById(R.id.SpinnerConverterS);
        return Spinner.getSelectedItem().toString();
    }
    public float GetNuton(){
        EditText mas = this.findViewById(R.id.InputConverterS);
        String mass = mas.getText().toString();
        return (float) Double.parseDouble(mass);
    }
    public String Converter(String find, String nuton, String H){
        float h = (float) Double.parseDouble(H);
        if(find.equals("Н") && nuton.equals("Н")){
            h += 0;
            H = Double.toString(h);
        }
        else if(find.equals("Н") && nuton.equals("кН")){
            h *= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("Н") && nuton.equals("гН")){
            h *= 100;
            H = Double.toString(h);
        }
        else if(find.equals("Н") && nuton.equals("МН")){
            h *= 1000000;
            H = Double.toString(h);
        }
        else if(find.equals("Н") && nuton.equals("ГН")){
            h *= 1000000000;
            H = Double.toString(h);
        }
        else if(find.equals("гН") && nuton.equals("Н")){
            h /= 100;
            H = Double.toString(h);
        }
        else if(find.equals("гН") && nuton.equals("гН")){
            h += 0;
            H = Double.toString(h);
        }
        else if(find.equals("гН") && nuton.equals("кН")){
            h *= 10;
            H = Double.toString(h);
        }
        else if(find.equals("гН") && nuton.equals("МН")){
            h *= 10000;
            H = Double.toString(h);
        }
        else if(find.equals("гН") && nuton.equals("ГН")){
            h *= 10000000;
            H = Double.toString(h);
        }
        else if(find.equals("кН") && nuton.equals("Н")){
            h /= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("кН") && nuton.equals("гН")){
            h /= 10;
            H = Double.toString(h);
        }
        else if(find.equals("кН") && nuton.equals("кН")){
            h += 0;
            H = Double.toString(h);
        }
        else if(find.equals("кН") && nuton.equals("МН")){
            h *= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("кН") && nuton.equals("ГН")){
            h *= 1000000;
            H = Double.toString(h);
        }
        else if(find.equals("МН") && nuton.equals("Н")){
            h /= 1000000;
            H = Double.toString(h);
        }
        else if(find.equals("МН") && nuton.equals("гН")){
            h /= 10000;
            H = Double.toString(h);
        }
        else if(find.equals("МН") && nuton.equals("кН")){
            h /= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("МН") && nuton.equals("МН")){
            h += 0;
            H = Double.toString(h);
        }
        else if(find.equals("МН") && nuton.equals("ГН")){
            h *= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("ГН") && nuton.equals("Н")){
            h /= 1000000000;
            H = Double.toString(h);
        }
        else if(find.equals("ГН") && nuton.equals("гН")){
            h /= 10000000;
            H = Double.toString(h);
        }
        else if(find.equals("ГН") && nuton.equals("кН")){
            h /= 1000000;
            H = Double.toString(h);
        }
        else if(find.equals("ГН") && nuton.equals("МН")){
            h /= 1000;
            H = Double.toString(h);
        }
        else if(find.equals("ГН") && nuton.equals("ГН")){
            h += 0;
            H = Double.toString(h);
        }
        return H;
    }
    @SuppressLint("DefaultLocale")
    public void ConverNuton(View v){
        Button btn = findViewById(R.id.ConverterButtonS);
        btn.setOnClickListener(v1 -> {
            try {
                String find = Find();
                String nuton = SpinnerNuton();
                float h = GetNuton();
                String ha = Double.toString(h);
                String Ansmas = Converter(find, nuton, ha);
                h = (float) Double.parseDouble(Ansmas);
                ha = BigDecimal.valueOf(Double.parseDouble(String.valueOf(h))).toPlainString();
                String Answer = ("m = " + ha + " " + find);
                final TextView ans = findViewById(R.id.ConverterSAnswer);
                ans.setText(Answer);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Введите правильно данные и уберите лишние данные", Toast.LENGTH_LONG).show();
            }
        });
    }
}