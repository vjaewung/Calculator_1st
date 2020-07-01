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

import java.util.ArrayList;
import java.util.Stack;

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
                    //String getMathText = mathText.getText().toString();
                    //String subString = getMathText.substring(0, getMathText.length() - 2);
                    //mathText.setText(subString);
                    //mathText.append(operator + " ");
                    resultText.append(operator);
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

    private static int getPriority(String parm1) {
        switch(parm1) {
            case "(":    case ")":
                return 0;
            case "+":    case "-":
                return 1;
            case "*":    case "/":
                return 2;
        }
        // -1일 경우, 오류
        return -1;
    }


    public  void equalsButtonClick (View view) {

        Log.e("(equalsButtonClick)", resultText.getText().toString() + " ");

        boolean paranExist = ckParanExist(resultText.getText().toString());
        if(paranExist) {
            String b = getCalculate("(10＋20)×10");
            Log.e("(getCalculate)", resultText.getText().toString() + " " + b);
            String a = getCalculate(resultText.getText().toString());

            //double a = calc(resultText.getText().toString());
            Log.e("(calc) and clay", resultText.getText().toString() + " " + a);
            //Log.e("(toPostfix)", toPostfix(resultText.getText().toString()) + " ");


            //inputNumber = Double.parseDouble(resultText.getText().toString());
            resultNumber = Double.parseDouble(a);
            //resultNumber = calculator(resultNumber, inputNumber, operator);
            lastOperator = operator; //?
            resultText.setText(String.valueOf(resultNumber));
            isFirstInput = true;
            operator = view.getTag().toString();
            mathText.append(inputNumber + " " + operator + " ");
//            Interpreter interpreter;
//            interpreter = new Interpreter();
//            interpreter.eval("result = 5+4*(7-15)");
//            System.out.println(interpreter.get("result"));
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

    private static double calc(String str) {

        // Step1. 중위 순회를 후위 순회로 변환
        ArrayList<String> postfix = toPostfix(str);
        Log.e("toPostfix--->", postfix + " ");

        Stack<String> stack = new Stack<>();
        double front, back;

        // Step2. 후위 순회 연산
        for (int i=0; i<postfix.size(); i=i+1) {
            switch (postfix.get(i)) {

                //÷, ×, ＋, -
                case "＋":
                    back = Double.parseDouble(stack.pop());
                    front = Double.parseDouble(stack.pop());
                    stack.push((front + back)+"");
                    break;
                case "-":
                    back = Double.parseDouble(stack.pop());
                    front = Double.parseDouble(stack.pop());
                    stack.push((front - back)+"");
                    break;
                case "÷":
                    back = Double.parseDouble(stack.pop());
                    front = Double.parseDouble(stack.pop());
                    stack.push((front / back)+"");
                    break;
                case "×":
                    back = Double.parseDouble(stack.pop());
                    front = Double.parseDouble(stack.pop());
                    stack.push((front * back)+"");
                    break;
                default:
                    stack.push(postfix.get(i));

            }
        }
        Log.e("stack.pop()--->", stack.pop() + " ");
        return Double.parseDouble(stack.pop());
    }


    /**
     * 중위 순회를 후위 순회로 변경하는 메소드
     * @param str
     * @return
     */
    private static ArrayList<String> toPostfix(String str) {
        Log.e("ArrayList-->", str + " ");
        ArrayList<String> result = new ArrayList<>();
        String[] calcTarget = str.split(" ");
        Stack<String> stack = new Stack<>();
        String forPrint="";

        for (int i=0; i<calcTarget.length; i=i+1) {
            switch (calcTarget[i]) {
                case "(":
                    stack.push(calcTarget[i]);
                    break;
                case ")":
                    forPrint = stack.pop();
                    while(!forPrint.equals("(")) {
                        result.add(forPrint);
                        forPrint = stack.pop();
                    }
                    break;
                case "+":
                case "-":
                case "/":
                case "*":
                    while(!stack.isEmpty() && getPriority(calcTarget[i]) <= getPriority(stack.peek())) {
                        forPrint = stack.pop();
                        result.add(forPrint);
                    }
                    stack.push(calcTarget[i]);
                    break;
                default:
                    result.add(calcTarget[i]);
                    break;
            }
        }

        while(!stack.isEmpty()) {
            forPrint = stack.pop();
            result.add(forPrint);
        }
        Log.e("result--->", result + " ");
        return result;
    }


    private static String getCalculate(String content) {

        char[] operationCode = {'＋', '-', '×', '÷', '(', ')'}; //연산 부호
//÷, ×, ＋, -
        ArrayList<String> postfixList = new ArrayList<String>(); //후위표기법으로 변환 후 저장 할 ArrayList
        Stack<Character> opStack = new Stack<Character>(); // 연산 부호 우선순위처리 하며 후위 표기법으로 변경하는 Stack
        Stack<String> calculatorStack = new Stack<String>(); //후위 표기법을 계산하는 Stack

        int index = 0;//content.substring() 인수

        for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < operationCode.length; j++) {
                if (content.charAt(i) == operationCode[j]) { //문자열과 연산 부호 비교

                    //postfixList에 연산 부호가 나오기 전까지의 숫자를 담는다(공백제거)
                    postfixList.add(content.substring(index, i).trim().replace("(", "").replace(")", ""));
                    if (content.charAt(i) == '(') {
                        if (content.charAt(i) == ')') {//우 괄호가 나오면 좌 괄호가 나오거나 스택에 비어있을때 까지 pop하여 list에 저장
                            while (true) {
                                postfixList.add(opStack.pop().toString());
                                if (opStack.pop() == '(' || opStack.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }

                    if (opStack.isEmpty()) { //opStack이 비어 있을 경우
                        opStack.push(operationCode[j]); //연산 부호 저장
                    } else { //opStack이 비어 있지 않을 경우
                        if (opOrder(operationCode[j]) > opOrder(opStack.peek())) { //우선 순위 비교
                            opStack.push(operationCode[j]); //스택에 top 값 보다 높은 우선순위이면 그대로 저장
                        } else if (opOrder(operationCode[j]) <= opOrder(opStack.peek())) {//우선 순위 비교
                            postfixList.add(opStack.peek().toString());//스택에 있는 값이 우선순위가 같거나 작을 경우 list에 저장
                            opStack.pop();//스택 제거
                            opStack.push(operationCode[j]);//높은 우선순위 연산 부호 스택에 저장
                        }
                    }
                    index = i + 1;// 다음 순서 처리
                }
            }
        }
        postfixList.add(content.substring(index, content.length()).trim().replace("(", "").replace(")", "")); //마지막 숫자 처리

        if (!opStack.isEmpty()) { //Stack에 남아있는 연산 모두 postfixList에 추가
            for (int i = 0; i < opStack.size();) {
                postfixList.add(opStack.peek().toString());
                opStack.pop();
            }
        }

        //list에 공백, 괄호 제거
        for (int i = 0; i < postfixList.size(); i++) {
            if (postfixList.get(i).equals("")) {
                postfixList.remove(i);
                i = i - 1;
            } else if (postfixList.get(i).equals("(")) {
                postfixList.remove(i);
                i = i - 1;
            } else if (postfixList.get(i).equals(")")) {
                postfixList.remove(i);
                i = i - 1;
            }
        }

        //[10, 20, +, 10, *]
        //300);
        Log.e("postfixList--->", postfixList + " ");
        opStack.clear(); //Stack 비우기

        //postfixList를 calculatorStack에 저장하면서 후위연산 처리
        for (int i = 0; i < postfixList.size(); i++) {
            calculatorStack.push(postfixList.get(i));
            for (int j = 0; j < operationCode.length; j++) {
                if (postfixList.get(i).charAt(0) == operationCode[j]) { //연산 부호 비교
                    calculatorStack.pop(); //stack에 저장된 연산 부호 제거
                    double s2, s1; //stack에서 pop 되는 값들을 저장할 변수
                    String rs; // 연산 처리 후 문자열로 변환 후 stack에 저장할 변수

                    s2 = Double.parseDouble(calculatorStack.pop()); //스택에서 pop하여 문자열을 숫자로 형변환
                    s1 = Double.parseDouble(calculatorStack.pop());

                    //연산 부호에 해당하는 산술 처리 후 stack에 저장
                    //÷, ×, ＋, -
                    switch (operationCode[j]) {
                        case '＋':
                            rs = String.valueOf(s1 + s2);
                            calculatorStack.push(rs);
                            break;
                        case '-':
                            rs = String.valueOf(s1 - s2);
                            calculatorStack.push(rs);
                            break;
                        case '×':
                            rs = String.valueOf(s1 * s2);
                            calculatorStack.push(rs);
                            break;
                        case '÷':
                            rs = String.valueOf(s1 / s2);
                            calculatorStack.push(rs);
                            break;
                    }
                }
            }
        }
        Log.e("calculatorStack.peek()--->", calculatorStack.peek() + " ");

        double re = Double.parseDouble(calculatorStack.peek()); //Stack Top 데이터
        //String result = String.format("%.10f", re); //소수점 10째짜리
        String result = String.valueOf(re);

        //정수 부분 자리 구하기
        int num = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '.') {
                num = i;
                break;
            }
        }

        //정수부분
        String mok = result.substring(0, num);

        //나머지 연산
        double divde = Double.parseDouble(result) % Double.parseDouble(mok);

        //나머지가 0이면 소수점 자릿 수 안보이게
        if (divde == 0) {
            result = String.format("%.0f", re);
        }

        return result;
    }

    /**
     * 연산 부호 우선순위 정하는 메서드
     *
     * @param op - 연산 부호
     */
    public static int opOrder(char op) {
        //÷, ×, ＋, -
        switch (op) {
            case '＋':
            case '-':
                return 1;
            case '×':
            case '÷':
                return 2;
            default:
                return -1;
        }
    }


}
