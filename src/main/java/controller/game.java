package controller;

import dao.*;
import model.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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


    // Una vez que tenemos el array definitivo de palabras
    // Teniendo en cuenta el tamaño del casillero, se ubicarían las palabras aleatoriamente
    // Recorremos listado de palabras
        // Recorremos letras de la palabra
            // Ubicamos la letra en una posición aleatoria
    // Volvemos a recorrer el casillero y rellenamos los espacios vacíos con letras

    // Función // Ubicamos la letra en una posición aleatoria
        // Ubicar la primera letra
        // Si está ocupada, nos fijamos de que sea la misma letra
        // Definir la dirección de la palabra en función del espacio que tenga disponible
        // Si no tiene ninguno busca otra posición donde asignar
        // Almacenamos la próxima posición

}
