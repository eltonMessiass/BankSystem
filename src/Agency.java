
//import java.util.ArrayList;
import java.util.Vector;

/* Esta é a classe Agência. Uma agência pertence a um banco somente, e possui uma arrayList de objectos da classe Conta. Uma conta pertence a somente uma agência, e uma agência pode ter inúmeras contas. */

public class Agency {
    private Vector<Account> accounts = new Vector<>();//lista de contas
    private Bank bank;// the bank which the agency belongs
    private int id;// The agency identification on in systtem. cat't repeat
    private String number;
    private String city;
    public static int agenciesCounter = 0;

    public Agency(Bank bank, int id, String number,String city){
        this.bank = bank;
        this.id = id;
        this.number = number;
        this.city = city;
    }
    public Agency(){}

    public Vector<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(Vector<Account> accounts){
        this.accounts = accounts;
    }

    public Bank getBank(){
        return bank;
    }
    public void setBank(Bank bank){
        this.bank = bank;
    }

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }
}


