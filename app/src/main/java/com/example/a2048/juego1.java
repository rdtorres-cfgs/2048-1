package com.example.a2048;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

//GEnerar metodo que contorle el random

public class juego1 extends AppCompatActivity implements GestureDetector.OnGestureListener {
    //LinearLayout LinearLayout;
    //GridLayout GridLayout;
    String resultRandomNumber;
    private GestureDetector gestureDetector;
    private static int min_distance = 100;
    private float x1, x2, y1, y2;
    private Button[][] matrix = new Button[4][4];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego1);
        gestureDetector = new GestureDetector(this, this);
        insertarMatrixTablero();
        generarNumRandom();

    }

    public boolean onTouchEvent(MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = e.getX();
                y1 = e.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = e.getX();
                y2 = e.getY();

                float valueX = x2 - x1;
                float valueY = y2 - y1;

                if (Math.abs(valueX) > min_distance) {
                    if (x2 > x1) {
                        movimientoDerecha(0);
                        sumaMovimientoDerecha(0);
                        movimientoDerecha(0);

                        movimientoDerecha(1);
                        sumaMovimientoDerecha(1);
                        movimientoDerecha(1);

                        movimientoDerecha(2);
                        sumaMovimientoDerecha(2);
                        movimientoDerecha(2);

                        movimientoDerecha(3);
                        sumaMovimientoDerecha(3);
                        movimientoDerecha(3);

                        generarNumRandom();

                        Toast.makeText(this, "Derecha", Toast.LENGTH_SHORT).show();
                    } else {
                        movimientoIzquierda(0);
                        sumaMovimientoIzquierda(0);
                        movimientoIzquierda(0);

                        movimientoIzquierda(1);
                        sumaMovimientoIzquierda(1);
                        movimientoIzquierda(1);

                        movimientoIzquierda(2);
                        sumaMovimientoIzquierda(2);
                        movimientoIzquierda(2);

                        movimientoIzquierda(3);
                        sumaMovimientoIzquierda(3);
                        movimientoIzquierda(3);

                        generarNumRandom();
                        Toast.makeText(this, "Izquierda", Toast.LENGTH_LONG).show();
                    }
                } else if (Math.abs(valueY) > min_distance) {
                    if (y2 > y1) {
                        movimientoAbajo(0);
                        sumaMovimientoAbajo(0);
                        movimientoAbajo(0);

                        movimientoAbajo(1);
                        sumaMovimientoAbajo(1);
                        movimientoAbajo(1);

                        movimientoAbajo(2);
                        sumaMovimientoAbajo(2);
                        movimientoAbajo(2);

                        movimientoAbajo(3);
                        sumaMovimientoAbajo(3);
                        movimientoAbajo(3);

                        generarNumRandom();
                        Toast.makeText(this, "Abajo", Toast.LENGTH_SHORT).show();
                    } else {
                        movimientoArriba(0);
                        sumaMovimientoArriba(0);
                        movimientoArriba(0);

                        movimientoArriba(1);
                        sumaMovimientoArriba(1);
                        movimientoArriba(1);

                        movimientoArriba(2);
                        sumaMovimientoArriba(2);
                        movimientoArriba(2);

                        movimientoArriba(3);
                        sumaMovimientoArriba(3);
                        movimientoArriba(3);

                        generarNumRandom();

                        Toast.makeText(this, "arriba", Toast.LENGTH_SHORT).show();
                    }
                }
        }
        return super.onTouchEvent(e);
    }


    public void generarNumRandom() {


        int filas = new Random().nextInt(4);
        int columnas = new Random().nextInt(4);
        int numero = new Random().nextInt(10);
        if (numero < 9) {
            numero = 2;
            resultRandomNumber = Integer.toString(numero);
        } else {
            numero = 4;
            resultRandomNumber = Integer.toString(numero);
        }
        while (!matrix[filas][columnas].getText().equals("")) {
            filas = new Random().nextInt(4);
            columnas = new Random().nextInt(4);
        }
        matrix[filas][columnas].setText(resultRandomNumber);

        //matrix[0][0].setText(resultRandomNumber);
    }

    public void insertarMatrixTablero() {
        matrix[0][0] = findViewById(R.id.boton0);
        matrix[0][1] = findViewById(R.id.boton1);
        matrix[0][2] = findViewById(R.id.boton2);
        matrix[0][3] = findViewById(R.id.boton3);
        matrix[1][0] = findViewById(R.id.boton4);
        matrix[1][1] = findViewById(R.id.boton5);
        matrix[1][2] = findViewById(R.id.boton6);
        matrix[1][3] = findViewById(R.id.boton7);
        matrix[2][0] = findViewById(R.id.boton8);
        matrix[2][1] = findViewById(R.id.boton9);
        matrix[2][2] = findViewById(R.id.boton10);
        matrix[2][3] = findViewById(R.id.boton11);
        matrix[3][0] = findViewById(R.id.boton12);
        matrix[3][1] = findViewById(R.id.boton13);
        matrix[3][2] = findViewById(R.id.boton14);
        matrix[3][3] = findViewById(R.id.boton15);
    }

    //Movimientos de filas y columnas
    public void movimientoDerecha(int filas) {
        for (int movimientocol = 0; movimientocol < 3; movimientocol++) {
            //Movimiento derecha hacia la izquierda columna 4 fila 0
            for (int columnas = 3; columnas > 0; columnas--) {
                if (matrix[filas][columnas].getText().equals("")) {
                    if (!(matrix[filas][columnas - 1].getText().equals(""))) {
                        String numeroCol = (String) matrix[filas][columnas - 1].getText();
                        matrix[filas][columnas].setText(numeroCol);
                        matrix[filas][columnas - 1].setText("");
                    }
                }
            }
        }
    }

    public void movimientoArriba(int columnas) {
        for (int movimientofil = 0; movimientofil < 3; movimientofil++) {
            //Movimiento derecha hacia la izquierda columna 4 fila 0
            for (int filas = 0; filas < 3; filas++) {
                if (matrix[filas][columnas].getText().equals("")) {
                    if (!(matrix[filas + 1][columnas].getText().equals(""))) {
                        String numeroFil = (String) matrix[filas + 1][columnas].getText();
                        matrix[filas][columnas].setText(numeroFil);
                        matrix[filas + 1][columnas].setText("");
                    }
                }
            }
        }
    }

    public void movimientoIzquierda(int filas) {
        for (int movimientocol = 0; movimientocol < 3; movimientocol++) {
            //Movimiento derecha hacia la izquierda columna 4 fila 0
            for (int columnas = 0; columnas < 3; columnas++) {
                if (matrix[filas][columnas].getText().equals("")) {
                    if (!(matrix[filas][columnas + 1].getText().equals(""))) {
                        String numeroCol = (String) matrix[filas][columnas + 1].getText();
                        matrix[filas][columnas].setText(numeroCol);
                        matrix[filas][columnas + 1].setText("");
                    }
                }
            }
        }
    }

    public void movimientoAbajo(int columnas) {
        for (int movimientofil = 0; movimientofil < 3; movimientofil++) {
            //Movimiento derecha hacia la izquierda columna 4 fila 0
            for (int filas = 3; filas >0; filas--) {
                if (matrix[filas][columnas].getText().equals("")) {
                    if (!(matrix[filas - 1][columnas].getText().equals(""))) {
                        String numeroFil = (String) matrix[filas - 1][columnas].getText();
                        matrix[filas][columnas].setText(numeroFil);
                        matrix[filas - 1][columnas].setText("");
                    }
                }
            }
        }
    }

    //Suma de movimientos
    public void sumaMovimientoDerecha(int filas) {
        for (int columnas = 3; columnas > 0; columnas--) {
            if (matrix[filas][columnas].getText().equals(matrix[filas][columnas - 1].getText())) {
                if (matrix[filas][columnas].getText().equals("") || matrix[filas][columnas - 1].getText().equals("")) {
                } else {
                    String col1 = (String) matrix[filas][columnas].getText();
                    String col2 = (String) matrix[filas][columnas - 1].getText();

                    int col1int = Integer.parseInt(col1);
                    int col2int = Integer.parseInt(col2);
                    int sumaTotalCol = col1int + col2int;

                    String sumTotalCol = Integer.toString(sumaTotalCol);

                    matrix[filas][columnas].setText(sumTotalCol);
                    matrix[filas][columnas - 1].setText("");
                }
            }
        }
    }

    public void sumaMovimientoArriba(int columnas) {
        for (int filas = 0; filas < 3; filas++) {
            if (matrix[filas][columnas].getText().equals(matrix[filas + 1][columnas].getText())) {
                if (matrix[filas][columnas].getText().equals("") || matrix[filas + 1][columnas].getText().equals("")) {
                } else {
                    String col1 = (String) matrix[filas][columnas].getText();
                    String col2 = (String) matrix[filas + 1][columnas].getText();

                    int fil1int = Integer.parseInt(col1);
                    int fil2int = Integer.parseInt(col2);
                    int sumaTotalFil = fil1int + fil2int;

                    String sumTotalFil = Integer.toString(sumaTotalFil);

                    matrix[filas][columnas].setText(sumTotalFil);
                    matrix[filas +1][columnas].setText("");
                }
            }
        }
    }

    public void sumaMovimientoIzquierda(int filas) {
        for (int columnas = 0; columnas < 3; columnas++) {
            if (matrix[filas][columnas].getText().equals(matrix[filas][columnas + 1].getText())) {
                if (matrix[filas][columnas].getText().equals("") || matrix[filas][columnas + 1].getText().equals("")) {
                } else {
                    String col1 = (String) matrix[filas][columnas].getText();
                    String col2 = (String) matrix[filas][columnas + 1].getText();

                    int col1int = Integer.parseInt(col1);
                    int col2int = Integer.parseInt(col2);
                    int sumaTotalCol = col1int + col2int;

                    String sumTotalCol = Integer.toString(sumaTotalCol);

                    matrix[filas][columnas].setText(sumTotalCol);
                    matrix[filas][columnas + 1].setText("");
                }
            }
        }
    }

    public void sumaMovimientoAbajo(int columnas) {
        for (int filas = 3; filas > 0; filas--) {
            if (matrix[filas][columnas].getText().equals(matrix[filas - 1][columnas].getText())) {
                if (matrix[filas][columnas].getText().equals("") || matrix[filas - 1][columnas].getText().equals("")) {
                } else {
                    String col1 = (String) matrix[filas][columnas].getText();
                    String col2 = (String) matrix[filas - 1][columnas].getText();

                    int fil1int = Integer.parseInt(col1);
                    int fil2int = Integer.parseInt(col2);
                    int sumaTotalFil = fil1int + fil2int;

                    String sumTotalFil = Integer.toString(sumaTotalFil);

                    matrix[filas][columnas].setText(sumTotalFil);
                    matrix[filas - 1][columnas].setText("");
                }
            }
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}