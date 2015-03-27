package com.example.iudicenguyen.iudicenguyenlab5;

import android.os.Bundle;
import android.support.annotation.*;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.net.Uri;
import android.content.Intent;



/**
 * Created by Khoa Nguyen & Alex Iudice on 2/16/15.
 * QuizFragmentAnswerWrong.java
 */
public class QuizAnswerWrongFragment extends Fragment implements View.OnClickListener {

    private Button next, learnMore;

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        GridLayout main = (GridLayout) getActivity().findViewById(R.id.mainLayout);
        main.setVisibility(View.GONE);

        View wrongAnswerFragment = inflater.inflate(R.layout.quiz_answer_wrong_fragment, container, false);

        TextView rightAnswer = (TextView) wrongAnswerFragment.findViewById(R.id.rightAnsText);

        if (Main.isQuiz1Clicked()) {
            switch (Main.getNumQuestions()) {
                case 1:
                    rightAnswer.setText(R.string.quiz1_1_expl);
                    break;
                case 2:
                    rightAnswer.setText(R.string.quiz1_2_expl);
                    break;
                case 3:
                    rightAnswer.setText(R.string.quiz1_3_expl);
                    break;
                case 4:
                    rightAnswer.setText(R.string.quiz1_4_expl);
                    break;
                case 5:
                    rightAnswer.setText(R.string.quiz1_5_expl);
                    break;
            }
        }
        else if (Main.isQuiz2Clicked()) {
            switch (Main.getNumQuestions()) {
                case 1:
                    rightAnswer.setText(R.string.quiz2_1_expl);
                    break;
                case 2:
                    rightAnswer.setText(R.string.quiz2_2_expl);
                    break;
                case 3:
                    rightAnswer.setText(R.string.quiz2_3_expl);
                    break;
                case 4:
                    rightAnswer.setText(R.string.quiz2_4_expl);
                    break;
                case 5:
                    rightAnswer.setText(R.string.quiz2_5_expl);
                    break;
            }
        }

        next = (Button) wrongAnswerFragment.findViewById(R.id.nextButton);
        next.setOnClickListener(this);

        learnMore = (Button) wrongAnswerFragment.findViewById(R.id.learnMoreButton);//ADD NEEDED XML PART. SET TO NEXTBUTTON SO THIS CODE WILL RUN.
        learnMore.setOnClickListener(this);

        return wrongAnswerFragment;
    }

    public void showWebPage(View view){
        if(Main.isQuiz1Clicked()){
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://harrypotter.wikia.com/wiki/Main_Page"));
            startActivity(intent);
        }
        else {
            Intent intent;

            switch(Main.getNumQuestions()) {
                case 1:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://en.wikipedia.org/wiki/Sequence"));
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.math.grinnell.edu/~miletijo/museum/infinite.html"));
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://111111111x111111111.com/"));
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.math.hmc.edu/funfacts/ffiles/10001.6.shtml"));
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://homeworktips.about.com/od/science/a/Bigger-Than-A-Trillion.htm"));
                    startActivity(intent);
                    break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        View clicked = (View) v;


        if (v == learnMore) {
            showWebPage(v);
        }

        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_container);

        //Check if there are any more questions
        if (Main.getNumQuestions() >= 5) {
            //Load Alex's Result Page
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new QuizEndFragment())
                    .commit();
        }
        else {
            if (!(fragment instanceof QuizQuestionFragment))
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new QuizQuestionFragment())
                        .commit();
            Main.setNumQuestions(Main.getNumQuestions()+ 1);
        }
    }
}
