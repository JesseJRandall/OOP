/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package test3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    
}

interface Buffer {
    
    public void put (int value) throws InterruptedException;
    
    public int get() throws InterruptedException;
}

class BlockingBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer () {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    public void put(int value) throws InterruptedException {
        buffer.put( value );
        System.out.println( "Producer writes: " + value + "\t\t" + buffer.size() );
    }

    public int get () throws InterruptedException {

        int readValue = buffer.take();
        System.out.println( "Consumer reads: " + readValue + "\t\t" + buffer.size() );
        
        return readValue;
    }
}

/*
class BlockingBufferTest {
    public static void main (String [] args) throws InterruptedException {
        System.out.println( "Action\t\tValue\tBuffer Size" );
        System.out.println( "------\t\t-----\t-----------" );
        
        Buffer sharedLocation = new BlockingBuffer();
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute( new Producer( sharedLocation ) );
        executorService.execute( new Consumer( sharedLocation ) );
        
        executorService.shutdown();
        executorService.awaitTermination( 1, TimeUnit.MINUTES );
    }
}
*/

// See HW6 for Producer / Consumer class.