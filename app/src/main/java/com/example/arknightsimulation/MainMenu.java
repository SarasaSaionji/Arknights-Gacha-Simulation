package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    ImageButton GotoBannerPage,GotoShopPage,GotoCreditPage,GotoDynamicSkinPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        GotoBannerPage = findViewById(R.id.GotoBanner);
        GotoShopPage = findViewById(R.id.GotoShop);
        GotoCreditPage = findViewById(R.id.GotoCredit);
        GotoDynamicSkinPage = findViewById(R.id.GotoDynamicSkin);


        GotoBannerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageBannerPage = new Intent(getApplicationContext(), Banner_page.class);
                startActivity(GotoPageBannerPage);
            }
        });

        GotoShopPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopup();
            }
        });

        GotoCreditPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoPageCreditPage = new Intent(getApplicationContext(), CreditPage.class);
                startActivity(GotoPageCreditPage);
            }
        });

        GotoDynamicSkinPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoLiveSkinPage = new Intent(getApplicationContext(), LiveSkinPage.class);
                startActivity(GotoLiveSkinPage);
            }
        });



    }


    private static final int REQUEST_TOPUP = 1;
    public void openTopup() {
        Intent intent = new Intent(this, Topup.class);
        startActivityForResult(intent, REQUEST_TOPUP);
    }

    // ส่งค่าหน้าที่ขอเข้าไป Topup เพื่อกลับมาหน้าเดิม เมื่อกดปุ่ม Back และนำข้อมูลจากหน้า Topup ที่ได้รับมา
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }


}