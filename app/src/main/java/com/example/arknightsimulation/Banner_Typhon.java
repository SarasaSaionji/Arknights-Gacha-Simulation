package com.example.arknightsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import java.util.Random;

public class Banner_Typhon extends AppCompatActivity {



    Button Gacha_10Time,Gacha_1Time,BackToCurrent;

    ImageButton Intent_Topup,ConvertToOrundum;
    TextView TextGacha1,TextGacha2,TextGacha3,TextGacha4,TextGacha5,TextGacha6,TextGacha7,TextGacha8,TextGacha9,TextGacha10;
    ImageView Image1,Image2,Image3,Image4,Image5,Image6,Image7,Image8,Image9,Image10;


    TextView MoneySpendShow,RollCountShow,PityRateShow,No6StarRollStreakShow,text_show,OriginiumShow,OrundumShow;

    int Originium;
    int Orundum;

    SharedPreferences Payment;
    SharedPreferences.Editor editor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_typhon);

        Payment = this.getSharedPreferences("PaymentData", Context.MODE_PRIVATE);
        editor = Payment.edit();

        Intent intent = getIntent();
        Originium = intent.getIntExtra("originium_key", 0);

        Gacha_10Time = findViewById(R.id.Headhunt10);
        Gacha_1Time = findViewById(R.id.Headhunt1);
        OriginiumShow = findViewById(R.id.OriginiumText);


        ConvertToOrundum = findViewById(R.id.ConvertOrundum);
        OrundumShow = findViewById(R.id.OrundumText);




        //Picture of Charactor you got
        Image1 = findViewById(R.id.GachaPicSlot1);
        Image2 = findViewById(R.id.GachaPicSlot2);
        Image3 = findViewById(R.id.GachaPicSlot3);
        Image4 = findViewById(R.id.GachaPicSlot4);
        Image5 = findViewById(R.id.GachaPicSlot5);
        Image6 = findViewById(R.id.GachaPicSlot6);
        Image7 = findViewById(R.id.GachaPicSlot7);
        Image8 = findViewById(R.id.GachaPicSlot8);
        Image9 = findViewById(R.id.GachaPicSlot9);
        Image10 = findViewById(R.id.GachaPicSlot10);


        //Text of Charactor you got
        TextGacha1 = findViewById(R.id.TextGachaSlot1);
        TextGacha2 = findViewById(R.id.TextGachaSlot2);
        TextGacha3 = findViewById(R.id.TextGachaSlot3);
        TextGacha4 = findViewById(R.id.TextGachaSlot4);
        TextGacha5 = findViewById(R.id.TextGachaSlot5);
        TextGacha6 = findViewById(R.id.TextGachaSlot6);
        TextGacha7 = findViewById(R.id.TextGachaSlot7);
        TextGacha8 = findViewById(R.id.TextGachaSlot8);
        TextGacha9 = findViewById(R.id.TextGachaSlot9);
        TextGacha10 = findViewById(R.id.TextGachaSlot10);

        //text for collect data
        MoneySpendShow = findViewById(R.id.MoneySpendText);
        PityRateShow = findViewById(R.id.PityRateText);
        RollCountShow = findViewById(R.id.RollCountText);
        No6StarRollStreakShow = findViewById(R.id.RollStreak_NoRateUpShow);
        text_show = findViewById(R.id.Test_text);
        Intent_Topup = findViewById(R.id.GotoTopup);

        BackToCurrent = findViewById(R.id.BackButton);


        //กลับไปหน้าล่าสุด
        BackToCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackPressed();
            }
        });




        //กดสุ่ม 10 ครั้ง ไปทำงาน method ที่ชื่อ Random_10TimeGacha

        ConvertToOrundum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ดึงค่า Orundum ที่มีอยู่
                int currentOrundum = Payment.getInt("DataSave_Orundum", 0);

                // แปลง Originium เป็น Orundum (1 Originium = 180 Orundum)
                int convertedOrundum = Originium * 180;

                Originium = 0;

                // เพิ่มค่าที่แปลงได้ลงในค่า Orundum ที่มีอยู่
                currentOrundum += convertedOrundum;

                // บันทึกค่า Orundum ลง SharedPreferences
                editor.putInt("DataSave_Orundum", currentOrundum);
                editor.apply(); // ใช้ apply() แทน commit() เพื่อบันทึกเป็นแบบไม่สะท้อน

                // บันทึกค่า Originium เป็น 0 ลง SharedPreferences
                editor.putInt("DataSave_Originium", Originium);
                editor.apply();

                // แสดงผล Orundum ที่แปลงและบันทึก
                OriginiumShow.setText(String.valueOf(0));
                OrundumShow.setText(String.valueOf(currentOrundum));

                // แสดง Text ใน OrundumShow
                // OrundumShow.setText("Your Text Here");
            }
        });

        // กดปุ่มเติมเงินเพื่อไปหน้าเติมเงิน

        Intent_Topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopup();
            }
        });

        //กดปุ่มสุ่มกาชา 10 ครั้ง
        Gacha_10Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentOrundum = Payment.getInt("DataSave_Orundum", 0);

                // เช็คว่า Orundum มีค่ามากกว่าหรือเท่ากับ 6000 หรือไม่
                if (currentOrundum >= 6000) {
                    // หัก Orundum ลง 6000
                    currentOrundum -= 6000;

                    // เรียกใช้เมท็อด Random_10TimeGacha
                    Random_10TimeGacha();

                    // บันทึกค่า Orundum ลง SharedPreferences
                    editor.putInt("DataSave_Orundum", currentOrundum);
                    editor.apply(); // ใช้ apply()

                    // แสดงค่า Orundum ใหม่
                    OrundumShow.setText(String.valueOf(currentOrundum));

                } else {
                    // แสดง Toast เงินไม่พอ
                    Toast.makeText(Banner_Typhon.this, "Not Enought Orundum", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //กดปุ่มสุ่มกาชา 11 ครั้ง
        Gacha_1Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentOrundum = Payment.getInt("DataSave_Orundum", 0);

                // เช็คว่า Orundum มีค่ามากกว่าหรือเท่ากับ 600 หรือไม่
                if (currentOrundum >= 600) {
                    // หัก Orundum ลง 600
                    currentOrundum -= 600;

                    // เรียกใช้เมท็อด Random_1TimeGacha
                    Random_1TimeGacha();

                    // บันทึกค่า Orundum ลง SharedPreferences
                    editor.putInt("DataSave_Orundum", currentOrundum);
                    editor.apply(); // ใช้ apply()

                    // แสดงค่า Orundum ใหม่
                    OrundumShow.setText(String.valueOf(currentOrundum));

                } else {
                    // แสดง Toast เงินไม่พอ
                    Toast.makeText(Banner_Typhon.this, "Not Enought Orundum", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Originium = Payment.getInt("DataSave_Originium", 0);



        // โหลดค่า Orundum จาก SharedPreferences
        SharedPreferences payment = getSharedPreferences("PaymentData", Context.MODE_PRIVATE);
        Orundum = payment.getInt("DataSave_Orundum", 0);

        // ตรวจสอบค่า Orundum และนำไปใช้ตามต้องการ
        // ...

        // แสดงค่า Orundum ที่โหลดได้

        OrundumShow.setText(String.valueOf(Orundum));

        OriginiumShow.setText(String.valueOf(Originium));

    }


    int totalRolls = 0;
    double totalmoney = 0;



    int PityRateCount = 0;

    //อัตราที่จะได้ตัวละคร
    double SIX_STAR_RATE = 0.02; //  4% 1-4
    double FIVE_STAR_RATE = 0.08; // 8% 5-12
    double FOUR_STAR_RATE = 0.5; // 0.5% 13-62
    double THREE_STAR_RATE = 0.4; // 40% 63 - 100

    boolean NoRateUp6Star = false;

    int RollStreakNoRateUp = 0;



    //สุ่มเลข 0-99 และ บวกเพิ่มอีก 1  เป็น 1-100 = 1%-100%
    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    //สุ่ม 10 ครั้ง
    private void Random_10TimeGacha() {






        totalRolls += 10; // เพิ่มจำนวนการสุ่ม เมื่อกดสุ่ม 10 ครั้ง
        totalmoney += 640.67;

        DecimalFormat df = new DecimalFormat("#,##0.00"); // สร้าง DecimalFormat สำหรับรูปแบบทศนิยม 2 ตำแหน่ง
        String formattedTotalMoney = df.format(totalmoney); // ทำการฟอร์แมท totalmoney ใหม่

        RollCountShow.setText("Total Rolls: " + totalRolls); // แสดงจำนวนรอบใน RollCountShow
        MoneySpendShow.setText(formattedTotalMoney + " Baht"); // แสดงจำนวนรอบใน RollCountShow




        //rate up
        String[] SixsStarRateup_Arknight = {"Typhon"};
        String[] FivesStarRateup_Arknight = {"Santalla","Proviso"};


        //Limited Event Out rate
        String[] SixsStarLimitedOutRateup_Arknight = {"Dorothy"};

        //common rate

        String[] SixsStar_Arknight = {"Weedy", "Thorns", "Eunectes", "Surtr", "Blemishine", "Mudrock",
                "Mountain", "Archetto", "Saga", "Passenger", "Kal'tsit", "Carnelian", "Pallas", "Mizuki",
                "Saileach", "Fartooth", "Flametail", "Gnosis", "Lee", "Goldenglow", "Fiammetta", "Horn",
                "Irene", "Ebenholz", "Dorothy", "Pozemka", "Mlynar", "Stainless", "Penance",
                "Reed the Flame", "Lin", "Qiubai", "Ines", "Ho'olheyak", "Executor the Ex Foedere",
                "Swire the Elegant Wit"};

        String[] FivesStar_Arknight = {"Elysium", "Andreana", "Flint", "April", "Aosta", "Whisperain",
                "Kafka", "Iris", "Mr. Nothing", "Toddifons", "Akafuyu", "Kirara", "La Pluma", "Mulberry",
                "Ashlock", "Corroserum", "Aurora", "Blacknight", "Quercus", "Kazemaru","Windflit",
                "Hibiscus the Purifier", "Cantabile", "Proviso", "Paprika",
                "Lunacub", "Harmonie", "Firewhistle", "Wind Chimes", "Cement", "Melanite", "Spuria", "Poncirus"};

        String[] FoursStar_Arknight = {"Arene","Aciddrop","Ambriel","Beanstalk","Beehunter","Bubble","Chestnut","Click","Conviction",
                "Courier","Cuora","Cutter","Deepcolor","Dobermann","Earthspirit","Estelle","Ethan","Frostleaf","Gavial"
                ,"Gitano","Gravel","Greyy","Gummy","Haze","Humus","Indigo","Jackie","Jaye","Jessica"
                ,"Matoimaru","Matterhorn","May","Meteor","Mousse","Myrrh","Myrtle","Perfumer","Pinecone","Podenco"
                ,"Pudding","Purestream","Quartz","Roberta","Rope","Scavenger","Shaw","Shirayuki","Sussurro"
                ,"Totter","Utage","Vermeil","Vigna"};
        String[] ThreeStar_Arknight = {"Adnachiel", "Ansel", "Beagle", "Cardigan",
                "Catapult", "Fang", "Hibiscus", "Kroos", "Lava", "Melantha", "Midnight",
                "Orchid", "Plume", "Popukar", "Spot", "Steward", "Vanila"};



        for (int i = 1; i <= 10; i++) {

            //เช็ค pity Rate


            if (PityRateCount >= 50) {
                SIX_STAR_RATE += 0.02;
                FOUR_STAR_RATE -= 0.01;

                //ดันเรท 4 ดาวลง 1%
                //เนื่องจากสุ่มได้ 1 ถึง 100 ทำให้ ลดขั้น 3 ดาว  ลงไป 1% ในตัวด้วย

            }
            else{
                SIX_STAR_RATE = 0.02;
                FOUR_STAR_RATE = 0.5;
            }



            // เก็บว่าครบ 150 แล้วได้หน้าตู้หรือยัง
            RollStreakNoRateUp += 1;










            //สุ่มเลขกาชา 1 ถึง 100 ใน Method getRandomInt
            int randomValue = getRandomInt(1, 100);

            String result = "";



            if (randomValue <= SIX_STAR_RATE * 100) {
                // สุ่มตัวละคร 6 ดาว

                // ถ้าได้ 6 ดาว รีเซ็ท PityRate

                //สุ่ม Rate up 50% ตัวละคร 6 ดาว สุ่มเลข 1 ถึง 2
                Random randomRateup6Star = new Random();

                int GetRandomRateup6Star = randomRateup6Star.nextInt(2) + 1;

                PityRateCount = 0;
                //ถ้า ผ่านไป 150 โรลและยังไม่ได้ Rate up
                if ((NoRateUp6Star  && RollStreakNoRateUp >= 150) || (RollStreakNoRateUp >= 150)){
                    //ได้กรันตรีหน้าตู้
                    result = getRandomCharacter(SixsStarRateup_Arknight);
                    changeTextColorFor6Star(i);
                    NoRateUp6Star = false;
                    RollStreakNoRateUp = 0;



                } else if (GetRandomRateup6Star == 1 ) { //ไม่ได้เรทหน้าตู้
                    result = getRandomCharacter(SixsStar_Arknight);
                    changeTextColorFor6Star(i);
                    NoRateUp6Star = true;


                } else { //ได้เรทหน้าตู้
                    result = getRandomCharacter(SixsStarRateup_Arknight);
                    changeTextColorFor6Star(i);
                    NoRateUp6Star = false;

                    RollStreakNoRateUp = 0;

                }


            } else if (randomValue <= (SIX_STAR_RATE + FIVE_STAR_RATE) * 100) { //5 - 12
                // สุ่มตัวละคร 5 ดาว
                //สุ่ม Rate up 50% ตัวละคร 5 ดาว สุ่มเลข 1 ถึง 2
                Random randomRateup5Star = new Random();
                int GetRandomRateup5Star = randomRateup5Star.nextInt(2) + 1;

                if (GetRandomRateup5Star == 1) {
                    result = getRandomCharacter(FivesStar_Arknight);
                    changeTextColorFor5Star(i);
                } else {
                    result = getRandomCharacter(FivesStarRateup_Arknight);
                    changeTextColorFor5Star(i);
                }
                PityRateCount += 1;


            } else if (randomValue <= (SIX_STAR_RATE + FIVE_STAR_RATE + FOUR_STAR_RATE) * 100) { //13 -
                // สุ่มตัวละคร 4 ดาว
                result = getRandomCharacter(FoursStar_Arknight);
                changeTextColorFor4Star(i);
                PityRateCount += 1;
            } else {
                // สุ่มตัวละคร 3 ดาว
                result = getRandomCharacter(ThreeStar_Arknight);
                changeTextColorFor3Star(i);
                PityRateCount += 1;
            }



            // แสดงผลลัพธ์ใน TextView
            displayResult(i, result);
            // แสดงผลลัพธ์ใน ImageView
            displayImage(i, result);
        }


        text_show.setText(String.valueOf(PityRateCount + " / 50 Pity Rate \n increase 2 %"));
        No6StarRollStreakShow.setText(String.valueOf(RollStreakNoRateUp + " Rolls"));
        PityRateShow.setText(String.valueOf(Math.round(SIX_STAR_RATE * 100)) + "% Chance");

    }


    //สุ่ม 1 ครั้ง
    private void Random_1TimeGacha() {
        totalRolls += 1; // เพิ่มจำนวน  1 การสุ่ม เมื่อกดสุ่ม 1 ครั้ง
        totalmoney += 64.06;

        PityRateShow.setText(String.valueOf(SIX_STAR_RATE * 100));

        DecimalFormat df = new DecimalFormat("#,##0.00"); // สร้าง DecimalFormat สำหรับรูปแบบทศนิยม 2 ตำแหน่ง
        String formattedTotalMoney = df.format(totalmoney); // ทำการฟอร์แมท totalmoney ใหม่





        RollCountShow.setText("Total Rolls: " + totalRolls); // แสดงจำนวนรอบใน RollCountShow
        MoneySpendShow.setText(formattedTotalMoney + " Baht");
        //rate up
        String[] SixsStarRateup_Arknight = {"Typhon"};
        String[] FivesStarRateup_Arknight = {"Santalla","Proviso"};

        //Limited Event Out rate
        String[] SixsStarLimitedOutRate_Arknight = {"Dorothy"};


        //common rate

        String[] SixsStar_Arknight = {"Weedy", "Thorns", "Eunectes", "Surtr", "Blemishine", "Mudrock",
                "Mountain", "Archetto", "Saga", "Passenger", "Kal'tsit", "Carnelian", "Pallas", "Mizuki",
                "Saileach", "Fartooth", "Flametail", "Gnosis", "Lee", "Goldenglow", "Fiammetta", "Horn",
                "Irene", "Ebenholz", "Dorothy", "Pozemka", "Młynar", "Stainless", "Penance",
                "Reed the Flame Shadow", "Lin", "Qiubai", "Ines", "Ho'olheyak", "Executor the Ex Foedere",
                "Swire the Elegant Wit"};
        String[] FivesStar_Arknight = {"Elysium", "Andreana", "Flint", "April", "Aosta", "Whisperain",
                "Kafka", "Iris", "Mr. Nothing", "Toddifons", "Akafuyu", "Kirara", "La Pluma", "Mulberry",
                "Ashlock", "Corroserum", "Aurora", "Blacknight", "Quercus", "Kazemaru","Windflit",
                "Hibiscus the Purifier", "Cantabile", "Proviso", "Paprika",
                "Lunacub", "Harmonie", "Firewhistle", "Wind Chimes", "Cement", "Melanite", "Spuria", "Poncirus"};

        String[] FoursStar_Arknight = {"Arene","Aciddrop","Ambriel","Beanstalk","Beehunter","Bubble","Chestnut","Click","Conviction",
                "Courier","Cuora","Cutter","Deepcolor","Dobermann","Earthspirit","Estelle","Ethan","Frostleaf","Gavial"
                ,"Gitano","Gravel","Greyy","Gummy","Haze","Humus","Indigo","Jackie","Jaye","Jessica"
                ,"Matoimaru","Matterhorn","May","Meteor","Mousse","Myrrh","Myrtle","Perfumer","Pinecone","Podenco"
                ,"Pudding","Purestream","Quartz","Roberta","Rope","Scavenger","Shaw","Shirayuki","Sussurro"
                ,"Totter","Utage","Vermeil","Vigna"};
        String[] ThreeStar_Arknight = {"Adnachiel", "Ansel", "Beagle", "Cardigan",
                "Catapult", "Fang", "Hibiscus", "Kroos", "Lava", "Melantha", "Midnight",
                "Orchid", "Plume", "Popukar", "Spot", "Steward", "Vanila"};



        for (int i = 1; i <= 10; i++) {




            if ( i == 1 ) {


                if (PityRateCount >= 50) {
                    SIX_STAR_RATE += 0.02;
                    FOUR_STAR_RATE -= 0.01;

                    //ดันเรท 4 ดาวลง 1%
                    //เนื่องจากสุ่มได้ 1 ถึง 100 ทำให้ ลดขั้น 3 ดาว  ลงไป 1% ในตัวด้วย
                }
                else{
                    SIX_STAR_RATE = 0.02;
                    FOUR_STAR_RATE = 0.5;
                }

                // เก็บว่าครบ 150 แล้วได้หน้าตู้หรือยัง
                RollStreakNoRateUp += 1;


                //สุ่มเลขกาชา 1 ถึง 100
                int randomValue = getRandomInt(1, 100);

                String result = "";
                // อัตรา 2 %
                if (randomValue <= SIX_STAR_RATE * 100) {
                    // สุ่มตัวละคร 6 ดาว

                    // ถ้าได้ 6 ดาว รีเซ็ท PityRate


                    Random randomRateup6Star = new Random();
                    int GetRandomRateup6Star = randomRateup6Star.nextInt(2) + 1;
                    PityRateCount = 0;

                    //ถ้า ผ่านไป 150 โรลและยังไม่ได้ Rate up
                    if (NoRateUp6Star  && RollStreakNoRateUp >= 150){
                        //ได้กรันตรีหน้าตู้
                        result = getRandomCharacter(SixsStarRateup_Arknight);
                        changeTextColorFor6Star(1);
                        NoRateUp6Star = false;
                        RollStreakNoRateUp = 0;
                        break;

                    } else if (GetRandomRateup6Star == 1 ) { //ไม่ได้เรทหน้าตู้
                        result = getRandomCharacter(SixsStar_Arknight);
                        changeTextColorFor6Star(1);
                        NoRateUp6Star = true;


                    } else { //ได้เรทหน้าตู้
                        result = getRandomCharacter(SixsStarRateup_Arknight);
                        changeTextColorFor6Star(1);
                        NoRateUp6Star = false;
                        RollStreakNoRateUp = 0;


                    }

                } else if (randomValue <= (SIX_STAR_RATE + FIVE_STAR_RATE) * 100) { //5 - 12
                    // สุ่มตัวละคร 5 ดาว
                    //สุ่ม Rate up 50% ตัวละคร 5 ดาว สุ่มเลข 1 ถึง 2
                    Random randomRateup5Star = new Random();
                    int GetRandomRateup5Star = randomRateup5Star.nextInt(2) + 1;

                    if (GetRandomRateup5Star == 1) {
                        result = getRandomCharacter(FivesStar_Arknight);
                        changeTextColorFor5Star(1);
                    } else {
                        result = getRandomCharacter(FivesStarRateup_Arknight);
                        changeTextColorFor5Star(1);
                    }
                    PityRateCount += 1;

                } else if (randomValue <= (SIX_STAR_RATE + FIVE_STAR_RATE + FOUR_STAR_RATE) * 100) { //13 -
                    // สุ่มตัวละคร 4 ดาว
                    result = getRandomCharacter(FoursStar_Arknight);
                    changeTextColorFor4Star(1);
                    PityRateCount += 1;
                } else {
                    // สุ่มตัวละคร 3 ดาว
                    result = getRandomCharacter(ThreeStar_Arknight);
                    changeTextColorFor3Star(1);
                    PityRateCount += 1;
                }


                // แสดงผลลัพธ์ใน TextView
                displayResult(1, result);
                // แสดงผลลัพธ์ใน ImageView
                displayImage(1, result);

            } else {
                //โยนค่าว่างคืนไปสำหรับตัวที่ 2 ถึง 10
                String result = "";
                displayResult(i, result);
                // แสดงผลลัพธ์ใน ImageView
                displayImage(i, result);
            }
        }
        text_show.setText(String.valueOf(PityRateCount + " / 50 Pity Rate \n increase 2 %"));
        No6StarRollStreakShow.setText(String.valueOf(RollStreakNoRateUp + " Rolls"));
        PityRateShow.setText(String.valueOf(Math.round(SIX_STAR_RATE * 100)) + "% Chance");

    }

    //สุ่ม เลข index กาชา ใน length
    private String getRandomCharacter(String[] characterArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(characterArray.length);
        return characterArray[randomIndex];
    }


    //แสดงชื่อ Operator
    private void displayResult(int index, String character) {
        String textGachaId = "TextGachaSlot" + index;
        int textResourceId = getResources().getIdentifier(textGachaId, "id", getPackageName());

        TextView textView = findViewById(textResourceId);
        textView.setText(character);
    }

    //แสดงภาพ Operator
    private void displayImage(int index, String character) {
        String imageName = formatCharacterName(character).toLowerCase();
        String imageId = "GachaPicSlot" + index;

        // ค้นหารูปภาพที่อยู่ใน drawable
        int imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());

        ImageView imageView = findViewById(getResources().getIdentifier(imageId, "id", getPackageName()));
        imageView.setImageResource(imageResourceId);
    }

    //แปลงชื่อตัวละคร โดยการลบ Space Special char เพื่อนำไปเทียบกับรชื่อูปภาพที่ตัวอักษรเล็ก และ return กลับ
    private String formatCharacterName(String characterName) {
        // ลบช่องว่างและตัวอักษรพิเศษ เพื่อจับคู่กับรูปภาพ
        return characterName.replaceAll("[\\s\\W]+", "");
    }

    //เอาไว้เปลี่ยนสี TEXT 6 ดาว
    private void changeTextColorFor6Star(int index) {
        String textGachaId = "TextGachaSlot" + index;
        int textResourceId = getResources().getIdentifier(textGachaId, "id", getPackageName());

        TextView textView = findViewById(textResourceId);
        // เปลี่ยนสีของ TextView เป็นสีแดง
        textView.setTextColor(Color.parseColor("#FF0000")); // เลือกสีที่ต้องการ
    }


    //เอาไว้เปลี่ยนสี TEXT 5 ดาว
    private void changeTextColorFor5Star(int index) {
        String textGachaId = "TextGachaSlot" + index;
        int textResourceId = getResources().getIdentifier(textGachaId, "id", getPackageName());

        TextView textView = findViewById(textResourceId);
        // เปลี่ยนสีของ TextView เป็นสีทอง
        textView.setTextColor(Color.parseColor("#FFD700")); // เลือกสีที่ต้องการ
    }


    //เอาไว้เปลี่ยนสี TEXT 4 ดาว
    private void changeTextColorFor4Star(int index) {
        String textGachaId = "TextGachaSlot" + index;
        int textResourceId = getResources().getIdentifier(textGachaId, "id", getPackageName());

        TextView textView = findViewById(textResourceId);
        // เปลี่ยนสีของ TextView เป็นสีม่วง
        textView.setTextColor(Color.parseColor("#D993FF")); // เลือกสีที่ต้องการ
    }

    //เอาไว้เปลี่ยนสี TEXT 3 ดาว
    private void changeTextColorFor3Star(int index) {
        String textGachaId = "TextGachaSlot" + index;
        int textResourceId = getResources().getIdentifier(textGachaId, "id", getPackageName());

        TextView textView = findViewById(textResourceId);
        // เปลี่ยนสีของ TextView เป็นสีขาว
        textView.setTextColor(Color.parseColor("#FFFFFF")); // เลือกสีที่ต้องการ
    }


    public void BackPressed() {
        Intent GotoPageBanner = new Intent(getApplicationContext(), Banner_page.class);
        startActivity(GotoPageBanner);
    }


// ส่วนของหน้า ที่ต้องการไปเติมเงิน

    //ส่งค่า เลข 1 ไป เพื่อมห้หน้า Topup ตรวจสอบว่ามีคำขอมาจากหน้าอื่นๆ
    private static final int REQUEST_TOPUP = 1;
    public void openTopup() {
        Intent intent = new Intent(this, Topup.class);
        startActivityForResult(intent, REQUEST_TOPUP);
    }

    // ส่งค่าหน้าที่ขอเข้าไป Topup เพื่อกลับมาหน้าเดิม เมื่อกดปุ่ม Back และนำข้อมูลจากหน้า Topup ที่ได้รับมา
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_TOPUP && resultCode == RESULT_OK) {
            // ดึงข้อมูลที่คืนมาจากหน้า Topup
            Originium = data.getIntExtra("originium_key", 0);
            Orundum = data.getIntExtra("orundum_key", 0);

            // ทำสิ่งที่คุณต้องการกับข้อมูลที่ได้รับ
            // ตัวอย่าง: อัปเดตข้อมูลในหน้า Banner_Typhon
            OrundumShow.setText(String.valueOf(Orundum));

            OriginiumShow.setText(String.valueOf(Originium));
        }
    }

}
