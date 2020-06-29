package com.example.calculator_1st;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String operator = "＋";
    String lastOperator = "＋";
   // ActivityMainBinding activityMainBinding;

    TextView resultText;
    /**
     * Clear any existing layout, add the current fragment
     * to the back stack, and load the new fragment.
     * @param fragment fragment to load
     */
    public void loadFragment(BlankFragment fragment) {
        // Clear any existing layout.
        frameLayout.removeAllViews();


        // Load the new fragment to the layout.
        getFragmentManager().beginTransaction()
                .addToBackStack(null) // Go to the previous fragment when clicking the back button.
                .replace(R.id.frameLayout, fragment)
                .commit();


    }

    /**
     * If fragments overlap each other when pressing the back button,
     * you need to overload the onBackPressed function.
     */
    @Override
    public void onBackPressed() {
        // Clear any existing layouts before popping the stack.
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }

        // Create a fragment manager to load the previous fragment.
        FragmentManager fragmentManager = getFragmentManager();

        // If there are fragments left in the stack, load the previous fragment.
        // This may be needed when calling addToBackStack(null) to load fragments.
        if (fragmentManager.getBackStackEntryCount() > 1 ) {
            fragmentManager.popBackStack();
            return;
        }

        // Exit the app if there are no more fragments.
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        // Attach the frame layout to a handle.
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        // Load the fragment into the layout handle.
        getFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new MainActivityFragment())
                .commit();

        resultText = findViewById(R.id.result_text_view);
        /*
        Button button1 = (Button) findViewById(R.id.num_1_button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
            }
        });

         */

    }


    public void numButtonClick (View view) {

        String getButtonText = view.getTag().toString();

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
    }


    public void operatorClick(View view) {

        //÷, ×, ＋, -
        isOperatorClick = true;
        lastOperator = view.getTag().toString();

//        inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
        inputNumber = Double.parseDouble(resultText.getText().toString());

        Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);

        resultNumber = calculator(resultNumber, inputNumber, operator);
        Log.e("calculator111111", resultNumber + " " + inputNumber + " " + operator);

//        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        resultText.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();
//        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
//        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");

    }

    public  void equalsButtonClick (View view) {

//        if(isFirstInput) {
//            if(isOperatorClick) {
//                activityMainBinding.mathTextView.setText(resultNumber + " " + lastOperator + " " + inputNumber + " =");
//                resultNumber = calculator(resultNumber, inputNumber, lastOperator);
//                activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
//            }
//        }
//        else {



        inputNumber = Double.parseDouble(resultText.getText().toString());

        resultNumber = calculator(resultNumber, inputNumber, operator);
        resultText.setText(String.valueOf(resultNumber));
        isFirstInput = true;

        operator = view.getTag().toString();
//        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
        // }

    }

    private double calculator(double resultNumber, double inputNumber, String operator) {

        Log.e("calculator--->", resultNumber + " " + inputNumber + " " + operator);

        if(operator.equals("=")) {
            resultNumber = inputNumber;
            Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber + inputNumber;
            Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber - inputNumber;
            Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber * inputNumber;
            Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
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


//        switch (operator) {
//
//            case "=" :
//                resultNumber = inputNumber;
//                Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
//                break;
//            case "＋" :
//                resultNumber = resultNumber + inputNumber;
//                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
//            case "-" :
//                resultNumber = resultNumber - inputNumber;
//                Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
//            case "×" :
//                resultNumber = resultNumber * inputNumber;
//                Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
//            case "÷" :
//                resultNumber = resultNumber / inputNumber;
//                Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);
//
//
//            default :
//                Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);
//                break;
//        }


        return resultNumber;
    }

    public void allClearButtonClick (View view) {

        resultText.setText(("0"));
//        activityMainBinding.mathTextView.setText("");
        resultNumber = 0;
        operator = "＋";
        isFirstInput = true;
    }

    public void pointButtonClick (View view) {
        if(isFirstInput) {
            resultText.setText("0" + view.getTag().toString());
            isFirstInput = false;
        }
        else {
            if(resultText.toString().contains(".")) {
                Toast.makeText(this, "이미 소숫점이 존재합니다", Toast.LENGTH_SHORT).show();
            }
            else {
                resultText.append(view.getTag().toString());
            }
        }
    }

}
