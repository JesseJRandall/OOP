/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

/*
Enum Type: A way to replace using integers to represent a fixed
set of non-numeric values. Declared as a class using the enum 
keyword instead. The advantage is that it enforces data validation
by requiring members of the type to be one of the fixed set. Can  
compare using the == operator. MOST USEFUL FOR PARAMETERS TO A 
METHOD.
        
Fixed Set - The 'enumeration'. (Days of the week)
Non-numeric - Can't do arithmetic with enum types. (Monday/2 Not defined)
*/

enum Fruit {
    APPLE,
    PEAR,
    ORANGE
}

class Dessert {
    
    private Fruit fruit;
    
    public Dessert ( Fruit e ) {
        fruit = e;
    }
    
    String show() {
        String ret;
        switch( fruit ) {
            case APPLE:
                ret = "apple";
                break;
            case PEAR:
                ret = "pear";
                break;
            default:
                ret = "orange";
                break;
        }
        return ret;
    }
}
