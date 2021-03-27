package model;

public class GameModel {
    private String parameter;
    private String value;
    private Integer id;

    public GameModel (){}

    // habrá parameters predefinidos y el usuario no podrá settear el parameter
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Configuración \n"+
                "parámetro: "+ this.parameter +"\n"+
                "Valor: " + this.value+"\n"+
                "Id: "+ this.id.toString();
    }
}
