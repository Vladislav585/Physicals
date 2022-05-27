package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button btn_SolvingProblem, btn_Formulas, btn_AvoutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        try {
            btn_SolvingProblem = findViewById(R.id.ButtonSolvingProblem);
            btn_Formulas = findViewById(R.id.ButtonFormulas);
            btn_AvoutApp = findViewById(R.id.buttonAboutApp);
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.mystyle);
            dialog.setTitle("Заголовок диалога");
            btn_SolvingProblem.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TaskList.class);
                startActivity(intent);
            });
            btn_Formulas.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Formulas.class);
                startActivity(intent);
            });
            btn_AvoutApp.setOnClickListener(v -> {
                dialog.show();
            });
        }catch(Exception e){
            Toast.makeText(this,"Произошла непредвиденная ситуция", Toast.LENGTH_LONG).show();
        }
    }
}