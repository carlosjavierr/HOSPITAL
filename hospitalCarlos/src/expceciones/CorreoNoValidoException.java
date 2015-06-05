package expceciones;
import javax.swing.JOptionPane;
/**
 *
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class CorreoNoValidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CorreoNoValidoException(String cadena){
		JOptionPane.showMessageDialog(null,cadena,"!!!Advertencia",JOptionPane.WARNING_MESSAGE);
	}
}
