/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package test;

import java.util.Random;

public class Notes {

    /**
     * @param args the command line arguments
     */
    
    /* Java Keywords:
       int, long, short byte, float, double, final,
       static, public, void, main, None, True, False,
       NaN, System, Random*/
    
    
    public static void main(String[] args) {
        
        // Basic system output.
        System.out.println("Hello, World!");
        
        // Print random numbers
        Random generator = new Random();
        System.out.println(generator.nextLong()); // 64 bit
        System.out.println(generator.nextInt()); // 32 bit
        
        
        // Primitive Integer Types
        int z = 7;
        System.out.println(z + "\n"); //Output: 7
        
        long y = 4000L;
        System.out.println(y + "\n"); //Output: 4000
        
        short x = 5000;
        System.out.println(x + "\n"); //Output: 5000
         
        byte w = 120;
        System.out.println(w + "\n"); //Output: 120
        
        System.out.println(Long.MAX_VALUE); //Output: 9223372036854775807
        System.out.println(Long.MIN_VALUE + "\n");
        
        System.out.println(0xCAFEBABE);
        System.out.println(0b1001);
        System.out.println(011 + "\n");
        
        
        // Floating Point Types
        float v = 5.0F;
        System.out.println(v);
        
        double u = 3.4E38D;
        System.out.println(u);
        
        
        // Char Types
        char t = '\u263A'; // Unicode character number 263.
        System.out.println(t); // Smiley face.
        
        
        // Boolean Type
        // No relationship between True/False and
        // 1/0 in Java.
        
        
        // Variable Declaration
        int aa = 0, bb, cc;
        /* DECLARATION IS NOT THE SAME AS 
           INSTANTIATION. You must instantiate
           a variable before using it with the
           assignment operator. */
        // final keyword denotes that a value is immutable.
        
        
        // Constants
        // This prints a constant class variable from
        // the Calendar class.
        System.out.println(Calendar.DAYS_PER_WEEK);
        // enumerated type can be used to declare multiple constants.
        // They can not be local though.
        // enum Weekday { MON, TUE, WED, THU, FRI, SAT, SUN };
        
        
        // IMPORTANT NOTE
        /* One of the stated goals of the Java programming language is portability. A
        computation should yield the same results no matter which virtual machine
        executes it. However, many modern processors use floating-point registers with
        more than 64 bit to add precision and reduce the risk of overflow in intermediate
        steps of a computation. Java allows these optimizations, since otherwise floatingpoint
        operations would be slower and less accurate. For the small set of users who
        care about this issue, there is a strictfp modifier. When added to a method, all
        floating-point operations in the method are strictly portable.*/
        
        
        /*
        Hexadecimal: 0xCAFEBABE (Start with 0x)
        Binary: 0b1001 (Start with 0b)
        Octal: 011 (Start with zero) 
        */
        
        /*
        int n = 7/3;
        System.out.println("n = " + n);
        
        double p = 7 / 3;
        System.out.println("p = " + p);
        
        double q = (double) (7 / 3);
        System.out.println("q = " + q);
        
        double r = ( (double) 7) / 3;
        System.out.println("r = " + r);
        */
        
        int[][] a = new int[ 3 ][ ];
        a[ 0 ] = new int[ 3 ];
        a[ 1 ] = new int[ 2 ];
        a[ 2 ] = new int[ 4 ];
        
   
        
        
        System.out.println( a.length + "\n"); // Output: 3
        
        int idx = 0;
        for (int i = 0; i < a.length; i++ ){
            for(int j = 0; j < a[ i ].length; j++){
                a[ i ][ j ] = ++idx;
            }
        }
        
        for( int[] b : a ){
            for( int c : b){
                System.out.println( c + " " );
            }
            System.out.println();
        }
    }
}
