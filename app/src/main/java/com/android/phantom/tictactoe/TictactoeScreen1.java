package com.android.phantom.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TictactoeScreen1 extends AppCompatActivity {
    private Button btn_ttt_play;
    private EditText et_ttt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_screen1);

        et_ttt_name = (EditText) findViewById(R.id.et_ttt_name);
        Log.d("ET TTT", et_ttt_name.getText()+"");

        btn_ttt_play = (Button) findViewById(R.id.btn_ttt_play);
        btn_ttt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TictactoeScreen1.this, TictactoeScreen2.class);
                i.putExtra(TictactoeScreen2.EXTRA_MESSAGE, et_ttt_name.getText().toString());
                startActivity(i);
            }
        });
    }
}
