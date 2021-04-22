/**
 * 
 */
package prj5;

/**
 * @author Jack Fox (jackf19)
 * @version 2021.04.21
 *
 */
public class Input {

    /**
     * Default constructor
     */
    public Input() {
        // intentionally left blank
    }
    
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            String file = args[0];
            CovidReader covRead = new CovidReader(file);
        }
        
    }
    
}
