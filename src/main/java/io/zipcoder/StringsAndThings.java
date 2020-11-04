package io.zipcoder;
import java.util.regex.*;

/**
 * @author tariq
 * Earl Atta-Fynn
 * 11/2/2020
 */
public class StringsAndThings {


    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        char[] in = input.toCharArray();
        Integer count = 0;
        String query1 = "y ";
        String query2 = "z ";

        if (in[in.length - 1] == 'y' || in[in.length - 1] == 'z') {

            count += 1;
        }

        if (input.indexOf(query1) > -1 || input.indexOf(query2) > -1) {

            count += 1;
        }

        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        String excised = base.replaceAll(remove, "");
        return excised;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    public Boolean containsEqualNumberOfIsAndNot(String input) {

        Pattern patternIs = Pattern.compile("is");
        Matcher queryIs = patternIs.matcher(input);
        Pattern patternNot = Pattern.compile("not");
        Matcher queryNot = patternNot.matcher(input);
        Integer countIs = 0;
        Integer countNot = 0;
        Boolean result = null;

        while (queryIs.find()) {
            countIs++;
        }

        while(queryNot.find()) {
            countNot++;
        }

        if (countIs == countNot) {
            result = true;
        }

        if (countIs != countNot) {
            result = false;
        }

        return result;
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){

        Pattern pattern = Pattern.compile("gg");
        Matcher query = pattern.matcher(input);
        Boolean result = null;

        if (query.find() != true) {

            result = false;

        }

        else {

            String filtered = input.replaceAll("gg", "");

            if (filtered.contains("g")) {

                result = false;

            } else {

                result = true;

            }
        }

        return result;
    }




    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

        //Convert to charArray
        char[] in = input.toCharArray();
        int tripletCount = 0;

        //Iterate over char array and find triples
        for (int i = 0; i < in.length; i++) {
            if ( i <= in.length-3 && in[i] == in[i+1] && in[i+1] == in[i+2]) {
                tripletCount++;
            }
        }
        return tripletCount;
    }
}
