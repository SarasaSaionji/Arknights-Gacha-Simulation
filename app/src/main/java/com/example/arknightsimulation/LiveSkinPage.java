package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LiveSkinPage extends AppCompatActivity {

    Button Gobacktomenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_skin_page);

        Gobacktomenu = findViewById(R.id.BackButtonToMenu);


        Gobacktomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageMainMenupage = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(GotoPageMainMenupage);
            }
        });
    }


}