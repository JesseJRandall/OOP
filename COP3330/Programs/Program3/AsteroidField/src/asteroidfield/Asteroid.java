/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package asteroidfield;

import blobz.PolyBlob;
import blobz.BlobUtils;
import java.awt.Point;
import java.util.Random;

public class Asteroid extends PolyBlob {
    
    /* 
      Define constructor that takes 3 arguments: vx, vy, angular rotation.
      Initializes initial position to (-100, -100) and velocity to given
      arguments.
    */
    
    private static Random random = new Random();
    
    Asteroid( int vxcomp, int vycomp, double angrot ) {
        
        // Takes arguments: xpos, ypos, angrot
        super(-100, -100, angrot);
        setDelta(vxcomp, vycomp);
        
        // Create random number of vertices from 5-9.
        int vertices = 5 + random.nextInt(5);
        
        // Point array initialization.
        Point [] p = new Point [ vertices ];
        
        // Create region and angle array for each vertex.
        double region   = 2 * Math.PI / vertices;
        double [] angle = new double[ vertices ];
        
        // For each vertex determine the point that is located at.
        for(int i=0; i<vertices; i++) {
            
            int distance = 5 + random.nextInt(11);
            angle[i] = ( i * region ) + ( Math.random() * region );
            p[i] = BlobUtils.rotatePoint( distance, angle[i] );
            
        }
        
        setPolygon(p);
    }
        
    
}
