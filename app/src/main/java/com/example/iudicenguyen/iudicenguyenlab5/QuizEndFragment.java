package com.example.iudicenguyen.iudicenguyenlab5;


import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.*;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by Khoa Nguyen & Alex Iudice on 2/18/2015.
 * QuizEndFragment.java
 */
public class QuizEndFragment extends Fragment implements View.OnClickListener {

    private TextView quizNumber;
    private Button gotoStart;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View endFragment = inflater.inflate(R.layout.quiz_end_fragment, container, false);

        quizNumber = (TextView) endFragment.findViewById(R.id.quizResult);

        gotoStart = (Button) endFragment.findViewById(R.id.gotoStart);
        gotoStart.setOnClickListener(this);

        TextView numCorrect = (TextView) endFragment.findViewById(R.id.numCorrect);
        numCorrect.setText(Integer.toString(Main.getNumCorrect()) + "/" + Integer.toString(Main.getNumQuestions()));

        if (Main.isQuiz1Clicked())
            quizNumber.setText("Your result for Quiz 1 is...");
        else if (Main.isQuiz2Clicked())
            quizNumber.setText("Your result for Quiz 2 is...");

        return endFragment;
    }

    @Override
    public void onClick(View v){
        //Button backToStart = (Button) v;
        //Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_container);

        //Reinitialize variables in Main. (quiz1Clicked/quiz2Clicked/numCorrect/numQuestions)
        Main.setNumCorrect(0);
        Main.setNumQuestions(0);
        Main.setQuiz1Clicked(false);
        Main.setQuiz2Clicked(false);

        //Remove this fragment so then just Main is showing.
        getFragmentManager().beginTransaction().remove(this).commit();

        GridLayout main = (GridLayout) getActivity().findViewById(R.id.mainLayout);
        main.setVisibility(View.VISIBLE);
    }
}
