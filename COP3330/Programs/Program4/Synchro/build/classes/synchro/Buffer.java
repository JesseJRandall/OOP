/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package synchro;

public interface Buffer {
    
    public void put (String value) throws InterruptedException;
    
    public String get() throws InterruptedException;
}
