/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class IO {
    
    public static void ReadTextFile () {
        try {
            Path p = Paths.get( "C:\\Users\\Jesse\\Desktop\\What.txt" );
            File file = p.toFile();
            
            Scanner input = new Scanner ( new FileInputStream( file ) );
            int count = 0;
            while ( input.hasNext() ) {
                String s = input.nextLine();
                System.out.println( ++count + ": " + s );
            }
        }
        catch (FileNotFoundException e) {
            System.out.println( "File not found!" );
        }       
    }   
}
