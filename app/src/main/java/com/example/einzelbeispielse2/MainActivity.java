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
    private Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Text = findViewById(R.id.textView2);
        Result = findViewById(R.id.textView3);
        Matrikelnummer = findViewById(R.id.inputText);
        SendMNr = findViewById(R.id.button);
        Calculate = findViewById(R.id.button2);

        SendMNr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = Matrikelnummer.getText().toString();
                TCP client = new TCP(result);
                Thread t1 = new Thread(client);
                t1.start();
                try {
                    t1.join();
                    Result.setText(client.getModifiedSentence());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}