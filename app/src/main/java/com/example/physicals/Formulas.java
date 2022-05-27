package com.example.physicals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;

public class Formulas extends AppCompatActivity {
    String[] formulas = {"P = mg \nm — масса тела, g — ускорение свободного падения, P - вес тела \nСИ: P = Н, m = кг, g = 9,8 м/с2 \nТакже можно найти: m = P / g, g = P / m"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}