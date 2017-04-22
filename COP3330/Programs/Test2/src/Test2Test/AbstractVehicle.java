/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

/*
Up till now the top level superclass served as the default object. Sometimes we
don't want a default, but we need to treat the different subclass objects as if 
they are all of a common supertype. Abstract classes allow us to do that.

An example being is that it would not make sense to have the program make
instances of Vehicle that are not cars.
*/

public abstract class AbstractVehicle {
    /*
    Cannot make instances of this class. Can extend it and can create arrays
    and array lists of this type.
    
    An abstract class can contain only concrete methods.
    
    A Concrete method is a method that is declared with an implementation, such
    as the getName() method.
    */
    
    protected String name;
    
    protected AbstractVehicle ( String name ) {
        this.name = name;
    }
    
    /*
    An abstract method is a method that is declared without an implementation,
    such as getWeeklyRuntime() method here. Uses abstract keyword and ends in 
    semicolon. Extending this class means that the subclass must implement all
    abstract methods or itself be declared abstract.
    */
    
    protected abstract double getWeeklyRuntime();
}

class Taxi extends AbstractVehicle {
    private double hrsPerDay;
    
    protected Taxi( String name, double hrsPerDay ) {
        super( name );
        this.hrsPerDay = hrsPerDay;
    }
    
    /*
    This is the implementation of the abstract method getWeeklyRuntime from 
    AbstractVehicle.
    */
    @Override
    protected double getWeeklyRuntime() {
        return hrsPerDay * 5;
    }
}