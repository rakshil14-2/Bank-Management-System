/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */
import java.io.*;

public class Fd {
    double p,r;
    double am;
    String na,g;
    int ag,t1;

    public Fd1() {
        this.p = 0.0;
        this.r = 0.0;
        this.t1 = 0;
        this.na = "";
        this.ag = 0;
        this.g="";
    }

 
    public void input()throws IOException
    {   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("enter details");
        try {
           
             
            System.out.println("Enter your Name");
            na=br.readLine();
            System.out.println("Enter your gender");
            g=br.readLine();
            System.out.println("Enter your age");
            ag=Integer.parseInt(br.readLine()); 
             System.out.println("Enter amount to deposit");
            p=Double.parseDouble(br.readLine());
            System.out.println("Enter time for deposit");
             t1=Integer.parseInt(br.readLine());
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("IOException | NumberFormatException e");
        }
        
    }
    public void calculate()
    {	if(t1>48)
{
System.out.println("You cannot open FD above 4 years");
}
else
{
        if(p>1000000)
        {
          System.out.println("Enter principal less than 1000000") ; 
        }
        else
        {
            if(g.equalsIgnoreCase("male"))
            {
                if(ag>60)
                {
                 if(t1>0 && t1<=6)
                 {
                     r=6.20;
                 } 
                 else if(t1>6 && t1<=12)
                 {
                     r=6.25;
                 }
                 else if(t1>12 && t1<=18)
                 {
                     r=6.50;
                 }
                  else if(t1>18 && t1<=24)
                 {
                     r=6.75;
                 }
                  else if(t1>24 && t1<=30)
                 {
                     r=6.80;
                 }
                  else if(t1>30 && t1<=36)
                 {
                     r=6.85;
                 }
                  else if(t1>36 && t1<=48)
                 {
                     r=6.87;
                 }
                 
               }
               else
               {
                   if(t1>0 && t1<=6)
                 {
                     r=5.05;
                 } 
                 else if(t1>6 && t1<=12)
                 {
                     r= 5.10;
                 }
                 else if(t1>12 && t1<=18)
                 {
                     r=5.60;
                 }
                  else if(t1>18 && t1<=24)
                 {
                     r=5.75;
                 }
                  else if(t1>24 && t1<=30)
                 {
                     r=5.80;
                 }
                  else if(t1>30 && t1<=36)
                 {
                     r=5.85;
                 }
                  else if(t1>36 && t1<=48)
                 {
                     r=6.01;
                 }
               }
                
               
            }
            else
            {
                if(ag>58)
                {
                 if(t1>0 && t1<=6)
                 {
                     r=6.20;
                 } 
                 else if(t1>6 && t1<=12)
                 {
                     r=6.25;
                 }
                 else if(t1>12 && t1<=18)
                 {
                     r=6.50;
                 }
                  else if(t1>18 && t1<=24)
                 {
                     r=6.75;
                 }
                  else if(t1>24 && t1<=30)
                 {
                     r=6.80;
                 }
                  else if(t1>30 && t1<=36)
                 {
                     r=6.85;
                 }
                  else if(t1>36 && t1<=48)
                 {
                     r=6.87;
                 }
                 
               }
               else
               {
                   if(t1>0 && t1<=6)
                 {
                     r=5.05;
                 } 
                 else if(t1>6 && t1<=12)
                 {
                     r= 5.10;
                 }
                 else if(t1>12 && t1<=18)
                 {
                     r=5.60;
                 }
                  else if(t1>18 && t1<=24)
                 {
                     r=5.75;
                 }
                  else if(t1>24 && t1<=30)
                 {
                     r=5.80;
                 }
                  else if(t1>30 && t1<=36)
                 {
                     r=5.85;
                 }
                  else if(t1>36 && t1<=48)
                 {
                     r=6.01;
                 }
               }
                    
                }
            }
        int t2 = t1/3;
        int t3= t1-t2*3;
        
        am=p*Math.pow((1+(r/4)/100),t2);
        if(t3>0)
            am=am*Math.pow((1+(r/12)/100),t3);
            
       } }
    public void display()
    {
        System.out.println("Name of person "+ na);
         System.out.println("Age of person "+ ag);
          System.out.println("Amount deposited "+ p);    
          System.out.println("Time for which amount is deposited "+ t1);
          if(t1<=48)
          System.out.println("Amount at maturity "+am);
    }
    public static void main(String [] args)throws IOException
    {   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fd1 f=new Fd();
f.input();
        f.calculate();
        f.display();
        
    }
    }

