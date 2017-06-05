package com.android.phantom.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class TictactoeScreen2 extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "intent_message";

    private Button btn_ttt_restart;
    private static int TOTAL_JOGADAS = 9;
    private TictactoeGame l1, l2, l3, c1, c2, c3, d1, d2;
    private ImageButton[] iB = new ImageButton[9];
    private int jogadas;
    private int jogador = 0;
    private String[] pl = {"Humano", "Computador"};
    private int[] img = {R.drawable.humano, R.drawable.computador};
    private TextView tv_jogada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_screen2);

        tv_jogada = (TextView) findViewById(R.id.tv_jogada);

        //TODO: Testar
        if (!getIntent().getStringExtra(this.EXTRA_MESSAGE).equals("")) {
            pl[0] = getIntent().getStringExtra(this.EXTRA_MESSAGE);
            tv_jogada.setText(getResources().getString(R.string.player, pl[0]));
        }

        btn_ttt_restart = (Button) findViewById(R.id.btn_ttt_restart);
        btn_ttt_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        iB[0] = (ImageButton) findViewById(R.id.b0);
        iB[1] = (ImageButton) findViewById(R.id.b1);
        iB[2] = (ImageButton) findViewById(R.id.b2);
        iB[3] = (ImageButton) findViewById(R.id.b3);
        iB[4] = (ImageButton) findViewById(R.id.b4);
        iB[5] = (ImageButton) findViewById(R.id.b5);
        iB[6] = (ImageButton) findViewById(R.id.b6);
        iB[7] = (ImageButton) findViewById(R.id.b7);
        iB[8] = (ImageButton) findViewById(R.id.b8);

        init();
    }

    public void clickListener(View v) {
        ImageButton b = (ImageButton) v;
        b.setEnabled(false);
        b.setImageResource(img[jogador]);
        TictactoeGame g = ((TictactoeGames) b.getTag()).gamesAddSerie(jogador);
        tv_jogada.setText((g != null) ? fimJogo(g.getImageButtons(), jogador) : verificarVelha(++jogadas));
    }

    public void init() {
        TOTAL_JOGADAS = 9;
        jogadas = 0;
        jogador = 0;

        for (int a = 0; a < 9; a++) {
            iB[a].setImageResource(0);
            iB[a].setEnabled(true);
            iB[a].animate().rotationY(0).setDuration(0);
        }

        l1 = null;
        l2 = null;
        l3 = null;
        c1 = null;
        c2 = null;
        c3 = null;
        d1 = null;
        d2 = null;

        l1 = new TictactoeGame(iB[0], iB[1], iB[2]);
        l2 = new TictactoeGame(iB[3], iB[4], iB[5]);
        l3 = new TictactoeGame(iB[6], iB[7], iB[8]);
        c1 = new TictactoeGame(iB[0], iB[3], iB[6]);
        c2 = new TictactoeGame(iB[1], iB[4], iB[7]);
        c3 = new TictactoeGame(iB[2], iB[5], iB[8]);
        d1 = new TictactoeGame(iB[0], iB[4], iB[8]);
        d2 = new TictactoeGame(iB[2], iB[4], iB[6]);

        //Primeira fila
        iB[0].setTag(new TictactoeGames(l1, c1, d1));
        iB[1].setTag(new TictactoeGames(l1, c2));
        iB[2].setTag(new TictactoeGames(l1, c3, d2));
        //Segunda fila
        iB[3].setTag(new TictactoeGames(l2, c1));
        iB[4].setTag(new TictactoeGames(l2, c2, d1, d2));
        iB[5].setTag(new TictactoeGames(l2, c3));
        //Terceira fila
        iB[6].setTag(new TictactoeGames(l3, c1, d2));
        iB[7].setTag(new TictactoeGames(l3, c2));
        iB[8].setTag(new TictactoeGames(l3, c3, d1));

        tv_jogada.setText(getResources().getString(R.string.player, pl[jogador]));
    }

    private String fimJogo(List<ImageButton> buttons, int jogador) {
        for (ImageButton button : buttons)
            button.animate().rotationY(360).setDuration(1000);
        disableButtons();
        return getResources().getString(R.string.vencedor, pl[jogador]);
    }

    private String verificarVelha(int jogadas) {
        //Muda o jogador
        jogador = (jogador == 0) ? 1 : 0;
        if (jogadas == TOTAL_JOGADAS)
            disableButtons();
        return (jogadas == TOTAL_JOGADAS) ? "Deu velha!!!" : getResources().getString(R.string.player, pl[jogador]);
    }

    private void disableButtons() {
        for (int b = 0; b < 9; b++)
            iB[b].setEnabled(false);
    }
}
