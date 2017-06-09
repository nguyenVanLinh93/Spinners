package com.example.nguyenlinh.spinners;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Spinner Exercises
 *
 * @author nguyenlinh
 * @version 1.0
 * @since 2017-6-8
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        mTextView = (TextView) findViewById(R.id.textView);

        spinner1.setOnItemSelectedListener(new SetColor());

        String[] stringColor = {"Red", "Yellow", "Blue", "Green"};
        ArrayAdapter spinner2Adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                stringColor
        );
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2Adapter);
        spinner2.setPrompt("Choise Color (choices from Java)");
        spinner2.setOnItemSelectedListener(new SetColor());
    }

    private class SetColor implements android.widget.AdapterView.OnItemSelectedListener {
        private boolean isFirst = true;

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (isFirst) {
                isFirst = false;
            } else {
                String color = parent.getItemAtPosition(position).toString();
                switch (color) {
                    case "Red":
                        mTextView.setBackgroundColor(Color.RED);
                        break;
                    case "Yellow":
                        mTextView.setBackgroundColor(Color.YELLOW);
                        break;
                    case "Blue":
                        mTextView.setBackgroundColor(Color.BLUE);
                        break;
                    case "Green":
                        mTextView.setBackgroundColor(Color.GREEN);
                        break;
                    default:
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
