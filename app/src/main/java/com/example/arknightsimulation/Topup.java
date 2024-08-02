package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Topup extends AppCompatActivity {


    ImageButton BuyOriginium_1,BuyOriginium_6,BuyOriginium_20,BuyOriginium_40,BuyOriginium_66,BuyOriginium_130;
    TextView ShowOriginium,ShowOrundum;

    Button BackToCurrent;
    SharedPreferences Payment;
    SharedPreferences.Editor editor;
    int Originium ;
    int Orundum ;

    int MoneySpend ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);




        Payment = this.getSharedPreferences("PaymentData", Context.MODE_PRIVATE);
        editor = Payment.edit();

        BuyOriginium_1 = findViewById(R.id.Originuim_1);
        BuyOriginium_6 = findViewById(R.id.Originuim_6);
        BuyOriginium_20 = findViewById(R.id.Originuim_20);
        BuyOriginium_40 = findViewById(R.id.Originuim_40);
        BuyOriginium_66 = findViewById(R.id.Originuim_66);
        BuyOriginium_130 = findViewById(R.id.Originuim_130);
        ShowOriginium = findViewById(R.id.OriginiumText);
        BackToCurrent = findViewById(R.id.BackButton);
        ShowOrundum = findViewById(R.id.OrundumText);

        BuyOriginium_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy1originium();
            }
        });


        BuyOriginium_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy6originium();
            }
        });

        BuyOriginium_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy20originium();
            }
        });

        BuyOriginium_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy40originium();
            }
        });

        BuyOriginium_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy66originium();
            }
        });

        BuyOriginium_130.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy130originium();
            }
        });

        BackToCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackPressed();
            }
        });
        Originium = Payment.getInt("DataSave_Originium", 0);

        ShowOriginium.setText(String.valueOf(Originium));

        // โหลดค่า Orundum จาก SharedPreferences
        SharedPreferences payment = getSharedPreferences("PaymentData", Context.MODE_PRIVATE);
        Orundum = payment.getInt("DataSave_Orundum", 0);

        // ตรวจสอบค่า Orundum และนำไปใช้ตามต้องการ
        // ...

        // แสดงค่า Orundum ที่โหลดได้

        ShowOrundum.setText(String.valueOf(Orundum));
    }





    public void Buy1originium() {


        Originium += 1;
        MoneySpend += 35;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 1 Originium THB 35 Successful", Toast.LENGTH_SHORT).show();
    }

    public void Buy6originium() {


        Originium += 6;
        MoneySpend += 175;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 6 Originium THB 175 Successful", Toast.LENGTH_SHORT).show();
    }

    public void Buy20originium() {


        Originium += 20;
        MoneySpend += 525;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 20 Originium THB 525 Successful", Toast.LENGTH_SHORT).show();
    }

    public void Buy40originium() {


        Originium += 40;
        MoneySpend += 1050;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 40 Originium THB 1050 Successful", Toast.LENGTH_SHORT).show();
    }

    public void Buy66originium() {


        Originium += 66;
        MoneySpend += 1750;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 66 Originium THB 1750 Successful", Toast.LENGTH_SHORT).show();
    }



    public void Buy130originium() {


        Originium += 130;
        MoneySpend += 3500;

        editor.putInt("DataSave_MoneySpend", MoneySpend);
        editor.putInt("DataSave_Originium", Originium);
        editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน


        ShowOriginium.setText(String.valueOf(Originium));



        ShowOriginium.setText(String.valueOf(Originium));
        Toast.makeText(getApplicationContext(), "Bought 130 Originium THB 3500 Successful", Toast.LENGTH_SHORT).show();
    }


    public void BackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("originium_key", Originium);
        resultIntent.putExtra("orundum_key", Orundum);

        setResult(RESULT_OK, resultIntent);
        finish();
    }
}