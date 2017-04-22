/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

/*
An INTERFACE is an OO mechanism for specifying a set of methods that a 
class must implement. Similar to a concrete or abstract superclass,
except that all methods(other than static/default methods) are abstract.

Note: CAN NEVER HAVE AN OBJECT OF THE INTERFACE TYPE. All objects are 
instances of classes that implement the interface.
*/

interface Stuff {
    
     /*
    Methods of interface are all abstract and must be implemented by a class
    using the syntax: access class identifier implements interface {}
    One class can implement many interfaces.
    
    No abstract methods in this interface so implementing classes do not have 
    to implement anything.
    
    Any variable defined in an interface is automatically public static final
    */
    
    /*
    Not standard practice. Better to use enum.
    */
    int NORTH = 1;
    int NORTHEAST = 2;
    int EAST = 3;
    
    /*
    Static methods in interfaces can be useful as factory methods. Create 
    instances of the implementing classes.
    */
    public static Stuff tangible( String s ) {
        return new TangibleStuff( s );
    }
    public static Stuff intangible( int id ) {
        return new IntangibleStuff( id );
    }
    
    /*
    Interface can supply default implementation for any method. Must use 
    keyword default and implementing class has a choice to use default or
    override. Example:
    */
    
    default boolean hasNext() {return true;}
    
    /*
    Default methods support evolving the interface. Adding another method and
    using default will make the code compile without having to write out an
    implementation in every implementing class.
    */
    
    /*
    Resolving potential conflicts:
    
    1) Class extends one class and implements an interface, both have same method.
    No problem. Superclass method controls, interface method ignored.
    
    2) Class implements 2 interfaces with same method without default.
    No problem. Implementing class can implement the method or be abstract.
    
    2) Class implements 2 interfaces with same method and at least one default
    Conflict. Resolve by using fully qualified name and 'super' to identify 
    implementation to use. ( Identified.super.getId() ) Identified is interface
    and getId() is conflicting method.
    */
    
}

/*
Class wishing to use methods from interface uses the keyword implements
in its declaration.
*/

/* 
First implementing class. 
Implementing class must implement all abstract methods of the interface
or be declared as abstract.
*/
class TangibleStuff implements Stuff {
    
    private final String name;
    
    public TangibleStuff( String name ) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

/* Second implmenting class. */
class IntangibleStuff implements Stuff {

    private final int id;

    public IntangibleStuff ( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}

/*
Extending Interfaces:
An interface can extend another interface. A concrete class that implements 
the sub-interface must implement all methods in both interfaces. An instance
of the concrete implementing class can be assigned to a variable of either
type.
*/

