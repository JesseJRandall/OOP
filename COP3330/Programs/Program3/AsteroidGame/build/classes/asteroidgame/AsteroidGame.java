/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI {
    
    private static Random random = new Random();
    private SandBox sandbox;
    
    public static void main(String[] args) {
        new AsteroidGame();
    }
    
    public AsteroidGame() {
        
        // Create sandbox object.
        sandbox = new SandBox();
        
        // Set sandboxmode to FLOW.
        sandbox.setSandBoxMode( SandBoxMode.FLOW );
        
        // Set FramteRate to 15.
        sandbox.setFrameRate( 15L );
        
        // Initiate the sandbox.
        sandbox.init( this );
        
    }
    
    public void generate () {
        
        // Create an instance of the rocket.
        Rocket rocket = new Rocket ( 300, 300, this.sandbox );
        
        // Add it to the sandbox.
        this.sandbox.addBlob( rocket );
        
        // Create 10 asteroids using random velocity components
        // and add them to the sandbox.
        for( int i = 0; i<10; i++ ) { 
            
            int vxcomp = 0;
            int vycomp = 0;
            
            // Random velocity components, make sure are not zero.
            while( vxcomp == 0 && vycomp == 0) {
            vxcomp = -3 + random.nextInt( 7 );
            vycomp = -3 + random.nextInt( 7 );
            }
            
            // Random anular rotation.
            double angrot = 0.1;
            if(random.nextInt(2) == 0) angrot = -1 * angrot;
            
            // Create asteroid object from previous values.
            Asteroid asteroid = new Asteroid(vxcomp, vycomp, angrot);
            sandbox.addBlob( asteroid );
            
        }
    
    }
    
}
