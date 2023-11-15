package org.acme.math;

/**
 * Expression binaire de division.
 */
public class Division extends ExpressionBinaire {

    /**
     * Constructeur.
     *
     * @param gauche Expression gauche
     * @param droite Expression droite
     */
    protected Division(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    protected int appliquer(int gauche, int droite) {
        return gauche / droite;
    }

    @Override
    protected double appliquer(double gauche, double droite) {
        return gauche / droite;
    }

    @Override
    protected String getOperateur() {
        return "/";
    }
}
