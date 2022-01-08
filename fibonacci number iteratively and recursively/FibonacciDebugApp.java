package fibonacci;

import javax.swing.SwingUtilities;

import fibonacci.gui.FibonacciDebugAppFrame;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FibonacciDebugApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> FibonacciDebugAppFrame.createAndShowGUI());
	}
}
