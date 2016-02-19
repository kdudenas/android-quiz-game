package com.cs407_android.owner.quizgame;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ImageQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageQuestionFragment extends Fragment {

    //fields here
    private int correctAnswers = 0;
    private Button imgSubmitButton;
    private ImageView questionImage;
    private TextView question;
    private EditText answerField;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ImageQuestionFragment.
     */
    public static ImageQuestionFragment newInstance() {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public ImageQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    //KAD displays an image and a question; user submits answer via text field
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_image_question, container, false);

        //instantiate widgets
        imgSubmitButton = (Button) view.findViewById(R.id.imgSubmitButton);
        questionImage = (ImageView) view.findViewById(R.id.questionImage);
        question = (TextView) view.findViewById(R.id.img_question);
        answerField = (EditText) view.findViewById(R.id.userAnswer);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //different way of implementing click interaction.
        imgSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String answer = "treble";//TODO make resource
                if (answerField.getText().toString().equals(answer)){
                    correctAnswers++;
                }

                //next question
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, QuestionFragment.newInstance(correctAnswers))
                        .addToBackStack(null)
                        .commit();

            }
        });


    }

}