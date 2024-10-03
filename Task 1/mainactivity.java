package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_M_KM = (Button)findViewById(R.id.btn_M_KM);
        Button btn_M_CM = (Button)findViewById(R.id.btn_M_CM);
        Button btn_CM_KM = (Button)findViewById(R.id.btn_CM_KM);
        Button btn_CM_M = (Button)findViewById(R.id.btn_CM_M);
        Button btn_KM_M = (Button)findViewById(R.id.btn_KM_M);
        Button btn_KM_CM = (Button)findViewById(R.id.btn_KM_CM);
        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.output);
        TextView txt_input = (TextView) findViewById(R.id.txt_input);
        TextView txt_output = (TextView) findViewById(R.id.txt_output);

        btn_M_KM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double mtoKm= Double.parseDouble(input.getText().toString());

                output.setText(String.valueOf(mtoKm/1000));
                txt_input.setText("m");
                txt_output.setText("km");
            }
        });
        btn_M_CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double mtoCm= Double.parseDouble(input.getText().toString());
                output.setText(String.valueOf(mtoCm*100));
                txt_input.setText("m");
                txt_output.setText("cm");
            }
        });
        btn_CM_KM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cmtoKm= Double.parseDouble(input.getText().toString());
                BigDecimal dbl = BigDecimal.valueOf(cmtoKm/100000);
                output.setText(String.valueOf(dbl));
                txt_input.setText("cm");
                txt_output.setText("km");
            }
        });
        btn_CM_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cmtom= Double.parseDouble(input.getText().toString());
                output.setText(String.valueOf(cmtom/100));
                txt_input.setText("cm");
                txt_output.setText("m");
            }
        });
        btn_KM_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Kmtom= Double.parseDouble(input.getText().toString());
                output.setText(String.valueOf(Kmtom*1000));
                txt_input.setText("km");
                txt_output.setText("m");
            }
        });
        btn_KM_CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double kmtoCm= Double.parseDouble(input.getText().toString());
                output.setText(String.valueOf(kmtoCm*100000));
                txt_input.setText("km");
                txt_output.setText("cm");
            }
        });
    }}