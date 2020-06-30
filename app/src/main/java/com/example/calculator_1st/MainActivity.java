package com.example.calculator_1st;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String operator = "＋";
    String lastOperator = "＋";
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

}
