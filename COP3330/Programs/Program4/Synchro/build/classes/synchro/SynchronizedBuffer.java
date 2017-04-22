/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package synchro;

public class SynchronizedBuffer implements Buffer {
   
    private String buffer    = "NIL";
    private boolean occupied = false;
    private int prodwrite = 0;
    private int consreads = 0;
    public static long waitprod = 0;
    public static long waitcons = 0;
    
    /*
    Occupied is true when the buffer is occupied:
    - if true, producer must wait for consumer to read.
    - if false, consumer must wait for producer to write
    - set to false after consumer reads value from buffer
    - set to true after producer writes value to buffer
    */
    
    public synchronized void put (String value) throws InterruptedException {
        
        long startTime;
        long endTime;
    
        while (occupied) {
            System.out.println( "Producer tries to write." );
            displayState( "Buffer full. Producer waits.");
            startTime = System.nanoTime() /  1000000;
            wait();
            endTime = System.nanoTime() /  1000000;
            waitprod += endTime - startTime;
        }
        
        buffer = value;
        occupied = true;
        displayState( "Producer writes " + ++prodwrite );
        notifyAll();
    }
  
    public synchronized String get () throws InterruptedException {
        
        long startTime;
        long endTime;
        
        while ( !occupied ) {
            System.out.println( "Consumer tries to read." );
            displayState( "Buffer empty. Consumer waits." );
            startTime = System.currentTimeMillis();
            wait();
            endTime = System.currentTimeMillis();
            waitcons += endTime - startTime;
        }
        
        occupied = false;
        displayState( "Consumer reads " + ++consreads );
        notifyAll();
        return buffer;
    }
    
    private synchronized void displayState ( String operation ) {
        System.out.printf( "%-30s\t\t%s\t%b%n%n" , operation, buffer, buffer, occupied );
    }
    
}
