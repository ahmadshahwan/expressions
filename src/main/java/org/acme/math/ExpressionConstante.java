package org.acme.math;

/**
 * Expression constante.
 */
public class ExpressionConstante implements Expression {

    /**
     * La valeur constante de l'expression.
     */
    private final ValeurTypee valeurTypee;

    /**
     * Constructeur.
     *
     * @param valeur La valeur constante de l'expression
     */
    public ExpressionConstante(ValeurTypee valeur) {
        this.valeurTypee = valeur;
    }

    @Override
    public ValeurTypee calculate() {
        return this.valeurTypee;
    }

    @Override
    public String toString() {
        return this.valeurTypee.toString();
    }
}
