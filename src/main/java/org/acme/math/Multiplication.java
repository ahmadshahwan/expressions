package org.acme.math;

/**
 * Expression binaire de multiplication.
 */
public class Multiplication extends ExpressionBinaire {

    protected Multiplication(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    protected int appliquer(int gauche, int droite) {
        return gauche * droite;
    }

    @Override
    protected double appliquer(double gauche, double droite) {
        return gauche * droite;
    }

    @Override
    protected String getOperateur() {
        return "*";
    }
}
