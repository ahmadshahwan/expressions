package org.acme.math;

/**
 * Valeur de type réel flottant.
 */
public class ReelFlottant implements ValeurTypee {

    /**
     * La valeur stockée.
     */
    private final double valeur;

    /**
     * Constructeur.
     *
     * @param valeur Valeur à stocker
     */
    public ReelFlottant(double valeur) {
        this.valeur = valeur;
    }

    /**
     * Extrait la valeur stockée.
     *
     * @return La valeur réelle stockée
     */
    public double getReel() {
        return this.valeur;
    }

    @Override
    public double asDouble() {
        return this.valeur;
    }

    @Override
    public String toString() {
        return String.valueOf(this.valeur);
    }
}
