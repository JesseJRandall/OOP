/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

/*

*BASIC EXCEPTION HANDLING CONCEPTS
An EXCEPTION is a runtime program error:
- Program may terminate and give error message and stack trace

Exceptions are handled with a try-catch block or throw it:
- Corrective or alternative processing

Error Messages and stack traces are intended to be informative:
- Tells what happened, where exception occurred.

*THROWING AN EXCEPTION
Instead of having error codes bubble up the chain of method calls, Java supports 
EXCEPTION HANDLING where a method can signal a serious problem by “throwing” an 
exception. One of the methods in the call chain, but not necessarily the direct 
caller, is responsible for handling the exception by “catching” it. 

The fundamental advantage of exception handling is that it decouples the processes 
of detecting and handling errors. ( REMEMBER THIS!!! )

Programmer-reported exceptions are subclasses of Exception.
- UNCHECKED exceptions are subclasses of RuntimeException.
- All other exceptions are CHECKED exceptions. Used when failue is anticipated.
  Input and output is the most common.
- FileNotFoundException, NullPointerException, NumberFormatException, 
  Illegal ArgmuentException

*DECLARING CHECKED EXCEPTIONS
Method must declare checked exceptions in the method header with a THROWS clause.
- public void write ( Object obj, String filename ) throws IOException
- List exceptions method might throw because of throw statement or it calls
  another method with a throws clause.

When you OVERRIDE a method, it CANNOT THROW more check exceptions than those
declared in the superclass method. If the superclass method has no throws, then
no overriding method can throw a checked exception.

*/

package test3;

import java.lang.Exception;

public class ExceptionHandling {
    public static void error () {
        try {
            int n = 0;
            int a = 3 / n;
            System.out.println( "a = " + a );
        }
        catch (Exception exc) {
            System.out.println( "Denominator zero. Unable to procedd.\n" );
            exc.printStackTrace();
            throw new IllegalArgumentException ( String.format( "Denominator zero ") );
        }
    }
}
