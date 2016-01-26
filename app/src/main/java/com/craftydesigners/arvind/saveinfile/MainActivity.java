package com.craftydesigners.arvind.saveinfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
EditText editText,editText2;
    Button button,button2;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=editText.getText().toString()+"$"+editText2.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(), "File saved", Toast.LENGTH_SHORT).show();
                }

                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data="";
                try{
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";

                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    data=temp;
                    //tv.setText(temp);
                    Toast.makeText(getBaseContext(),"File read..",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
                String username = data.substring(0,data.indexOf("$"));
                String password = data.substring(data.indexOf("$")+1);
                editText.setText(username);
                editText2.setText(password);
            }
        });
    }
}
