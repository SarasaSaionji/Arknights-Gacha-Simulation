package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditPage extends AppCompatActivity {


    Button Goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_page);

        Goback = findViewById(R.id.BackButton);


        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoMainMenuPage = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(GotoMainMenuPage);
            }
        });
    }
}