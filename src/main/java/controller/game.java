package controller;

import dao.*;
import model.Game;
import model.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class game extends HttpServlet {
    public String example = "isdasdasdasd";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try{
            GameDao gameDAO = FactoryDAO.getGameDAO();
            Game gamemodel = gameDAO.read("words");
            //System.out.println(gamemodel.toString());
            out.println(gamemodel.toString());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Word> printAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        return words;
    }

    public void readGame(String parameter) throws DAOException {


    }


}
