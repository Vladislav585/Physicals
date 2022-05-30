package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class ComvertList extends AppCompatActivity {
    private Button btn_Massa, btn_Nuton, btn_S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comvert_list);
        Objects.requireNonNull(getSupportActionBar()).hide();
        addListenerOnButton();
    }
    private void addListenerOnButton() {
        try {
            btn_Massa = findViewById(R.id.buttonConvertM);
            btn_Nuton = findViewById(R.id.buttonConvertH);
            btn_S = findViewById(R.id.buttonConvertS);
            btn_Massa.setOnClickListener(v -> {
                Intent intent = new Intent(ComvertList.this, ConvertMassa.class);
                startActivity(intent);
            });
            btn_Nuton.setOnClickListener(v -> {
               Intent intent = new Intent(ComvertList.this, ConvertNuton.class);
               startActivity(intent);
            });
            btn_S.setOnClickListener(v ->{
               Intent intent = new Intent(ComvertList.this, ConvertS.class);
               startActivity(intent);
            });
        }catch(Exception e){
            Toast.makeText(this,"Произошла непредвиденная ситуция", Toast.LENGTH_LONG).show();
        }
    }
}