package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FillLetters {

    public char [] chars;
    public StringBuffer buffer;

    public FillLetters() {
        chars  = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        // Longitud del array de char.
        int charsLength = chars.length;

        // Instanciamos la clase Random
        Random random = new Random();

        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        buffer = new StringBuffer();

        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i=0;i<48;i++){

            // Añadimos al buffer un caracter al azar del array
            //buffer.append(chars[random.nextInt(charsLength)]);
        }

        // Y solo nos queda hacer algo con la cadena
        //System.out.println("Random String " + buffer.toString());

    }


}
