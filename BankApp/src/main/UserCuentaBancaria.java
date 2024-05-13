package main;

public class UserCuentaBancaria 
{
   private String Name;
   private String Pass;
   private String DNI;
   private int Balance;
   private String Divisa;
   
   public UserCuentaBancaria(String Name,String Pass,String DNI,int Balance,String Divisa)
   {
       this.Name=Name;
       this.Pass=Pass;
       this.DNI=DNI;
       this.Balance=Balance;
       this.Divisa=Divisa;
   }
   
public String getName() {
    return Name;
}
public String getPass() {
    return Pass;
}
public String getDNI() {
    return DNI;
}
public int getBalance() {
    return Balance;
}
public String getDivisa() {
    return Divisa;
}
public void setName(String name) {
    Name = name;
}
public void setPass(String pass) {
    Pass = pass;
}
public void setDNI(String dni) {
    DNI = dni;
}

public void setDivisa(String divisa) {
    Divisa = divisa;
}
public void Ingreso (int newBal)
{
 Balance = Balance+newBal;
}
public void Retirada(int newBal)
{
 Balance = Balance-newBal;    
}


    
}
