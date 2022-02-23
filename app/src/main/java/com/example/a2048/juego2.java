package com.example.a2048;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class juego2 extends AppCompatActivity {
    public ImageView[][] matrixImageView;
    int[][] BOARD;
    boolean firstClick = true;
    int iV_selectedI;
    int iV_selectedJ;
    int finalI;
    int finalJ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego2);
        setTitle("Peg Solitaire");
        Game();

    }

    public void Game() {
        matrix();
//        pintarTablero();
//        recorrerTablero();
        detectarCasillaClicada();
    }

    public void pintarTablero() {
        BOARD = new int[][]{
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0}
        };
    }

    public void recorrerTablero() {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[0].length; j++) {
                Log.d(TAG, "recorrerTablero: ");
                if (BOARD[i][j] == 1) {
                    Log.d(TAG, "recorrerTableroIf1: ");
                    matrixImageView[i][j].setBackgroundResource(R.drawable.ficha_shape_noclicked);
                } else if (BOARD[i][j] == 2) {
                    Log.d(TAG, "recorrerTableroIf2: ");
                    matrixImageView[i][j].setBackgroundResource(R.drawable.ficha_shape_vacia);
                }
            }
        }
    }

    public void matrix() {
        matrixImageView = new ImageView[][]{
                {findViewById(R.id.cell00), findViewById(R.id.cell01), findViewById(R.id.cell02), findViewById(R.id.cell03), findViewById(R.id.cell04), findViewById(R.id.cell05), findViewById(R.id.cell06)},
                {findViewById(R.id.cell10), findViewById(R.id.cell11), findViewById(R.id.cell12), findViewById(R.id.cell13), findViewById(R.id.cell14), findViewById(R.id.cell15), findViewById(R.id.cell16)},
                {findViewById(R.id.cell20), findViewById(R.id.cell21), findViewById(R.id.cell22), findViewById(R.id.cell23), findViewById(R.id.cell24), findViewById(R.id.cell25), findViewById(R.id.cell26)},
                {findViewById(R.id.cell30), findViewById(R.id.cell31), findViewById(R.id.cell32), findViewById(R.id.cell33), findViewById(R.id.cell34), findViewById(R.id.cell35), findViewById(R.id.cell36)},
                {findViewById(R.id.cell40), findViewById(R.id.cell41), findViewById(R.id.cell42), findViewById(R.id.cell43), findViewById(R.id.cell44), findViewById(R.id.cell45), findViewById(R.id.cell46)},
                {findViewById(R.id.cell50), findViewById(R.id.cell51), findViewById(R.id.cell52), findViewById(R.id.cell53), findViewById(R.id.cell54), findViewById(R.id.cell55), findViewById(R.id.cell56)},
                {findViewById(R.id.cell60), findViewById(R.id.cell61), findViewById(R.id.cell62), findViewById(R.id.cell63), findViewById(R.id.cell64), findViewById(R.id.cell65), findViewById(R.id.cell66)},
        };
    }

    public void detectarCasillaClicada() {
        for (int i = 0; i < matrixImageView.length; i++) {
            for (int j = 0; j < matrixImageView[0].length; j++) {
                int finalI = i;
                int finalJ = j;
                matrixImageView[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (firstClick && matrixImageView[finalI][finalJ].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            //Toast.makeText(juego2.this, "Clicado", Toast.LENGTH_SHORT).show();
                            matrixImageView[finalI][finalJ].setBackgroundResource(R.drawable.ficha_shape_clicked);
                            Log.d(TAG, "buscarFichaClicada: Busco" + finalI + " " + finalJ);
                            firstClick = false;
                            iV_selectedI = finalI;
                            iV_selectedJ = finalJ;
                            buscarFichaClicada();
                            listenerCasillasJugables();
                        } else if (!firstClick && matrixImageView[finalI][finalJ].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            matrixImageView[iV_selectedI][iV_selectedJ].setBackgroundResource(R.drawable.ficha_shape_noclicked);
                            firstClick = true;
                            //recorrerTablero();
                        }
                    }
                });
            }
        }
        iV_selectedI = finalI;
        iV_selectedJ = finalJ;
        System.out.println(iV_selectedI + iV_selectedJ);
        //return iV_selectedI[finalI][finalJ];
    }

    public void borrarListener() {
        for (int i = 0; i < matrixImageView.length; i++) {
            for (int j = 0; j < matrixImageView[0].length; j++) {
                matrixImageView[i][j].setOnClickListener(null);
                {
                }
            }
        }
    }

    public void buscarFichaClicada() {
        for (int i = 0; i < matrixImageView.length; i++) {
            for (int j = 0; j < matrixImageView[0].length; j++) {
                if (matrixImageView[i][j].getBackground().getConstantState().equals(
                        getResources().getDrawable(R.drawable.ficha_shape_clicked, null).getConstantState())) {
                    if (i + 2 < matrixImageView.length) {
                        if (matrixImageView[i + 1][j].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            if (matrixImageView[i + 2][j].getBackground().getConstantState().equals(
                                    getResources().getDrawable(R.drawable.ficha_shape_vacia, null).getConstantState())) {
                                matrixImageView[i + 2][j].setBackgroundResource(R.drawable.ficha_jugable);
                            }
                        }
                    }
                    if (i - 2 > 0) {
                        if (matrixImageView[i - 1][j].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            if (matrixImageView[i - 2][j].getBackground().getConstantState().equals(
                                    getResources().getDrawable(R.drawable.ficha_shape_vacia, null).getConstantState())) {
                                matrixImageView[i - 2][j].setBackgroundResource(R.drawable.ficha_jugable);
                            }
                        }
                    }
                    if (j + 2 < matrixImageView.length) {
                        if (matrixImageView[i][j + 1].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            if (matrixImageView[i][j + 2].getBackground().getConstantState().equals(
                                    getResources().getDrawable(R.drawable.ficha_shape_vacia, null).getConstantState())) {
                                matrixImageView[i][j + 2].setBackgroundResource(R.drawable.ficha_jugable);
                            }
                        }
                    }
                    if (j - 2 > 0) {
                        if (matrixImageView[i][j - 1].getBackground().getConstantState().equals(
                                getResources().getDrawable(R.drawable.ficha_shape_noclicked, null).getConstantState())) {
                            if (matrixImageView[i][j - 2].getBackground().getConstantState().equals(
                                    getResources().getDrawable(R.drawable.ficha_shape_vacia, null).getConstantState())) {
                                matrixImageView[i][j - 2].setBackgroundResource(R.drawable.ficha_jugable);
                            }
                        }
                    }
                }
            }
        }
    }

    public void listenerCasillasJugables() {
        for (int i = 0; i < matrixImageView.length; i++) {
            for (int j = 0; j < matrixImageView[0].length; j++) {
                int clicI = i;
                int clicJ = j;
                if (matrixImageView[i][j].getBackground().getConstantState().equals(
                        getResources().getDrawable(R.drawable.ficha_jugable, null).getConstantState())) {
                    Log.d(TAG, "onClick: Entro a mover1");
                    int finalI1 = i;
                    int finalJ1 = j;
                    matrixImageView[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            for (int i = 0; i < matrixImageView.length; i++) {
                                for (int j = 0; j < matrixImageView[0].length; j++) {
                                    Log.d(TAG, "onClick: Entro a mover2");
                                    if (matrixImageView[i][j].getBackground().getConstantState().equals(
                                            getResources().getDrawable(R.drawable.ficha_shape_clicked, null).getConstantState())) {
                                        matrixImageView[i][j].setBackgroundResource(R.drawable.ficha_shape_vacia);
                                        //BOARD [finalI1][finalJ1] = 2;
                                        matrixImageView[clicI][clicJ].setBackgroundResource(R.drawable.ficha_shape_noclicked);
                                        //BOARD [clicI][clicJ] = 1;
                                    }
                                }
                            }
                        }
                    });
                }
                matrixImageView[finalI][finalJ].setBackgroundResource(R.drawable.ficha_shape_vacia);
            }
        }
        firstClick = true;
    }
}
