package model;

import java.util.List;

public class Play {
    private Integer wordsNumber;
    private Integer seconds;
    private List<Object> words;
    private String casillero;

    public Play() {
    }

    public Integer getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(Integer wordsNumber) {
        this.wordsNumber = wordsNumber;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public List<Object> getWords() {
        return words;
    }

    public void setWords(List<Object> words) {
        this.words = words;
    }

    public String getCasillero() {
        return casillero;
    }

    public void setCasillero(String casillero) {
        this.casillero = casillero;
    }
}
