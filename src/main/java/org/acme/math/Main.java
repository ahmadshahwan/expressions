package org.acme.math;

public class Main {

    public static void main(String[] args) {
        EntierRelatif deux = new EntierRelatif(2);
        EntierRelatif trois = new EntierRelatif(3);
        EntierRelatif quatre = new EntierRelatif(4);
        ExpressionConstante ope2 = new ExpressionConstante(deux);
        ExpressionConstante ope3 = new ExpressionConstante(trois);
        ExpressionConstante ope4 = new ExpressionConstante(quatre);
        Expression exp = new Addition(new Multiplication(ope3, ope4), new Inverse(ope2));
        System.out.printf("%s = %s", exp, exp.calculate());
    }
}
