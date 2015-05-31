package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 *
 */
public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setBounds(100, 100, 616, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nuevo -> Ctrl - N");
			lblNewLabel.setBounds(32, 62, 201, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblTeclasDeAcceso = new JLabel("Teclas De Acceso R\u00E1pido");
			lblTeclasDeAcceso.setBounds(178, 11, 183, 23);
			lblTeclasDeAcceso.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			contentPanel.add(lblTeclasDeAcceso);
		}
		{
			JLabel lblAbrirCtrl = new JLabel("Abrir -> Ctrl - O");
			lblAbrirCtrl.setBounds(32, 87, 97, 14);
			contentPanel.add(lblAbrirCtrl);
		}
		{
			JLabel lblGuardarCtrl = new JLabel("Guardar -> Ctrl - S");
			lblGuardarCtrl.setBounds(32, 112, 121, 14);
			contentPanel.add(lblGuardarCtrl);
		}
		{
			JLabel lblGuardarComo = new JLabel("Guardar como -> Ctrl + Alt - S");
			lblGuardarComo.setBounds(32, 137, 171, 14);
			contentPanel.add(lblGuardarComo);
		}
		{
			JLabel lblSalirAlt = new JLabel("Salir -> Alt - F4\r\n");
			lblSalirAlt.setBounds(32, 162, 164, 14);
			contentPanel.add(lblSalirAlt);
		}
		{
			JLabel lblNuevoCtrl = new JLabel("Nuevo -> Ctrl + Alt - N");
			lblNuevoCtrl.setBounds(32, 187, 144, 14);
			contentPanel.add(lblNuevoCtrl);
		}
		{
			JLabel lblEliminarCtrl = new JLabel("Eliminar -> Ctrl + Alt - L");
			lblEliminarCtrl.setBounds(32, 212, 144, 14);
			contentPanel.add(lblEliminarCtrl);
		}
		{
			JLabel lblMostrarConcesionario = new JLabel("Buscar por Sexo -> Ctrl + Alt - M");
			lblMostrarConcesionario.setBounds(341, 137, 211, 14);
			contentPanel.add(lblMostrarConcesionario);
		}
		{
			JLabel lblMostrarPorMatricula = new JLabel("Buscar por Antiguedad -> Ctrl + Alt - Y");
			lblMostrarPorMatricula.setBounds(341, 112, 211, 14);
			contentPanel.add(lblMostrarPorMatricula);
		}
		{
			JLabel lblMostrarPorColor = new JLabel("Todos -> Ctrl + Alt - C");
			lblMostrarPorColor.setBounds(341, 87, 211, 14);
			contentPanel.add(lblMostrarPorColor);
		}
		{
			JLabel lblAyudaShift = new JLabel("Ayuda -> Shift - F1");
			lblAyudaShift.setBounds(341, 187, 121, 14);
			contentPanel.add(lblAyudaShift);
		}
		{
			JLabel lblAcercaDe = new JLabel("Acerca de -> F1\r\n");
			lblAcercaDe.setBounds(341, 212, 121, 14);
			contentPanel.add(lblAcercaDe);
		}
		
		JLabel lblBuscarPorAo = new JLabel("Buscar por A\u00F1o -> Ctrl + Alt - O");
		lblBuscarPorAo.setBounds(341, 162, 211, 14);
		contentPanel.add(lblBuscarPorAo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
