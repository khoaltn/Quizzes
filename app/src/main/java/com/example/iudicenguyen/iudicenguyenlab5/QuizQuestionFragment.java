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
 * Created by Khoa Nguyen & Alex Iudice on 2/12/15.
 */
public class QuizQuestionFragment extends Fragment implements View.OnClickListener {
    private TextView questionField;
    private Button opt1, opt2, opt3, opt4;

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {

        GridLayout main = (GridLayout) getActivity().findViewById(R.id.mainLayout);
        main.setVisibility(View.GONE);

        View questionFragment = inflater.inflate(R.layout.quiz_question_fragment, container, false);

        questionField = (TextView) questionFragment.findViewById(R.id.questionField);
        opt1 = (Button) questionFragment.findViewById(R.id.opt1);
        opt1.setOnClickListener(this);

        opt2 = (Button) questionFragment.findViewById(R.id.opt2);
        opt2.setOnClickListener(this);

        opt3 = (Button) questionFragment.findViewById(R.id.opt3);
        opt3.setOnClickListener(this);

        opt4 = (Button) questionFragment.findViewById(R.id.opt4);
        opt4.setOnClickListener(this);

        if (Main.isQuiz1Clicked()) {
            switch (Main.getNumQuestions()) {
                case 1:
                    questionField.setText(R.string.quiz1_1_q);
                    opt1.setText(R.string.quiz1_1_aw2);
                    opt2.setText(R.string.quiz1_1_aw1);
                    opt3.setText(R.string.quiz1_1_ar);
                    opt4.setText(R.string.quiz1_1_aw3);
                    break;
                case 2:
                    questionField.setText(R.string.quiz1_2_q);
                    opt1.setText(R.string.quiz1_2_aw3);
                    opt2.setText(R.string.quiz1_2_aw1);
                    opt3.setText(R.string.quiz1_2_aw2);
                    opt4.setText(R.string.quiz1_2_ar);
                    break;
                case 3:
                    questionField.setText(R.string.quiz1_3_q);
                    opt1.setText(R.string.quiz1_3_ar);
                    opt2.setText(R.string.quiz1_3_aw1);
                    opt3.setText(R.string.quiz1_3_aw3);
                    opt4.setText(R.string.quiz1_3_aw2);
                    break;
                case 4:
                    questionField.setText(R.string.quiz1_4_q);
                    opt1.setText(R.string.quiz1_4_aw3);
                    opt2.setText(R.string.quiz1_4_ar);
                    opt3.setText(R.string.quiz1_4_aw1);
                    opt4.setText(R.string.quiz1_4_aw2);
                    break;
                case 5:
                    questionField.setText(R.string.quiz1_5_q);
                    opt1.setText(R.string.quiz1_5_aw3);
                    opt2.setText(R.string.quiz1_5_aw1);
                    opt3.setText(R.string.quiz1_5_aw2);
                    opt4.setText(R.string.quiz1_5_ar);
                    break;
            }
        }
        else if (Main.isQuiz2Clicked()) {
            switch (Main.getNumQuestions()) {
                case 1:
                    questionField.setText(R.string.quiz2_1_q);
                    opt1.setText(R.string.quiz2_1_aw3);
                    opt2.setText(R.string.quiz2_1_aw1);
                    opt3.setText(R.string.quiz2_1_ar);
                    opt4.setText(R.string.quiz2_1_aw2);
                    break;
                case 2:
                    questionField.setText(R.string.quiz2_2_q);
                    opt1.setText(R.string.quiz2_2_aw3);
                    opt2.setText(R.string.quiz2_2_aw1);
                    opt3.setText(R.string.quiz2_2_aw2);
                    opt4.setText(R.string.quiz2_2_ar);
                    break;
                case 3:
                    questionField.setText(R.string.quiz2_3_q);
                    opt1.setText(R.string.quiz2_3_ar);
                    opt2.setText(R.string.quiz2_3_aw1);
                    opt3.setText(R.string.quiz2_3_aw3);
                    opt4.setText(R.string.quiz2_3_aw2);
                    break;
                case 4:
                    questionField.setText(R.string.quiz2_4_q);
                    opt1.setText(R.string.quiz2_4_aw3);
                    opt2.setText(R.string.quiz2_4_ar);
                    opt3.setText(R.string.quiz2_4_aw1);
                    opt4.setText(R.string.quiz2_4_aw2);
                    break;
                case 5:
                    questionField.setText(R.string.quiz2_5_q);
                    opt1.setText(R.string.quiz2_5_aw3);
                    opt2.setText(R.string.quiz2_5_aw1);
                    opt3.setText(R.string.quiz2_5_aw2);
                    opt4.setText(R.string.quiz2_5_ar);
                    break;
            }
        }

        TextView quesCounter = (TextView) questionFragment.findViewById(R.id.quesCounter);
        quesCounter.setText(Integer.toString(Main.getNumCorrect()) + "/" + Integer.toString(Main.getNumQuestions()));

        return questionFragment;
    }

    @Override
    public void onClick(View v) {
        Button clickedOpt = (Button) v;
        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_container);

        CharSequence chosenAns = clickedOpt.getText();
        CharSequence currentQuestion = questionField.getText();

        //CHECK THE PAIRS QUESTION-RIGHT ANSWER
        if (    //FIRST QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz1_1_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz1_1_ar))) ) ||

                //SECOND QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz1_2_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz1_2_ar))) ) ||

                //THIRD QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz1_3_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz1_3_ar))) ) ||

                //FOURTH QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz1_4_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz1_4_ar))) ) ||

                //FIFTH QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz1_5_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz1_5_ar))) ) ||

                        // QUIZ 2

                // FIRST QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz2_1_q))
                && (chosenAns.equals(getResources().getString(R.string.quiz2_1_ar))) ) ||

                //SECOND QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz2_2_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz2_2_ar))) ) ||

                //THIRD QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz2_3_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz2_3_ar))) ) ||

                //FOURTH QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz2_4_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz2_4_ar))) ) ||

                //FIFTH QUESTION
                (currentQuestion.equals(getResources().getString(R.string.quiz2_5_q))
                        && (chosenAns.equals(getResources().getString(R.string.quiz2_5_ar))) )

           ) {
                // If answer is right, then load the rightAns fragment.
                if (!(fragment instanceof QuizAnswerRightFragment))
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new QuizAnswerRightFragment())
                            .commit();
                Main.setNumCorrect(Main.getNumCorrect() + 1);
           }
           else {
                //If answer is wrong, then load the wrongAns fragment.
                if (!(fragment instanceof QuizAnswerWrongFragment))
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new QuizAnswerWrongFragment())
                            .commit();
           }
    }
}
