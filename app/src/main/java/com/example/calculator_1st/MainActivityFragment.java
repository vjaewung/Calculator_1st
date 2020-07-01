package com.example.calculator_1st;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityFragment extends Fragment {

    private ViewGroup container;
    private LayoutInflater inflater;
    private EditText editText;
    private TextView textView;
    private Button button;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private Button buttonLeftPts, buttonRightPts, buttonPercent, buttonClear, buttonPlus, buttonMinus, buttonTimes, buttonDivide, buttonEquals, buttonPoint;

    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String operator = "＋";
    String lastOperator = "＋";

    TextView resultText;
    TextView mathText;

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

        //Instantiate our widgets from the layout.
        //editText = view.findViewById(R.id.editText);
        //textView = view.findViewById(R.id.textView);
        //button = view.findViewById(R.id.button);
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

        buttonLeftPts = view.findViewById(R.id.left_pts_button);
        buttonRightPts = view.findViewById(R.id.right_pts_button);
        buttonPercent = view.findViewById(R.id.percent_button);
        buttonClear = view.findViewById(R.id.clear_button);
        buttonPlus = view.findViewById(R.id.plus_button);
        buttonMinus = view.findViewById(R.id.minus_button);
        buttonTimes = view.findViewById(R.id.times_button);
        buttonDivide = view.findViewById(R.id.divide_button);
        buttonEquals = view.findViewById(R.id.equals_button);
        buttonPoint = view.findViewById(R.id.point_button);

        resultText = view.findViewById(R.id.result_text_view);
        mathText = view.findViewById(R.id.math_text_view);

        // Display the orientation in the text view.
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
           // textView.setText("Portrait");
        }
        else {
            //textView.setText("Landscape");

            // Get the width of the screen.
            //DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            //int width = displayMetrics.widthPixels;

            // If we have a small screen, adjust text size.
            //if (width < 793) {
            //    textView.setTextSize(12);
            //}
        }

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Create an on click listener for the button that loads a new fragment for the user.
            button1.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button2.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button3.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button4.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button5.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button6.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button7.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button8.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button9.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button0.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });

            buttonLeftPts.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { paranButtonClick(view); } });
            buttonRightPts.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { paranButtonClick(view); } });
            //buttonPercent.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonClear.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { allClearButtonClick(view); } });
            buttonPlus.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonMinus.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonTimes.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonDivide.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonEquals.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { equalsButtonClick(view); } });
            buttonPoint.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { pointButtonClick(view); } });
        }
        else {
            // Create an on click listener for the button that loads a new fragment for the user.
            button1.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button2.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button3.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button4.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button5.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button6.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button7.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button8.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button9.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });
            button0.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { numButtonClick(view); } });

            buttonLeftPts.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { paranButtonClick(view); } });
            buttonRightPts.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { paranButtonClick(view); } });
            //buttonPercent.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonClear.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { allClearButtonClick(view); } });
            buttonPlus.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonMinus.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonTimes.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonDivide.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { operatorClick(view); } });
            buttonEquals.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { equalsButtonClick(view); } });
            buttonPoint.setOnClickListener(new View.OnClickListener() {public void onClick(View view) { pointButtonClick(view); } });
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        // Save the text that the user has already typed.
        // String preserveThisText = editText.getText().toString();
        String preserveThisText = resultText.getText().toString();
        String preserveThisMathText = mathText.getText().toString();

        // Log.e("onConfigurationChanged", preserveThisText + " " + preserveThisMathText);

        // Create the new layout.
        View view = initializeUserInterface();

        // Display the text the user has already typed.
        //editText.setText(preserveThisText);
        resultText.setText(preserveThisText);
        mathText.setText(preserveThisMathText);

        // Display the new layout on the screen.
        container.addView(view);

        // Call the default method to cover our bases.
        super.onConfigurationChanged(newConfig);
    }


    public void numButtonClick(View view) {

        Log.e("numButtonClick", view.getTag().toString() + " " + isFirstInput);

        String getButtonText = view.getTag().toString();

        boolean paranExist = ckParanExist(resultText.getText().toString());
        if(paranExist) {
            resultText.append(getButtonText);
        }
        else {
            if (isFirstInput) {

                resultText.setTextColor(0xFF666666);
                resultText.setText(getButtonText);

                isFirstInput = false;
                if (operator.equals("=")) {
                    mathText.setText("");
                    isOperatorClick = false;
                }
            } else {
                if (resultText.getText().toString().equals("0")) {
                    resultText.setText("0");
                    isFirstInput = true;
                } else {
                    resultText.append(getButtonText);
                }
            }
        }
    }

    public void paranButtonClick(View view) {

        Log.e("paranButtonClick", view.getTag().toString() + " " + isFirstInput);

        String getButtonText = view.getTag().toString();
        boolean paranExist = ckParanExist(resultText.getText().toString());
        if(paranExist) {
            resultText.append(getButtonText);
        }
        else {
            if (isFirstInput) {
                resultText.setTextColor(0xFF666666);
                resultText.setText(getButtonText);

                isFirstInput = false;
                if (operator.equals("=")) {
                    mathText.setText("");
                    isOperatorClick = false;
                }
            } else {
                if (resultText.getText().toString().equals("0")) {
                    //Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show();
                    resultText.setText("0");
                    isFirstInput = true;
                } else {
                    resultText.append(getButtonText);
                }
            }
        }
    }

    public boolean ckParanExist(String resultText) {
        if(resultText.indexOf("(") > -1 || resultText.indexOf(")") > -1) { return  true; }
        else { return false; }
    }

    public void operatorClick (View view) {

        Log.e("operatorClick", resultText.getText().toString() + " " + ckParanExist(resultText.getText().toString()));
        //if(resultText.getText().toString().indexOf("("))

        boolean paranExist = ckParanExist(resultText.getText().toString());
        if(paranExist) {
            //÷, ×, ＋, -
            isOperatorClick = true;
            lastOperator = view.getTag().toString();

            if (isFirstInput) {
                if (operator.equals("=")) {
                    operator = view.getTag().toString();
                    resultNumber = Double.parseDouble((resultText.getText().toString()));
                    mathText.setText(resultNumber + " " + operator + " ");
                } else {
                    operator = view.getTag().toString();
                    String getMathText = mathText.getText().toString();
                    String subString = getMathText.substring(0, getMathText.length() - 2);
                    mathText.setText(subString);
                    mathText.append(operator + " ");
                }
            } else {
                //inputNumber = Double.parseDouble(resultText.getText().toString());
                //resultNumber = calculator(resultNumber, inputNumber, operator);
                //resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                operator = view.getTag().toString();
                resultText.append(operator);
                //mathText.append(inputNumber + " " + operator + " ");
            }
        }
        else {
            //÷, ×, ＋, -
            isOperatorClick = true;
            lastOperator = view.getTag().toString();

            if (isFirstInput) {
                if (operator.equals("=")) {
                    operator = view.getTag().toString();
                    resultNumber = Double.parseDouble((resultText.getText().toString()));
                    mathText.setText(resultNumber + " " + operator + " ");
                } else {
                    operator = view.getTag().toString();
                    String getMathText = mathText.getText().toString();
                    String subString = getMathText.substring(0, getMathText.length() - 2);
                    mathText.setText(subString);
                    mathText.append(operator + " ");
                }
            } else {
                inputNumber = Double.parseDouble(resultText.getText().toString());
                resultNumber = calculator(resultNumber, inputNumber, operator);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                operator = view.getTag().toString();
                mathText.append(inputNumber + " " + operator + " ");
            }
        }

    }

    public  void equalsButtonClick (View view) {

        boolean paranExist = ckParanExist(resultText.getText().toString());
        if(paranExist) {

        }
        else {
            if (isFirstInput) {
                if (isOperatorClick) {
                    mathText.setText(resultNumber + " " + lastOperator + " " + inputNumber + " =");
                    //activityMainBinding.mathTextView.setText(resultNumber + " " + lastOperator + " " + inputNumber + " =");
                    resultNumber = calculator(resultNumber, inputNumber, lastOperator);
                    resultText.setText(String.valueOf(resultNumber));
                    //activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
                }
            } else {

                inputNumber = Double.parseDouble(resultText.getText().toString());

                resultNumber = calculator(resultNumber, inputNumber, operator);
                lastOperator = operator; //?
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;

                operator = view.getTag().toString();
                mathText.append(inputNumber + " " + operator + " ");
            }
        }
    }

    private double calculator(double resultNumber, double inputNumber, String operator) {

        Log.e("calculator--->", resultNumber + " " + inputNumber + " " + operator);

        //÷, ×, ＋, -

        if(operator.equals("=")) {
            resultNumber = inputNumber;
            Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber + inputNumber;
            Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("-")) {
            resultNumber = resultNumber - inputNumber;
            Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("×")) {
            resultNumber = resultNumber * inputNumber;
            Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("÷")) {
            resultNumber = resultNumber / inputNumber;
            Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);
        }

        /*
            case "=" :
                resultNumber = inputNumber;
                Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
                break;
            case "＋" :
                resultNumber = resultNumber + inputNumber;
                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
            case "-" :
                resultNumber = resultNumber - inputNumber;
                Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
            case "×" :
                resultNumber = resultNumber * inputNumber;
                Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
            case "÷" :
                resultNumber = resultNumber / inputNumber;
                Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);


            default :
                Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);
                break;
                }
         */

/*
        switch (operator) {

            case "=" :
                resultNumber = inputNumber;
                Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
                break;
            case "＋" :
                resultNumber = resultNumber + inputNumber;
                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
            case "-" :
                resultNumber = resultNumber - inputNumber;
                Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
            case "×" :
                resultNumber = resultNumber * inputNumber;
                Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
            case "÷" :
                resultNumber = resultNumber / inputNumber;
                Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);


            default :
                Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);
                break;
        }
 */

        return resultNumber;
    }

    public void allClearButtonClick (View view) {

        resultText.setText(("0"));
        mathText.setText("");

        resultNumber = 0;
//        operator = "＋";
        operator = "=";
        isFirstInput = true;
        isOperatorClick = false;
    }

    public void pointButtonClick (View view) {
        if(isFirstInput) {
            resultText.setText("0" + view.getTag().toString());
            //activityMainBinding.resultTextView.setText("0" + view.getTag().toString());
            isFirstInput = false;
        }
        else {
            if(resultText.toString().contains(".")) {
                //Toast.makeText(this, "이미 소숫점이 존재합니다", Toast.LENGTH_SHORT).show();
            }
            else {
                resultText.append(view.getTag().toString());
            }
        }
    }

    public void backspaceButtonClick(View view) {
        if(!isFirstInput) {
            String getResultText = resultText.getText().toString();
            if(getResultText.length() == 1) {
                String subString = getResultText.substring(0, getResultText.length() - 1);
                resultText.setText(subString);
            } else {
                resultText.setText("0");
                isFirstInput = true;
            }

        }
    }

}
