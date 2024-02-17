package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight, edtHeightFt, edtHeightInc;
        Button btnCalculate;

        edtWeight = findViewById(R.id.edtweight);
        edtHeightFt = findViewById(R.id.edtheightFt);
        edtHeightInc = findViewById(R.id.edtweightInc);
        btnCalculate = findViewById(R.id.BtnCalc);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int wt = Integer.parseInt(edtWeight.getText().toString());
                    int ft = Integer.parseInt(edtHeightFt.getText().toString());
                    int inc = Integer.parseInt(edtHeightInc.getText().toString());

                    int totalInc = ft * 12 + inc;

                    double totalCm = totalInc * 2.54; // 1 inch = 2.54 cm

                    double totalM = totalCm / 100; // Convert to meters

                    double bmi = wt / (totalM * totalM);

                    if (Double.isNaN(bmi) || Double.isInfinite(bmi)) {
                        txtResult.setText("Invalid input");
                    } else {
                        String resultText = String.format("Your BMI: %.2f", bmi);
                        if (bmi > 25) {
                            resultText += "\nYou Are Overweight!";
                        } else if (bmi < 18.5) {
                            resultText += "\nYou are Underweight!";
                        } else {
                            resultText += "\nYou are Healthy!";
                        }
                        txtResult.setText(resultText);
                    }
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input");
                }
            }
        });

    }
}
