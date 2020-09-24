package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(1, 2);
    }

    @Test
    void testConstructor() {
        Fraction f = new Fraction();

        assertEquals(1, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testGetNumerator() {
        assertEquals(1, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(4);

        assertEquals(4, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(5);

        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal(), 0.00001);
    }

    @Test
    void testIsProper() {
        assertTrue(fraction.isProper());
        assertFalse(new Fraction(7,2).isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(fraction.isImproper());
        assertTrue(new Fraction(7, 2).isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(fraction.isEquivalent(new Fraction(3, 6)));
        assertFalse(fraction.isEquivalent(new Fraction(2, 5)));
    }

    @Test
    void testAdd() {
        Fraction f = new Fraction(3, 5);

        Fraction sum = fraction.add(f);

        assertEquals(11, sum.getNumerator());
        assertEquals(10, sum.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction f = new Fraction(3, 5);

        Fraction mult = fraction.multiply(f);

        assertEquals(3, mult.getNumerator());
        assertEquals(10, mult.getDenominator());
    }

    @Test
    void testMultiply2() {
        Fraction f = new Fraction(5, 10);

        Fraction mult = fraction.multiply(f);

        assertEquals(1, mult.getNumerator());
        assertEquals(4, mult.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction f = new Fraction(3, 5);

        Fraction div = fraction.divide(f);

        assertEquals(5, div.getNumerator());
        assertEquals(6, div.getDenominator());
    }

    @Test
    void testIsNegative() {
        assertFalse(fraction.isNegative());
        assertTrue(new Fraction(-1, 2).isNegative());
        assertFalse(new Fraction(-1, -2).isNegative());
    }

    @Test
    void testToString() {
        String fractionStr = "Fraction{" +
                "numerator=" + fraction.getNumerator() +
                ", denominator=" + fraction.getDenominator() +
                '}';

        assertEquals(fractionStr, fraction.toString());
    }
}