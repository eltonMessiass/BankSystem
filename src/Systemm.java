import java.lang.StackWalker.Option;
import java.rmi.Remote;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.prefs.BackingStoreException;

import javax.xml.transform.Source;



public class Systemm {
   private ArrayList<Client> clients = new ArrayList<>();
   private ArrayList<Bank> banks = new ArrayList<>();
   Scanner enter = new Scanner(System.in);

   public static void main(String[] args){
    Systemm s = new Systemm();
    s.mainMenu();
   }

   public void mainMenu() {
    while(true){
      System.out.println("\n:::: B A N K I N G     S Y S T E M ::::\n");
      System.out.println(":::: W E L C O M E ::::");
      System.out.println("1 - System Admin");
      System.out.println("2 - Access as client");
      System.out.println("3 - Exit");
      System.out.println("Choose an option:");

      int option = Integer.parseInt(enter.nextLine());
      switch(option){
         case 1:
            SystemAdminMENU();
            break;
         case 2:
            clientMENU();
            break;
         case 3:
            System.out.println("\nThanks for using our System\n");
            System.exit(0);
      }
    }
   }

   // the system administraction
   public int SystemAdminMENU(){
      while(true){
         System.out.println(":::: S Y S T E M  A D M I N ::::");
         System.out.println("Choose an option");
         System.out.println("1 - Manage Banks");
         System.out.println("2 - Manage Clients");
         System.out.println("3 - Manage Agencies");
         System.out.println("4 - Manage Accounts");
         System.out.println("5 - Back to previous Menu");
         System.out.print("Your Option please: ");

         int option = Integer.parseInt(enter.nextLine());

         switch(option){
            case 1:
               banksManagerMENU();
               break;
            case 2:
               clientsManagerMENU();
               break;
            case 3:
               agenciesManagerMENU();
               break;
            case 4:
               //accountsManageMENU();
               break;
            case 5:
               return 1;
         }
      }
   }

   public int banksManagerMENU() {
      Bank ln;
      String bankSearch;

      while(true){
         System.out.println(":::: B A N K S   M A N A G E M E N T ::::");
         System.out.println("Choose an option");
         System.out.println("1 - New Bank");
         System.out.println("2 - Banks list");
         System.out.println("3 - Search Bank");
         System.out.println("4 - Delete Bank");
         System.out.println("5 - Update Bank");
         System.out.println("6 - Back to previous MENU");
         System.out.println("Your Option please: ");

         int option = Integer.parseInt(enter.nextLine());
         switch(option){
            case 1:
               System.out.println("\nBank Number: ");
               String bankNumber = enter.nextLine();
               System.out.println("Bank Name: ");
               String bankName = enter.nextLine();

               Bank.banksCounter++;//increment the banks counter

               
               Bank b = new Bank(Bank.banksCounter, bankName, bankNumber);//new bank object
               banks.add(b); //adding in the banks arrayList
             


               

               System.out.println("The bank was created successfully");

               break;
            
               case 2: //banks list

                  if(banks.isEmpty()){
                     System.out.println("There's no registered bank");
                  }
                  else{

                    for(int i = 0; i < banks.size(); i++){
                     
                     
                        ln = (Bank) banks.get(i); //obtém o banco da iteracao actual
                        
                        System.out.println("Id: "+ ln.getID());
                        System.out.println("Number: "+ ln.getNumber());
                        System.out.println("Name: "+ ln.getName());
                        System.out.println("The agencies quantity: "+ ln.getAgencies().size());
                     }
                  }
                  break;
                
               case 3: // search bank
                  System.out.println("Enter the bank Id, number or the bank's name");
                  bankSearch = enter.nextLine();

                  ln = bankSearch(bankSearch);
                  if(ln == null){
                     System.out.println("The bank was not found");
                  }
                  else{
                     System.out.println("Id: " + ln.getID());
                     System.out.println("Number: " + ln.getNumber());
                     System.out.println("Name: " + ln.getName());
                     System.out.println("The agencies quantity: " + ln.getAgencies().size());
                  }
                  break;
               
               case 4: //delete bank
                  System.out.println("Enter the bank Id, number or the bank's name to delete");
                  bankSearch = enter.nextLine();

                  ln = bankSearch(bankSearch);
                  if(ln == null){
                     System.out.println("The bank was not found");
                  }
                  else{
                     banks.remove(ln);
                     System.out.println("The bank was deleted successfully");
                  }

                  break;

               case 5: // update a bank
                  System.out.println("Enter the bank Id, number or the bank's name");
                  bankSearch = enter.nextLine();

                  ln = bankSearch(bankSearch);
                  if(ln == null){
                     System.out.println("The bank was not found");
                  }
                  else{
                     System.out.println(":::: The current data of this bank ::::");
                     System.out.println("Id: "+ ln.getID());
                     System.out.println("Number: "+ ln.getNumber());
                     System.out.println("Name: "+ ln.getName());
                     System.out.println("Number of agencies: "+ ln.getAgencies().size());

                     System.out.println(":::: Enter the new data ::::");
                     System.out.println("TNew bank number:");
                     String newNumber = enter.nextLine();
                     System.out.println("New bank name");
                     String newName = enter.nextLine();

                     // update this bank data in the arrayList
                     ln.setNumber(newNumber);
                     ln.setName(newName);
                     System.out.println("The bank was updated successfully");

                  }
                  break;

            case 6:
            return 0;
         }
      }
   }

   // this method search a bank by id, name or number
   public Bank bankSearch(String bankSearch){
      Bank b = null;

      for(int i = 0; i < banks.size(); i++){
         // search bank by Id
         if(Integer.toString(banks.get(i).getID()).equals(bankSearch)){
            return banks.get(i);
         }
         // search bank by name
         else if(banks.get(i).getName().contains(bankSearch)){
            return banks.get(i);
         }
         else if(banks.get(i).getName().contains(bankSearch)){
            return banks.get(i);
         }
      }
      return b;
   }


   public int clientsManagerMENU(){
      Client ln;
      String clientSearch;

      while(true){
         System.out.println(":::: C L I E N T S   M A N A G E M E N T");
         System.out.println("Choose an option");
         System.out.println("1 - New Client");
         System.out.println("2 - Clients list");
         System.out.println("3 - Search client");
         System.out.println("4 - Delete client");
         System.out.println("5 - Update client data");
         System.out.println("6 - Back to previous Menu");
         System.out.println("Your option please: ");
         int option = Integer.parseInt(enter.nextLine());

         switch(option){
            case 1:
               System.out.println("Name: ");
               String clientName = enter.nextLine();
               System.out.println("Age: ");
               int clientAge = Integer.parseInt(enter.nextLine());
               System.out.println("Sex");
               char clientSex = enter.nextLine().charAt(0);

               Client.peopleCounter++;

               Client c = new Client(Client.peopleCounter, clientName, clientAge, clientSex);
               clients.add(c);

               System.out.println("The new client was registered successfully");

               break;

            case 2: // Clients list
               if(clients.isEmpty()){
                  System.out.println("There is no registered client");
               }
               else{
                  for(int i = 0; i < clients.size(); i++){
                     ln = clients.get(i); //gets the client of the current iteration
                     System.out.println("Id: "+ ln.getID());
                     System.out.println("Name: "+ ln.getName());
                     System.out.println(("Age: "+ ln.getAge()));
                     System.out.println("Sex: "+ ln.getSex());
                     System.out.println("Number of bank accounts: " + ln.getAccounts(banks).size());
                  }
               }
               break;

            case 3: //search the client
               System.out.println("Enter the client's Id or name: ");
               clientSearch = enter.nextLine();

               ln = clientSearch(clientSearch);
               if(ln == null){
                  System.out.println("Client not found");
               }
               else{
                  System.out.println("Id: "+ ln.getID());
                  System.out.println("Name: "+ ln.getName());
                  System.out.println("Age: "+ ln.getAge());
                  System.out.println("Sex: "+ ln.getSex());
                  System.out.println("Number of bank accounts" + ln.getAccounts(banks).size());
               }
               break;

            case 4: // delete client
               System.out.println("Enter the client's Id or name to delete");

               clientSearch = enter.nextLine();

               ln = clientSearch(clientSearch);
               if(ln == null){
                  System.out.println("Client not found");
               }
               //if the client has bank account you must delete de accounts firstly
               else{
                  if(ln.getAccounts(banks).size() > 0){
                     System.out.println("Sorry! This client has bank accounts.\nDelete the accounts firstly");
                  }
                  else{
                     clients.remove(ln);
                     System.out.println("Client removed");
                  }
               }
               break;

               case 5: // update the client data
                  System.out.println("Enter the clint's id or name");
                  clientSearch = enter.nextLine();
                  ln = clientSearch(clientSearch);
                  if(ln == null){
                     System.out.println("Client not found");
                  }
                  else{
                     System.out.println(":::: The current client's data ::::");
                     System.out.println("Id: "+ ln.getID());
                     System.out.println("Name: "+ ln.getName());
                     System.out.println("Age: "+ ln.getAge());
                     System.out.println("Sex: "+ ln.getSex());
                     System.out.println("Number of bank accounts: " + ln.getAccounts(banks).size());


                     System.out.println(":::: Enter the new client's data ::::");
                     System.out.println("New Name: ");
                     String newName = enter.nextLine();
                     System.out.println("New Age: ");
                     int newAge = Integer.parseInt(enter.nextLine());
                     System.out.println("New Sex: ");
                     char newSex = enter.nextLine().charAt(0);

                     ln.setNome(newName);
                     ln.setAge(newAge);
                     ln.setSex(newSex);
                     System.out.println("New data updated");
                  }
                  break;
               case 6:
                  return 0;
         }
      }
   }

   public Client clientSearch(String clientSearch){
      Client c = null;

      for(int i = 0; i < clients.size(); i++){
         // search by id
         if(Integer.toString(clients.get(i).getID()).equals(clientSearch)){
            return clients.get(i);
         }
         // search by name
         else if(clients.get(i).getName().contains(clientSearch)){
            return clients.get(i);
         }
      }
      return c;
   }

   public int agenciesManagerMENU(){
      Agency ln;
      String agencySearch;

      Bank currentBank = null; //guarda o banco actual

      //to manage an agency we a bank
      while(currentBank == null){
         System.out.println("Enter the Bank's id, number or name");
         String bankSearch = enter.nextLine();

         Bank b = bankSearch(bankSearch);
         if(b == null){// bank not found
            System.out.println("Bank not found.\n\n\nType 1 to search again or type 2 to go back previous Menu: ");
            int option = Integer.parseInt(enter.nextLine());
            if(option == 2){
               return 1;
            }
         }
            else{
               // bank not found. Go ahead with the agencies
               currentBank = b;
            }
      }

         //The bellow MENU should be shown if a bank being found
      while(true){

            System.out.println(":::: A G E N C I E S   M A N A G  E M E N T ::::");
            System.out.println("Selected Bank: "+ currentBank.getName());

            System.out.println("\nChoose an option:");
            System.out.println("1 - New Agency");
            System.out.println("2 - Agencies list");
            System.out.println("3 - Search agency");
            System.out.println("4 - Remove agency");
            System.out.println("5 - Update agency");
            System.out.println("6 - Back previous MENU");
            System.out.println("Your option please: ");
            int option = Integer.parseInt(enter.nextLine());

            switch(option){
               case 1:
                  System.out.println("Number of agency: ");
                  String agencyNumber = enter.nextLine();
                  System.out.println("City/town:");
                  String city = enter.nextLine();

                  Agency.agenciesCounter++;

                  Agency a = new Agency(currentBank, Agency.agenciesCounter, agencyNumber, city);
                  currentBank.getAgencies().add(a);
                  System.out.println("The agency was created successfully");

                  break;
               
               case 2://generate the list of agencies
                  if(currentBank.getAgencies().isEmpty()){
                     System.out.println("There is no an agency in this bank");

                  }else{
                     for(int i = 0; i<currentBank.getAgencies().size(); i++){
                        ln = currentBank.getAgencies().get(i);
                        System.out.println("Id: "+ ln.getID());
                        System.out.println("Number: "+ ln.getNumber());
                        System.out.println("City/Town: "+ ln.getCity());
                        System.out.println("Bank accounts: "+ ln.getAccounts().size());
                     }

                  }
                  break;
               
               case 3: //search an agency
                  System.out.println("Enter the id, number or the city/town of agency");
                  agencySearch = enter.nextLine();
                  ln = agencySearch(currentBank, agencySearch);
                  if(ln == null){
                     System.out.println("Agency not found");
                  }else{
                     System.out.println("Id: "+ ln.getID());
                     System.out.println("Number: "+ ln.getNumber());
                     System.out.println("City/Town: "+ ln.getCity());
                     System.out.println("Number of bank accounts "+ ln.getAccounts().size());
                  }
                  break;
               
               case 4:// remove an 
               /*
                  System.out.println("Enter the Id, number or the city/town of the agency");
                  agencySearch = enter.nextLine();
                  agencySearch = agencySearch(currentBank, agencySearch);
                  if(ln == null){
                     System.out.println("Agency not found");

                  }else{
                     currentBank.getAgencies().remove(ln);
                  } */
                  break;

               case 5:// updade an agency
                  System.out.println("Enter the number or city/town of the agency");
                  agencySearch = enter.nextLine();
                  ln = agencySearch(currentBank, agencySearch);
                  if(ln == null){
                     System.out.println("Agency not found");
                  }else{
                     System.out.println(":::: Agency data ::::");
                     System.out.println("Id :"+ ln.getID());
                     System.out.println("Number: "+ ln.getNumber());
                     System.out.println("City/Town: "+ ln.getCity());
                     System.out.println("Number of bank accounts: "+ ln.getAccounts().size());


                     System.out.println("\n\n\n:::: Enter the new data ::::");
                     System.out.println("New number: ");
                     String newNumber = enter.nextLine();
                     System.out.println("New City/Town: ");
                     String newCity = enter.nextLine();

                     ln.setNumber(newNumber);
                     ln.setCity(newCity);
                     System.out.println("\nAgency updated");
                  }
                  break;

               case 6:
               return 0;

            }

         }
      }
      
   
   public Agency agencySearch(Bank b, String agencySearch){
      Agency a = null;
      for(int i = 0; i < b.getAgencies().size(); i++){
         if(b.getAgencies().get(i).getNumber().contains(agencySearch)){
            return b.getAgencies().get(i);
         }else if(b.getAgencies().get(i).getCity().contains(agencySearch)){
            return b.getAgencies().get(i);
         }
      }
      return a;
   }


   public int accountsManageMENU(){
      Account ln;
      String accountSearch;
      Bank currentBank = null;
      Agency currentAgency = null;

      while(currentBank == null){
         System.out.println("Enter the ID, number or the name of the bank");
         String bankSearch = enter.nextLine();

         Bank b = bankSearch(bankSearch);
         if(b == null){
            System.out.println("Bank not found.\nType 1 to search again or 2 to back previous MENU");
            int option = Integer.parseInt(enter.nextLine());
            if(option == 2){
               return 1;
            }
         }else{
            currentBank = b;
         }
      }
      while(currentAgency == null){
         System.out.println("Enter the ID, number or the name of the agency");
         String agencySearch = enter.nextLine();

         Agency a = agencySearch(currentBank, agencySearch);
         if(a == null){
            System.out.println("Agency not found.\n\nType 1 to search again or 2 to back previous MENU: ");
            int option = Integer.parseInt(enter.nextLine());
            if(option == 2){
               return 1;
            }
         }else{
            currentAgency = a;
         }
      }

         //The menu below will be shown if a bank and an agency be selected

         while(true){
            System.out.println("\n:::: A C C O U N T S   M A N A G E M E N T ::::");
            System.out.println("Bank: "+ currentBank.getName());
            System.out.println("Agency: "+ currentAgency.getNumber() + " - "+ currentAgency.getCity());

            System.out.println("Choose an option ");
            System.out.println("1 - New Account Opening");
            System.out.println("2 - List Accounts");
            System.out.println("3 - Search Account");
            System.out.println("4 - Remove Account");
            System.out.println("5 - Update an Account");
            System.out.println("6 - Back to previous MENU");
            System.out.println("Your option please: ");
            int option = Integer.parseInt(enter.nextLine());

            switch(option){
               case 1:
                  System.out.println("Number of Account: ");
                  String accountnumber = enter.nextLine();
                  System.out.println("Limit of Account: ");
                  double accountLimit = Double.parseDouble(enter.nextLine());

                  //to open an account we need a client
                  Client client = null;
                  while(client == null){
                     System.out.println("Enter the Id or the name of Client: ");
                     String clientSearch = enter.nextLine();
                     client = clientSearch(clientSearch);
                     if(client == null){
                        System.out.println("Client not fount!!!\n\n\nType 1 to search again or 2 to back to previous MENU: ");
                        int optionln = Integer.parseInt(enter.nextLine());
                        if(optionln == 2){
                           return 1;
                        }
                     }
                  }

                  Account.accountsCounter++;

                  Account ac = new Account(currentAgency, client, Account.accountsCounter, accountnumber, 0.0, accountLimit);

                  currentAgency.getAccounts().add(ac);

                  System.out.println("\n\nA new account was created to: "+ client.getName() +"\nThe opening balance is  $ 0,00 and the opening limit is "+ accountLimit);

                  break;

               case 2: //list the accounts registered for the selected branch and bank

                  if(currentAgency.getAccounts().isEmpty()){
                     System.out.println("\nThere is no an account registered for this agency");
                  }else{
                     for(int i = 0; i<currentAgency.getAccounts().size(); i++){
                        ln = currentAgency.getAccounts().get(i);//gets the current iteration
                        System.out.println("Bank aaccount ID: "+ ln.getID());
                        System.out.println("Account Number: "+ ln.getNumber());
                        System.out.println("Client: "+ ln.getClient().getName());
                        System.out.println("Bank: "+ currentBank.getNumber() + " - "+ currentBank.getName());
                        System.out.println("Current Balance: "+ ln.getBalance());
                        System.out.println("Current Limit: "+ ln.getLimit());
                     }
                  }
                  
                  break;

               case 3:
                  System.out.println("Enter the number or name of the client");
                  accountSearch = enter.nextLine();
                  ln = accountSearch(currentAgency, accountSearch);
                  if(ln == null){
                     System.out.println("Account not found!!!");
                  }else{
                     System.out.println("Bank account ID: "+ ln.getID());
                     System.out.println("Account Number: "+ ln.getNumber());
                     System.out.println("Client: "+ ln.getClient().getName());
                     System.out.println("Agency: "+ currentAgency.getNumber()+ " - "+ currentAgency.getCity());
                     System.out.println("Bank: "+ currentBank.getNumber()+ " - "+ currentBank.getName());
                     System.out.println("Current Balance: "+ ln.getBalance());
                     System.out.println("Current Limit: "+ ln.getLimit());
                  }

                  break;

               case 4: // remove an account
               System.out.println("Enter the number or name of the client");
               accountSearch = enter.nextLine();
               ln = accountSearch(currentAgency, accountSearch);
               if(ln == null){
                  System.out.println("Account not found!!!!");
               }else{
                  currentAgency.getAccounts().remove(ln);
                  System.out.println("Account removed!!!");
               }
               break;

               case 5: // update an account
               System.out.println("Enter the number or name of the client");
                  accountSearch = enter.nextLine();
                  ln = accountSearch(currentAgency, accountSearch);
                  if(ln == null){
                     System.out.println("Account not found!!!!");
                  }else{
                     System.out.println("\n:::: Current data of this agency ::::");
                     System.out.println("Bank account ID: "+ ln.getID());
                     System.out.println("Account Number: "+ ln.getNumber());
                     System.out.println("Client: "+ ln.getClient().getName());
                     System.out.println("Agency: "+ currentAgency.getNumber()+ " - "+ currentAgency.getCity());
                     System.out.println("Bank: "+ currentBank.getNumber()+ " - "+ currentBank.getName());
                     System.out.println("Current Balance: "+ ln.getBalance());
                     System.out.println("Current Limit: "+ ln.getLimit());


                     System.out.println("\n\n:::: Enter the new data ::::");
                     System.out.println("New Account number: ");
                     String newNumber = enter.nextLine();
                     System.out.println("New Limit: ");
                     double newLimit = Double.parseDouble(enter.nextLine());

                     ln.setNumber(newNumber);
                     ln.setLimit(newLimit);
                     System.out.println("Account updated successfully");
                  }

                  break;

               case 6:
                  return 0;


               
            }
         }
      }

   public Account accountSearch(Agency agency, String accountSearch){
      Account ac = null;

      for(int i = 0; i < agency.getAccounts().size(); i++){
         if(agency.getAccounts().get(i).getNumber().contains(accountSearch)){
            return agency.getAccounts().get(i);
         }
         else if(agency.getAccounts().get(i).getClient().getName().contains(accountSearch)){
            return agency.getAccounts().get(i);
         }
      }
      return ac;
   }

   public int clientMENU(){
      int idAccount;
      Account account;
      Transaction transaction;
      NumberFormat nf = NumberFormat.getCurrencyInstance();//to format the currency 
      Format format = new SimpleDateFormat("dd/MM/yyyy"); //to format the date

      //we need to authenticate the client in the system
      Client client = null;
      while(client == null){
         System.out.println(":::: W E L C O M E ::::");
         System.out.println("Enter your Id or your name: ");
         String clientSearch = enter.nextLine();

         client = clientSearch(clientSearch);
         if(client == null){
            System.out.println("Client not found!!\n\nType 1 to search again or 2 to back to previous MENU");
            int optionln = Integer.parseInt(enter.nextLine());
            if(optionln == 2){
               return 1;
            }
         }
      }

      while(true){
         System.out.println(":::: W E L C O M E ::::");
         System.out.println("::: "+ client.getName() +":::\n");
         System.out.println("Choose an option");
         System.out.println("1 - list of my bank accounts");
         System.out.println("2 - Deposit Money");
         System.out.println("3 - Cash withdrawal");
         System.out.println("4 - Send Money");
         System.out.println("5 - Get the extract");
         System.out.println("Your option please: ");

         //int option = Integer.parseInt(enter.nextLine());

         
      }

   }
}
   