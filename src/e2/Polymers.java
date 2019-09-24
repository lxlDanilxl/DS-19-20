package e2;

import java.util.HashSet;

/**
 * Class for handling polymers represented by Strings
 */
public class Polymers {

    /**
     * Given a polymer represented with the letters of the alphabet ( uppercase
     * and lowercase excluding ~N), it processes the chain reactions of said
     * polymer ( due to adjoint units of the same type but different polarity ,
     * for example : aA ). It returns the polymer without the reactive pairs (it
     * can be an empty string ) and it throws an IllegalArgumentException if the
     * String passed as parameter is null .
     */
    public static String processPolymer(String polymer) {
        Character current;
        Character next;
        boolean found = false;
        String resultado;
        
        if (polymer==null)
            throw new IllegalArgumentException();
        
        StringBuilder sb = new StringBuilder(polymer);
        
        for (int i = 0; i < sb.length(); i++) {
            current = sb.charAt(i);
            if (Character.isLowerCase(current) && (i + 1 < sb.length())) {
                next = sb.charAt(i + 1);
                if (Character.isUpperCase(next)) {
                    if (next.equals(Character.toUpperCase(current))) {
                        sb.delete(i, i + 2);
                        found=true;
                    }
                }
            }
            if (Character.isUpperCase(current) && (i + 1 < sb.length())) {
                next = sb.charAt(i + 1);
                if (Character.isLowerCase(next)) {
                    if (next.equals(Character.toLowerCase(current))) {
                        sb.delete(i, i + 2);
                        found=true;
                    }
                }
            }
        }
        resultado = sb.toString();
        if (found) {
            resultado=Polymers.processPolymer(resultado);
        }
        return resultado;
    }

    /**
     * Given a polymer returns the monomer ( existing in the polymer ) whose
     * elimination ( both in its positive and negative form ) results , after
     * the consequent chain reactions , in the smallest polymer . It returns the
     * positive form ( lowercase ) of the monomer . In case of a tie , the one
     * with the lowest alphabetical order is returned . An
     * IllegalArgumentException is thrown if the original polymer is null or if
     * it is a empty string .
     */
    public static char minProcessedPolymer(String polymer) {
        if (polymer==null || polymer.equals("")) 
            throw new IllegalArgumentException();
        
        String str = polymer;
        HashSet check = new HashSet();
        int best = -1, count;
        char bestChar=0;
        String current;

        for (int i = 0; i < str.length(); i++) {
            str=polymer;
            if (check.isEmpty() || !check.contains(str.charAt(i))) {
                current=String.valueOf(str.charAt(i));
                str = str.replace(current.toUpperCase(), "");
                str = str.replace(current.toLowerCase(), "");
                str=Polymers.processPolymer(str);
                count = str.length();
                if (best < 0 || best > count) {
                    best=count;
                    bestChar = polymer.charAt(i);
                } else if (best==count || !Character.isAlphabetic(bestChar)) {
                    if (bestChar<polymer.charAt(i)) {
                        bestChar=polymer.charAt(i);
                    }
                }
                check.add(current.toUpperCase().charAt(0));
                check.add(current.toLowerCase().charAt(0));
            }
        }
        return bestChar;
    }
}
