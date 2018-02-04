package com.example.android.gameoftrones;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Recap extends AppCompatActivity {

    String testoRecap = "";
    TextView recap;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        //Finds the TextView

        recap = findViewById(R.id.recapText);

        //Get in the integer in the previous activity
        Intent intent = getIntent();
        int correct = intent.getIntExtra("correct", 0);
        username = intent.getExtras().getString("username");

        //Set the text when the activity is created and the stars evaluation
        if ( correct == 0) {
            testoRecap = username + " " + getString(R.string.score) + " " +  correct + getString(R.string.zeroScore);
        } else if ( correct >= 1 &&  correct <= 2) {
            testoRecap = username + " " + getString(R.string.score) + " " +  correct + getString(R.string.lowScore);
        } else if ( correct > 3 &&  correct <= 4) {
            testoRecap = username + " " + getString(R.string.score) + " " +  correct + getString(R.string.midScore);
        } else if ( correct == 5) {
            testoRecap = username + " " + getString(R.string.score) + " " +  correct + getString(R.string.highScore);
        }

        //Set the text into the testview of the recap
        recap.setText(testoRecap);

    }

    /**
     * When the button is clicked it lounces an Intent that opens gmail (or only an email app) and allows the user to send the recap content via mail
     *
     * @param view
     */
    public void Recapmail (View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.results));
        intent.putExtra(Intent.EXTRA_TEXT, testoRecap);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * This method ends the app
     *
     * @param view
     */
    public void exit(View view) {

        finish();
        moveTaskToBack(true);
    }
}
