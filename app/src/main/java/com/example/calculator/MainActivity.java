package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding mBinding;

    boolean addOperator, subOperator, mulOperator, divOperator;
    double valueOne = 0.0;
    double valueTwo = 0.0;
    double outPut = 0.0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        mBinding.zero.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "0"));

        mBinding.one.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "1"));

        mBinding.two.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "2"));

        mBinding.three.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "3"));

        mBinding.four.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "4"));

        mBinding.five.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "5"));

        mBinding.six.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "6"));

        mBinding.seven.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "7"));

        mBinding.eight.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "8"));

        mBinding.nine.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "9"));

        mBinding.clearByValue.setOnClickListener(view -> {
            mBinding.input.setText("");
            mBinding.results.setText("");
            valueTwo=0;
            valueOne =0;
            setOperator("");

        });

      //  mBinding.point.setOnClickListener(view -> mBinding.input.setText(mBinding.input.getText() + "."));

        mBinding.plus.setOnClickListener(view -> {
            if (!isAnyOperator())
                valueOne = Double.parseDouble(mBinding.input.getText() + "");
            mBinding.input.setText("");
            setOperator("+");
        });

        mBinding.minus.setOnClickListener(view -> {
            if (!isAnyOperator())
                valueOne = Double.parseDouble(mBinding.input.getText() + "");
            mBinding.input.setText("");
            setOperator("-"); }
        );

        mBinding.multiplication.setOnClickListener(view -> {
            if (!isAnyOperator())
                valueOne = Double.parseDouble(mBinding.input.getText() + "");
            mBinding.input.setText("");
            setOperator("*");
        });

        mBinding.divide.setOnClickListener(view -> {

            if (!isAnyOperator())
                valueOne = Double.parseDouble(mBinding.input.getText() + "");
            mBinding.input.setText("");
            setOperator("/");
                }
        );

        mBinding.equal.setOnClickListener(view -> {
            valueTwo = Double.parseDouble(mBinding.input.getText().toString());
            mBinding.input.setText("");

            if (addOperator) {
                outPut = valueOne + valueTwo;
                mBinding.results.setText(outPut + "");
                valueOne = outPut;
            }
            else if(subOperator){
                outPut = valueOne - valueTwo;
                mBinding.results.setText(outPut + "");
                valueOne = outPut;
            }
            else if(mulOperator){
                outPut = valueOne * valueTwo;
                mBinding.results.setText(outPut + "");
                valueOne = outPut;
            }
            else if(divOperator){
                outPut = valueOne / valueTwo;
                mBinding.results.setText(outPut + "");
                valueOne = outPut;
            }

        });

    }
    private void setOperator(String operator){
        addOperator = operator.equals("+");
        subOperator = operator.equals("-");
        mulOperator = operator.equals("*");
        divOperator = operator.equals("/");
    }
    private boolean isAnyOperator(){
        return addOperator || subOperator || divOperator || mulOperator;
    }
}