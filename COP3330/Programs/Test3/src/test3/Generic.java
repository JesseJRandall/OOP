/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

/*
GENERIC CLASSES AND METHODS

*MOTIVATION
Basic idea: Doing SIMILAR things on DIFFERENT kinds of objects.

!!!MAKES THE TYPE A VARIABLE!!!
- Can be applied to both classes and methods.
- Type MUST be a reference type. (NOT Primitive)
- Type must be declared in the "type parameter" section
- Different declaration syntax for classes and methods

Example: Output values of different kinds of arrays.
- Old way (Not OOP): 
    public void printArray( int [] inputArray )
    public void printArrayDouble( double [] inputArray )
- Basic OOP way: Use Overloading
    public void printArray( int [] inputArray )
    public void printArray( double [] inputArray )
- Another OOP way: Use generic methods
    public <T> void printArray( T [] inputArray )
Advantage: Only write one method.

The term "parameterized type" can refer to a generic class, as well as a standard 
class, for example: CustomStack <Integer>, List <String>

*GENERIC METHOD
- Must have type parameter section before the return type
- Can have a generic method in either a generic class or a regular class.
- Type can be restricted

TYPE PARAMETERS: Required. PRECEDES return type. Use angle brackets. Contains 1
or more type parameters separated by commas. ( <T> ) MUST BE REFERENCE TYPES!!!

Benefit is that we can RESTRICT the types accepted while using type OBJECT cannot.

*GENERIC CLASS
- Type parameter section follows class name
- No need to declare again for methods that use the generic types (No overloading)
- Method input parameters, return type, and local variables can be of the generic type.

Generic stack follows LIFO. (Last in, first out.)
- Push new element onto the stack.
- Pop an element off the stack.

*RAW TYPES
When a generic is instantiated without specifying the type, it is a RAW TYPE
- CustomStack myStack = new CustomStack( 5 );
- Compiler implicitly uses type Object for each type argument.
- Effect is to allow ANY type of reference object.

Q: So why should we ever want to specify the type?
- When we wish to restrict the types of objects allowed. 
- CustomStack <Integer> mystack = new CustomStack( 5 );

*WILDCARD TYPE ARGUMENTS
Why do we need them?
- Can define a method that operates on COLLECTIONS of objects of a particular 
  supertype. public static double sum ( ArrayList <Number> list )
- Successfully processes collections containing objects of subtypes.
- If we pass to the method a collection of one of the subtypes, an ArrayList <Integer>
  then the program will not compile.
- Reason: Java does not consider ArrayList <Number> to be a superclass of ArrayList <Integer>
  because we can add a Double to an ArrayList <Number> but not to an ArrayList <Integer>.
(Makes total sense. Needs to be passed an array of the same wildcard type to 
accomodate all types that fit under the superclass.)

*INSTANTIATING GENERIC OBJECT
- Create generic object by calling its constructor with concrete types that comply
  with any restrictions.
- Example: public class Table < K, V > { Table < String, Integer > table = new Table(); }

- Type is considered a RAW TYPE if the object is instantiated without specifying
  the type. Java defaults type is of class Object.
- Example: public class CustomStack < T > { CustomStack dump = new CustomStack(); }

*GENERIC DATA STRUCTURES
Queue: 
- FIFO (First in first out). 
- ENQUEUE a new element to the end of the queue.
- DEQUEUE an element from the head of the queue.

LinkedList: Ordered Collection
- Ordered collection of self-referential class objects called nodes.
- Self-reference achieved by composition ( at least 1 field is a reference to another )
- Order maintained by the sequence of self-referential links

- Advantages:
    Grow or shrink dynamically.
    Don't need to shift elements when inserting in between
    Useful when membership in the collection is unpredictable
    Very useful for natural language processingx

Box

Stack

*/

package test3;

import java.util.List;
import java.util.ArrayList;

public class Generic {
    
    // Generic printArray method. 
    static <T> void printArray ( T [] inputArray ) {
        
        // <T> are the TYPE PARAMETERS
        System.out.print( " generic method: " );
        for ( T element : inputArray ) {
            System.out.print( element.toString() + " " );
        }
        System.out.println();
    }
}

// Generic Method maximum
class Maximum {
    /*
    How this method works:
    - When maximum is called with integers, compiler looks for a method that takes
      those parameters
    - Finding none, it then looks for a generic method and finds generic maximum
      method.
    - Since arguments must be reference types, compiler "autoboxes" the ints and
      passes Integer arguments to the method. 
    - Since class Integer implements Comparable, the values can be compared.
    - Similarly for method calls with double and String parameters.
    
    Type restriction in type parameter section. T is the return type and the input type.
    */
    
    public static < T extends Comparable <T> > T maximum ( T x, T y, T z ) {
        T max = x;
        if ( y.compareTo( max ) > 0 ) {
            max = y;
        }
        if ( z.compareTo( max ) > 0 ) {
            max = z;
        }
        return max;
    }
}

// Generic Wild Card Method
class WildCard {
    // Adds up all the elements of the input list, regardless of type, as long 
    // as they are all Numbers.
    
    public static double sum ( ArrayList < ? extends Number > list ) {
        double total = 0;
        
        for ( Number element : list ) {
            total += element.doubleValue();
        }
        
        return total;
    }
    
    // Generic Method comparison
    public static < T extends Number > double sum2 ( ArrayList < T > list ) {
        double total = 0;
        
        for ( Number element : list ) {
            total += element.doubleValue();
        }
        
        return total;
    }
}

// Data Structures

// Generic Class CustomStack
class CustomStack <T> {
    private final List <T> elements = new ArrayList();
    
    public void push ( T pushValue ) {
        // Add to the end of the list / top of the stack.
        elements.add( pushValue );
    }
    
    public T pop () {
        if( elements.isEmpty() ) {
            return null;
        }
        // Remove from tail of the list because that is the top of the stack.
        return elements.remove( elements.size() - 1 );
    }
}

// Generic Class CustomQueue
class CustomQueue < T > {
    private final List < T > elements = new ArrayList();
    
    public void enqueue ( T element ) {
        elements.add( element );
    }
    
    public T dequeue () {
        if ( elements.isEmpty() ) {
            return null;
        }
        return elements.remove( 0 );
    }
    
    public String show () {
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for ( T e : elements ) {
            sb.append( "{" + e.toString() + "} " );
        }
        sb.append( "]" );
        
        return sb.toString();
    }
}