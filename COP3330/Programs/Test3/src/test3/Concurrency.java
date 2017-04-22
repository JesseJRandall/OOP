/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package test3;

import java.util.Random;
import java.util.Arrays;

/*
    
    *MULTIPROGRAMMING:
    Running separate programs at the same time looks like they are running 
    simultaneously. This is NOT the case. They are running CONCURRENTLY.    
    Programs share the processors attention with the use of a SCHEDULING
    ALGORITHM. Each program has its own memory, method call stack, heap,
    and progam counter.
    
    *MULTITHREADING: 
    Like multiprocessing except we refer to processes that are children of a 
    single application program. Allows the rest of the program to run without
    waiting for a long running child process.
    
    Java supports concurrency by allowing programs to have multiple THREADS OF
    EXECUTION. 
    - Threads: run like separate program, share memory, file handles.
    
    Java has a concurrency API that make concurrency programming easier.
    - Package java.util.concurrent
    
    Look at INTERFACES EXECUTOR and EXECUTORSERVICE.
    
    *THREAD STATES:
    A thread is always in some state:
    - "new"        : thread is first instantiated, NOT RUNNING.
    - "runnalbe"   : thread is started / acquires resources it needs. RUNNING.
    - "waiting"    : thread must wait for another thread to perform task to 
                     perform its task.
    - "timed wait" : when the thread is waiting for specified time interval.
    - "blocked"    : thread is waiting for another thread to release resource.
    - "terminated" : when thread completes / crashes.
                  
    *RUNNABLE STATES:
    JVM sees this as one state. Operating system uses its scheduling algorithm 
    to switch back and forth from ready (no processor assigned) to running 
    (processor assigned).
    
    *THREAD PRIORITIES AND DEADLOCK:
    Every thred has a priority for scheduling (inherited from thread that made it).
    
    OS scheduling algorithm generally lets higher priority threads PREEMPT lower
    priority ones. Sometimes a thread can STARVE, constantly being preempted.
    
    DEADLOCK - Two threads each holding onto a resource that the other one needs
    while waiting for them to release it.
    
    *EXECUTOR FRAMEWORK:
    Preferred mechanism for executing threads.
    1) Create threads (concurrent tasks) with runnable interface
       - public class MyClass implements Runnable { ...
    
    2) Obtain an ExecutorService object from the Executor class
       - ExecutorService = Executors.newCachedThreadPool();
    
    3) Run the threads using the executor service's execute() method
       - ex.execute( <thread_reference> );
    NOTE: Call returns immediately, does not wait for thread to finish.
    
    *RUNNABLE INTERFACE:
    The interface contains only the public abstract void run() method.
    - When an object implementing interface Runnable is used to create
      a thread, starting the thread causes the object's run method to be
      called in that separately executing thread.
    
    *THREAD SYNCHRONIZATION:
    Consider -
    - Program has a shared variable int n, with current value 7.
    - Thread 1 updates n to value n++
    - Thread 2 updates n to value 2*n
    - Thread 3 reads value of n and uses it in its operation
    - Desired outcome is for Thread 3 to read the value n = 16
    
    Since order of execution is not guaranteed, sometimes Thread 2 will 
    start before Thread 1 is finished, and still finish after Thread 1.
    Thread 3 then reads n = 14 instead of n = 16
    
    Solution is to give only one thread at a time EXCLUSIVE ACCESS to the 
    code that accesses the shared data.
    - Called THREAD SYNCHRONIZATION
    - Enforces the principle of MUTUAL EXCLUSION
    
    *MONITORS:
    Java supports explicit MUTUAL EXCLUSION using MONITORS. Only ONE THREAD at a 
    time can access a designated resource.
    
    Every Java object has a built-in MONITOR (instance method)
    - MONITOR LOCK or INTRINSIC LOCK.
    - Lock can be held by only one thread at a time.
    - Similar to having only person drive a car at a time. (Good analogy)
    - Other THREADS needing the lock are BLOCKED and must WAIT until lock is
      released.
    
    Implemented by using the "SYNCHRONIZED" keyword
    - Around a block of code
    - Can also have synchronized methods
    - Can even have static synchronized methods

    *TOPICS
    Causing a thread to pause execution for a specified time "sleep".
    - Done in the thread's run() method (Sleeping is NOT NECESSARY)
    - run () is required for the Runnable interface which the thread implements.
    
*/

class PrintTask implements Runnable {
    
    // Implements runnable interface. 
    private final static Random random = new Random();
    private final int sleepTime;
    private final String name;
    
    public PrintTask (String name) {
        this.name = name;
        sleepTime = random.nextInt(5); // milliseconds
    }
    
    @Override
    public void run() {
        
        try {
            // Report how long will sleep.
            System.out.printf("%s going to sleep for %d millisecons.%n",
                    name, sleepTime);
            
            // Use static method to sleep.
            Thread.sleep(sleepTime);
        }
        
        catch (InterruptedException exc) {
            exc.printStackTrace();
            Thread.currentThread().interrupt();
        }
        
        // Report when finished.
        System.out.printf("%s done sleeping%n", name);
    }
}

/* 
Examples of Synchronized Data Sharing.
*/

/*
Instance of this class will be shared by multiple threads. Require the monitor
lock for the instance method "add()" by adding the "synchronized" keyword in
method declaration.
*/
class SimpleArray {
    
    private static final Random random = new Random();
    private final int[] array;
    private int idx = 0;
    
    public SimpleArray (int size) {
        array = new int[size];
    }
    
    public synchronized void add (int value) {
        
        int position = idx;
        
        try {
            Thread.sleep(random.nextInt(5));
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        array[position] = value;
        System.out.printf( "%s wrote %2d to element %d.%n",
                Thread.currentThread().getName(), value, position );
        
        ++idx;
        System.out.printf( "Next write index: %d%n", idx );
    }
    
    public String toString () {
        return Arrays.toString(array);
    } 
}

/* 
Instance of this thread will insert 3 consecutive values into the given
SimpleArray starting with a given value.
*/
class ArrayWriter implements Runnable {
    
    private final SimpleArray shared;
    private final int val;
    
    public ArrayWriter (int value, SimpleArray array) {
        val = value;
        shared = array;
    }
    
    public void run () {
        for ( int i = val; i < val + 3; i++ ) {
            shared.add(i);
        }
    }
}