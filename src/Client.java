
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Vector;

/* ESta é a classe Pessoa. Uma ppessoas pode estar associada a uma ou mais contas bancárias */

public class Client{
    
    private int id; //identificaçào da pessoa. Nao pode repetir
    private String name;
    private int age;
    private char sex;
    public static int peopleCounter = 0;  // auto-incremento para o identificador de cada pessoa

    //Construtor com parâmetros
    public Client(int id, String name,int age, char sex){
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    
    //Construtor vazio
    public Client(){
    
    }

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setNome(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public char getSex(){
        return sex;
    }

    public void setSex(char sex){
        this.sex = sex;
    }

    public Vector<Account> getAccounts(ArrayList<Bank> banks){
        Vector<Account> accounts = new Vector<>();

        for(int i = 0; i < banks.size(); i++){
            //go through the agencies of each bank
            Bank bank = banks.get(i);// represents the bank of the current iteration
            for(int c = 0; c < bank.getAgencies().size(); c++ ){
                Agency agency = bank.getAgencies().get(c); //the agency of the actual iteration
                for(int n = 0; n < agency.getAccounts().size(); n++){
                    Account account = agency.getAccounts().get(n);//the count of actual iteration
                    if(account.getClient().getID() == this.getID()){
                        accounts.add(account);
                    }
                }
            }

        }

        return accounts;
    }

}

