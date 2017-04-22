/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package synchro;

// import java.util.Random;

public class Producer implements Runnable {
    
    // private static final Random random = new Random();
    private final Buffer shared;
    private final String sentence;
    
    public Producer (Buffer sharedLocation, String sentence) {
        this.shared = sharedLocation;
        this.sentence = sentence;
    }
    
    @Override
    public void run () {
        
        long startTime = System.currentTimeMillis();
        int writes = 0;
          
        String [] arr = sentence.split(" ");
        
        for (int i = 0 ; i < arr.length + 1 ; i++) {
            try {
                if ( i == arr.length ) {
                    // Thread.sleep( random.nextInt( 300 ) );
                    shared.put( "@@@" );
                    writes++;
                }
                else {
                    // Thread.sleep( random.nextInt( 300 ) );
                    shared.put( arr[ i ] );
                    writes++;
                }    
            }
                
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        long endTime = System.currentTimeMillis();    
        System.out.printf( "Producer summary: %s @@@\n"
                         + "Total writes: %d\n"
                         + "Total sleep time: %d milliseconds\n"
                         + "Total time from start: %d milliseconds\n\n"
                         , sentence,  writes, SynchronizedBuffer.waitprod, endTime - startTime);
        
    }
    
}
