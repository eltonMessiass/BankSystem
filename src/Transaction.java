import java.util.Date;

public class Transaction {
    private Account count; // the transaction's count
    private int id; // identifies this transaction
    private Date date; //transaction's date
    private String history; //transaction history/description
    private double value;
    private char cardType;
    public static int transactionsCounter = 0;

    public Transaction(Account count, int id, Date date, String history, double value, char cardType){
        this.count = count;
        this.id = id;
        this.date = date;
        this.history = history;
        this.value = value;
        this.cardType = cardType;

    }
    public Transaction(){}

    public Account getCount(){
        return count;
    }
    public void setCount(Account count){
        this.count = count;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public String getHistory(){
        return history;
    }
    public void setHistory(String history){
        this.history = history;
    }

    public double getValue(){
        return value;
    }
    public void setvalue(double value){
        this.value = value;
    }

    public char getCardType(){
        return cardType;
    }
    public void setCardType(char cardType){
        this.cardType = cardType;
    }

}

