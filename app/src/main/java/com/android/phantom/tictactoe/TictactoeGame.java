package com.android.phantom.tictactoe;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class TictactoeGame {
    private List<ImageButton> imageButtons = new ArrayList<>();
    private int[] serie = new int[2];

    public TictactoeGame(ImageButton...imageButtons){
        for (ImageButton btn : imageButtons)
            this.imageButtons.add(btn);
        this.serie[0] = 0;
        this.serie[1] = 0;
    }
    public TictactoeGame addSerie(int jogador){
        TictactoeGame g = (++serie[jogador] < 3) ? null : this;
        return g;
    }
    public List<ImageButton> getImageButtons(){
        return this.imageButtons;
    }
}
