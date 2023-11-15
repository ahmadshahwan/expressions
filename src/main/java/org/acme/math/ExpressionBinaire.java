package org.acme.math;

/**
 * Expression binaire.
 */
public abstract class ExpressionBinaire implements Expression {

    /**
     * Expression gauche.
     */
    protected final Expression gauche;

    /**
     * Expression droite.
     */
    protected final Expression droite;

    /**
     * Constructeur.
     *
     * @param gauche Expression gauche
     * @param droite Expression droite
     */
    protected ExpressionBinaire(Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    @Override
    public ValeurTypee calculate() {
        ValeurTypee gaucheValeur = this.gauche.calculate();
        ValeurTypee droiteValeur = this.droite.calculate();
        if (
                gaucheValeur instanceof EntierRelatif firstInteger &&
                droiteValeur instanceof EntierRelatif secondInteger
        ) {
            int result = this.appliquer(firstInteger.getEntier(), secondInteger.getEntier());
            return new EntierRelatif(result);
        } else {
            double result = this.appliquer(gaucheValeur.asDouble(), droiteValeur.asDouble());
            return new ReelFlottant(result);
        }
    }

    /**
     * Appliquer l'opération sur deux entiers.
     *
     * @param gauche Entier côté gauche
     * @param droite Entier côté droite
     * @return Entier résultat
     */
    abstract protected int appliquer(int gauche, int droite);

    /**
     * Appliquer l'opération sur deux réels.
     *
     * @param gauche Réel côté gauche
     * @param droite Réel côté droite
     * @return Réel résultat
     */
    abstract protected double appliquer(double gauche, double droite);

    abstract protected String getOperateur();

    @Override
    public String toString() {
        return "(%s %s %s)".formatted(this.gauche, this.getOperateur(), this.droite);
    }
}
