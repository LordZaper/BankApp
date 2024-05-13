package main;

import java.util.Scanner;

public class GestionMain
 {
   private static Scanner UsInput =new Scanner(System.in);
 public static void main(String[] args) 
 {
    int sc;
    String prev ="";
    
        System.out.println("Introduzca sus datos de inicio de sesión: ");
        System.out.print("Usuario: ");
        String UsName=UsInput.nextLine();
        
        System.out.print("\nContraseña: ");
        String UsPass=UsInput.nextLine();
        
        String UsDNI;
        do 
        {
            System.out.print("Introduzca su DNI: ");
            UsDNI= UsInput.nextLine();
            if(TestDNI(UsDNI)!=true)
            {
                System.out.print("¡DNI NO VÁLIDO! \n");
            }
        }while(TestDNI(UsDNI)!=true);
        
        System.out.print("Introduzca el balance de su cuenta bancaria: ");
        int UsBalance=UsInput.nextInt();
        
        System.out.print("Introduzca la divisa que va a utilizar: ");
        String UsDivisa=UsInput.next();
       
        UserCuentaBancaria us1 = new UserCuentaBancaria(UsName,UsPass,UsDNI,UsBalance,UsDivisa);
        System.out.println("Registro realizado con éxito, gracias por confiar en nuestro banco! \n");
        do {         
            
        System.out.println("¿Que quiere hacer en su cuenta? \n");
        
        System.out.println("1 - [Comprobar el balance actual]");
        System.out.println("2 - [Hacer un depósito a su cuenta]");
        System.out.println("3 - [Hacer una retirada de su cuenta]");
        System.out.println("4 - [Visualizar la transacción previa]");
        System.out.println("5 - [Calcular el interés por X años]");
        System.out.println("6 - [Salir de la aplicación]");
        sc =UsInput.nextInt();
        
        switch(sc)
        {
        case 1:
            
            if(us1.getBalance()<0)
            {System.out.println("Tiene una deuda de: "+us1.getBalance()+" "+us1.getDivisa());}
            else 
            {System.out.println("Su balance es de: "+us1.getBalance()+" "+us1.getDivisa());}
            prev ="Comprobación de Balance";
            break;
        case 2:
            
            System.out.print("Introduzca la cantidad que desea ingresar: ");
            int UsIng =UsInput.nextInt();
            us1.Ingreso(UsIng);
            System.out.println("Su ingreso es de: " +UsIng+" "+us1.getDivisa());
            prev="Deposito en la cuenta";
            break;
        case 3:
            
            System.out.print("Introduzca la cantidad que quiere retirar");
            int UsRet =UsInput.nextInt();
            us1.Retirada(UsRet);
            System.out.println("Su retirada es de: "+UsRet+" "+us1.getDivisa());
            prev="Retirada de la cuenta";
            break;
        case 4:
            System.out.println("Su anterior transacción fue: \n"+prev);
            break;
        case 5:
            System.out.println("Su interés anual actual es del 1.5%, ¿a cuantos años quiere comprobar su balance?");
            int years=UsInput.nextInt();
            double DineroInteres=years*1.5;
            double BalTrasX= (us1.getBalance()+DineroInteres);
            System.out.println("Dentro de "+years+" años, su balance será de "+BalTrasX+us1.getDivisa());
            prev="Su anterior transacción fue la comprobación de su balance tras"+years+"";
            break;
        case 6:
            System.out.println("Gracias por salir de la aplicación y hasta la próxima");
            prev="Si estás leyendo esto, es que algo fue mal, así que tu no viste nada :)";
            break;           
        }
    
     }while(sc!=6);
}
 
 
 public static boolean TestDNI(String dni)
 {
     boolean conf =false;
     StringBuilder sb= new StringBuilder();
     for(int i=0;i<dni.length()-1;i++)
     {
      sb.append(dni.charAt(i));
     }
     int sbInt=Integer.parseInt(sb.toString());
     String[] letras=new String[]{"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
     if(dni.indexOf(letras[sbInt%23])!=-1)
     {
         conf=true;
     }
    return conf;
     
 }
}
