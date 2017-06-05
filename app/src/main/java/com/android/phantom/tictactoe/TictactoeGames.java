package com.android.phantom.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phantom on 31/03/2017.
 */

public class TictactoeGames {
    private List<TictactoeGame> games = new ArrayList<>();

    public TictactoeGames(TictactoeGame...tictactoegames){
        for (TictactoeGame g : tictactoegames)
            this.games.add(g);
    }
    public TictactoeGame gamesAddSerie(int jogador){
        TictactoeGame g;
        for (TictactoeGame game : games){
            g = game.addSerie(jogador);
            if (g != null) return g;
        }
        return null;
    }
}
