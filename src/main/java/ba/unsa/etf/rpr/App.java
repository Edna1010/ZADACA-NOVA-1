package ba.unsa.etf.rpr;

/**
 * App class
 */
public class App {
       /**
     * Ovo je main metoda
     * @param args tipa String
     */
    public static void main(String[] args) {
      StringBuilder unos=new StringBuilder();
        for(int i=0; i<args.length; i++){
            unos.append(args[i]);
            if(i!=args.length-1)
                unos.append(" ");
        }
        try{
            Double rezultat=ExpressionEvaluator.evaluate(unos.toString());
            System.out.println(" iznosi " +rezultat);
        }
        catch(Exception izuzetak){
            System.err.println(izuzetak.getMessage());
        }
    }
}
