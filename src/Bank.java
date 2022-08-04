import java.util.ArrayList;

import java.io.Serializable;
//import java.util.Vector;

public class Bank implements Serializable{

    private ArrayList<Agency> agencies = new ArrayList<>();// lista de agências
    //private Vector<Agency> agencies = new Vector<>();
    private int id;// identificação do banco no sistema. Nao pode repetir
    private String name;//nome do banco
    private String number;// número do banco
    public static int banksCounter = 0; // auto-incremento para o identificador de cada banco
    //private  static  final long serialVersionUID=1L;

    public Bank(int id, String name, String number){
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Bank(){

    }

    // gets the list of the agencies
  public ArrayList<Agency> getAgencies() {
    return agencies;
  }

  // define the agencies' list
  public void setAgencies(ArrayList<Agency> agencies) {
    this.agencies = agencies;
  }

    public int getID(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }
}
