package com.example.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView temp,toux,gout,gorge,diarhee,fatigue,soufle,cardiaque,diabtique,resp;
    int correctAnswers = 0;
    EditText name;

    RadioButton answer_1_question_1;
    RadioButton answer_1_question_2;
    RadioButton answer_1_question_3;
    RadioButton answer_1_question_4;
    RadioButton answer_1_question_5;
    RadioButton answer_1_question_6;
    RadioButton answer_1_question_7;
    RadioButton answer_1_question_8;
    RadioButton answer_1_question_9;
    RadioButton answer_1_question_10;
    Boolean Question1Correct;
    Boolean Question2Correct;
    Boolean Question3Correct;
    Boolean Question4Correct;
    Boolean Question5Correct;
    Boolean Question6Correct;
    Boolean Question7Correct;
    Boolean Question8Correct;
    Boolean Question9Correct;
    Boolean Question10Correct;
    String finalToast1;
    String finalToast2;
    String questionsWrong;
    String greeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        this.temp = (ImageView) this.findViewById(R.id.icon);
        this.temp.setImageResource(R.drawable.temp);
        this.toux = (ImageView) this.findViewById(R.id.icon2);
        this.toux.setImageResource(R.drawable.toux);
        this.gout = (ImageView) this.findViewById(R.id.icon3);
        this.gout.setImageResource(R.drawable.gout);
        this.gorge = (ImageView) this.findViewById(R.id.icon4);
        this.gorge.setImageResource(R.drawable.gorge);
        this.diarhee = (ImageView) this.findViewById(R.id.icon5);
        this.diarhee.setImageResource(R.drawable.diarhee);
        this.fatigue = (ImageView) this.findViewById(R.id.icon6);
        this.fatigue.setImageResource(R.drawable.fatigue);
        this.soufle = (ImageView) this.findViewById(R.id.icon7);
        this.soufle.setImageResource(R.drawable.soufle);
        this.cardiaque = (ImageView) this.findViewById(R.id.icon8);
        this.cardiaque.setImageResource(R.drawable.cardiaque);
        this.diabtique = (ImageView) this.findViewById(R.id.icon9);
        this.diabtique.setImageResource(R.drawable.diabtique);
        this.resp = (ImageView) this.findViewById(R.id.icon10);
        this.resp.setImageResource(R.drawable.resp);
        EditText name = (EditText) findViewById(R.id.name_input);
    }

    //Check which Radio Buttons have an have not been checked, and passes that information over to be calculated
    public void answerCheck(View view){


        name =(EditText) findViewById(R.id.name_input);
        String usersName = name.getText().toString();

        //Checks whether or not the correct Radio Buttons
        answer_1_question_1 = (RadioButton) findViewById(R.id.answer_1_question_1);
        boolean choiceForQuestion1 = answer_1_question_1.isChecked();

        answer_1_question_2 = (RadioButton) findViewById(R.id.answer_1_question_2);
        boolean choiceForQuestion2 = answer_1_question_2.isChecked();

        answer_1_question_3 = (RadioButton) findViewById(R.id.answer_1_question_3);
        boolean choiceForQuestion3 = answer_1_question_3.isChecked();

        answer_1_question_4 = (RadioButton) findViewById(R.id.answer_2_question_4);
        boolean choiceForQuestion4 = answer_1_question_4.isChecked();

        answer_1_question_5 = (RadioButton) findViewById(R.id.answer_1_question_5);
        boolean choiceForQuestion5 = answer_1_question_5.isChecked();

        answer_1_question_6 = (RadioButton) findViewById(R.id.answer_1_question_6);
        boolean choiceForQuestion6 = answer_1_question_6.isChecked();

        answer_1_question_7 = (RadioButton) findViewById(R.id.answer_1_question_7);
        boolean choiceForQuestion7 = answer_1_question_7.isChecked();

        answer_1_question_8 = (RadioButton) findViewById(R.id.answer_1_question_8);
        boolean choiceForQuestion8 = answer_1_question_8.isChecked();

        answer_1_question_9 = (RadioButton) findViewById(R.id.answer_1_question_9);
        boolean choiceForQuestion9 = answer_1_question_9.isChecked();

        answer_1_question_10 = (RadioButton) findViewById(R.id.answer_1_question_10);
        boolean choiceForQuestion10 = answer_1_question_10.isChecked();





        correctAnswers = scoreCalculated(choiceForQuestion1, choiceForQuestion2, choiceForQuestion3, choiceForQuestion4,
                choiceForQuestion5,choiceForQuestion6, choiceForQuestion7, choiceForQuestion8,
                choiceForQuestion9, choiceForQuestion10);

        //Changes the greeting to appropriately match the score
        if (correctAnswers >= 7) {

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");

            alertDialog.setMessage("Please don't move ,don't be scared  we will take care of you ! \nCalling Emergency in progress ... ");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

           // Toast toast = Toast.makeText(getApplicationContext(), "please don't move we will call emergency for u !", Toast.LENGTH_LONG);
          //  toast.show();
            // SLEEP 2 SECONDS HERE ...
            final Handler handler = new Handler();
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {
                            call();
                        }
                    });
                }
            }, 3000);


        }
        else {
            greeting = "Congrats, " + usersName + ".";
            finalToast1 = greeting + " Your are in good health !";
            finalToast2 = "\nRemember to stay safe and healthy, spread this test to help keep people safe!";

            //Toast message that is displayed once the user has completed the quiz
            Toast toast = Toast.makeText(getApplicationContext(), finalToast1 + finalToast2, Toast.LENGTH_LONG);
            toast.show();

        }

    }

    private void call() {
        Uri uri = Uri.parse("tel:190");
        Intent sendIntent = new Intent(Intent.ACTION_CALL,uri);



        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(sendIntent);

    }

    //Calculates the amount of correct answers inputted
    public int scoreCalculated(boolean choiceForQuestion1, boolean choiceForQuestion2, boolean choiceForQuestion3,
                               boolean choiceForQuestion4,boolean choiceForQuestion5,boolean choiceForQuestion6,
                               boolean choiceForQuestion7, boolean choiceForQuestion8,boolean choiceForQuestion9,
                               boolean choiceForQuestion10) {
        int answersCorrect = 0;

        if (choiceForQuestion1 == true) {
            answersCorrect += 1;
            Question1Correct = true;
        }

        else {
            Question1Correct = false;
        }

        if (choiceForQuestion2 == true) {
            answersCorrect += 1;
            Question2Correct = true;
        }

        else {
            Question2Correct = false;
        }

        if (choiceForQuestion3 == true) {
            answersCorrect += 1;
            Question3Correct = true;
        }

        else {
            Question3Correct = false;
        }

        if (choiceForQuestion4 == true) {
            answersCorrect += 1;
            Question4Correct = true;
        }

        else {
            Question4Correct = false;
        }

        if (choiceForQuestion5 == true) {
            answersCorrect += 1;
            Question5Correct = true;
        }

        else {
            Question5Correct = false;
        }

        if (choiceForQuestion6 == true) {
            answersCorrect += 1;
            Question6Correct = true;
        }

        else {
            Question6Correct = false;
        }

        if (choiceForQuestion7 == true) {
            answersCorrect += 1;
            Question7Correct = true;
        }

        else {
            Question7Correct = false;
        }

        if (choiceForQuestion8 == true) {
            answersCorrect += 1;
            Question8Correct = true;
        }

        else {
            Question8Correct = false;
        }

        if (choiceForQuestion9 == true) {
            answersCorrect += 1;
            Question9Correct = true;
        }

        else {
            Question9Correct = false;
        }

        if (choiceForQuestion10 == true) {
            answersCorrect += 1;
            Question10Correct = true;
        }

        else {
            Question10Correct = false;
        }

        return answersCorrect;
    }

    public void onRadioButtonInQ1Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_1:
                if (checked)

                    break;
            case R.id.answer_2_question_1:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ2Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_2:
                if (checked)

                    break;
            case R.id.answer_2_question_2:
                if (checked)

                    break;


        }
    }

    public void onRadioButtonInQ3Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_3:
                if (checked)

                    break;
            case R.id.answer_2_question_3:
                if (checked)

                    break;


        }
    }

    public void onRadioButtonInQ4Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_4:
                if (checked)

                    break;
            case R.id.answer_2_question_4:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ5Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_5:
                if (checked)

                    break;
            case R.id.answer_2_question_5:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ6Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_6:
                if (checked)

                    break;
            case R.id.answer_2_question_6:
                if (checked)

                    break;


        }
    }
    public void onRadioButtonInQ7Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_7:
                if (checked)

                    break;
            case R.id.answer_2_question_7:
                if (checked)
                    break;

        }
    }

    public void onRadioButtonInQ8Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_8:
                if (checked)

                    break;
            case R.id.answer_2_question_8:
                if (checked)
                    break;

        }
    }

    public void onRadioButtonInQ9Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_9:
                if (checked)

                    break;
            case R.id.answer_2_question_9:
                if (checked)

                    break;
        }
    }

    public void onRadioButtonInQ10Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_10:
                if (checked)

                    break;
            case R.id.answer_2_question_10:
                if (checked)

                    break;
        }
    }

    //Resets the Quiz by removing all checks and text
    public void resetTheQuiz(View view) {

        if (name != null)
            name.setText("");
        else {
            name = (EditText) findViewById(R.id.name_input);
            name.setText("");
        }

        questionsWrong = "";

        greeting = "";

        RadioGroup radioGroupForQuestion1 = (RadioGroup) findViewById(R.id.choices_For_Question1);
        radioGroupForQuestion1.clearCheck();

        RadioGroup radioGroupForQuestion2 = (RadioGroup) findViewById(R.id.choices_For_Question2);
        radioGroupForQuestion2.clearCheck();

        RadioGroup radioGroupForQuestion3 = (RadioGroup) findViewById(R.id.choices_For_Question3);
        radioGroupForQuestion3.clearCheck();

        RadioGroup radioGroupForQuestion4 = (RadioGroup) findViewById(R.id.choices_For_Question4);
        radioGroupForQuestion4.clearCheck();

        RadioGroup radioGroupForQuestion5 = (RadioGroup) findViewById(R.id.choices_For_Question5);
        radioGroupForQuestion5.clearCheck();

        RadioGroup radioGroupForQuestion6 = (RadioGroup) findViewById(R.id.choices_For_Question6);
        radioGroupForQuestion6.clearCheck();

        RadioGroup radioGroupForQuestion7 = (RadioGroup) findViewById(R.id.choices_For_Question7);
        radioGroupForQuestion7.clearCheck();

        RadioGroup radioGroupForQuestion8 = (RadioGroup) findViewById(R.id.choices_For_Question8);
        radioGroupForQuestion8.clearCheck();

        RadioGroup radioGroupForQuestion9 = (RadioGroup) findViewById(R.id.choices_For_Question9);
        radioGroupForQuestion9.clearCheck();

        RadioGroup radioGroupForQuestion10 = (RadioGroup) findViewById(R.id.choices_For_Question10);
        radioGroupForQuestion10.clearCheck();

        Toast toast = Toast.makeText(getApplicationContext(), "Test Reset!", Toast.LENGTH_LONG);
        toast.show();


    }

}