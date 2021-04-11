package controller;

import dao.*;
import model.Game;
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

public class GameController extends HttpServlet {
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

    public Integer getGameConfigWords() throws DAOException {
        Integer value;
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gameModel = gameDAO.read("words");
        String gameModelValue = gameModel.getValue();
        value = Integer.parseInt(gameModelValue);
        return value;
    }

    public Integer getGameConfigSeconds() throws DAOException {
        Integer value;
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gameModel = gameDAO.read("max_time");
        String gameModelValue = gameModel.getValue();
        value = Integer.parseInt(gameModelValue);
        return value;
    }

    public Character[][] createCasillero(){
        // Filas y columnas
        final int FILAS = 12, COLUMNAS = 12;
        // Variables para recorrer palabras, letras..
        int i, j;
        // Creamos una matriz de caracteres 5 filas y 4 columnas
        Character[][] A = new Character[FILAS][COLUMNAS];
        // Rellenamos con espacios vacíos (en char 0 es como si estuviera vacío)
        for (i = 0; i < FILAS; i++) {
            for (j = 0; j < COLUMNAS; j++) {
                A[i][j] = (char)0;
            }
        }
        return A;
    }

    public List<Word> setWordLetters(List<Word> words){
        // Variables para recorrer palabras, letras..
        int i, j;
        // Casillero
        Character[][] A = createCasillero();
        // Asignamos un hueco a las palabras
        words = wordPosition(words, A);
        return words;
    }


    // Render casillero
    public String renderCasillero(List<Word> words){
        System.out.println("render casillero");
        // Variables
        String html = "";
        // Casillero
        Character[][] A = createCasillero();
        // Rellenamos casillero con palabras asignadas
        // Variables para recorrer palabras, letras..
        int i, j, row, col;
        // Character random
        char c;
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
                row = position[0];
                // La columna en el index 1
                col = position[1];
                // Guardamos en matriz
                A[row][col] = letra;
            }
        }
        // Recorremos casillero y rellenamos huecos con letras random
        Random rnd = new Random();
        for (row=0; row < A.length ;row++){
            for (col=0; col < A[row].length; col++){
                if(A[row][col] == 0){
                    c = (char) ('a' + rnd.nextInt(26));
                    A[row][col] = c;
                }
            }
        }
        html = generateCasilleroHTML(A);
        return html;
    }


    public String generateCasilleroHTML(Character[][] A){
        System.out.println("generate casillero html");
        String html = "<table class=\"table table-bordered\"><tbody>";
        Integer row,col;
        for (row=0; row < A.length ;row++){
            html += "<tr>";
            for (col=0; col < A[row].length; col++){
                html += "<td id="+row+"-"+col+" class='letra'>";
                html += A[row][col];
                html += "</td>";
            }
            html += "</tr>";
        }
        html += "</tbody></table>";
        return html;
    }

    // Asignamos un hueco a las palabras
    public List<Word> wordPosition(List<Word> words, Character[][] Casillero){
        System.out.println("word position");
        // Variables int para loops
        Integer i, j, row, col, direction = null;
        // Objeto Random
        Random random = new Random();
        // Recorremos palabras
        for (i = 0; i < words.size(); i++) {
            // Obtenemos palabra
            Word word = words.get(i);
            // System.out.println(word.getWord());
            // Buscamos hueco para la palabra
            // Definimos asignado a falso
            boolean asigned = false;
            // Mientras la palabra no esté asignada seguimos intentando encontrarle un hueco
            while(!asigned) {
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
                        // Definimos orientación de la palabra
                        // Hay 8 posibles direcciones
                        // PENDIENTE Optimizar direcciones en función de los valores de la primera posición
                        direction = random.nextInt(8 - 1 + 1) + 1;
                        System.out.println(direction);
                    }else{
                        // Si no es la primera letra generamos la posición correspondiente
                        Letter previousLetter = letters.get(j-1);
                        List<Integer> position = letterPosition(direction, previousLetter, Casillero);
                        row = position.get(0);
                        col = position.get(1);
                    }
                    // Comprobamos que las posiciones no estén fuera de la matriz
                    if(row < 0 || col < 0 || row > 11 || col > 11){
                        System.out.println("fuera de la matriz");
                        // En ese caso salimos del for, y vuelve a empezar el while
                        break;
                    }
                    // Si la posición de la matriz está vacía
                    // o ya tiene una letra igual a la que tenemos, nos sirve. Continuamos
                    if ( Casillero[row][col] == (char)0 || Casillero[row][col] == letra ) {
                        System.out.println(letra + " nos sirve");
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
        //System.out.println("letter position");
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
