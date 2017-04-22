/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

import java.util.ArrayList;
import java.util.List;
/*
Polymorphism is treating objects of different types the same, according
to their common characteristics. Examples would include classes in an 
inheritance hierarchy or classes that implement the same interface.

Reason: 
Collections of different objects in a list, set, arraylist, etc.
Exercise same behavior for different objects. 
*/
public class Polymorphism {
    /*
    An interface is a supertype of every class that implement it.
    So an instance of an implementing class can be assigned to a variable
    of the supertype. An example is that ArrayList implements the List
    interface so you can make this assignment:
    */
    
    protected List<Integer> myList = new ArrayList();
    
    /*
    We have a variable of supertype list but is truly an instance of the
    class ArrayList which implements the List interface.
    */
    
}



