package com.example.a2048;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Menu extends AppCompatActivity {
    TextView juego1Button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        juego1Button = (TextView) findViewById(R.id.TextViewPlay);
        juego1Button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent juego1 = new Intent(Menu.this, juego1.class);
                startActivity(juego1);
            }
        });
    }

    ;
}
