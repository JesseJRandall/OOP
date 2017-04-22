/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package asteroidgame;

import blobz.PolyBlob;
import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.SandBox;
import blobz.BlobUtils;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {
  
    /*
    Define constructor that takes 3 arguments.
    Initializes rocket using setPolygon method inherited from PolyBlob class.
    keyAction handles movement of the rocket.
    */
    
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    private SandBox sandbox;
    
    Rocket( int x, int y, SandBox sandbox ) {
        
        // Run super class constructor.
        super( 0, 0, 0 );
        super.setLoc( x, y );
        
        // Assign sandbox to instance variable.
        this.sandbox = sandbox;
        
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
    
    void launch ( SandBox sb ) {
        
        // Calculate start point of missile.
        Point loc = this.getLoc();
        loc.x = loc.x + (int) Math.round(5 * Math.cos(angle));
        loc.y = loc.y + (int) Math.round(5 * Math.sin(angle));
        
        // Instantiate missile with calculated position.
        Missile missile = new Missile( loc.x, loc.y, angle );
        
        // Add missile to sandbox.
        sb.addBlob( missile );
        
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
        
        // Spacebar: Shoot missile.
        else if ( e.getKeyCode() == 32 ) {
            
            // Run launch instance method.
            launch( this.sandbox );
            
            // Play sound.
            BlobUtils.playSound();
        }
    }               
}
    
