import java.io.*;
import java.util.*;
import java.lang.*;

abstract class account
{
    String name;
    String email;
    String phone_number;
    String sign;
    String password;
    String username;
    String id_proof;
    abstract void add_money(double x)throws IOException;
    abstract void debit_money()throws IOException;
    abstract void add_beneficiary()throws IOException;
    abstract void request_for_necessary_conditions()throws IOException;
    abstract void close_account()throws IOException;
    abstract void balance_enquiry()throws IOException;
}


class current_account extends account
{
    //Making an object of Buffer reader for quick input.
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    //Declaring some private variables,so as to make them accessible inside methods only and not globally
    private static double curr_balance=0;
    private static String beneficiary="None";
    private static double rate_of_interest=0.0015;
    private static double minimum_balance=0;

    public current_account()
    {
        System.out.println("\n\n\nNote you have called default constructor ,you must call parametrized constructor in order to intialize the variables\n\n\n");

    }
    //Below is the parametrized constructor.
    public current_account(String password,String name,String username,String sign,String id_proof,String email,String phone_number)
    {
    this.password=password;
    this.name=name;
    this.username=username;
    this.email=email;
    this.id_proof=id_proof;
    this.phone_number=phone_number;
    this.sign=sign;
    }

    //Below is the method for adding money.
    public void add_money(double x)throws NumberFormatException,IOException
    {
        
    if(x<=0)
    {
        //In this ,what I am doing is that if the user enters -ve value then we will ask if in real,he/she wants to debit instead of add.
        System.out.println("You can only add positive value,if you want to debit money press 1 ");
        int temp=Integer.parseInt(br.readLine());
        if(temp==1)
        {
        debit_money();
        return ;
        }
    }
    curr_balance+=x;
     
}
    public void debit_money() throws NumberFormatException,IOException
    {
    //In this , what I am doing is amount will be debited if amount entered is less than the current amount in bank.
    System.out.println("\nHow much amount do you want to debit");
    double temp=Double.parseDouble(br.readLine());
    if(temp<=curr_balance)
    {
        curr_balance-=temp;
        System.out.println("Amount successfully debited,current balance is "+curr_balance+"\n");
    }
    else
    System.out.println("You don't have enough balance available in your account"+"\n");
    }



    public void add_beneficiary() throws NumberFormatException,IOException
    {
        //THe idea is pretty clear ,We will first ask the user,if he/she  knows about the beneficiary,if yes then we will ask the name of the person and will add his/her as a beneficairy.


       System.out.println("\nSo you want to add beneficiary, We hope you know what does beneficiary means, if you know then continue else if you want to know meaning of beneficiary press 1"); 
       int temp=Integer.parseInt(br.readLine());
       if(temp==1)
       {
           System.out.println("The person to whom the payment is to be made needs to be added as a 'beneficiary' and his bank account details provided in order to transfer the funds. These include the name of the beneficiary account holder, account number, bank and branch name, and the IFSC code of the beneficiary bank branch");
           System.out.println("Do you still want someone to be your beneficiary then continue and press other digit than 1,if not then kindly press 1");
           System.out.print("Enter name of beneficiary  ");
           temp=Integer.parseInt(br.readLine());
           System.out.println("\n");
           if(temp==1)
           return ;
       }
       String x=br.readLine();
       beneficiary=x;
    }

    public void request_for_necessary_conditions() throws IOException,NumberFormatException
    {
        //This is a method for requesting necessary items such as atm card,passbook or cheque book.



        System.out.println("\nFor what do you want to make request,You can either request for cheque book or atm card,passbook");
        System.out.println("Press 1 for atm card\n2for passbook\n3for cheque book");
        int temp=Integer.parseInt(br.readLine());
        if(temp>3||temp<=0)
        {
            System.out.println("You can only enter the number from 1 to 3");
            return ;
        }
        System.out.println("Your request is successfully been added into our nottice,we will try to provide this as early as we can\n");
    }



    public void close_account() throws IOException,NumberFormatException
    {

        //This is a method for closing the account,we will first ask the password ,if the user authenticates the password then we will close the account and will ask the feedback ,Basically the reason of closing of that account.


    System.out.println("\nAre you sure you want to close your account,press y for yes ,else press anything except y");
    String temp=br.readLine();
    if(temp.substring(0,1).startsWith("y")||temp.substring(0,1).startsWith("Y"))
    {
        System.out.println("Enter your password if you want to close your account");
        
        String password_confirmation=br.readLine();
        if(password.equals(password_confirmation))
        {
            System.out.println("Ok your account has been successfully closed,kindly provide us feedback why have you closed account in our bank");
            System.out.print("\nYour feedback=  ");
            String feedback=br.readLine();
            System.out.println("\nThank you for your precious feedback ,we will definitely try to solve this\n");
        }
    }
  }


    public void balance_enquiry() throws NumberFormatException,IOException
    {
        //This is a method for getting enquiry about the balance and interest after a certain period of time entered by user.


        
        int current_year=Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("\nEnter the date of opening of bank in dd/mm/yyyy format please");


        //This will keep asking the date until the date entered by the user is not legit.
        String open=br.readLine();
        boolean var=Integer.parseInt(open.substring(0,2))>31||Integer.parseInt(open.substring(0,2))<0||Integer.parseInt(open.substring(3,5))>12||Integer.parseInt(open.substring(3,5))<0||Integer.parseInt(open.substring(6))>current_year||Integer.parseInt(open.substring(6))<0;
        while(var==true)
        {
            System.out.println("Date not valid,enter again");
            open=br.readLine();
            var=Integer.parseInt(open.substring(0,2))>31||Integer.parseInt(open.substring(0,2))<0||Integer.parseInt(open.substring(3,5))>12||Integer.parseInt(open.substring(3,5))<0||Integer.parseInt(open.substring(6))>current_year||Integer.parseInt(open.substring(6))<0;
        }
        System.out.println("Now enter the current date or time after you which you want to enquire about your account in dd/mm/yyyy format");
        String curr=br.readLine();


        //This will keep asking the date until the date entered by the user is not legit.
        var=Integer.parseInt(curr.substring(0,2))>31||Integer.parseInt(curr.substring(0,2))<0||Integer.parseInt(curr.substring(3,5))>12||Integer.parseInt(curr.substring(3,5))<0||Integer.parseInt(curr.substring(6))>current_year||Integer.parseInt(curr.substring(6))<0;
        while(var==true)
        {
            System.out.println("Date not valid,enter again");
            open=br.readLine();
            var=Integer.parseInt(curr.substring(0,2))>31||Integer.parseInt(curr.substring(0,2))<0||Integer.parseInt(curr.substring(3,5))>12||Integer.parseInt(curr.substring(3,5))<0||Integer.parseInt(curr.substring(6))>current_year||Integer.parseInt(curr.substring(6))<0;
        }


        //Then we are calculating interest by calculating the number of years exactly

        int year_diff=Integer.parseInt(curr.substring(6))-Integer.parseInt(open.substring(6));
        int month_diff=Integer.parseInt(curr.substring(3,5))-Integer.parseInt(open.substring(3,5));
        double t=(year_diff*12+month_diff)/12;


        //Converting years into one decimal place.
        t=Math.floor(t*10)/10.0;

        //Calculating interest (Simple Interest) as We know P'=P(1+RT),so interest is P*R*T and P' we have already defined
        double curr_interest=curr_balance*rate_of_interest*t;
        curr_balance=curr_balance+curr_interest;
        System.out.println("So your current balance is "+curr_balance+" which also includes the interest amount of "+curr_interest+"\n");
    }


    public void about_current_account()
    {
        System.out.println("\nCurrent account is a type of account which mainly used in businesses");
        System.out.println("It has a interest rate of 0.15% ");
        System.out.println("It has a condition of minimum balance = "+minimum_balance+"\n");
    }
  
} 


public class project{

public static void main(String[] args) {

  
 } 
}