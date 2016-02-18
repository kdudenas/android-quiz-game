package com.cs407_android.owner.quizgame;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    //fields here

    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button4;
    private RadioButton button8;

    private TextView textQuestion;

    /**
     * DONT CHANGE THIS METHOD
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param //TODO
     * @return A new instance of fragment PlayFragment.
     */
    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PLAYER_ONE, player1Choice);
       // fragment.setArguments(args);
        return fragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//            player1Choice = getArguments().getString(ARG_PLAYER_ONE);
//            player2Choice = getArguments().getString(ARG_PLAYER_TWO);
//        }
    }

    @Override
    //KAD this is the gameplay screen, basically. Displays the text-base question
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_question, container, false);

        //instantiate widgets
        button1 = (RadioButton) view.findViewById(R.id.button1);
        button2 = (RadioButton) view.findViewById(R.id.button2);
        button4 = (RadioButton) view.findViewById(R.id.button4);
        button8 = (RadioButton) view.findViewById(R.id.button8);

        //set question text
        textQuestion = (TextView) view.findViewById(R.id.text_question);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      //implementing click interaction
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wrong answer
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wrong answer
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wrong answer
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correct answer
                System.out.println("Yay!!!!!!!!"); //TODO remove
            }
        });

    }


    private void displayWinner(String winner) {
        //TODO
        //do a prompt about the winner
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Winner is:")
                .setMessage(winner)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //KAD start a rematch!
                        getFragmentManager()
                                .beginTransaction() //KAD apparently getText(int) will retain any rich text styling applied to the string.
                                .replace(R.id.main_fragment_container, QuestionFragment.newInstance())
                                .addToBackStack(null)
                                .commit();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //KAD back out to the start screen
                        getActivity().finish();

                    }
                })
                .show();

    }

}