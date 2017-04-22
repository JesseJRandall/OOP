/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

import java.util.Random;

public class Vehicle {
    
    /* 
    Declared instance variable. If not assigned in constructor it will
    have a default value depending on the type. 
    */    
    protected int wheels;
   
    /* 
    Declared static variable known as a class variable because
    it belongs to the class and is shared among instances. 
    */ 
    protected static final int Cylinders = 4;
    
    /* 
    Initialization block. Valid piece of code. Ran before any piece
    of a constructor is ran. 
    */
    protected int id;
    {
        Random ran = new Random();
        id = 1 + ran.nextInt( 1000000 );
    }
    
    protected String name;
    
    /* Java has a built in zero argument constructor. */
    protected Vehicle() {
        /* Constructor with not arguments is necessary to set instance 
        variables to different default values and makes that explicit. */
        
        /* Keyword this designates the object. */
        this(4);
    }
    
    /* 
    If you make an explicit constructor you MUST make a zero argument
    constructor if you intend to use it because the default zero argument 
    constructor won't work otherwise. This is known as OVERLOADING.
    This concept applies to methods as well. Each method/constructor
    must have a different SIGNATURE.
    */
    protected Vehicle( int b ) {
        this.wheels = b;
        
        /* 
        This uses the Object class' method toString. toString is
        an instance method and can be called by using the dot operator 
        on the name of an object. However, in the constructor the super
        keyword is required since an instance has not been made. 
        */
        this.name = super.toString();
    }
    
    /* 
    Basic instance method used to print out the number of wheels of 
    a vehicle. 
    */
    protected void show() {
        System.out.printf( "%nNumber of wheels: %d%nNumber of cylinders: %d%n%n", 
                this.wheels, Cylinders);
    }
    
    /* Overloaded version of instance method show(). */
    protected void show( int a ) {
        /* 
        The assignment here changes the instance variable wheels to the given
        argument. 
        */
        System.out.printf("%nNumber of wheels: %d%nNumber of cylinders: %d%n%n", 
                this.wheels = a, Cylinders);
    }
    
    /* 
    Example of a static method. These are not run by objects. They
    are invoked by using the dot operator with the name of the class and
    can act on objects.
    */
    protected static void setWheels( Vehicle e, int b ) {
        e.wheels = b;
    }
    
    /* 
    Factory method is a class method that returns a new instance of the
    class. This is just a wrapper of the constructor which can be used in
    interfaces to create instances of the implementing classes.
    */
    protected static Vehicle newVehicle() {
        return new Vehicle();
    }
}

/* 
Inheritance allows us to treat subclass objects as superclass objects.
Java allows single inheritance only so a subclass has one superclass. 

Only protected and public fields/methods are inherited from the superclass
to the subclass. Static/private/constructors are not inherited. Subclass can
still use all of the static fields/methods like other classes.

Subclass Inheritance inheriting from the superclass Vehicle. 
Keyword extends is used to show inheritance.
*/

class Car extends Vehicle {
   
    private int passengers; 
    
    /* Subclass constructor. */
    protected Car( int n ) {
        /* Subclass constructor must call superclass constructor first. */
        super( 4 );
        
        /* 
        Superclass variable can be assigned an instance of the subclass. 
        One way that polymorphism is allowed in OO languages. 
        */
        passengers = n;
    }
    
    /* 
    Subclass can modify inherited methods by overriding them with a method
    that has the same name. Can add its own fields and methods. This is what 
    show() does to the method show() in Vehicle. Final methods cannot be 
    overridden. Must use the same signature, else it is an overload. Also must
    use same access modifier. To access overridden method you must use 'super' 
    and dot operator. Also known as 'shadowing'. 
    */
    protected void show() {
        System.out.println( "I am a subclass of Vehicle that can carry " 
        + passengers + " passengers.");
    }
    
}
