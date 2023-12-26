import java.util.Scanner;

public class Main {
    public void myMethod() throws MyException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ArithmeticException");
            System.out.println("NullPointerException");
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("NumberFormatException");
            System.out.println("please choose the number : ");
            int anInt = scanner.nextInt();
            switch (anInt) {
                case 1:
                    int num1 = 24;
                    int num2 = 0;
                    int result = num1 / num2;
                    System.out.println(result);
                case 2:
                    String str = null;
                    System.out.println(str.length());
                case 3:
                    int[] a = new int[4];
                    a[10] = 90;
                case 4:
                    String s = "12s";
                    int num = Integer.parseInt(s);
                    System.out.println(num);
            }
        } catch (ArithmeticException a) {
            throw new MyException("THIS IS ARITHMETIC EXCEPTION");
        } catch (NullPointerException a) {
            throw new MyException("THIS IS NULL POINTER EXCEPTION");
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new MyException("THIS IS ARRAY INDEX OUT OF BOUNDS EXCEPTION");
        } catch (NumberFormatException a) {
            throw new MyException("THIS IS NUMBER FORMAT EXCEPTION");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.myMethod();
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
    }
}
