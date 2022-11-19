package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Expression Evaluator Test
 */
class ExpressionEvaluatorTest {


    /**
     * test za testiranje da li se racuna tacna vrijednost
     */
    @Test
    void evaluate() {
        Double r = ExpressionEvaluator.evaluate("( 8 + ( 1 - 4 ) )");
        assertEquals(5.0, r);
    }

    /**
     * test za testiranje da li se vraca tacna vrijednost oduzimanja
     */
    @Test
    void oduzimanje() {
        String s = new String("( 8 - 4 )");
        Double r = ExpressionEvaluator.evaluate(s);
        assertEquals(4.0, r);
    }

    /**
     * test za testiranje da li se baca izuzetak ukoliko se unese prazna zagrada
     */
    @Test
    void izuzetak(){


        Assertions.assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.evaluate("( )"));
        Assertions.assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.evaluate("( 8 + ( ) )"));
        Assertions.assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.evaluate("(( 8 + 3) )"));
        Assertions.assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.evaluate("( 8 + ( 2 + 3 )"));
    }

    /**
     * test za testiranje da li se vraca tacna vrijednost sabiranja
     */
    @Test
    void sabiranje() {
        String s = new String("( 8 + 4 )");
        Double r = ExpressionEvaluator.evaluate(s);
        assertEquals(12, r);
    }

    /**
     * test za testiranje da li se vraca tacna vrijednost mnozenja
     */
    @Test
    void mnozenje() {
        String s = new String("( 8 + 4 )");
        Double r = ExpressionEvaluator.evaluate(s);
        assertEquals(12, r);
    }

    /**
     * test za testiranje da li se vraca tacna vrijednost dijeljenja
     */
    @Test
    void dijeljenje() {
        String s = new String("( 8 / 4 )");
        Double r = ExpressionEvaluator.evaluate(s);
        assertEquals(2, r);
    }

    /**
     * test za testiranje da li se vraca tacna vrijednost korijena
     */
    @Test
    void korijen(){
        String s = new String("( sqrt  4 )");
        Double r = ExpressionEvaluator.evaluate(s);
        assertEquals(2, r);
        String s1 = new String(" sqrt  ( 4 )" );
        Double r1 = ExpressionEvaluator.evaluate(s1);
        assertEquals(2, r1);

    }
}