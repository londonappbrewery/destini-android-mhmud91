package com.londonappbrewery.destini;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button redButton;
    Button blueButton;
    TextView storyText;
    int storyIndex=0;
    int[] storyArray = {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };
    int[] answer1Array = {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };
    int[] answer2Array = {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        redButton = findViewById(R.id.buttonTop);
        blueButton = findViewById(R.id.buttonBottom);
        storyText = findViewById(R.id.storyTextView);

        storyText.setText(storyArray[storyIndex]);
        redButton.setText(answer1Array[storyIndex]);
        blueButton.setText(answer2Array[storyIndex]);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(storyIndex == 0 || storyIndex == 1){
                    storyIndex = 2;
                }else if(storyIndex == 2){
                    storyIndex = 5;
                }
                updateStory();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(storyIndex == 0){
                    storyIndex = 1;
                }else if(storyIndex == 1){
                    storyIndex = 3;
                }else if(storyIndex == 2){
                    storyIndex = 4;
                }
                updateStory();
            }
        });

    }

    private void updateStory(){
        if(storyIndex <= 2){
            storyText.setText(storyArray[storyIndex]);
            redButton.setText(answer1Array[storyIndex]);
            blueButton.setText(answer2Array[storyIndex]);
        }else{
            storyText.setText(storyArray[storyIndex]);
            redButton.setVisibility(View.GONE);
            blueButton.setVisibility(View.GONE);
        }
    }
}
