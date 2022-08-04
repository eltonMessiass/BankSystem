
//import java.util.ArrayList;
import java.util.Vector;

public class Account {
    private Agency agency; // The agency associated with this account
    private Client client; // the person associated with this account
    private Vector<Transaction> transactions = new Vector<>(); //transactions associated with this account
    private int id;
    private String number;
    private double balance;
    private double limit;
    public static int accountsCounter = 0; // auto-incremento para o identificador de cada conta

    public Account(Agency agency, Client client, int id, String number, double balance, double limit){
        this.agency = agency;
        this.client = client;
        this.id = id;
        this.limit = limit;
        this.number = number;
        this.balance = balance;
    }
    public Account(){}

    public Vector<Transaction> getTransactions() {
        return transactions;
      }
    
      public void setTransactions(Vector<Transaction> transactions) {
        this.transactions = transactions;
      }

    public Agency getAgency(){
        return agency;
    }
    public void setAgency(Agency agency){
        this.agency = agency;
    }

    public Client getClient(){
        return client;
    }
    public void setClient( Client client){
        this.client = client;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    public double getLimit(){
        return limit;
    }
    public void setLimit(double limit){
        this.limit = limit;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void add(Account account) {
    }
}

