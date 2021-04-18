package controller;

import com.google.gson.Gson;
import dao.DAOException;
import model.Game;
import model.Play;
import model.Word;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import controller.WordController;

@WebServlet(name = "play", value = "/play")
public class PlayController extends HttpServlet {

    // https://www.baeldung.com/servlet-json-response
    // Objeto de librería Gson, para convertir a JSON
    // Instalada dependencia vía pom.xml desde mvnrepository.com
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Respuesta en formato JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // Obtener datos para inicializar el juego
        // Objeto con 3 parámetros:
        // words
        // gameSeconds
        // casillero
        String gameDataJSON = null;
        try {
            gameDataJSON = gameDataJSON();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        out.println(gameDataJSON);
        out.flush();
    }

    // Función para obtener los datos del juego
    public String gameDataJSON() throws DAOException {
        // Variable return
        String playJson = "";
        // Construimos model play
        Play play = new Play();
        // Número de palabras del juego
        Integer wordsNumber = new GameController().getGameConfigWords();
        // gameSeconds a JSON
        Integer gameSeconds = new GameController().getGameConfigSeconds();
        // Listado de palabras
        List<Word> words = new WordController().selectRandomWords();
        // Listado de palabras con posiciones
        List<Word> wordsPositions = new GameController().setWordLetters(words);
        List<Object> wordsPlay = null;
        for (Word word:wordsPositions
             ) {
            wordsPlay.add(word);
        }
        play.setWords(wordsPlay);
        // Casillero
        String casillero = new GameController().renderCasillero(wordsPositions);
        System.out.println(casillero);

        play.setSeconds(gameSeconds);
        play.setWordsNumber(wordsNumber);

        play.setCasillero(casillero);
        // Transformamos a JSON
        playJson = this.gson.toJson(play);
        System.out.println(playJson);
        // Return
        return playJson;
    }


}
