
/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package Test2Test;

public class StructuredObjects {
    /*
    Issue comes up when trying to sort STRUCTURED OBJECTS ( objects that were
    created by programmer defined classes ). Java does not know how to sort these
    so we must create COMPARATORS or COMPARABLES.
    */
    
    /*
    Comparators: Defined in a separate class. Useful when we don't have control 
    of class. Must implement the Comparator interface in a separate class file.
    
    Can be general: public class MyComparator implements Comparator {}
    Can be specific: public class MyComparator implements Comparator<Blob> {}
    
    Only 1 method to implement: int compare( Object o1, Object o2 )
    returns -1 if o1 is 'less than' o2
    returns 1 if o1 is 'greater than' o2
    returns 0 if o1 'equals' o2
    
    Example: Collections.sort(employees, new EmployeeComparator() );
    */
    
    /*
    Comparables: Defined in the class that is being sorted. Useful when we have
    complete control over class. Must implement the Comparable interface in the 
    class being sorted. This is an INSTANCE METHOD.
    
    Can be general: public class MyClass implements Comparable{}
    Can be specific: public class MyClass implements Comparable<Blob>{}
    
    Only 1 method to implement: int compareTo( Object o )
    returns -1 if this is "less than" o
    returns +1 if this is "greater than" o
    return 0 if this "equals" o
    
    Example: Collections.sort( sysAdmins ); (Uses the comparable inside the class)
    */
    
}
