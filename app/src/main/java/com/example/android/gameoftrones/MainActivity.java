    package com.example.android.gameoftrones;

    import android.app.ActivityOptions;
    import android.content.Context;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Build;
    import android.support.annotation.RequiresApi;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.view.WindowManager;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        int correct = 0;
        int nothingChecked = 0; //see if the user gives answers
        RadioGroup family;
        RadioGroup murder;
        RadioGroup khown;
        RadioGroup show;
        RadioGroup reek;
        String username;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Prevent the keyboard to pop up automatically

            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

            family = findViewById(R.id.family);
            murder = findViewById(R.id.murder);
            khown = findViewById(R.id.known);
            show = findViewById(R.id.snow);
            reek = findViewById(R.id.reek);

            Intent intent = getIntent();
            username = intent.getExtras().getString("username");
        }
    public void  rezultati (View view) {

        /**
         * The int checked has the id of checked RadioButton
         */
        int checkedRadio = family.getCheckedRadioButtonId();

        RadioButton correctt = findViewById(R.id.corrFamily);
        RadioButton radio = findViewById(checkedRadio);

        if (family.getCheckedRadioButtonId() == -1) {

        } else {

            if (radio == correctt) {
                correctt.setTextColor(Color.GREEN);
                correct++;
            } else {

                radio.setTextColor(Color.RED);
            }

            nothingChecked++;
        }
        /**
         * The int checked has the id of checked RadioButton
         */
       checkedRadio = murder.getCheckedRadioButtonId();

        correctt = findViewById(R.id.corrMurder);
        radio = findViewById(checkedRadio);

        if (murder.getCheckedRadioButtonId() == -1) {

        } else {

            if (radio == correctt) {
                correctt.setTextColor(Color.GREEN);
                correct++;
            } else {

                radio.setTextColor(Color.RED);
            }

            nothingChecked++;
        }
        /**
         * The int checked has the id of checked RadioButton
         */
        checkedRadio = khown.getCheckedRadioButtonId();

        correctt = findViewById(R.id.corrKnow);
        radio = findViewById(checkedRadio);

        if (khown.getCheckedRadioButtonId() == -1) {

        } else {

            if (radio == correctt) {
                correctt.setTextColor(Color.GREEN);
                correct++;
            } else {

                radio.setTextColor(Color.RED);
            }

            nothingChecked++;
        }

        /**
         * The int checked has the id of checked RadioButton
         */
        checkedRadio = show.getCheckedRadioButtonId();

        correctt = findViewById(R.id.corrSnow);
        radio = findViewById(checkedRadio);

        if (show.getCheckedRadioButtonId() == -1) {

        } else {

            if (radio == correctt) {
                correctt.setTextColor(Color.GREEN);
                correct++;
            } else {

                radio.setTextColor(Color.RED);
            }

            nothingChecked++;
        }
        /**
         * The int checked has the id of checked RadioButton
         */
        checkedRadio = reek.getCheckedRadioButtonId();

        correctt = findViewById(R.id.corrReek);
        radio = findViewById(checkedRadio);

        if (reek.getCheckedRadioButtonId() == -1) {

        } else {

            if (radio == correctt) {
                correctt.setTextColor(Color.GREEN);
                correct++;
            } else {

                radio.setTextColor(Color.RED);
            }

            nothingChecked++;
        }

        if (nothingChecked == 0) {
            //Make a LONG Toast notification if no answer is present
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.ToastMainNoAnswer);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {

            //Make a LONG Toast notification if at least one answer is given
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.ToastMainComplete);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void Score (View view) {

            //Launches the Recap activity
            Intent i = new Intent(MainActivity.this, Recap.class);
            i.putExtra("correct", correct);
            i.putExtra("username", username);

            ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view,
                    0,
                    0,
                    view.getWidth(),
                    view.getHeight());
            startActivity(i, options.toBundle());
        }
    }
