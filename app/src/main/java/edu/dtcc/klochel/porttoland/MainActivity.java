package edu.dtcc.klochel.porttoland;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Creating an onClick method (linked @ onClick attribute)
    public void HandleClick(View arg0) {
        double inputRate = 0.0;
        double convertedRate = 0.0;
        EditText inputText = (EditText) findViewById(R.id.editRate);
        TextView convertedText = (TextView) findViewById(R.id.tvResult);
        try {
            inputRate = Double.parseDouble(inputText.getText().toString()) / 100.0;
        } catch (Exception ex) {
            inputText.setText("0.0");
        }
        if (((RadioButton) (findViewById(R.id.rbYearly))).isChecked()) {
            //If converting to monthly
            convertedRate = (pow((1.0 + inputRate), (1.0 / 12.0)) - 1.0) * 100.0;
        } else {
            if (((RadioButton) (findViewById(R.id.rbMonthly))).isChecked()) {
                //Converting to yearly
                convertedRate = (pow((1.0 + inputRate), 12.0) - 1.0) * 100.0;
                convertedText.setText(String.format("Converted Rate is %1$.4f%%", convertedRate));
            }
        }
    }
}