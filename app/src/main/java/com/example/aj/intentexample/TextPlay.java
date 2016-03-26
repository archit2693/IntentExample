package com.example.aj.intentexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity
{
    Button button;
    TextView textView;
    ToggleButton toggleButton;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        button =(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
        input=(EditText)findViewById(R.id.etCommands);




    }

    public void onToggle(View view)
    {
        if(toggleButton.isChecked())
        {
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD );
        }else
        {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }

    public void onButtonClick(View view)
    {
        String check=input.getText().toString();
        textView.setText(check);
        if (check.contentEquals("left"))
        {

            textView.setGravity(Gravity.LEFT);
        }
        else if (check.contentEquals("center"))
        {
            textView.setGravity(Gravity.CENTER);
        }
        else if (check.contentEquals("right"))
        {
            textView.setGravity(Gravity.RIGHT);
        }

    }
}
