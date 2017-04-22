/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package rocketsim;

import blobz.PolyBlob;
import blobz.BlobAction;
import blobz.SandBox;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Rocket extends PolyBlob implements BlobAction {
  
    /*
    Define constructor that takes 3 arguments.
    Initializes rocket using setPolygon method
    in PolyBlob class.
    */
    
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    
    Rocket( int x, int y, SandBox sandbox ) {
        
        // Run super class constructor.
        super( 0, 0, 0 );
        super.setLoc( x, y );
        
        // Create rocket shape using setPolygon.
        int vertices = 4;
        Point [] p = {
            new Point(10, 0),
            new Point(-10, -7),
            new Point(-5, 0),
            new Point(-10, 7), 
        };
        
        setPolygon( p );
                 
    }
    
    public void keyAction( KeyEvent e ) {
                
        // Left Arrow: Update angle.
        if ( e.getKeyCode() == 37 ) {
            if ( angle - delta < 2*Math.PI ) {
                angle = angle - delta + 2*Math.PI;
                super.setAngle(angle);
            }
            else {
                angle = angle - delta;
                super.setAngle(angle);
            }
        }
        
        // Up Arrow: Update x and y location.
        else if ( e.getKeyCode() == 38 ) {
            Point p = super.getLoc();
            p.x = p.x + (int) Math.round(speed * Math.cos(angle));
            p.y = p.y + (int) Math.round(speed * Math.sin(angle));
            super.setLoc(p.x, p.y);
        }
        
        // Right Arrow: Update angle.
        else if ( e.getKeyCode() == 39 ) {
            if  ( angle + delta > 2*Math.PI ) {
                angle = angle + delta - 2*Math.PI;
                super.setAngle(angle);
            }
            else {
                angle = angle + delta;
            }   super.setAngle(angle);
        }
    }               
}
    
