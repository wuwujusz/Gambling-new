package com.example.gambling;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView spin1;
    private TextView spin2;
    private TextView spin3;
    private TextView spin4;
    private TextView spin5;

    private Button button_spin;
    private Button button_reset;

    private TextView title;

    private TextView spin_result;
    private TextView game_result;
    int game_result2 = 0;

    private TextView spin_number;

    private Random random = new Random();
    int licznik = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spin1 = findViewById(R.id.rzut1);
        spin2 = findViewById(R.id.rzut2);
        spin3 = findViewById(R.id.rzut3);
        spin4 = findViewById(R.id.rzut4);
        spin5 = findViewById(R.id.rzut5);

        game_result = findViewById(R.id.wynik_gry);
        spin_result = findViewById(R.id.wynik_losowania);

        button_spin = findViewById(R.id.button_rzut);
        button_reset = findViewById(R.id.button_reset);

        spin_number = findViewById(R.id.liczba_rzutow);

        title = findViewById(R.id.tytul);


        button_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int space1 = random.nextInt(6) + 1;
                spin1.setText(Integer.toString(space1));


                int space2 = random.nextInt(6) + 1;
                spin2.setText(Integer.toString(space2));


                int space3 = random.nextInt(6) + 1;
                spin3.setText(Integer.toString(space3));


                int space4 = random.nextInt(6) + 1;
                spin4.setText(Integer.toString(space4));


                int space5 = random.nextInt(6) + 1;
                spin5.setText(Integer.toString(space5));


                int[] numbers = {space1, space2, space3, space4, space5};
                int result = 0;
                int[] count = new int[6];


                for (int i = 0; i < numbers.length; i++) {
                    count[numbers[i] - 1]++;
                }


                for (int i = 0; i < count.length; i++) {
                    if (count[i] > 1) {
                        result += (i + 1) * count[i];
                    }
                }


                spin_result.setText("Wynik tego losowania: " + result);
                licznik++;
                spin_number.setText("Liczba rzutów: " + licznik);
                updateScore(result);
            }
        });


        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spin1.setText("?");
                spin2.setText("?");
                spin3.setText("?");
                spin4.setText("?");
                spin5.setText("?");

                game_result2 = 0;
                licznik = 0;

                game_result.setText("Wynik gry: " + game_result2);
                spin_number.setText("Liczba rzutów: " + licznik);
            }
        });
    }


    private void updateScore(int wynik) {

        game_result2 +=wynik;
        game_result.setText("Wynik gry: " + game_result2);
    }
}
