package gui;
import hospitalCarlos.Especialista;
import hospitalCarlos.Gestion;
import hospitalCarlos.ListaEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import expceciones.CorreoNoValidoException;
import expceciones.DniNoValidoException;
import javax.swing.DefaultComboBoxModel;
import hospitalCarlos.Sexo;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class EnfermeroGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNomb;
	private JTextField textFieldApell;
	private JTextField textFieldDirecc;
	private JTextField textFieldEmail;
	private JTextField textFieldAntigue;
	private int indice;
	private int indice_aux=0;
	private JTextField textFieldDniEliminar;
	private JTextField textField;
	ListaEmpleados milista= new ListaEmpleados();
	private int a=0;
	Especialista aux;



	
	/**
	 * Metodo de la burbuja
	 * @param le
	 * 				Representa una lista de empleados
	 * @return Una lista de empleados ordenada de menor a mayor; En caso de no poder ordenar devuelve nulo.
	 */
	public ListaEmpleados ordenar(ListaEmpleados le){
		int i,j,aux;
		ListaEmpleados ml = new ListaEmpleados();
		Especialista uno;
		Especialista dos;
		if (le.size()!=0){
			for (i=0;i<=le.size()-1;i++){
				for (j=0;j<=le.size()-2-i;j++){
					uno = (Especialista) le.devolver(j);
					dos = (Especialista) le.devolver(j+1);
					if (uno.getDiasTrabajados()>=dos.getDiasTrabajados()){
						ml.annadir(uno);
						ml.annadir(dos);
					}
					else
					{
						ml.annadir(dos);
						ml.annadir(uno);
					}
				}
			}
			return ml;
		}
		else
			return null;
	}
	/**
	 * Se utiliza para la baja y consultas menos para la alta de Enfermeros
	 * @param listaEmpleados
	 * 							Representa una lista de empleados
	 * @param i
	 * 							Representa el tipo 
	 * @param gestion
	 * 							Representa si se ha modificao o no
	 * @param l
	 * 							Representa una lista de empleados
	 * 
	 */
	public EnfermeroGui(final ListaEmpleados listaEmpleados, final int i, final Gestion gestion, final ListaEmpleados l) {
		
		indice = 0;
		setTitle("Enfermero");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(144, 33, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(16, 58, 57, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(16, 33, 23, 14);
		contentPane.add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(16, 83, 57, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(16, 111, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(244, 111, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblNewLabel_1 = new JLabel("Antiguedad");
		lblNewLabel_1.setBounds(286, 188, 69, 14);
		contentPane.add(lblNewLabel_1);

		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(48, 30, 86, 20);
		contentPane.add(textFieldDni);

		textFieldNomb = new JTextField();
		textFieldNomb.setColumns(10);
		textFieldNomb.setBounds(208, 30, 183, 20);
		contentPane.add(textFieldNomb);
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(83, 58, 308, 20);
		contentPane.add(textFieldApell);
		
		textFieldDirecc = new JTextField();
		textFieldDirecc.setColumns(10);
		textFieldDirecc.setBounds(83, 80, 308, 20);
		contentPane.add(textFieldDirecc);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(72, 108, 86, 20);
		contentPane.add(textFieldEmail);
		
		textFieldAntigue = new JTextField();
		textFieldAntigue.setColumns(10);
		textFieldAntigue.setBounds(359, 185, 32, 20);
		contentPane.add(textFieldAntigue);
	
		final JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(300, 108, 91, 20);
		contentPane.add(comboBox);
				
		JLabel label = new JLabel("Fecha Nacimiento");
		label.setBounds(16, 143, 107, 14);
		contentPane.add(label);
		
		final JDateChooser dateChooserFNaci = new JDateChooser();
		dateChooserFNaci.setDateFormatString("dd/MM/yyyy");
		dateChooserFNaci.setBounds(136, 139, 95, 20);
		contentPane.add(dateChooserFNaci);
		
		final JDateChooser dateChooserFcontra = new JDateChooser();
		dateChooserFcontra.setDateFormatString("dd/MM/yyyy");
		dateChooserFcontra.setBounds(136, 162, 95, 20);
		contentPane.add(dateChooserFcontra);
		
		JLabel label_1 = new JLabel("Fecha Contratacion");
		label_1.setBounds(16, 168, 118, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Fecha Fin Contratacion");
		label_2.setBounds(16, 188, 130, 14);
		contentPane.add(label_2);
		
		final JDateChooser dateChooserFfinContr = new JDateChooser();
		dateChooserFfinContr.setDateFormatString("dd/MM/yyyy");
		dateChooserFfinContr.setBounds(146, 182, 95, 20);
		contentPane.add(dateChooserFfinContr);
		
		if (i==16){                                                               // Muestra por antiguedad   -  16
		
			//Tengo que ordenar ascendente o descendente.
			milista.cero();
			// Voy a ordenador de menor a mayor, si el usuario pulsa menor tengo la lista
			// directamente ordenadada y si pulsa mayor pues recorreo el arraylist de forma
			// inversa.
			if (listaEmpleados.size()>0){
				milista = ordenar(listaEmpleados);
			}
		}
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(147, 1, 84, 22);
		if(i==10)
			comboBox_1.setEnabled(true);
		
		final JButton btnNewButtonSiguiente = new JButton("Siguiente");
		btnNewButtonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i==16){                                                              // Muestra por antiguedad - Boton Siguiente  -16
				
					milista = ordenar(listaEmpleados);
					System.out.println(milista.size());
					Especialista especialista2;
					if (milista.size()!=0){
					
						
						if (indice_aux<milista.size()-1){
						
							indice_aux++;
							especialista2=(Especialista) milista.get(indice_aux);
							asignarDatos(especialista2);
						}
						else{
						
							indice_aux=milista.size()-1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);

					}
				}
				if(i == 10){                                                                     // Mostrar por Sexo - Boton Siguiente  -10
				
					Especialista especialista2;
					indice++;
					int h = 0;
					while(indice<=listaEmpleados.size()-1 && h==0){
					
						
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_1.getSelectedItem().toString())==0){
						
							h = 1;
							asignarDatos(especialista2);
						}
						else
							indice++;	
					}
					
					if (indice>listaEmpleados.size()-1){
					
						indice=listaEmpleados.size()-1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
					
				} 
			 if (i==14 || i==17){                                                          // 14- Mostrar Todos       17- Nomina - Boton Siguiente
			 
				if(indice < listaEmpleados.size()-1){
					Especialista especialista2 = new Especialista("a");
					indice++;
					especialista2 = (Especialista) listaEmpleados.devolver(indice);
					asignarDatos(especialista2);
					if (especialista2.getDiasTrabajados()>365 && i==17)	{
				
						JOptionPane.showMessageDialog(null,"\nEste especialista tiene en nómina +25%","!!!",JOptionPane.WARNING_MESSAGE);
						
						textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
					}
					}else{
					 JOptionPane.showMessageDialog(null,"\nNo hay mas enfermeros para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
			 }
			}
			
			/**
			 * Asignar a los textField, comboBox  y dateChooser los datos que contiene especialista2
			 * @param especialista2
			 * 						Representa un especialista
			 */
			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textFieldNomb.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecc.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try{
				
					dateChooserFNaci.setDate(formato.parse(especialista2.getfNacimiento()));
					dateChooserFcontra.setDate(formato.parse(especialista2.getFAlta()));
					dateChooserFfinContr.setDate(formato.parse(especialista2.getFBaja()));
				}
				catch (ParseException ex){
				
					ex.printStackTrace();
				}
				switch (especialista2.getSexo())
				{
					case "HOMBRE": 
						comboBox.setSelectedIndex(0); 
						break;
					case "MUJER": 
						comboBox.setSelectedIndex(1);
						break;
				}
			}
			});
		btnNewButtonSiguiente.setBounds(324, 232, 89, 23);
		contentPane.add(btnNewButtonSiguiente);
			
		contentPane.add(comboBox_1);
		
		final JButton btnNewButtonAnt = new JButton("Anterior");
		btnNewButtonAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Especialista especialista2 = new Especialista("a");
				if(i == 14 || i==17){   // Consultar todos y obtener nomina
				if(indice > 0){
					indice--;
					especialista2 = (Especialista) listaEmpleados.devolver(indice);
					asignarDatos(especialista2);
					if (especialista2.getDiasTrabajados()>365 && i==17){
					
						JOptionPane.showMessageDialog(null,"\nEste especialista tiene en nómina +25%","!!!",JOptionPane.WARNING_MESSAGE);
						
						textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
					}
					}else{
					 JOptionPane.showMessageDialog(null,"\nNo hay mas enfermeros para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				if (i==16){                                                                //Muestra por antiguedad- Boton Anterio  -16
				
					//Tengo que ordenar ascendente o descendente.
					milista = ordenar(listaEmpleados);
					if (milista.size()!=0){
					
						indice_aux--;
						if (indice_aux>=0 && indice_aux<milista.size()-1){
						
							especialista2=(Especialista) milista.get(indice_aux);
							asignarDatos(especialista2);
						}
						else{
						
							indice_aux=0;
							JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				if(i == 10){                                                                        // Mostrar por Sexo - Boton Anterio  -10
				
					indice--;
					int h = 0;
					while(indice>=0 && h==0){
					
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_1.getSelectedItem().toString())==0){
						
							h = 1;
							asignarDatos(especialista2);
						}
						else
							indice--;	
					}
					if (indice<0){
					
						indice=0;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}				
				}
			
			}
			
			/**
			 * Asignar a los textField, comboBox  y dateChooser los datos que contiene especialista2
			 * @param especialista2
			 * 						Representa un especialista
			 */
			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textFieldNomb.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecc.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try{
					dateChooserFNaci.setDate(formato.parse(especialista2.getfNacimiento()));
					dateChooserFcontra.setDate(formato.parse(especialista2.getFAlta()));
					dateChooserFfinContr.setDate(formato.parse(especialista2.getFBaja()));
				}
				catch (ParseException ex){
					ex.printStackTrace();
				}
				
				switch (especialista2.getSexo()){
					case "HOMBRE": 
						comboBox.setSelectedIndex(0); 
						break;
					case "MUJER": 
						comboBox.setSelectedIndex(1);
						break;
				}	
			}
		});
		btnNewButtonAnt.setBounds(117, 232, 89, 23);
		contentPane.add(btnNewButtonAnt);
		
		textFieldDniEliminar = new JTextField();
		textFieldDniEliminar.setBounds(48, 2, 86, 20);
		contentPane.add(textFieldDniEliminar);
		textFieldDniEliminar.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista e1 = new Especialista(textFieldDniEliminar.getText());				//textFieldDni.getText(), textField_1Nombre.getText(), textFieldApell.getText(), comboBoxSexo.getSelectedItem().toString(),dateChooserFNaci.toString()	 ,textFieldDirecci.getText(), textFieldEmail.getText(),  0,dateChooserFcontra.toString(),dateChooserFfinContr.toString(),5,true,comboBoxEspecial.getSelectedItem().toString());
				if(listaEmpleados.devolverDni(textFieldDniEliminar.getText()) != null)
				{
					Especialista e2 = (Especialista) listaEmpleados.devolverDni(textFieldDniEliminar.getText());
					if (e2.getEspe().compareTo("null")==0){
						asignarDatos(e2);
						if(JOptionPane.showOptionDialog(contentPane,"¿Quieres eliminar el Enfermero?", "--> Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null)==0){
							listaEmpleados.eliminar(e2);
							gestion.setModificado(true);
						}
					}
					else
						JOptionPane.showMessageDialog(null,"\nImposible eliminar","!!!",JOptionPane.WARNING_MESSAGE);
				}
				else
					 JOptionPane.showMessageDialog(null,"\nImposible eliminar","!!!",JOptionPane.WARNING_MESSAGE);
			
			}
			/**
			 * Asignar a los textField, comboBox  y dateChooser los datos que contiene especialista2
			 * @param especialista2
			 * 						Representa un especislita
			 */
			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textFieldNomb.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecc.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));//reajustarlo
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try				{
					dateChooserFNaci.setDate(formato.parse(especialista2.getfNacimiento()));
					dateChooserFcontra.setDate(formato.parse(especialista2.getFAlta()));
					dateChooserFfinContr.setDate(formato.parse(especialista2.getFBaja()));
				}
				catch (ParseException ex)				{
					ex.printStackTrace();
				}
				switch (especialista2.getSexo())				{
					case "HOMBRE": 
						comboBox.setSelectedIndex(0); 
						break;
					case "MUJER": 
						comboBox.setSelectedIndex(1);
						break;
				}
				textField.setText(Float.toString(especialista2.nomina()));
				if (especialista2.getDiasTrabajados()>365)				{
					JOptionPane.showMessageDialog(null,"\nEste enfermero tiene en nómina +25%","!!!",JOptionPane.WARNING_MESSAGE);
					textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
				}
	
			}
		});
	
		btnEliminar.setBounds(16, 232, 91, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNmina = new JLabel("N\u00F3mina");
		lblNmina.setEnabled(false);
		lblNmina.setBounds(244, 143, 46, 14);
		contentPane.add(lblNmina);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(298, 139, 86, 20);
		contentPane.add(textField);
		
		
		
		
		
		final JButton btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCerrar_1.setBounds(116, 244, 89, 23);
		contentPane.add(btnCerrar_1);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(223, 213, 91, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		
		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista uno;
				uno = (Especialista) listaEmpleados.devolverDni(textFieldDni.getText().toString());
				int i=0;			
				i=comprobar_campos(dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr);
				if (i==7){
					String aux,aux1,aux2;
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					aux=formato.format(dateChooserFNaci.getDate());
					aux1=formato.format(dateChooserFcontra.getDate());
					if (dateChooserFfinContr.getDate()!=null)
					aux2=formato.format(dateChooserFfinContr.getDate());
					else
						aux2=null;
					Date fnac= null;
					Date falta = null;
					Date fbaja= null;
					try{
						//El string lo devuelve de tipo date
						fnac=formato.parse(aux);
						falta=formato.parse(aux1);
						if (aux2!=null)	{
							final long MILLSECS_PER_DAY = 24*60*60*1000;
							fbaja=formato.parse(aux2);
							long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
							textFieldAntigue.setText(Long.toString(diferencia));
						}
						else{
							fbaja=formato.parse(aux1);
							textFieldAntigue.setText("0");
						}
						
					} catch (ParseException ex)	{
						ex.printStackTrace();
					}
					
					Especialista e2 = new Especialista(textFieldDni.getText(),textFieldNomb.getText(),textFieldApell.getText(),comboBox.getSelectedItem().toString(),formato.format(fnac),textFieldDirecc.getText(),textFieldEmail.getText(),6,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAntigue.getText()),true,"null");
					listaEmpleados.eliminar(uno);
					listaEmpleados.annadir(e2);
					l.eliminar(uno);
					l.annadir(e2);
					gestion.setModificado(true);
					JOptionPane.showMessageDialog(null,"\n ENFERMERO MODIFICADO CORRECTAMENTE.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					btnCerrar_1.setVisible(false);
					btnNewButtonAnt.setVisible(true);
					btnNewButtonSiguiente.setVisible(true);
					btnGuardar.setVisible(false);
					Ponercampos(false);
					btnCancelar.setVisible(false);
				}				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 * 				Representa estado de los textFiel y comboBox(true o false)
			 */
			void Ponercampos(boolean valor)	{
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAntigue.setEditable(valor);
				textFieldAntigue.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooserFNaci.setEnabled(valor);
				dateChooserFfinContr.setEnabled(valor);
				dateChooserFcontra.setEnabled(valor);
			}
			/**
			 * Comprueba que los elementos del panel no esten vacios
			 * @param uno
			 * 				Representa la fecha de nacimiento
			 * @param dos
			 * 				Representa la fecha de alta
			 * @param tres
			 * 				Representa la fecha de Fin de contratacion
			 * @return entero dependiendo de que campo esté vacio
			 */
				public int comprobar_campos(JDateChooser uno,JDateChooser dos, JDateChooser tres){
					
					if (textFieldDni.getText().compareTo("")==0)
						return 1;
					if (textFieldNomb.getText().compareTo("")==0)
						return 2;
					if (textFieldApell.getText().compareTo("")==0)
						return 3;
					if (textFieldDirecc.getText().compareTo("")==0)
						return 4;
					if (textFieldEmail.getText().compareTo("")==0)
						return 5;
					if (textFieldAntigue.getText().compareTo("")==0)
						return 6;
					if (uno==null)
						return 8;
					if (dos==null)
						return 9;
					return 7;
						
				}
		});
		btnGuardar.setBounds(119, 244, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.setVisible(false);
		
		
		
		final JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					btnNewButton.setVisible(false);
					btnGuardar.setVisible(true);
					btnNewButtonAnt.setVisible(false);
					btnNewButtonSiguiente.setVisible(false);
					btnCancelar.setVisible(true);
					
					Ponercampos(true);
				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 * 					Representa estado de los textFiel y comboBox(true o false)
			 */
			void Ponercampos(boolean valor)	{
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAntigue.setEditable(valor);
				textFieldAntigue.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooserFNaci.setEnabled(valor);
				dateChooserFfinContr.setEnabled(valor);
				dateChooserFcontra.setEnabled(valor);
			}
		});
		btnNewButton.setBounds(225, 232, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Cerrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(322, 263, 91, 23);
		contentPane.add(button);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				btnCancelar.setVisible(false);
				btnGuardar.setVisible(false);
				btnNewButtonAnt.setVisible(true);
				btnNewButtonSiguiente.setVisible(true);
				Ponercampos(false);
				
			}
			/**
			 Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 * 				Representa estado de los textFiel y comboBox(true o false)
			 */
			void Ponercampos(boolean valor)	{
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAntigue.setEditable(valor);
				textFieldAntigue.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooserFNaci.setEnabled(valor);
				dateChooserFfinContr.setEnabled(valor);
				dateChooserFcontra.setEnabled(valor);
			}
		});
		

		desactivar_campos();
		if (i==10)  {                        // Mostramos por sexo  - 10
		
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(true);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(true);
			textFieldDni.setVisible(false);
			lblDni.setVisible(false);
			btnNewButtonSiguiente.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox_1);
			label_2.setVisible(false);
			
			
			modo_edicion(comboBox,comboBox_1,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
			comboBox_1.setVisible(true);
			comboBox_1.setEnabled(true);
			
		}
		if(i==12){                                         // Baja de especialista.  -12
			btnNewButton.setVisible(false);
			btnCerrar_1.setVisible(true);
			lblDni.setVisible(true);
			btnEliminar.setVisible(true);
			textFieldDniEliminar.setVisible(true);
			textFieldDniEliminar.setEnabled(true);
			lblDni.setEnabled(true);
			textFieldDni.setVisible(false);
			lblDni.setVisible(false);
			btnNewButtonSiguiente.setVisible(false);
			btnNewButtonAnt.setVisible(false);
			resetear(comboBox_1);
			label_2.setVisible(true);
			
			
			modo_edicion(comboBox,comboBox_1,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
			comboBox_1.setVisible(false);
		}
		if (i==14) {    //Mostramos todos los enfermeros. - 14
		
			btnCerrar_1.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			modo_edicion(comboBox,comboBox_1,comboBox,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
			
		}
		if (i==15){   // Mostrar por especialidad -  15
		
			btnCerrar_1.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			modo_edicion(comboBox,comboBox_1,comboBox,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==16){  // Mostramos los enfermeros por antiguedad.  -  16
		
			btnCerrar_1.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			modo_edicion(comboBox,comboBox_1,comboBox,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==17){ // Toca obtener la nómina para cada empleado.  -  17
		
			
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(true);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(false);
			textFieldDni.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox,comboBox_1);
			
			label_2.setVisible(false);						
			lblNmina.setVisible(true);
			textField.setVisible(true);
			modo_edicion(comboBox,comboBox_1,comboBox,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i!=12){
			Especialista en;
			en = (Especialista) listaEmpleados.devolver(0);
			textFieldDni.setText(en.getDni());
			textFieldNomb.setText(en.getNombre());
			textFieldApell.setText(en.getApellidos());
			textFieldDirecc.setText(en.getDireccion());
			textFieldEmail.setText(en.getEmail());
			textFieldAntigue.setText(Integer.toString(en.getDiasTrabajados()));
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try	{
				dateChooserFNaci.setDate(formato.parse(en.getfNacimiento()));
				dateChooserFcontra.setDate(formato.parse(en.getFAlta()));
				dateChooserFfinContr.setDate(formato.parse(en.getFBaja()));
			}
			catch (ParseException ex){
				ex.printStackTrace();
			}
			textField.setText(Float.toString(en.nomina()));
			if (en.getDiasTrabajados()>365){
				JOptionPane.showMessageDialog(null,"\nEste enfermero tiene en nómina +25%","!!!",JOptionPane.WARNING_MESSAGE);
				
				textField.setText(Float.toString(((en.nomina()*25)/100)+en.nomina()));
			}
			if (en.getSexo().compareTo("HOMBRE")==0)
				comboBox.setSelectedIndex(0);
			else
				comboBox.setSelectedIndex(1);
		}
				
		
		
	}
	/**
	 * Pone los campos textField en modo editable a false.
	 */
	public void desactivar_campos(){
		textFieldNomb.setEditable(false);
		textFieldAntigue.setEditable(false);
		textFieldApell.setEditable(false);
		textFieldDirecc.setEditable(false);
		textFieldDni.setEditable(false);
		textFieldEmail.setEditable(false);
	}
	/**
	 * Pone los textField, comboBox y dateChooser sus modos editable y enabled a un valor booleano
	 * @param uno
	 * 				Representa fecha de nacimiento
	 * @param dos
	 * 				Representa fecha de alta
	 * @param tr
	 * 				Representa fecha de fin de contratacion
	 * @param un
	 * 				Representa fecha de nacimiento
	 * @param doses
	 * 				Representa fecha de alta
	 * @param tres
	 * 				Representa fecha de fin de contratacion
	 * @param valor
	 * 				Representa el estado (editable o enable) de los textfield y combobox(true/false)
	 */
	public void modo_edicion(JComboBox uno, JComboBox dos,JComboBox tr,JDateChooser un, JDateChooser doses, JDateChooser tres, boolean valor){
		textFieldDni.setEditable(valor);
		textFieldNomb.setEnabled(valor);
		textFieldApell.setEnabled(valor);
		textFieldDirecc.setEnabled(valor);
		textFieldEmail.setEnabled(valor);
		textFieldAntigue.setEnabled(valor);
		uno.setEnabled(valor);
		dos.setEnabled(valor);
		tr.setEnabled(valor);
		un.setEnabled(valor);
		doses.setEnabled(valor);
		tres.setEnabled(valor);
	}
	/**
	 * Pone los textField a vacio y los combobox a elemento cero de la lista.
	 * @param uno
	 * 				Representa la fecha de sexo 
	 * @param dos
	 * 				Representa la especialidad
	 */
	public void resetear(JComboBox uno, JComboBox dos){
		textFieldDni.setText("");
		textFieldApell.setText("");
		textFieldNomb.setText("");
		textFieldDirecc.setText("");
		textFieldEmail.setText("");
		textFieldAntigue.setText("");
		dos.setSelectedItem(0);
		uno.setSelectedItem(0);
		
		
	}
	/**
	 * Pone en blanco los textField y los comboBox los resetea al elemento cero de la lista
	 * @param uno
	 * 				Representa el sexo
	 */
	public void resetear(JComboBox uno){
		textFieldDni.setText("");
		textFieldApell.setText("");
		textFieldNomb.setText("");
		textFieldDirecc.setText("");
		textFieldEmail.setText("");
		textFieldAntigue.setText("");
		uno.setSelectedItem(0);
		
		
	}
	/**
	 * Comprueba que ningun campo sea vacio; si un cambpo es vacio retornamos un numero asociado al campo. Si nos devuelve 7 sabremos que todos los campos estan perfectos.
	 * @param uno
	 * 				Representa la fecha de nacimiento
	 * @param dos	
	 * 				Representa la fecha de Alta
	 * @param tres
	 * 				Representa la fecha de Baja
	 * @return Entero(dependiendo de que campos estén vacios)
	 */
	public int comprobar_campos(JDateChooser uno, JDateChooser dos, JDateChooser tres){
		
		if (textFieldDni.getText().compareTo("")==0)
			return 1;
		if (textFieldNomb.getText().compareTo("")==0)
			return 2;
		if (textFieldApell.getText().compareTo("")==0)
			return 3;
		if (textFieldDirecc.getText().compareTo("")==0)
			return 4;
		if (textFieldEmail.getText().compareTo("")==0)
			return 5;
		if (textFieldAntigue.getText().compareTo("")==0)
			return 6;
		if (uno==null)
			return 8;
		if (dos==null)
			return 9;
		return 7;
			
	}
	/**
	 * habilita o deshabilita los campos
	 * @param uno 
	 * 				Representa el sexo
	 * @param tr
	 * 				Representa
	 * @param un
	 * 				Representa la fecha de Nacimiento
	 * @param doses
	 * 				Representa la fecha de Alta
	 * @param tres
	 * 				Representa la fecha de find e contratacion
	 * @param valor
	 * 				Representa el estado (editable o enable) de los textfield y combobox(true/false)
	 */
	public void modo_edicion(JComboBox uno, JComboBox tr,JDateChooser un, JDateChooser doses, JDateChooser tres, boolean valor){
		textFieldDni.setEditable(valor);
		textFieldNomb.setEnabled(valor);
		textFieldApell.setEnabled(valor);
		textFieldDirecc.setEnabled(valor);
		textFieldEmail.setEnabled(valor);
		textFieldAntigue.setEnabled(valor);
		uno.setEnabled(valor);
	
		tr.setEnabled(valor);
		un.setEnabled(valor);
		doses.setEnabled(valor);
		tres.setEnabled(valor);
	}
	/**
	 * Constructor para añadir enfermeros
	 * @param listaEmpleados
	 * 						Representa la lista de Empleados
	 * @param gestion
	 * 						Representa el estado(true o false)
	 */
	public EnfermeroGui(final ListaEmpleados listaEmpleados, final Gestion gestion) {
		setTitle("Enfermero");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 43, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(35, 68, 49, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(35, 18, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(246, 18, 46, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(246, 43, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(246, 71, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblFechaContratacion = new JLabel("Fecha Contratacion");
		lblFechaContratacion.setBounds(23, 147, 101, 14);
		contentPane.add(lblFechaContratacion);
		
		JLabel lblNewLabel = new JLabel("Fecha Fin Contratacion");
		lblNewLabel.setBounds(23, 173, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Antiguedad");
		lblNewLabel_1.setBounds(300, 147, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(121, 99, 95, 20);
		contentPane.add(dateChooser);
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(127, 147, 95, 20);
		contentPane.add(dateChooser_1);

		final JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("dd/MM/yyyy");
		dateChooser_2.setBounds(155, 178, 95, 20);
		contentPane.add(dateChooser_2);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(121, 15, 86, 20);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNomb = new JTextField();
		textFieldNomb.setColumns(10);
		textFieldNomb.setBounds(121, 43, 86, 20);
		contentPane.add(textFieldNomb);
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(121, 68, 86, 20);
		contentPane.add(textFieldApell);
		
		textFieldDirecc = new JTextField();
		textFieldDirecc.setColumns(10);
		textFieldDirecc.setBounds(302, 15, 86, 20);
		contentPane.add(textFieldDirecc);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(302, 40, 86, 20);
		contentPane.add(textFieldEmail);
		
		textFieldAntigue = new JTextField();
		textFieldAntigue.setColumns(10);
		textFieldAntigue.setBounds(287, 170, 86, 20);
		contentPane.add(textFieldAntigue);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(304, 75, 101, 20);
		contentPane.add(comboBox);
		
		JLabel labelSalario = new JLabel("Fecha Nacimiento");
		labelSalario.setBounds(35, 97, 49, 14);
		contentPane.add(labelSalario);
		

		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnCerrar.setBounds(288, 228, 89, 23);
		contentPane.add(btnCerrar);
		
		JButton btnNewButtonAnnadir = new JButton("A\u00F1adir");
		btnNewButtonAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=0;			
				i=comprobar_campos(dateChooser,dateChooser_1,dateChooser_2);
				if (i==7){
				String aux,aux1,aux2;
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				aux=formato.format(dateChooser.getDate());
				aux1=formato.format(dateChooser_1.getDate());
				if (dateChooser_2.getDate()!=null)
					aux2=formato.format(dateChooser_2.getDate());
				else
					aux2=null;
				Date fnac= null;
				Date falta = null;
				Date fbaja= null;
				try{
					//El string lo devuelve de tipo date
					fnac=formato.parse(aux);
					falta=formato.parse(aux1);
					if (aux2!=null){
						final long MILLSECS_PER_DAY = 24*60*60*1000;
						fbaja=formato.parse(aux2);
						long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
						textFieldAntigue.setText(Long.toString(diferencia));
					}
					else{
						fbaja=formato.parse(aux1);
						textFieldAntigue.setText("0");
					}
					
				} catch (ParseException ex){
					ex.printStackTrace();
				};
				
				try {
					listaEmpleados.comprobar_dni(textFieldDni.getText());
					 listaEmpleados.comprobar_correo(textFieldEmail.getText());
					Especialista e2 = new Especialista(textFieldDni.getText(),textFieldNomb.getText(),textFieldApell.getText(),comboBox.getSelectedItem().toString(),formato.format(fnac),textFieldDirecc.getText(),textFieldEmail.getText(),6,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAntigue.getText()),true,"null");
					if (listaEmpleados.annadir(e2)){
						gestion.setModificado(true);
						JOptionPane.showMessageDialog(null,"\nEnfermero dado de alta correctamente","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"\nEl Efermero ya esta dado de alta en el sistema.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					}
				}catch (DniNoValidoException  | CorreoNoValidoException e1) {	
					;
			}
				

				}
				else{
					switch (i){
					case 1:JOptionPane.showMessageDialog(null,"\nEl campo DNI no puede estar vacio.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 2:JOptionPane.showMessageDialog(null,"\nEl campo NOMBRE no puede estar vacio.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 3:JOptionPane.showMessageDialog(null,"\nEl campo APELLIDOS no puede estar vacio.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 4:JOptionPane.showMessageDialog(null,"\nEl campo DIRECCOIN no puede estar vacio","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 5:JOptionPane.showMessageDialog(null,"\nEl campo EMAIL no puede estar vacio","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 6:JOptionPane.showMessageDialog(null,"\nEl campo ANTIGUEDAD no puede estar vacio","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 8:JOptionPane.showMessageDialog(null,"\nEl campo FECHA DE NACIMIENTO no puede estar vacio","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					case 9:JOptionPane.showMessageDialog(null,"\nEl campo FECHA DE CONTRATACION no puede estar vacio","!!!Advertencia",JOptionPane.WARNING_MESSAGE);break;
					}
				}

			}
		});
		
		
		btnNewButtonAnnadir.setBounds(188, 228, 89, 23);
		contentPane.add(btnNewButtonAnnadir);
		
		
		JButton btnNewButtonEliminar = new JButton("Eliminar");
		btnNewButtonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButtonEliminar.setBounds(288, 228, 89, 23);
		contentPane.add(btnNewButtonEliminar);
	}
}
