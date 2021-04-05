package controller;

import dao.*;
import model.Letter;
import model.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game extends HttpServlet {
    public String example = "isdasdasdasd";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public List<Word> printAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        return words;
    }

    // Función que prepara cosas

    // Obtener número de palabras de la configuración read param


    // Obtiene listado de palabras readAll


    // Obtiene de forma aleatoria X número de palabras del listado de palabras

    public List<Word> setWordLetters(List<Word> words){
        // Filas y columnas
        final int FILAS = 12, COLUMNAS = 12;
        // Variables para recorrer palabras, letras..
        int i, j;
        // Creamos una matriz de caracteres 5 filas y 4 columnas
        Character[][] A = new Character[FILAS][COLUMNAS];
        // Rellenamos con espacios vacíos (en char 0 es como si estuviera vacío)
        for (i = 0; i < FILAS; i++) {
            for (j = 0; j < COLUMNAS; j++) {
                A[i][j] = 0;
            }
        }
        // Asignamos un hueco a las palabras
        words = wordPosition(words, A);
        // Asignamos las palabras a la matriz
        // Recorremos palabras
        for (i = 0; i < words.size(); i++){
            Word word = words.get(i);
            // Obtenemos las letras de la palabra
            List<Letter> letters = word.getLetters();
            // Recorremos las letras
            for (j=0; j < letters.size(); j++){
                // Obtenemos la letra
                Letter letter = letters.get(j);
                // Obtenemos el caracter
                Character letra = letter.getLetter();
                // Obtenemos la posición
                Integer[] position = letter.getPosition();
                // La fila está en el index 0
                Integer row = position[0];
                // La columna en el index 1
                Integer col = position[1];
                // Guardamos en matriz
                A[row][col] = letra;
            }
        }
        // Mostramos casillero
        //renderCasillero(A);
        return words;
    }


    // Render casillero
    public void renderCasillero(Character[][] casillero){
        // Variables
        int row,col;
        // Salto de línea
        String newLine = System.getProperty("line.separator");
        // Recorremos casillero y printamos
        for (row=0; row < casillero.length ;row++){
            for (col=0; col < casillero.length; col++){
                System.out.println(casillero[row][col]);
            }
            System.out.println(newLine);
        }
    }


    // Asignamos un hueco a las palabras
    public List<Word> wordPosition(List<Word> words, Character[][] Casillero){
        // Variables int para loops
        Integer i, j, row, col, direction;
        // Objeto Random
        Random random = new Random();
        // Recorremos palabras
        for (i = 0; i < words.size(); i++) {
            // Obtenemos palabra
            Word word = words.get(i);
            System.out.println(word.getWord());
            // Buscamos hueco para la palabra
            // Definimos asignado a falso
            boolean asigned = false;
            // Mientras la palabra no esté asignada seguimos intentando encontrarle un hueco
            while(!asigned) {
                // Definimos orientación de la palabra
                // Hay 8 posibles direcciones
                direction = random.nextInt(8 - 1 + 1) + 1;
                // Obtenemos las letras de la palabra
                List<Letter> letters = word.getLetters();
                // Recorremos las letras
                for (j=0; j < letters.size(); j++) {
                    // Obtenemos la letra
                    Letter letter = letters.get(j);
                    //System.out.println("letra "+letter);
                    // Obtenemos el caracter de la letra
                    Character letra = letter.getLetter();
                    // Si es la primera letra de la palabra
                    if(j==0){
                        // Generamos posición aleatoria para la primera letra en la matriz entre 0 y 11
                        row = random.nextInt(11 - 0 + 1) + 0;
                        col = random.nextInt(11 - 0 + 1) + 0;
                    }else{
                        // Si no es la primera letra generamos la posición correspondiente
                        Letter previousLetter = letters.get(j-1);
                        List<Integer> position = letterPosition(direction, previousLetter, Casillero);
                        row = position.get(0);
                        col = position.get(1);
                    }
                    // Comprobamos que las posiciones no estén fuera de la matriz
                    if(row < 0 || col < 0 || row > 11 || col > 11){
                        // En ese caso salimos del for, y vuelve a empezar el while
                        break;
                    }
                    // Si la posición de la matriz está vacía
                    // o ya tiene una letra igual a la que tenemos, nos sirve. Continuamos
                    if ( Casillero[row][col] == 0 || Casillero[row][col].equals(letra) ) {
                        // Asignamos letra a la matriz
                        Casillero[row][col] = letra;
                        // Almacenamos posición de la letra
                        Integer[] position = new Integer[]{row,col};
                        letter.setPosition(position);
                        // Si es la última letra por asignar de la palabra
                        if (j == letters.size()-1) {
                            // Marcamos la palabra como asignada para salir del while
                            asigned = true;
                        }
                    }else{
                        // Si la posición de la matriz está ocupada, y la letra no es la misma
                        // Cortamos el for
                        break;
                        // Por lo tanto el while vuelve a empezar
                    }
                }
            }
        }
        return words;
    }


    // Devuelve un array con la posición de la letra de la palabra
    // 0 = fila y 1 = columna
    public List<Integer> letterPosition(Integer direction, Letter previousLetter, Character[][] Casillero){
        List<Integer> position = new ArrayList<>();
        Integer[] previousPosition = previousLetter.getPosition();
        //System.out.println(direction);
        //System.out.println(previousLetter.getLetter());
        Integer row = previousPosition[0];
        //System.out.println("fila "+row);
        Integer col = previousPosition[1];
        //System.out.println("row "+col);
        switch (direction) {
            case 1:  // arriba izquierda
                row = row - 1;
                col = col - 1;
                break;
            case 2:  // arriba
                row = row - 1;
                col = col;
                break;
            case 3:  // arriba derecha
                row = row - 1;
                col = col + 1;
                break;
            case 4:  // izquierda
                row = row;
                col = col - 1;
                break;
            case 5:  // derecha
                row = row;
                col = col + 1;
                break;
            case 6:  // abajo izquierda
                row = row + 1;
                col = col - 1;
                break;
            case 7:  // abajo
                row = row + 1;
                col = col;
                break;
            case 8:  // abajo derecha
                row = row + 1;
                col = col + 1;
                break;
            default: // por defecto
                break;
        }
        position.add(row);
        position.add(col);
        return position;
    }

    // Volvemos a recorrer el casillero y rellenamos los espacios vacíos con letras

    // Si no tiene ninguno busca otra posición donde asignar
    // Almacenamos la próxima posición

}
