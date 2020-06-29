package com.example.calculator_1st;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MainActivityFragment extends Fragment {

    private ViewGroup container;
    private LayoutInflater inflater;
    private EditText editText;
    private TextView textView;
    private Button button;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;


    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String operator = "＋";
    String lastOperator = "＋";

    TextView resultText;

    public MainActivityFragment() {



    }

    public View initializeUserInterface() {
        View view;

        // If there is already a layout inflated, remove it.
        if (container != null) {
            container.removeAllViewsInLayout();
        }

        // Get the screen orientation.
        int orientation = getActivity().getResources().getConfiguration().orientation;

        // Inflate the appropriate layout based on the screen orientation.
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            view = inflater.inflate(R.layout.fragment_main_activity, container, false);
        }
        else { // orientation == Configuration.ORIENTATION_LANDSCAPE
            view = inflater.inflate(R.layout.fragment_main_activity_horizontal, container, false);
        }


        // Instantiate our widgets from the layout.
        editText = view.findViewById(R.id.editText);
        textView = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.button);
        button1 = view.findViewById(R.id.num_1_button);
        button2 = view.findViewById(R.id.num_2_button);
        button3 = view.findViewById(R.id.num_3_button);
        button4 = view.findViewById(R.id.num_4_button);
        button5 = view.findViewById(R.id.num_5_button);
        button6 = view.findViewById(R.id.num_6_button);
        button7 = view.findViewById(R.id.num_7_button);
        button8 = view.findViewById(R.id.num_8_button);
        button9 = view.findViewById(R.id.num_9_button);
        button0 = view.findViewById(R.id.num_0_button);
        resultText = view.findViewById(R.id.result_text_view);

        // Display the orientation in the text view.
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
           // textView.setText("Portrait");
        }
        else {
            //textView.setText("Landscape");

            // Get the width of the screen.
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int width = displayMetrics.widthPixels;

            // If we have a small screen, adjust text size.
            if (width < 793) {
                textView.setTextSize(12);
            }
        }

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Create an on click listener for the button that loads a new fragment for the user.
            button1.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    action_1(view);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    action_1(view);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button5.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button6.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button7.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button8.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button9.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
            button0.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { action_1(view); } });
        }
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cast the activity to the MainActivity class and call the load fragment method.
                ((MainActivity)getActivity()).loadFragment(new BlankFragment());
            }
        });

         */





        return view;
    }
    public void action_1(View view) {
        String getButtonText = view.getTag().toString();

        if(isFirstInput) {

            //resultText.setTextColor(0xFF666666);
            resultText.setText(getButtonText);

            //activityMainBinding.resultTextView.setText(getButtonText);
            isFirstInput = false;
        }
        else {
            if(resultText.getText().toString().equals("0")) {
                //Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show();
                isFirstInput = true;
            }
            resultText.append(getButtonText);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Instantiate our container and inflater handles.
        this.container = container;
        this.inflater = inflater;

        //resultText = resultText.findViewById();

        // Display the desired layout and return the view.
        return initializeUserInterface();
    }

    /**
     * This is called when the user rotates the device.
     * @param newConfig Configuration
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // Save the text that the user has already typed.
        //String preserveThisText = editText.getText().toString();

        // Create the new layout.
        View view = initializeUserInterface();

        // Display the text the user has already typed.
        //editText.setText(preserveThisText);

        // Display the new layout on the screen.
        container.addView(view);

        // Call the default method to cover our bases.
        super.onConfigurationChanged(newConfig);
    }

    public void action1(View view) {

        String getButtonText = view.getTag().toString();
        //Log.e("B--->", getButtonText + " " + getButtonText + " " + getButtonText);
        //Toast.makeText(this, "0으로 시작되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
/*
        if(isFirstInput) {

            //resultText.setTextColor(0xFF666666);
            resultText.setText(getButtonText);

            //activityMainBinding.resultTextView.setText(getButtonText);
            isFirstInput = false;
        }
        else {
            //if(activityMainBinding.resultTextView.getText().toString().equals("0")) {
            if(resultText.getText().toString().equals("0")) {
                Toast.makeText(this, "0으로 시작되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
                isFirstInput = true;
            }
            resultText.append(getButtonText);
//            activityMainBinding.resultTextView.append(getButtonText);
        }
        */
    }


}
