package com.example.einzelbeispielse2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Text;
    private TextView Result;
    private EditText Matrikelnummer;
    private Button SendMNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Text = findViewById(R.id.textView2);
        Result = findViewById(R.id.textView3);
        Matrikelnummer = findViewById(R.id.inputText);
        SendMNr = findViewById(R.id.button);

        SendMNr.setOnClickListener(new View.OnClickListener() {
            String result = Matrikelnummer.getText().toString();
            @Override
            public void onClick(View v) {
                TCP client = new TCP(result);
                Thread t1 = new Thread(client);
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Result.setText(client.getModifiedSentence());
            }
        });
    }
}