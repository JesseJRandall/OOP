/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Jesse Randall
 */

package rocketsim;

import blobz.SandBox;
import blobz.SandBoxMode;
import blobz.BlobGUI;

public class RocketTest implements BlobGUI {
    
    /*
    Main method is one line: new RocketTest();
    Constructor instantiates sandbox and sets it up.
    Generate method instantiates a rocket and adds it to the sandbox.
    */
    
    private SandBox sandbox;

    public static void main(String[] args) {
        // Run constructor for the RocketTest.
        new RocketTest();
    }
    
    private RocketTest() {
        // Create sandbox object.
        sandbox = new SandBox();
        
        // Set sandboxmode to FLOW.
        sandbox.setSandBoxMode( SandBoxMode.FLOW );
        
        // Set FramteRate to 15.
        sandbox.setFrameRate( 15L );
        
        // Initiate the sandbox.
        sandbox.init(this);
    }
    
    public void generate () {
        
        // Create an instance of the rocket.
        Rocket rocket = new Rocket ( 300, 300, sandbox );
        
        // Add it to the sandbox.
        sandbox.addBlob( rocket );
    }
}
