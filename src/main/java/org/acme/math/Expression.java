package org.acme.math;

import java.util.function.BinaryOperator;

/**
 * Expression arithmétique.
 */
public interface Expression {

    /**
     * Calcule la valeur de l'expression.
     *
     * @return la valeur de l'expression.
     */
    ValeurTypee calculate();

    /**
     * Lire une expression représentée sous forme de chaîne de caractères.
     *
     * @param input Chaîne de caractères représentant l'expression
     * @return L'expression interprétée
     */
    static Expression lire(String input) {
        String str = input.trim();
        if (str.isEmpty()) {
            throw new ExpressionMalFormeeExpression("Invalid empty expression");
        }
        char firstChar = str.charAt(0);
        if (firstChar == '(') {
            int position = 1;
            int openParentheses = 1;
            while (position < str.length() && openParentheses > 0) {
                char c = str.charAt(position++);
                openParentheses += c == '(' ? 1 : c == ')' ? -1 : 0;
            }
            if (openParentheses == 0) {
                String subExpression = str.substring(1, position - 1);
                Expression left = lire(subExpression);
                return lireLaSuite(str, position, left);
            } else {
                throw new ExpressionMalFormeeExpression("Invalid expression <%s>".formatted(str));
            }
        } else {
            int position = 0;
            char c = str.charAt(position);
            if (c == '-') {
                position++;
                c = str.charAt(position);
            }
            while (position < str.length() && (c >= '0' && c <= '9' || c == '.')) {
                c = str.charAt(position);
                position++;
            }
            if (position == 0) {
                throw new ExpressionMalFormeeExpression("Invalid expression <%s>".formatted(str));
            } else {
                Expression left = lireConstant(str.substring(0, position));
                return lireLaSuite(str, position, left);
            }
        }

    }

    private static Expression lireLaSuite(String input, int position, Expression left) {
        while (position != input.length() && Character.isWhitespace(input.charAt(position))) {
            position++;
        }
        if (position == input.length()) {
            return left;
        }
        char operator = input.charAt(position);
        String rightString = input.substring(position + 1);
        if (operator == '^') {
            if (!rightString.trim().equals("-1")) {
                throw new ExpressionMalFormeeExpression("Invalid exponent <%s>".formatted(rightString));
            }
            return new Inverse(left);
        }
        Expression right = lire(rightString);
        BinaryOperator<Expression> function = switch (operator) {
            case '+' -> Addition::new;
            case '-' -> Soustraction::new;
            case '*' -> Multiplication::new;
            case '/' -> Division::new;
            default -> throw new ExpressionMalFormeeExpression("Invalid operator <%s> in <%s>".formatted(operator, input));
        };
        return function.apply(left, right);
    }

    private static Expression lireConstant(String input) {
        String number = input.trim();
        try {
            ValeurTypee valeurTypee = input.contains(".")
                    ? new ReelFlottant(Double.parseDouble(number))
                    : new EntierRelatif(Integer.parseInt(number));
            return new ExpressionConstante(valeurTypee);
        } catch (NumberFormatException e) {
            throw new ExpressionMalFormeeExpression("Invalid constant <%s>".formatted(input));
        }
    }
}
