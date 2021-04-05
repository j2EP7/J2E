package controller;

import dao.*;
import model.Game;
import model.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    //devuelve objeto Game (model) con el número de palabras que hay que buscar
    public Game returnConfigWord(){
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gamemodel=null;
        try {
            gamemodel = gameDAO.read("words");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return gamemodel;
        }
    }

    //devuelve objeto Gme (model) con el Tiempo máximo de juego
    public Game returnConfigTime(){
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gamemodel=null;
        try {
            gamemodel = gameDAO.read("max_time");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return gamemodel;
        }
    }


    // Obtiene listado de palabras readAll


    // Obtiene de forma aleatoria X número de palabras del listado de palabras

    public void setWordLetters(List<Word> words){
        // Filas y columnas
        final int FILAS = 11, COLUMNAS = 11;
        // Variables para recorrer palabras, letras, filas y columnas
        int i, j, f, c;
        // Creamos una matriz de caracteres 5 filas y 4 columnas
        char[][] A = new char[FILAS][COLUMNAS];
        // Rellenamos con espacios vacíos (en char 0 es como si estuviera vacío)
        for (i = 0; i < FILAS; i++) {
            for (j = 0; j < COLUMNAS; j++) {
                A[i][j] = 0;
            }
        }
        // Objeto Random
        Random random = new Random();
        // Recorremos palabras
        for (i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            String text = word.getWord();
            // Recorremos letras de la palabra
            for (j=0; j< text.length(); j++) {
                // Letra
                char letter = text.charAt(j);
                boolean asigned = false;
                // Asignamos letra a la matriz
                while(!asigned) {
                    // Generamos posición aleatoria para la letra en la matriz entre 0 y 11
                    int posicionFila = random.nextInt(11 - 0 + 1) + 0;
                    int posicionColumna = random.nextInt(11 - 0 + 1) + 0;
                    // Si la posición de la matriz está vacía
                    // o ya tiene una letra igual a la que tenemos, nos sirve
                    if (A[posicionFila][posicionColumna] == 0 || A[posicionFila][posicionColumna] == letter) {
                        // Buscamos un hueco para la palabra
                        boolean hole = false;
                        while(!hole) {
                            // Comprobamos si cabe la palabra
                            

                            // Marcamos hueco encontrado para la palabra para salir del while
                            hole = true;
                            // Asignamos letra a la matriz
                            A[posicionFila][posicionColumna] = letter;
                            // Marcamos la letra como asignada para salir del while
                            asigned = true;
                        }
                    }
                }
            }
        }
    }

    // Volvemos a recorrer el casillero y rellenamos los espacios vacíos con letras

        // Si no tiene ninguno busca otra posición donde asignar
        // Almacenamos la próxima posición

}
