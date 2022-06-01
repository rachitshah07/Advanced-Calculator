package Adv_Calculator;
import java.io.*;
import java.util.Scanner;

interface LogicalCalculator {
   int BinaryToDecimal(int n);
    int DecimalToBinary(int n);
    int DecimalToOctal(int n);
    String  DecimalToHexaDecimal(int n);
    int OctalToDecimal(int n);
    int HexaDecimaltoDecimal(String n);
}
interface simpleCalculator{
    int Addition(int x,int y);
    int Subtraction(int x,int y);
    int Multiplication(int x,int y);
    int Division(int x,int y);
}
interface Basic{
    int gcd(int a,int b);
     int lcm(int A, int B);
    long fastPower(long a, long b);
}
class Logical implements LogicalCalculator{

    private int N;
    void setN(int N1){
        this.N=N1;
    }
    int getN(){
        return N;
    }
    @Override
    public int BinaryToDecimal(int n) {
        setN(n);
        int ans =0;
        int x =1;
        while(n>0){
            int y = n%10;
            ans += x*y;
            x*=2; //Updating x after each loop
            n = n/10;
        }
        return ans;
    }
    @Override
    public int DecimalToBinary(int n) {
        setN(n);
        int x=1;
        int ans =0;
        while(x<=n)
            x*=2;
        x = x/2;
        while(x>0){
            int lastDigit =n/x;
            n -= lastDigit *x;
            x /= 2;
            ans = ans*10 +lastDigit;
        }
        return ans;
    }
    @Override
    public int DecimalToOctal(int n){
        setN(n);
        int x=1;
        int ans =0;
        while(x<=n)
            x*=8;
        x = x/8;

        while(x>0){
            int lastDigit =n/x;
            n -= lastDigit *x;
            x = x/8;
            ans = ans*10 +lastDigit;
        }
        return ans;
    }
    @Override

   public int OctalToDecimal(int n){
        int ans =0;
        int x =1;
        while(n>0){
            int y = n%10;
            ans += x *y;
            x*=8;
            n = n/10;
        }
        return ans;
    }
    @Override
    public String DecimalToHexaDecimal(int decimal){
        int rem;
        StringBuilder hex= new StringBuilder();
        char[] hexchars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            rem=decimal%16;
            hex.insert(0, hexchars[rem]); //hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        return hex.toString();
    }
    @Override
    public int HexaDecimaltoDecimal(String hex){
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

}
class Simple implements simpleCalculator{
    private int x2,y2;
    void setX(int x1){
        this.x2=x1;
    }
    void setY(int y1){
        this.y2=y1;
    }

    @Override
    public int Addition(int x, int y) {
        setX(x);
        setY(y);
        return x+y;
    }

    @Override
    public int Subtraction(int x, int y) {
        setX(x);
        setY(y);
        return x-y;
    }

    @Override
    public int Multiplication(int x, int y) {
        setX(x);
        setY(y);
        return x*y;
    }

    @Override
    public int Division(int x, int y) {
        setX(x);
        setY(y);
        try{
            return (x/y);
        }
       catch (ArithmeticException e){
           System.out.println(e);
       }
        return 0;
    }

}
class BASIC_CAL implements Basic {
    public int gcd(int a, int b) {
        while (b != 0) {            //42 24        24 18        18 6
            int rem = a % b;      //42%24=18     24%18=6      18%6=0
            a = b;              //a=24         a=18         a=6
            b = rem;            //b=18         b=6          b=0 (stops)
        }
        return a;
    }
   public int lcm(int A, int B){
       int LCM;
       LCM = (A * B) / gcd(A, B);
       return LCM;
    }
    public long fastPower(long a, long  b)
    {
       long  res=1;
        if(b==0) return 1;
        if(b%2==0) res = fastPower(a*a,b/2); //Even power
        else res = fastPower(a*a,b/2) *a; //Odd power
        return res;
    }
}
public class Main {
    public static void main(String[] args)  throws IOException {
        System.out.println("\n\t\t\t\t\t\t\t\t\t*****************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\tADVANCE CALCULATOR ");
        System.out.println("\t\t\t\t\t\t\t\t\t*****************************");

        Scanner sc = new Scanner(System.in);
        int x;

        File file = new File("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt");
        File f2 = new File("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\f2.txt");
//        FileWriter F = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt",true);
//        F.write("EMPLOYEE \t  ");
        File FILE = new File("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Simple.txt");
        File File1 = new File("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Basic.txt");
        do {

            System.out.println("\n\t\t\t\t\tSelect the OPERATIONS to perform\n\t\t\t1.Logical Operations\n\t\t\t2.Simple Operations\n\t\t\t3.Basic Operations\n\t\t\t4.EXIT\t\t\t\t");
            x = sc.nextInt();
//            FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
            if (x == 1) {
                Logical l = new Logical();
                System.out.println("\t\tSelect the following Logical Calculations  \n\t\t1.Binary to Decimal\n\t\t2.Decimal to Binary\n\t\t3.Decimal To Octal\n\t\t4.Octal To Decimal \n\t\t5.Decimal To HexaDecimal\n\t\t6.HexaDecimal To Decimal");
                int y = sc.nextInt();
                if (y == 1) {
                        FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);

                        System.out.print("\t\t\t\tEnter Binary number to be converted to Decimal: ");
                        int num = sc.nextInt();
                        fw.write("Binary = " + num + "\tto \tDecimal = " + l.BinaryToDecimal(num) + "\n");
                        System.out.println("\t\t\t\tDecimal conversion of " + num + " : " + l.BinaryToDecimal(num));
                        fw.close();

                } else if (y == 2) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
                    System.out.print("\t\t\t\tEnter Decimal number to be converted to Binary: ");
                    int num = sc.nextInt();
                    fw.write("Decimal = " + num + "\tto \tBinary = " + l.DecimalToBinary(num) + "\n");
                    System.out.println("\t\t\t\tBinary conversion of " + num + " : " + l.DecimalToBinary(num));
                    fw.close();
                } else if (y == 3) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
                    System.out.print("\t\t\t\tEnter Decimal number to be converted to Octal: ");
                    int num = sc.nextInt();
                    fw.write("Decimal =" + num + "\tto \tOctal =" + l.DecimalToOctal(num) + "\n");
                    System.out.println("\t\t\t\tOctal conversion of " + num + " : " + l.DecimalToOctal(num));
                    fw.close();
                } else if (y == 4) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
                    System.out.print("\t\t\t\tEnter Octal number to be converted to Decimal: ");
                    int num = sc.nextInt();
                    fw.write("Octal = " + num + "\tto \tBinary =" + l.OctalToDecimal(num) + "\n");
                    System.out.println("\t\t\t\tDecimal conversion of " + num + " : " + l.OctalToDecimal(num));
                    fw.close();
                } else if (y == 5) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
                    System.out.print("\t\t\t\tEnter Decimal number to be converted to Hexadecimal: ");
                    int num = sc.nextInt();
                    fw.write("Decimal = " + num + "\tto \tHexadecimal = " + l.DecimalToHexaDecimal(num) + "\n");
                    System.out.println("\t\t\t\tHexadecimal conversion of " + num + " : " + l.DecimalToHexaDecimal(num));
                    fw.close();
                } else if (y == 6) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Logical.txt", true);
                    System.out.print("\t\t\t\tEnter Hexadecimal number to be converted to Decimal: ");
                    String num = sc.next();
                    fw.write("Hexadecimal =" + num + "\tto \tDecimal = " + l.HexaDecimaltoDecimal(num) + "\n");
                    System.out.println("\t\t\t\tDecimal conversion of " + num + " : " + l.HexaDecimaltoDecimal(num));
                    fw.close();
                }
            } else if (x == 2) {

                Simple s = new Simple();
                System.out.print("\t\t\t\tSelect the following Simple Calculations \n1.Addition\n2.Subtract\n3.Multiplication\n4.Division\n\n");
                int y = sc.nextInt();
                if (y == 1) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Simple.txt", true);
                    System.out.print("\t\t\t\tEnter two numbers to be added: ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write(num1 + " + " + num2 + " = " + s.Addition(num1, num2) + "\n");

                    System.out.println("\t\t\t\tAddition of " + num1 + " & " + num2 + " : " + s.Addition(num1, num2));
                    fw.close();
                } else if (y == 2) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Simple.txt", true);
                    System.out.print("\t\t\t\tEnter two numbers to be subtracted: ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write(num1 + " - " + num2 + " = " + s.Subtraction(num1, num2) + "\n");
                    System.out.println("\t\t\t\tSubtraction of " + num1 + " & " + num2 + " : " + s.Subtraction(num1, num2));
                    fw.close();
                } else if (y == 3) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Simple.txt", true);

                    System.out.print("\t\t\t\tEnter two numbers to be multiplied: ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write(num1 + " * " + num2 + " = " + s.Multiplication(num1, num2) + "\n");
                    System.out.println("\t\t\t\tMultiplication of " + num1 + " & " + num2 + " : " + s.Multiplication(num1, num2));
                    fw.close();
                } else if (y == 4) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Simple.txt", true);

                    System.out.print("\t\t\t\tEnter two numbers to be divided: ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write(num1 + " / " + num2 + " = " + s.Division(num1, num2) + "\n");
                    System.out.println("\t\t\t\tDivision of " + num1 + " & " + num2 + " : " + s.Division(num1, num2));
                    fw.close();
                }
            }

            else if (x==3) {
                BASIC_CAL B = new BASIC_CAL();
                System.out.println("\t\t\t\tSelect the following Basic Calculations \n\t\t\t\t1.GCD\n\t\t\t\t2.LCM\n\t\t\t\t3.Exponent\n");
                int y = sc.nextInt();
                if (y == 1) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Basic.txt");
                    System.out.print("\t\t\t\tEnter two numbers to find GCD : ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write("GCD of " + num1 + " & " + num2 + " is " + B.gcd(num1, num2) + "\n");
                    System.out.println("\t\t\t\tGCD of " + num1 + " & " + num2 + " : " + B.gcd(num1, num2));
                    fw.close();
                } else if (y == 2) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Basic.txt");
                    System.out.print("\t\t\t\tEnter two numbers to find LCM : ");
                    int num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write("LCM of " + num1 + " & " + num2 + " is " + B.lcm(num1, num2) + "\n");
                    System.out.println("\t\t\t\tLCM of " + num1 + " & " + num2 + " : " + B.gcd(num1, num2));
                    fw.close();
                } else if (y == 3) {
                    FileWriter fw = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\Basic.txt");
                    System.out.print("\t\t\t\tEnter number to calculate (N1)^N2:  ");
                    long num1 = sc.nextInt(), num2 = sc.nextInt();
                    fw.write(num1 + "^" + num2 + " = " + B.fastPower(num1, num2) + "\n");
                    System.out.println("\t\t\t\t" + num1 + "^" + num2 + " =" + B.fastPower(num1, num2));
                    fw.close();
                }
            }
        } while (x != 4);
        System.out.println("\n\t\t\t\t\tFor history: \n\t\t\t\t1.Logical Operations\n\t\t\t\t2.Simple Operations\n\t\t\t\t3.Basic Operations\n\t\t\t\t4.Delete all files\n\t\t\t\t5.EXIT");
        int z ;
               do {
                   z = sc.nextInt();
                   if (z == 1) try {
                       System.out.println("\t\t\tHistory of Logical Operations: ");
                       Scanner scan = new Scanner(file);
                       while (scan.hasNextLine()) {
                           String line1 = scan.nextLine();
                           FileWriter f = new FileWriter("E:\\Skills\\CS\\Java\\src\\Adv_Calculator\\f2.txt",true);
                           f.write(line1+"\n");
//                           System.out.println(line1);
                           f.close();
                       }
                       scan.close();
                       System.out.println("\n\t\t\t\t\tFor history: \n\t\t\t\t1.Logical Operations\n\t\t\t\t2.Simple Operations\n\t\t\t\t3.Basic Operations\n\t\t\t\t4.Delete all files\n\t\t\t\t5.EXIT");
                   } catch (IOException e) {
                       System.out.println("FILE EMPTY");
                   }
                   else if(z==2) try {
                       System.out.println("\t\t\tHistory of Simple Operations: ");
                       Scanner scan = new Scanner(FILE);
                       while (scan.hasNextLine()) {
                           String line1 = scan.nextLine();
                           System.out.println(line1);
                       }
                       scan.close();
                       System.out.println("\n\t\t\t\t\tFor history: \n\t\t\t\t1.Logical Operations\n\t\t\t\t2.Simple Operations\n\t\t\t\t3.Basic Operations\n\t\t\t\t4.Delete all files\n\t\t\t\t5.EXIT");
                   } catch (IOException e) {
                       System.out.println("FILE EMPTY");
                   }
                   else if(z==3) try{
                       System.out.println("\t\t\tHistory of Basic Operations: ");
                       Scanner scan = new Scanner(File1); // file1 -> a+b , a-b
                       while (scan.hasNextLine()) {
                           String line1 = scan.nextLine();
                           System.out.println(line1);
                       }
                       scan.close();
                       System.out.println("\n\t\t\t\t\tFor history: \n\t\t\t\t1.Logical Operations\n\t\t\t\t2.Simple Operations\n\t\t\t\t3.Basic Operations\n\t\t\t\t4.Delete all files\n\t\t\t\t5.EXIT");
                   } catch (IOException e) {
                       System.out.println("FILE EMPTY");
                   }
                   else if(z==4){
                       if(file.delete()) System.out.println("Logical Operations deleted. "+file.getName());
                       if(FILE.delete())  System.out.println("Simple Operations deleted. "+FILE.getName());
                       if(File1.delete()) System.out.println("Basic Operations deleted. "+File1.getName());
                   }
               }while (z!=5);
    }
}