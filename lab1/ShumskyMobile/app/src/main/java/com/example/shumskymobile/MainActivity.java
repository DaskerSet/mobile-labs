package com.example.shumskymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[] productType = {"Phone", "TV", "Watch", "Speakers"};
    public String[] companyName = {"Comfy", "MOYO", "Eldorado", "Foxtrot"};
    TextView textAnswer;

    Button buttonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayAdapter<String> productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, productType );
        productTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner productType  = (Spinner) findViewById(R.id.productType);
        productType.setPrompt("Product type");
        productType.setAdapter(productTypeAdapter);
        productType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> companyNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, companyName );
        companyNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner companyName  = (Spinner) findViewById(R.id.companyName);
        companyName.setPrompt("Company name");
        companyName.setAdapter(companyNameAdapter);
        companyName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button buttonOk;
        textAnswer = (TextView) findViewById(R.id.textAnswer);
        buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String textConcat = "Your category: " +productType.getSelectedItem().toString() + ", Your company: "+ companyName.getSelectedItem().toString();
                textAnswer.setText(textConcat);
                Toast toast2 = Toast.makeText(MainActivity.this,textConcat, Toast.LENGTH_SHORT);
                toast2.show();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAnswer.setText("Choose your category and company and press OK button");
            }
        });
    }
}
