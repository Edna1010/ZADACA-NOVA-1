package ba.unsa.etf.rpr;

import java.util.InputMismatchException;
import java.util.Stack;

/**
 * ExpressionEvaluator klasa
 * @author Edna Basic
 * klasa koja razdvaja brojeve i operatore u dva steka
 */
public class ExpressionEvaluator {

    static Stack<String> operatori=new Stack<String>();
    static Stack<Double>brojevi=new Stack<Double>();
    private static final RuntimeException izuzetak=new RuntimeException("Netacan unos");



    /**
     * Ovo je evaluate metoda koja racuna izraz u zagradi koristeci Dijakstra algoritam
     * @param unos tipa string
     * @return double vrijednost
     *
     */
    public static  Double evaluate(String unos)throws RuntimeException{
        if(unos.contains("( )")) throw izuzetak;
        if(unos.contains("((")) throw izuzetak;
        String[] novi=razdvoji(unos);
        int brojac1=0;
        int brojac2=0;
        int brojac3=0;
        for(String s:novi){
            if (s.equals("("))brojac1++;
            else if(JeLiOperator(s)){
                operatori.push(s);
            brojac3++;}
            else if(s.equals(")")){
                if(brojevi.empty())throw izuzetak;
                else {
                Double rez = (double) 0;
                brojac2++;
                    String operator=operatori.pop();
                    if(operator.equals("sqrt")){
                        Double prvi= brojevi.pop();
                       rez=korijen(prvi);
                    }
                    else if(operator.equals("+")){
                        Double prvi= brojevi.pop();
                        Double drugi = brojevi.pop();
                        rez = sabiranje(prvi, drugi);

                    }
                    else if(operator.equals("-")){
                        Double prvi= brojevi.pop();
                        Double drugi = brojevi.pop();
                        rez = oduzimanje(prvi, drugi);

                    }
                    else if(operator.equals("*")){
                        Double prvi= brojevi.pop();
                        Double drugi = brojevi.pop();
                        rez=mnozenje(prvi,drugi);

                    }
                    else if(operator.equals("/")){
                        Double prvi= brojevi.pop();
                        Double drugi = brojevi.pop();
                        rez=dijeljenje(drugi,prvi);

                    }
                    brojevi.push(rez);
                }}
            else {
                try{
                brojevi.push(Double.valueOf(s));
                 }
                catch (Exception izuzetak){
                    izuzetak.getMessage();
                }
            }
        }
        if(brojac1!=brojac2 || brojac2!=brojac3) throw new InputMismatchException("Netacan unos");
        return brojevi.pop();}

    /**
     * Uzimaju se dva parametra i vraca se njihova razlika
     * @param a tipa Double
     * @param b tipa Double
     * @return razlika tipa double
     */
    private static Double oduzimanje(Double a, Double b){
        return b-a;
    }

    /**
     *Uzimaju se dva parametra i vraca se njihov zbir
     * @param a tipa Double
     * @param b tipa Double
     * @return zbir tipa double
     */
    private static Double sabiranje(Double a, Double b){
        return a+b;
    }

    /**
     * Uzimaju se dva parametra i vraca se njihov proizvod
     * @param a tipa Double
     * @param b tipa Double
     * @return proizvod tipa double
     */
   private static double mnozenje(Double a, Double b){
        return a*b;
    }

    /**
     * Uzimaju se dva parametra i vraca se njihov kolicnik
     * @param a tipa Double
     * @param b tipa Double
     * @return kolicnik tipa double
     */
    private static double dijeljenje(Double a, Double b){
        return a/b;
    }

    /**
     * Uzima se jedan parametar i vraca se njegov korijen
     * @param a tipa Double
     * @return korijen tipa double
     */
    private static double korijen(Double a){
        return Math.sqrt(a);
    }

    /**
     * Uzima se string, te se pretvara u niz substringova
     *
     */
    private static String[] razdvoji(String string) {
        return string.split(" ");
    }

    /**
     * Uzima se string i provjerava da li je jedan od opeartora te vraca true ili false
     * @param s tipa string
     * @return true ili false
     */
    private static boolean JeLiOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
            return true;
        return false;
    }

}


