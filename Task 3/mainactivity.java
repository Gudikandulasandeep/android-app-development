package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_result,txt_soln;
    MaterialButton btn_c,btn_open_brace,btn_close_brace,btn_div,btn_mul,btn_add,btn_sub,
            btn_equal,btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_ac,btn_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = findViewById(R.id.result_tv);
        txt_soln = findViewById(R.id.solution_tv);


        assignId(btn_c,R.id.button_c);
        assignId(btn_open_brace,R.id.button_open_bracket);
        assignId(btn_close_brace,R.id.button_close_bracket);
        assignId(btn_div,R.id.button_divide);
        assignId(btn_mul,R.id.button_multiply);
        assignId(btn_add,R.id.button_plus);
        assignId(btn_sub,R.id.button_minus);
        assignId(btn_equal,R.id.button_equals);
        assignId(btn_0,R.id.button_0);
        assignId(btn_1,R.id.button_1);
        assignId(btn_2,R.id.button_2);
        assignId(btn_3,R.id.button_3);
        assignId(btn_4,R.id.button_4);
        assignId(btn_5,R.id.button_5);
        assignId(btn_6,R.id.button_6);
        assignId(btn_7,R.id.button_7);
        assignId(btn_8,R.id.button_8);
        assignId(btn_9,R.id.button_9);
        assignId(btn_ac,R.id.button_ac);
        assignId(btn_dot,R.id.button_dot);

    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = txt_soln.getText().toString();

        if(buttonText.equals("AC")){
            txt_soln.setText("");
            txt_result.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            txt_soln.setText(txt_result.getText());
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);

        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }

        txt_soln.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);
        if(!finalResult.equals("Err")){
            txt_result.setText(finalResult);
        }
    }
    String getResult(String data){
         try{
             Context context = Context.enter();
             context.setOptimizationLevel(-1);
             Scriptable scriptable = context.initStandardObjects();
             String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
             if(finalResult.endsWith(".0")){
                 finalResult = finalResult.replace(".0","");
             }
             return finalResult;
         }catch (Exception e){
             return "Err";
         }
    }
}