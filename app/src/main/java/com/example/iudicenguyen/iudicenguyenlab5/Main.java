package com.example.iudicenguyen.iudicenguyenlab5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;



public class Main extends FragmentActivity implements View.OnClickListener {

    private QuizQuestionFragment quiz;
    private Button quiz1Button;
    private Button quiz2Button;

    private static int numCorrect = 0;
    private static int numQuestions = 0;
    private static boolean quiz1Clicked = false;
    private static boolean quiz2Clicked = false;

    public static int getNumCorrect() {
        return numCorrect;
    }

    public static void setNumCorrect(int numCorrect) {
        Main.numCorrect = numCorrect;
    }

    public static int getNumQuestions() {
        return numQuestions;
    }

    public static void setNumQuestions(int numQuestions) {
        Main.numQuestions = numQuestions;
    }

    public static boolean isQuiz1Clicked() {
        return quiz1Clicked;
    }

    public static void setQuiz1Clicked(boolean quiz1Clicked) {
        Main.quiz1Clicked = quiz1Clicked;
    }

    public static boolean isQuiz2Clicked() {
        return quiz2Clicked;
    }

    public static void setQuiz2Clicked(boolean quiz2Clicked) {
        Main.quiz2Clicked = quiz2Clicked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setQuiz1Button((Button) findViewById(R.id.quiz1Button));
        getQuiz1Button().setOnClickListener(this);

        setQuiz2Button((Button) findViewById(R.id.quiz2Button));
        getQuiz2Button().setOnClickListener(this);

        setQuiz(new QuizQuestionFragment());
    }

    public void onClick(View v)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (v == getQuiz1Button())
        {
            setQuiz1Clicked(true);
            setQuiz2Clicked(false);
        }
        else if (v == getQuiz2Button())
        {
            setQuiz1Clicked(false);
            setQuiz2Clicked(true);
        }

        setNumCorrect(0);
        setNumQuestions(1);

        GridLayout main = (GridLayout) findViewById(R.id.mainLayout);
        main.setVisibility(View.GONE);

        if ( !(fragment instanceof QuizQuestionFragment) )
            getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, getQuiz())
                        .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //TEST
    //Override methods to save data when the device rotates
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("savedQuiz1Clicked", isQuiz1Clicked());
        outState.putBoolean("savedQuiz2Clicked", isQuiz2Clicked());
        outState.putInt("savedNumCorrect", getNumCorrect());
        outState.putInt("savedNumQuestions", getNumQuestions());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        setQuiz1Clicked(savedInstanceState.getBoolean("savedQuiz1Clicked"));
        setQuiz2Clicked(savedInstanceState.getBoolean("savedQuiz2Clicked"));
        setNumCorrect(savedInstanceState.getInt("savedNumCorrect"));
        setNumQuestions(savedInstanceState.getInt("savedNumQuestions"));
    }

    public QuizQuestionFragment getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizQuestionFragment quiz) {
        this.quiz = quiz;
    }

    public Button getQuiz1Button() {
        return quiz1Button;
    }

    public void setQuiz1Button(Button quiz1Button) {
        this.quiz1Button = quiz1Button;
    }

    public Button getQuiz2Button() {
        return quiz2Button;
    }

    public void setQuiz2Button(Button quiz2Button) {
        this.quiz2Button = quiz2Button;
    }
}
