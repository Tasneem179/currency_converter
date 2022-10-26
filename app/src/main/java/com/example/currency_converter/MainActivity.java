package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convertBtn=(Button) findViewById(R.id.Convetbtn);
        EditText usText=(EditText) findViewById(R.id.usEditText);
        EditText egyText=(EditText) findViewById(R.id.egEditText);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrencyConverter currencyConverter=new CurrencyConverter();
                //   EditText usText=(EditText) findViewById(R.id.usEditText);
                //   EditText egyText=(EditText) findViewById(R.id.egEditText);
                String usValue=usText.getText().toString();
                String egyValue=egyText.getText().toString();

                if(TextUtils.isEmpty(usValue)&&!TextUtils.isEmpty(egyValue))
                {
                    float currency=Float.parseFloat(egyValue);
                    currencyConverter.setCurrency(currency);
                    currency=currencyConverter.converToDollar();
                    usText.setText(String.valueOf(currency));
                }
                else if(!TextUtils.isEmpty(usValue)&&TextUtils.isEmpty(egyValue))
                {
                    float currency=Float.parseFloat(usValue);
                    currencyConverter.setCurrency(currency);
                    currency=currencyConverter.converToEgyPound();
                    egyText.setText(String.valueOf(currency));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid data - try again",Toast.LENGTH_LONG).show();
                }
            }
        });




        Button clearBtn=(Button) findViewById(R.id.Clearbtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                egyText.setText(String.valueOf(""));
                usText.setText(String.valueOf(""));
            }
        });

    }
}