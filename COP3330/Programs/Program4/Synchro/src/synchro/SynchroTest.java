/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package synchro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/*
File read contains only one sentence with an unknown number of words.
Producer must take the sentence as an argument, send one word at a time
to the consumer, and, when at the end, send the string '@@@' to signify
that the string is over.
*/

public class SynchroTest {

    public static void main(String[] args) {
        
        try {
            
            // Read in the file and use scanner to retrieve the string.
            File file = new File( args[ 0 ] );
            Scanner scanner = new Scanner( file );
            String sentence = scanner.nextLine();
            
            // Output formatting for table
            System.out.printf("University of Central Florida\n"
                    + "COP3330 Object Oriented Programming, Spring 2017\n\n"
                    + "Synchronized Buffer by: Jesse Randall\n\n"
                    + "Input file: %s\nInput sentence: %s\n\n"
                    + "%-30s\t\t%s\t%s\n"
                    + "%-30s\t\t%s\t%s\n"
                    , args[ 0 ], sentence, "Operation", "Buffer", "Occupied"
                    , "---------", "------", "--------");
            
            // Instantiate a SynchronizedBuffer object and ExecutorService
            Buffer sharedLocation = new SynchronizedBuffer();           
            ExecutorService executorService = Executors.newCachedThreadPool();
            
            // Use the executorService on a Producer and Consumer object
            executorService.execute( new Producer ( sharedLocation, sentence ) );
            executorService.execute( new Consumer ( sharedLocation) );
            
            // Shut down executor
            executorService.shutdown();
            executorService.awaitTermination( 1, TimeUnit.MINUTES );         
        }
        
        // Two potential exceptions that may arise.
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}