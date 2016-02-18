package com.cs407_android.owner.quizgame;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private TextView headerTextView;

    /**
     * DONT CHANGE THIS METHOD
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param //TODO
     * @return A new instance of fragment PlayFragment.
     */
    public static ImageQuestionFragment newInstance() {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PLAYER_ONE, player1Choice);
       // fragment.setArguments(args);
        return fragment;
    }

    public ImageQuestionFragment() {
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
    //KAD this is the gameplay screen, basically. Displays to the user the three options: rock, paper, scissors.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TA Implementation DON'T CHANGE
        View view = null;
        view = inflater.inflate(R.layout.fragment_question, container, false);

        //instantiate widgets
//        rockButton = (Button) view.findViewById(R.id.rock);


        //set header
//        if (player1Choice == null) {
//            headerTextView.setText(getString(R.string.player_1_header));
//        } else {
//            headerTextView.setText(getString(R.string.player_2_header));
//        }

        return view;

        // End TA Implementation
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TA Implementation //different way of implementing click interaction.
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
                                .replace(R.id.main_fragment_container, ImageQuestionFragment.newInstance())
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