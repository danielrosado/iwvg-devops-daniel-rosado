package es.upm.miw.iwvg_devops.code;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return numerator * fraction.denominator == denominator * fraction.numerator;
    }

    public Fraction add(Fraction fraction) {
        int gcd = gcd(denominator, fraction.denominator);
        int den = (denominator * fraction.denominator) / gcd;
        int num = (numerator) * (den / denominator) + (fraction.numerator) * (den / fraction.denominator);
        Fraction sum = new Fraction(num, den);
        sum.reduce();
        return sum;
    }

    private int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
    }

    public Fraction multiply(Fraction fraction) {
        int num = numerator * fraction.numerator;
        int den = denominator * fraction.denominator;
        Fraction mult = new Fraction(num, den);
        mult.reduce();
        return mult;
    }

    public Fraction divide(Fraction fraction) {
        int num = numerator * fraction.denominator;
        int den = denominator * fraction.numerator;
        Fraction div = new Fraction(num, den);
        div.reduce();
        return div;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
