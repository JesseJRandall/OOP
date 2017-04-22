/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package asteroidgame;

import blobz.Blob;
import blobz.BlobProximity;
import java.awt.Color;

public class Missile extends Blob implements BlobProximity {
    
    double angle;
     
    public Missile ( int x, int y, double angle ) {
        
        // Run superclass constructor.
        super( x, y, Color.yellow );
        
        // Set speed using given angle.
        double speed = 5;
        int vx = (int) Math.round( speed * Math.cos( angle ) );
        int vy = (int) Math.round( speed * Math.sin( angle ) );
        super.setDelta( vx, vy );
        
    }
    
}
