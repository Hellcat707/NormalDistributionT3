package com.example.normaldistribution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText meanEditText;
    EditText stdevEditText;
    Button calcButton;
    TextView resultTextView;
    GaussianDistribution gaussianDistribution;

    public double calcIQR() {
        double mean = Double.parseDouble(meanEditText.getText().toString());
        double stdev = Double.parseDouble(stdevEditText.getText().toString());

        //Instantiate the gaussian distribution class, pass the parameters to to constructor
        gaussianDistribution = new GaussianDistribution(mean, stdev);
        return gaussianDistribution.calculateIQR();
    }

    public void displayStatisticBasedOnInput(View v) {
        Log.i("MEAN: ",meanEditText.getText().toString());
        Log.i("STDEV: ",stdevEditText.getText().toString());
        double IQR = calcIQR();
        resultTextView.setText(String.valueOf(IQR));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meanEditText = (EditText)findViewById(R.id.meanEditText);
        stdevEditText = (EditText)findViewById(R.id.stdevEditText);
        calcButton = (Button) findViewById(R.id.calcButton);
        resultTextView = (TextView) findViewById(R.id.resultTextEdit);

    }
}
