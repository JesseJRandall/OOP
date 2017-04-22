/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package sentenceutils;

public class SentenceUtils {
    
    private static int num = 0; // Number of sentences.
    private String sentence;    // Array containing the sentence.
    private String[] tokens;    // Array containing each token in the sentence.
    private String[] shingles;  // Array containing the shingles from the sentence.
    
    public SentenceUtils( String s ) {
        // Constructor for the class Sentence Utils.
        sentence = s;
        generateTokens();
        generateShingles();
    }
    
    private void generateTokens() {
        // Instance method of the class Sentence Utils.
        // Breaks string into tokens.
        tokens = sentence.split("\\s");
    }
    
    private void generateShingles() {
        // Instance method of the class Sentence Utils.
        // Breaks string into shingles.
        shingles = new String[ sentence.length() - 1];
        for( int i = 0; i < sentence.length() - 1; i++) {
            shingles[ i ] = sentence.substring( i, i + 2 );
        }      
    }
    
    public void report() {
        // Instance method of the class Sentence Utils.
        // Prints out result of previous instance methods.
        System.out.println(sentence);
        
        for(int i = 0; i < tokens.length; i++) {
            System.out.printf("%d:%s\n", i, tokens[i]);
        }
        
        for(int i = 0; i < shingles.length; i++) {
            System.out.printf("\'%s\' ", shingles[i]);
        }
    }
}
