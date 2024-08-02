package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Banner_page extends AppCompatActivity {



    ImageButton GotoDorothyRerunBanner,GotoTyphonBanner,GotoNearlTheRadiant;
    Button GoBackToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_page);

        GotoTyphonBanner = findViewById(R.id.TyphonBanner);
        GotoNearlTheRadiant = findViewById(R.id.NearlTheRadiantBanner);
        GotoDorothyRerunBanner = findViewById(R.id.DorothyBanner);
        GoBackToMenu = findViewById(R.id.BackButton);




        GotoTyphonBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageTyphonBanner = new Intent(getApplicationContext(), Banner_Typhon.class);
                startActivity(GotoPageTyphonBanner);
            }
        });

        GotoDorothyRerunBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageDorothyRerunBanner = new Intent(getApplicationContext(), Banner_Dorothy.class);
                startActivity(GotoPageDorothyRerunBanner);
            }
        });

        GotoNearlTheRadiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageNearlTheRadiantBanner = new Intent(getApplicationContext(), Banner_Nearl_Radiant.class);
                startActivity(GotoPageNearlTheRadiantBanner);
            }
        });

        GoBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageDorothyRerunBanner = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(GotoPageDorothyRerunBanner);
            }
        });
    }
}