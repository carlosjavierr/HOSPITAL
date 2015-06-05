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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Ayuda extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
			JLabel lblTeclasDeAcceso = new JLabel("Teclas De Acceso R\u00E1pido");
			lblTeclasDeAcceso.setBounds(178, 11, 183, 23);
			lblTeclasDeAcceso.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			contentPanel.add(lblTeclasDeAcceso);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 40, 545, 246);
			contentPanel.add(scrollPane);
			
			JTextPane txtpnAsdfasdfasdfasdfasdfasdfAsdfA = new JTextPane();
			scrollPane.setViewportView(txtpnAsdfasdfasdfasdfasdfasdfAsdfA);
			txtpnAsdfasdfasdfasdfasdfasdfAsdfA.setText("\r\nMenu Ficheros\r\n\r\n    - Nuevo                -> Crea un fichero vacio.\r\n    -Abrir                   -> Abre un fichero creado anteriormente.\r\n    -Guardar              -> Guarda un archivo automaticamente si antes se ha guardado.\r\n    -Guardar Como    -> Guarda un archivo preguntando el nombre que se le pondr\u00E1 al fichero\r\n    -Salir                    -> Sale del programa.\r\n\r\nMenu Persona\r\n\r\n - Especialista\r\n      Alta                   -> A\u00F1ade un Especialista.\r\n      Baja                  -> Elimina un Especialista.\r\n- Enfermero\r\n     Alta                    -> A\u00F1ade un Enfermero.\r\n     Baja                    -> Elimina un Enfermero.\r\n- Ats\r\n     Alta                    -> A\u00F1ade un Ats.\r\n     Baja                    -> Elimina un Ats.\r\n\r\nMenu Buscar\r\n\r\n- Especialista\r\n    Por Antiguedad  -> Muestra los especialistas de mayor antiguedad a menos antiguedad.\r\n    Todos                 -> Muestra todos los especialistas.\r\n    Por Sexo             -> Muestra los especialistas dependiendo de si son hombres o muejres.\r\n    Por Especialidad -> Muestra los especialistas dependiendo del tipo de especialidad.\r\n\tObtener Nomina -> Muestra la nomina de cada uno de los especialistas.\r\n- Enfermero\r\n     Por Antiguedad  -> Muestra los enfermeros de mayor antiguedad a menos antiguedad.\r\n     Todos                 -> Muestra todos los enfermeros.\r\n      Por Sexo            -> Muestra los enfermerosdependiendo de si son hombres o muejres.\r\n      Obtener Nomina -> Muestra la nomina de cada uno de los enfermeros.\r\n- \r\n- Ats\r\n      Por Antiguedad  -> Muestra los ats de mayor antiguedad a menos antiguedad\r\n      Todos                 -> Muestra todos los ats.\r\n      Por Sexo             -> Muestra los ats dependiendo del sexo.\r\n      Por Especialidad -> Muestra los ats dependiendo del tipo de especialidad.\r\n      Obtener Nomina -> Muestra la nomina de cada uno de los ats.\r\n\r\n- Nominas Generales -> Muestra la suma de todas las nominas y el numero de empleados al que se \r\n                                      les sumara un 25 % en su salario(solo si ha superado 1 a\u00F1o de antiguedad).\r\n\t\t\r\n- Mayor Antiguedad -> Muestra el dni, nombre de la persona que tiene la mayor antiguedad.");
			txtpnAsdfasdfasdfasdfasdfasdfAsdfA.setToolTipText("");
		}
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
