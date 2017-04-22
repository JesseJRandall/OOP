/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

/* 
Packages provide a namespace hierarchy for library classes.
This ensures the uniqueness of class names and supports the 
overall use of these libraries in our progrms. Name is a dot
separated list of identifiers. Common practice is to use 
internet domain name in reverse. (com.horstmann.corejava) 
To put a class in a package use the package statement. Must be
first line in class file. 
*/
package Test2Test;

/* Library classes used. */
import java.util.ArrayList;
import java.util.List;

/* 
Can import static methods from a library using STATIC IMPORT 
which allow you to avoid using the class name with the dot operator.
*/
import static java.lang.Math.*;

/* 
Class belonging to a package has a FULLY QUALIFIED NAME that is
the name of the package plus the class name separated by a dot. Scope
of a class depends on its access modifiers. Private, only instances 
of the class can access its fields/methods. Package private allows 
other classes in the same pakcage to access it.
*/

/*
Every class in Java either directly or indirectly extends the class
Object. It has no fields but has methods like:

toString() - Returns the fully qualified name with an extension that is
a hash code probably representing its place in memory.

equals() - Tests whether two references refer to the same object.
Subclasses may override this method to check whether the variables of
the objects are the same. This is an instance method so the syntax 
is: ref1.equals( ref2 )

hashcode() - Fixed-size number that is computed for an arbitrary input.
Intent is for all hashes to be unique however there will be hash collisions
eventually.
*/
public class Test2Test {
    
    /* 
    Final instance variables must be initialized before the end of 
    the class constructor. If a reference type then the referene is final.
    This is an example of a final class variable that is a reference type
    which is initialized when the class is first loaded. Can be added to 
    using a static initialization block. 
    */
    protected static final ArrayList<Vehicle> types;
    
    static {
        /* Add code to initialize here. */
        types = new ArrayList();
    }
    
    /* Arrays used for AbstractVehicle. */
    private static final String[] taxi = { "1", "2", "3" }; 
    private static final double[] hrs  = {  8,  9,  5 };
    
    /* Variables used for polymorphism and interfaces. */
    private static final String[] a = { "books", "furniture"};
    private static final int[]    b = {     219,         324};
    private static final List<Stuff> myStuff = new ArrayList();
    
    /* 
    Main method testing our the concepts taught in lectures 14-21.
    Main must be static otherwise Java throws a fit. 
    */
    public static void main(String[] args) {
        
        /* Created object of the class Vehicle named vehicle. */
        Vehicle vehicle = new Vehicle();
        vehicle.show();
        
        vehicle.wheels = 4;
        vehicle.show();
        
        Vehicle.setWheels( vehicle, 4 );
        
        System.out.println("This is the output of toString: " 
                + vehicle.name );
        
        /* Created object of the class Vehicle named vehicle2. */
        Vehicle vehicle2 = new Vehicle( 7 );
        vehicle2.show();
        vehicle2.show(4);
        vehicle2.show();
        
        Vehicle.setWheels(vehicle2, 8);
        
        System.out.println("This is the output of toString: "
                + vehicle2.name );
        
        /* Added both objects to an ArrayList. */
        types.add( vehicle );
        types.add( vehicle2 );
        
        System.out.printf("%n" +  vehicle.id + "%n");
        System.out.printf("%n" + vehicle2.id + "%n%n");
        
        /* Static Math methods. */
        double radius = 2.0;
        double area   = PI * pow( radius, 2 );
        
        /* Every Vehicle in convoy is an INSTANCEOF the subclass SUBCLASS. */
        ArrayList<Vehicle> convoy = new ArrayList();
        
        convoy.add( new Car( 6 ) );
        convoy.add( new Car( 8 ) );
        
        /* 
        This casts the zeroth element as type Subclass so that its method
        show() overrides the one in Vehicle. 
        */
        ((Car) convoy.get(0)).show();
        /* 
        The casting is unnecessary however, because the subclass knows it
        is a subclass of vehicle and will automatically run its method that
        overrides the method it shadows in Vehicle. 
        */
        
        
        /* This goes over Abstract classes. */
        List<AbstractVehicle> abstractvehicle = new ArrayList();
        
        for( int i=0; i < taxi.length; i++) {
            AbstractVehicle e = new Taxi( taxi[i], hrs[i] );
            abstractvehicle.add( e );
        }
        
        /* 
        Here running the getWeeklyRuntime method without needing to
        know the concrete implementing class is known as polymorphism. 
        */
        for( AbstractVehicle e : abstractvehicle ) {
            double runTime = e.getWeeklyRuntime();
            System.out.println( e.name + " : " + runTime );
        }
        
        
        /*
        Polymorphism / Interfaces
        */
        for ( String a1 : a ) {
            myStuff.add( new TangibleStuff( a1 ) );
        }
        for ( int i=0; i < b.length; i++) {
            myStuff.add( new IntangibleStuff( b[i]) );
        }
        report();
    }
    
    /*
    Casting and instanceof operator:
    If we have a single collection of objects of different types the we
    can treat the instances of different types differently using the 
    instanceof operator.
    
    Example:
    for( Blob b : mylist ) {
        if( b instanceof Asteroid ) {
          ... = ( ( Asteroid ) b ).asteroidMathod(); 
        }   
    
    When using ( (Asteroid) object ) we are downcasting so that we can us
    methods of the subclass.
    */
    
    static void report () {
        System.out.printf("%nMy stuff:%n");
        for ( Stuff s : myStuff ) {
            if ( s instanceof TangibleStuff ) {
                System.out.println("Tangible   : " 
                        + ((TangibleStuff) s).getName() );
            }
            else {
                System.out.println("Intangible : " 
                        + ((IntangibleStuff) s).getId() );
            }
        }
    }
}
