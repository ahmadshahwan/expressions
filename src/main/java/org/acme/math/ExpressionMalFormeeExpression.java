package org.acme.math;

/**
 * Exception levée lorsqu'une expression est mal formée.
 */
public class ExpressionMalFormeeExpression extends RuntimeException {

    /**
     * Constructeur.
     *
     * @param message message d'erreur
     */
    public ExpressionMalFormeeExpression(String message) {
        super(message);
    }
}
