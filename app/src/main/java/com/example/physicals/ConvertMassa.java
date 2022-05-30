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

public class ConvertMassa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_massa);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public String Find(){
        Spinner sp = findViewById(R.id.spinnerConverterAnswerS);
        return sp.getSelectedItem().toString();
    }
    public String SpinnerWeight(){
        Spinner Spinner = findViewById(R.id.SpinnerConverterS);
        return Spinner.getSelectedItem().toString();
    }
    public float GetMassa(){
        EditText mas = this.findViewById(R.id.InputConverterS);
        String mass = mas.getText().toString();
        return (float) Double.parseDouble(mass);
    }
    public String Converter(String find, String massa, String m){
        float M = (float) Double.parseDouble(m);
        if(find.equals("Кг") && massa.equals("Кг")){
            M += 0;
            m = Double.toString(M);
        }
        else if(find.equals("Кг") && massa.equals("Г")){
            M /= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Кг") && massa.equals("Мг")){
            M /= 1000000;
            m = Double.toString(M);
        }
        else if(find.equals("Кг") && massa.equals("Ц")){
            M *= 100;
            m = Double.toString(M);
        }
        else if(find.equals("Кг") && massa.equals("Т")){
            M *= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Г") && massa.equals("Кг")){
            M *= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Г") && massa.equals("Г")){
            M += 0;
            m = Double.toString(M);
        }
        else if(find.equals("Г") && massa.equals("Мг")){
            M /= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Г") && massa.equals("Ц")){
            M /= 100000;
            m = Double.toString(M);
        }
        else if(find.equals("Г") && massa.equals("Т")){
            M /= 1000000;
            m = Double.toString(M);
        }
        else if(find.equals("Мг") && massa.equals("Кг")){
            M *= 1000000;
            m = Double.toString(M);
        }
        else if(find.equals("Мг") && massa.equals("Г")){
            M *= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Мг") && massa.equals("Мг")){
            M += 0;
            m = Double.toString(M);
        }
        else if(find.equals("Мг") && massa.equals("Ц")){
            M *= 100000000;
            m = Double.toString(M);
        }
        else if(find.equals("Мг") && massa.equals("Т")){
            M *= 1000000000;
            m = Double.toString(M);
        }
        else if(find.equals("Ц") && massa.equals("Кг")){
            M /= 100;
            m = Double.toString(M);
        }
        else if(find.equals("Ц") && massa.equals("Г")){
            M /= 100000;
            m = Double.toString(M);
        }
        else if(find.equals("Ц") && massa.equals("Мг")){
            M /= 100000000;
            m = Double.toString(M);
        }
        else if(find.equals("Ц") && massa.equals("Ц")){
            M += 0;
            m = Double.toString(M);
        }
        else if(find.equals("Ц") && massa.equals("Т")){
            M *= 10;
            m = Double.toString(M);
        }
        else if(find.equals("Т") && massa.equals("Кг")){
            M /= 1000;
            m = Double.toString(M);
        }
        else if(find.equals("Т") && massa.equals("Г")){
            M /= 1000000;
            m = Double.toString(M);
        }
        else if(find.equals("Т") && massa.equals("Мг")){
            M /= 1000000000;
            m = Double.toString(M);
        }
        else if(find.equals("Т") && massa.equals("Ц")){
            M /= 10;
            m = Double.toString(M);
        }
        else if(find.equals("Т") && massa.equals("Т")){
            M += 0;
            m = Double.toString(M);
        }
        return m;
    }
    @SuppressLint("DefaultLocale")
    public void Conver(View v){
        Button btn = findViewById(R.id.ConverterButtonS);
        btn.setOnClickListener(v1 -> {
            try {
                String find = Find();
                String massa = SpinnerWeight();
                float m = GetMassa();
                String mas = Double.toString(m);
                String Ansmas = Converter(find, massa, mas);
                m = (float) Double.parseDouble(Ansmas);
                mas = BigDecimal.valueOf(Double.parseDouble(String.valueOf(m))).toPlainString();
                String Answer = ("m = " + mas + " " + find);
                final TextView ans = findViewById(R.id.ConverterSAnswer);
                ans.setText(Answer);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Введите правильно данные и уберите лишние данные", Toast.LENGTH_LONG).show();
            }
        });
    }
}