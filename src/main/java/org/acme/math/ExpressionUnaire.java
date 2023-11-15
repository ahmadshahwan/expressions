package org.acme.math;

/**
 * Expression unaire.
 */
public abstract class ExpressionUnaire implements Expression {

    /**
     * Le seul opérande.
     */
    protected final Expression operand;

    /**
     * Constructeur.
     *
     * @param operand l'opérande de l'expression
     */
    protected ExpressionUnaire(Expression operand) {
        this.operand = operand;
    }
}
