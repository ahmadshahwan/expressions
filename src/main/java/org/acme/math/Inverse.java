package org.acme.math;

/**
 * Expression représentant l'inverse multiplicatif.
 */
public class Inverse extends ExpressionUnaire {

    /**
     * Constructeur.
     *
     * @param operande L'expression à inverser
     */
    protected Inverse(Expression operande) {
        super(operande);
    }

    @Override
    public ValeurTypee calculate() {
        double original = operand.calculate().asDouble();
        return new ReelFlottant(1D / original);
    }

    @Override
    public String toString() {
        return "(%s ^ -1)".formatted(operand);
    }
}
