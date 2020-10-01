/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zalai
 */
import java.io.*;
import java.util.Scanner;

public class SavingAcc2 {
    public static void main(String args[]) throws IOException
    {
        
      Saving aw = new Saving("1234","name","username","sign","1234567","email","17283829",12,3,2020);
       BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
       
     aw.deposit();
     aw.withdraw();
     aw.add_beneficiary();
    
     aw.intcal();
     aw.display_details();
      aw.close_account();
      
              
       
    }
}

/*abstract class Account
{
    String name;
    String email;
    String phone_number;
    String sign;
    String password;
    String username;
    String id_proof;
    int d,m,y;
    abstract void deposit()throws IOException;
    abstract void withdraw() throws IOException;
    abstract void add_beneficiary();
    abstract void close_account();;

}*/
  
 class Saving extends Account
{
    private double curr_balance=5000.0;
    private static String beneficiary="None";
    private double interest;
    private static final double minimum_balance=5000;
    public Saving(String password,String name,String username,String sign,String id_proof,String email,String phone_number,int d,int m,int y)
    {
this.password=password;
this.name=name;
this.username=username;
this.email=email;
this.id_proof=id_proof;
this.phone_number=phone_number;
this.sign=sign;
this.d=d;
this.m=m;
this.y=y;

    }
    public void deposit() throws IOException
    {
        String str;
        double amount;
       
        boolean valid=true;
        System.out.println("/nDEPOSIT AMOUNT");
              
        try
        {
            //InputStreamReader is = new InputStreamReader(System.in);
            // create object.
        	BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Account No : ");
            
             
          
            
            // check valid account number.
            if (curr_balance < minimum_balance)  
            {
            	System.out.println("\n\n\nInvalid Account Number \n\n");
                valid=false;
            }
           
            if (valid==true)
            {
                System.out.print("Enter Amount you want to Deposit  : ");
                
                  
                str=obj.readLine();
                amount=Double.parseDouble(str);

                curr_balance = curr_balance+amount;

                //Displaying Depsit Details
                System.out.println("\nAfter Updation...");
              //  System.out.println("Account Number :  "+account);
                System.out.println("Balance Amount :  "+curr_balance+"\n\n\n");
            }
        }
        catch(IOException | NumberFormatException e)
        {
        	System.out.println("Exception in Depositing record.....");
        }
    }
    public void withdraw() throws IOException
    { 
    	String str;
        
    	double amount,checkamount;
       // int account;
        boolean valid=true;
        
        System.out.println("\nWITHDRAW MONEY");
        try
        {
           // InputStreamReader is = new nputStreamReader(System.in);
            // create object. 
        	BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
             
        	// enter account number for entering money
            System.out.print("Enter the account number to deposit money : ");
           
            
         //   str=obj.readLine();
         //   account=Integer.parseInt(str);

            // check for valid account number.
         //   if (ac<min_limit)  
         //   {
         //        System.out.println("\n\n\nInvalid Account Number \n\n");
          //       valid=false;
         //   }

            if (valid==true)
            {
            	System.out.println("Balance is : "+curr_balance);
                System.out.print("Enter Amount you want to withdraw  : ");
              
                 
                str=obj.readLine();
                amount=Double.parseDouble(str);
                checkamount=curr_balance-amount;

                if(checkamount >= minimum_balance)
                {
                	curr_balance = checkamount;
                      
                    // Updating the amount after withdraw.
                    System.out.println("\nAfter Updation...");
                 //   System.out.println("Account Number :  "+account);
                    System.out.println("Balance Amount :  "+curr_balance+"\n\n\n");
                }
                else
                {
                	System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 5000\n\n\n");
                }
            }
        }
        catch(IOException | NumberFormatException e)
        {
        	System.out.println("Exception in Withdrawing record.....");
        }
    }	
    public void add_beneficiary()
    {
        Scanner input=new Scanner(System.in);
       System.out.println("So you want to add beneficiary, We hope you know what does beneficiary means, if you know then continue else if you want to know meaning of beneficiary press 1"); 
       int temp=input.nextInt();
       if(temp==1)
       {
           System.out.println("The person to whom the payment is to be made needs to be added as a 'beneficiary' and his bank account details provided in order to transfer the funds. These include the name of the beneficiary account holder, account number, bank and branch name, and the IFSC code of the beneficiary bank branch");
           System.out.println("Do you still want someone to be your beneficiary then continue and press other digit than 1,if not then kindly press 1");
           temp=input.nextInt();
           if(temp==1)
           return ;
       }
       input.nextLine();
       String x=input.nextLine();
       beneficiary=x;

    }
     public void close_account()
    {
        Scanner input=new Scanner(System.in);
    
     System.out.println("Are you sure you want to close your account");
     
     String temp=input.nextLine();
      if(temp.equalsIgnoreCase("yes"))
    {
     System.out.println("Enter your password if you want to close your account");
        input.nextLine();
        String password_confirmation=input.nextLine();
        if(password.equals(password_confirmation))
        {
            System.out.println("Ok your account has been successfully closed,kindly provide us feedback why have you closed account in our bank");
            input.nextLine();
            String feedback=input.nextLine();
            System.out.println("Thank you for your precious feedback ,we will definitely try to solve this");
        }
    }
    }
     public void intcal()
     {
         int temp1,temp2,temp3;
         double intr;
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter  day from which date you want to calculate interest :");
         int day= sc.nextInt();
         System.out.println("Enter  month from which date you want to calculate interest :");
         int mon= sc.nextInt();
         System.out.println("Enter  year from which date you want to calculate interest :");
         int yea= sc.nextInt();
         System.out.println("Enter  day of the current date :");
         int da= sc.nextInt();
         System.out.println("Enter  month of the current date :");
         int mo= sc.nextInt();
         System.out.println("Enter  year of the current date :");
         int ye= sc.nextInt();
         
         temp1=da-day;
         temp2=mo-mon;
         temp3=ye-yea;
         if(temp3>=1){
             temp2=temp2 + 12*temp3;         }
         
        intr = curr_balance;
        
         curr_balance = curr_balance*(Math.pow(1+(0.035/12),temp2));
      interest=curr_balance-intr;
      
     }
        
     void display_details(){
        System.out.println("Depositor Name :" +name);
       // System.out.println("Account Number : "+Acc_num);
        System.out.println("Account Balance : "+curr_balance);
        System.out.println("Account Balance : "+interest);
        
    }
 }

