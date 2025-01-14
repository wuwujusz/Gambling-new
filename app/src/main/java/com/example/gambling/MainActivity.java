
package com.example.gambling;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView[] diceViews = new ImageView[5];
    private int[] pictures = {R.drawable.em, R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    private TextView dice1, dice2, dice3, dice4, dice5;
    private int[] DiceResults = new int[5] ;
    private Button button_rzut;
    private Button button_reset;
    private TextView rzut1;
    private TextView rzut2;
    private TextView rzut3;
    private TextView rzut4;
    private TextView rzut5;
    private TextView tytul;
    private TextView wynik_losowania;
    private TextView wynik_gry;
    private TextView liczba_rzutow;
    private Random ra = new Random();
    int wynik_los = 0;
    int wynik_Gry = 0;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceViews[0] = findViewById(R.id.dice1);
        diceViews[1] = findViewById(R.id.dice2);
        diceViews[2] = findViewById(R.id.dice3);
        diceViews[3] = findViewById(R.id.dice4);
        diceViews[4] = findViewById(R.id.dice5);
        rzut1 = findViewById(R.id.rzut1);
        rzut2 = findViewById(R.id.rzut2);
        rzut3 = findViewById(R.id.rzut3);
        rzut4 = findViewById(R.id.rzut4);
        rzut5 = findViewById(R.id.rzut5);
        tytul = findViewById(R.id.tytul);
        wynik_gry = findViewById(R.id.wynik_gry);
        wynik_losowania = findViewById(R.id.wynik_losowania);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);
        button_rzut = findViewById(R.id.button_rzut);
        button_reset = findViewById(R.id.button_reset);

        button_rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<5; i++){
                    DiceResults[i] = ra.nextInt(6) + 1;
                    diceViews[i].setImageResource(pictures[DiceResults[i]]);
                }

                // Ustawianie wartości wyrzuconych liczb w odpowiednich polach tekstowych
                rzut1.setText(String.valueOf(DiceResults[0]));
                rzut2.setText(String.valueOf(DiceResults[1]));
                rzut3.setText(String.valueOf(DiceResults[2]));
                rzut4.setText(String.valueOf(DiceResults[3]));
                rzut5.setText(String.valueOf(DiceResults[4]));


//                int[] liczby = {rad1, rad2, rad3, rad4, rad5};
                int wynik = 0;
                int[] count = new int[6]; //tablica przechowująca powtórzenia

                //tutaj leci przez liczby i dodaje powtórzenia do count
                for (int i = 0; i < DiceResults.length; i++) {
                    count[DiceResults[i] - 1]++;
                }

                // tutaj liczy wynik
                for (int i = 0; i < count.length; i++) {
                    if (count[i] > 1) {
                        wynik += (i + 1) * count[i];
                    }
                }

                wynik_losowania.setText("Wynik tego losowania: " + wynik);
                licznik++;
                liczba_rzutow.setText("Liczba rzutów: " + licznik);
                updateScore(wynik);

            }
        });

        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rzut1.setText("?");
                rzut2.setText("?");
                rzut3.setText("?");
                rzut4.setText("?");
                rzut5.setText("?");
                wynik_Gry = 0;
                licznik = 0;
                wynik_losowania.setText("Wynik tego losowania: " + wynik_los);
                wynik_gry.setText("Wynik gry: " + wynik_Gry);
                liczba_rzutow.setText("Liczba rzutów: " + licznik);


                // Ustawienie obrazków na blank_dice
                for (ImageView diceView : diceViews) {
                    diceView.setImageResource(R.drawable.em);
                }

            }
        });

    }

    private void updateScore(int wynik) {
        wynik_Gry +=wynik;
        wynik_gry.setText("Wynik gry: " + wynik_Gry);
    }
}
