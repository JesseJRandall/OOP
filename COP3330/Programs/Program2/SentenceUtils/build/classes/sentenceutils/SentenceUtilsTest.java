/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package sentenceutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentenceUtilsTest {
    
    private static List<SentenceUtils> slist = new ArrayList();
    
    public static void main(String[] args) {
        
        try {
            File file = new File( args[ 0 ] );
            Scanner scanner = new Scanner( file );
            
            while( scanner.hasNextLine() ) {
                String sent = scanner.nextLine();
                if( sent.trim().length() > 0 ) {
                    SentenceUtils sutil = new SentenceUtils( sent );
                    slist.add( sutil );
                }
            }
            
            System.out.println("COP3330 Sentence Utility Tester by Jesse Randall.\n");
            System.out.printf("Input file name: %s\n", args[ 0 ]);
            System.out.printf("Number of sentences: %d\n\n", slist.size());
            System.out.println("Sentence reports:");
            
            for( int i = 0; i < slist.size(); i++ ) {
                System.out.printf("\nSentence %d >\n", i);
                slist.get(i).report();
                System.out.printf("\n");
            }           
            
        }
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
