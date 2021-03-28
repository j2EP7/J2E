package controller;

import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Word;

import java.util.List;

public class wordList {
    private List<Word> words;


    public wordList() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
    }
}
