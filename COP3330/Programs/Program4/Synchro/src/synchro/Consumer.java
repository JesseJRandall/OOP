/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package synchro;

// import java.util.Random;

public class Consumer implements Runnable {
    
    // private static final Random random = new Random();
    private final Buffer shared;
    
    public Consumer (Buffer sharedLocation) {
        this.shared = sharedLocation;
    }
    
    @Override
    public void run () {
        
        long startTime = System.currentTimeMillis();
        String list = new String();
        String last = new String();
        int reads = 0;
        
        while ( last != "@@@" ) {
            try {
                // Thread.sleep( random.nextInt( 300 ) );
                last = shared.get();
                list += " " + last;
                reads++;
            }
        
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        long endTime = System.currentTimeMillis();       
        System.out.printf( "Consumer summary: %s\n"
                         + "Total reads: %d\n"
                         + "Total sleep time: %d milliseconds\n"
                         + "Total time from start: %d milliseconds\n\n"
                         , list, reads, SynchronizedBuffer.waitcons, endTime - startTime );
    }   
}
