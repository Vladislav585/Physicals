package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class TaskList extends AppCompatActivity {
    private Button btn_Weight, btn_Gravity, btn_Density, btn_MomentOfPower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Objects.requireNonNull(getSupportActionBar()).hide();
        addListenerOnButton();
    }
    private void addListenerOnButton(){
        btn_Weight = findViewById(R.id.buttonWeight);
        btn_Gravity = findViewById(R.id.buttonGravity);
        btn_Density = findViewById(R.id.buttonDensity);
        btn_MomentOfPower = findViewById(R.id.buttonMomentOfPower);
        btn_Weight.setOnClickListener(v -> {
            Intent intent = new Intent(TaskList.this, Weight.class);
            startActivity(intent);
        });
        btn_Gravity.setOnClickListener(v ->{
            Intent intent = new Intent(TaskList.this, Gravity.class);
            startActivity(intent);
        });
        btn_Density.setOnClickListener(v -> {
           Intent intent = new Intent(TaskList.this, Density.class);
           startActivity(intent);
        });
        btn_MomentOfPower.setOnClickListener(v ->{
            Intent intent = new Intent(TaskList.this, MomentOfPower.class);
            startActivity(intent);
        });
    }
}