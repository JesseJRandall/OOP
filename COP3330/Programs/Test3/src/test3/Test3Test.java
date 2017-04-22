/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package test3;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.List;
import java.util.ArrayList;

public class Test3Test {

    public static void main(String[] args) {
        
        // CONCURRENCY EXAMPLE
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");
        
        System.out.println("Starting Executor");
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        // Use ExecutorService to manage threads.
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        
        // main() finishes as soon sa threads launched.
        executorService.shutdown();
        System.out.printf("Tasks started, main ends.%n%n");
        //
        
        
        // SYNCHRONOUS DATA SHARING EXAMPLE
        // Instantiates two ArrayWriters and uses ExecutorService to schedule them
        SimpleArray shared = new SimpleArray(6);
        
        ArrayWriter writer1 = new ArrayWriter(1, shared);
        ArrayWriter writer2 = new ArrayWriter(11, shared);
        
        // ExecutorService manages threads.
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(writer1); // Start task1.
        executorService1.execute(writer2); // Start task2.
        
        executorService1.shutdown(); // Accept no new tasks.
        
        // To wait for both threads to complete, use "waitTermination" method.
        try {
            // wait 1 minute for both writers to finish executing
            boolean tasksEnded =
                    executorService1.awaitTermination(1, TimeUnit.MINUTES);
            
            if (tasksEnded) {
                System.out.printf("%nContents of SimpleArray:%n");
                System.out.println(shared);
            }
            else {
                System.out.println("Timed out while waiting for tasks to finish.");
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //
        
        // EXCEPTION HANDLING
        // Provides output message with stacktrace and throws an exception.
        // ExceptionHandling.error();
        
        
        // GENERIC CLASSES, METHODS, PROGRAMS
        // Example printing an array of strings.
        String [] string = { "Hello!", "Fuck off!" };
        Generic.printArray( string );
        
        // Example using maximum generic method
        System.out.printf( "%nMaximum of %d, %d, and %d is %d%n%n", 3, 4, 5, 
                            Maximum.maximum(3,4,5) );
        System.out.printf( "%nMaximum of %s, %s, and %s is %s%n%n", "pear", "apple",
                           "orange", Maximum.maximum("pear", "apple", "orange") );
        
        // Example using WildCard generic class.
        Number [] numbers = { 1, 2.4, 3, 4.1 };
        ArrayList <Number> numberList = new ArrayList <> ();
        
        for ( Number element : numbers ) {
            numberList.add( element );
        }
        
        System.out.printf( "numberList contains: %s%n", numberList );
        System.out.printf( "Total of the elements in numberList: %.1f%n", 
                            WildCard.sum( numberList ) );
        
        // Example using CustomStack generic class.
        CustomStack <Object> pile = new CustomStack();
        pile.push(1);
        pile.push(2.3);
        pile.push("apple");
        
        Object thing = pile.pop();
        while ( thing != null ) {
            System.out.println( thing.toString() );
            thing = pile.pop();
        }
        
        // Example using CustomQueue
        CustomQueue q = new CustomQueue();
        q.enqueue( 1 );
        q.enqueue( 2.3 );
        q.enqueue( "apple" );
        q.enqueue( new ArrayList() );
        
        System.out.println( q.show() );
        
        Object t = q.dequeue();
        System.out.println( "t = " + t.toString() );
        
        System.out.println( q.show() );
        
        
        // INPUT AND OUTPUT
        IO.ReadTextFile();
    }
}
