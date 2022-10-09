package com.example.hangman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button minus, plus, tipp;
    private TextView alphabet, first, second, third, fourth, fifth;
    private ImageView man;
    private AlertDialog.Builder builderJatekVege;
    private int index, elet, chars;
    private char c, one, two, three, four, five;
    private String abc, chos;
    ArrayList<String> word = new ArrayList<String>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index > 25){
                    index = 0;
                }
                c = abc.charAt(index);
                alphabet.setText(String.valueOf(c));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index < 0){
                    index = 25;
                }
                c = abc.charAt(index);
                alphabet.setText(String.valueOf(c));

            }
        });
        tipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (c == chos.charAt(0)){
                        first.setText(String.valueOf(c));
                        chars--;
                    }else if (c == chos.charAt(1)){
                        second.setText(String.valueOf(c));
                        chars--;
                    }else if (c == chos.charAt(2)){
                        third.setText(String.valueOf(c));
                        chars--;
                    }else if (c == chos.charAt(3)){
                        fourth.setText(String.valueOf(c));
                        chars--;
                    }else if (c == chos.charAt(4)){
                        fifth.setText(String.valueOf(c));
                        chars--;
                    }else {
                        eletLevon();
                    }
                    if (chars == 0){
                        builderJatekVege.setTitle("You Won!").setMessage("New game?").create();
                        builderJatekVege.show();
                    }
                }
        });







    }
    private void ujJatek() {
        first.setText(" _ ");
        second.setText(" _ ");
        fourth.setText(" _ ");
        third.setText(" _ ");
        fifth.setText(" _ ");
        index = 0;
        Random rnd = new Random();
        int chosen = rnd.nextInt(4);
        if (chosen == 0){
            chos = word.get(0);
        }else if (chosen == 1){
            chos = word.get(1);
        }else if (chosen == 2){
            chos = word.get(2);
        }else if (chosen == 3){
            chos = word.get(3);
        }
        
        elet = 13;
        man.setImageResource(R.drawable.akasztofa00);
    }
    private void eletLevon(){
        elet--;
        if (elet == 12){
            man.setImageResource(R.drawable.akasztofa01);
        }else if(elet == 11){
            man.setImageResource(R.drawable.akasztofa02);
        }else if(elet == 10){
            man.setImageResource(R.drawable.akasztofa03);
        }else if(elet == 9){
            man.setImageResource(R.drawable.akasztofa04);
        }else if(elet == 8){
            man.setImageResource(R.drawable.akasztofa05);
        }else if(elet == 7){
            man.setImageResource(R.drawable.akasztofa06);
        }else if(elet == 6){
            man.setImageResource(R.drawable.akasztofa07);
        }else if(elet == 5){
            man.setImageResource(R.drawable.akasztofa08);
        }else if(elet == 4){
            man.setImageResource(R.drawable.akasztofa09);
        }else if(elet == 3){
            man.setImageResource(R.drawable.akasztofa10);
        }else if(elet == 2){
            man.setImageResource(R.drawable.akasztofa11);
        }else if(elet == 1){
            man.setImageResource(R.drawable.akasztofa12);
        }else if(elet == 0){
            man.setImageResource(R.drawable.akasztofa13);
            builderJatekVege.setTitle("Game over!").setMessage("New game?").create();
            builderJatekVege.show();
        }
    }




    private void init() {
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        tipp = findViewById(R.id.tipp);
        alphabet = findViewById(R.id.alphabet);
        man = findViewById(R.id.man);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);

        chars = 5;
        word.add("SOUND");
        word.add("WATER");
        word.add("JUMPS");
        word.add("GHOST");
        index = 0;
        abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        c = abc.charAt(index);
        elet = 13;
        builderJatekVege = new AlertDialog.Builder(MainActivity.this);
        builderJatekVege.setCancelable(false)
                .setTitle("Game Over")
                .setMessage("New ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                });

        Random rnd = new Random();
        int chosen = rnd.nextInt(4);
        if (chosen == 0){
            chos = word.get(0);
        }else if (chosen == 1){
            chos = word.get(1);
        }else if (chosen == 2){
            chos = word.get(2);
        }else if (chosen == 3){
            chos = word.get(3);
        }
    }


}