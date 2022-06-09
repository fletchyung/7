package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x ");
        int x = scanner.nextInt();
        System.out.print("y ");
        int y = scanner.nextInt();
        System.out.print("z ");
        int z = scanner.nextInt();
        Formula did = new Formula(x,y,z);
        did.displayFormula();
        try{
            int result=Formula.getFormula(x, y, z);
            System.out.println(result);
        }
        catch (FormulaException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

    }
}
class Formula {
    float x;
    float y;
    float z;
    public Formula(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void displayFormula() {
        double vector = Math. sqrt( Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2) );
        System.out.println(vector);
    }
    public static int getFormula(int x, int y, int z) throws FormulaException {
        int result = 1;
        if (x < 0 ) throw new FormulaException (" Число меньше 0 ",x );
        for (int p = 0; p <= x; p++) {
            result *= p;
        }
        if (y < 0 ) throw new FormulaException (" Число меньше 0 ",y );
        for (int p = 0; p <= y; p++) {
            result *= p;
        }
        if (z < 0 ) throw new FormulaException (" Число меньше 0 ",z );
        for (int p = 0; p <= z; p++) {
            result *= p;
        }
        return result;
    }
}
class FormulaException extends Exception {
    private int numb;
    public int getNumber() {
        return numb;
    }

    public FormulaException(String message, int scanner) {
        super(message);
        numb = scanner;
    }
}