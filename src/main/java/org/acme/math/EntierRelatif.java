package org.acme.math;

/**
 * Valeur de type entier.
 */
public class EntierRelatif implements ValeurTypee {

    /**
     * Valeur stockée.
     */
    private final int valeur;

    /**
     * Constructeur.
     *
     * @param valeur Valeur à stocker
     */
    public EntierRelatif(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Extrait la valeur stockée.
     *
     * @return Valeur entier stockée
     */
    public int getEntier() {
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
