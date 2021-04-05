package model;

import java.util.Arrays;

public class Letter {
    private Integer Id;
    private Character Letter;
    // En la posición 0 se guarda el valor de la fila y en la 1 el valor de la columna
    private Integer[] Position;

    public Letter() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Character getLetter() {
        return Letter;
    }

    public void setLetter(Character letter) {
        Letter = letter;
    }

    public Integer[] getPosition() {
        return Position;
    }

    public void setPosition(Integer[] position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "Letters{" +
                "Id=" + Id +
                ", Letter=" + Letter +
                ", Position=" + Arrays.toString(Position) +
                '}';
    }
}
