/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsim;

import blobz.SandBox;
import blobz.SandBoxMode;
import blobz.BlobGUI;

public class RocketTest implements BlobGUI {
    
    private SandBox sandbox;

    public static void main(String[] args) {
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
        Rocket rocket = new Rocket ( 300, 300, sandbox );
        sandbox.addBlob( rocket );
    }
}
