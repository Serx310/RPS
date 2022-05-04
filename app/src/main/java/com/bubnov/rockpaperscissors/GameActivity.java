package com.bubnov.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bubnov.rockpaperscissors.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button btnRock, btnScissors, btnPaper;
    TextView txtScore;
    ImageView imgBotChoice, imgUserChoice;
    int YourScore, ComputerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnRock = (Button) findViewById(R.id.btnRock);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnScissors = (Button) findViewById(R.id.btnScissors);
        imgBotChoice = (ImageView) findViewById(R.id.imgBotChoice);
        imgUserChoice = (ImageView) findViewById(R.id.imgUserChoice);

        txtScore = (TextView) findViewById(R.id.txtScore);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUserChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(GameActivity.this, message, Toast.LENGTH_LONG).show();
                txtScore.setText("You " + Integer.toString(YourScore) + " - Computer " + Integer.toString(ComputerScore));
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUserChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(GameActivity.this, message, Toast.LENGTH_LONG).show();
                txtScore.setText("You " + Integer.toString(YourScore) + " - Computer " + Integer.toString(ComputerScore));
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUserChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(GameActivity.this, message, Toast.LENGTH_LONG).show();
                txtScore.setText("You " + Integer.toString(YourScore) + " - Computer " + Integer.toString(ComputerScore));
            }
        });
    }

    public String play_turn( String your_choice ){
        String computer_choice = "";
        Random r = new Random();
        int computerChoiceNumber = r.nextInt(3);
        if(computerChoiceNumber == 0){
            computer_choice = "rock";
            imgBotChoice.setImageResource(R.drawable.rock);
        }else if(computerChoiceNumber == 1){
            computer_choice = "paper";
            imgBotChoice.setImageResource(R.drawable.paper);
        }else{
            computer_choice = "scissors";
            imgBotChoice.setImageResource(R.drawable.scissors);
        }

        if(computer_choice.equals(your_choice)){
            return "Draw";
        }else if(your_choice.equals("rock") && computer_choice.equals("scissors")){
            YourScore++;
            return "Rock crushes scissors. You win!";
        }else if(your_choice.equals("scissors") && computer_choice.equals("paper")){
            YourScore++;
            return "Scissors cut paper. You win!";
        }else if(your_choice.equals("paper") && computer_choice.equals("rock")){
            YourScore++;
            return "Paper hides rock. You win!";
        }else if(your_choice.equals("rock") && computer_choice.equals("paper")){
            ComputerScore++;
            return "Paper hides rock. You lose!";
        }else if(your_choice.equals("scissors") && computer_choice.equals("rock")){
            ComputerScore++;
            return "Rock crushes scissors. You lose!";
        }else if(your_choice.equals("paper") && computer_choice.equals("scissors")){
            ComputerScore++;
            return "Scissors cut paper. You lose!";
        }
        else return "Not sure.";
    }
}