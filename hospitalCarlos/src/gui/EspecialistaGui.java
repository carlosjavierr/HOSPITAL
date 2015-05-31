package gui;


import hospitalCarlos.Empleado;
import hospitalCarlos.Especialista;
import hospitalCarlos.Gestion;
import hospitalCarlos.ListaEmpleados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JCalendar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import hospitalCarlos.Sexo;
import hospitalCarlos.EspecialidadEspecialista;

public class EspecialistaGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textField_1Nombre;
	private JTextField textFieldApell;
	private JTextField textFieldAntigue;
	private JTextField textFieldDirecci;
	private JTextField textFieldEmail;
	
	private int indice;
	private int a=0;
	private int b = 0;
	private JTextField textFieldDniEliminar;
	private ListaEmpleados milista = new ListaEmpleados();
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Especialista frame = new Especialista(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	/**
	 * Devuelve una lista de empleados dependiendo de su especialidad que coincida con aux(especialidad)
	 * @param le
	 * @param aux
	 * @return
	 */
	public ListaEmpleados cargarlista(ListaEmpleados le,String aux)
	{
		ListaEmpleados ml = new ListaEmpleados();
		Especialista mi;
		if (le.size()!=0)
		{
			for (int i=0;i<=le.size()-1;i++)
			{
				mi = (Especialista) le.devolver(i);
				if (mi.getEspe().compareTo(aux)==0)
					ml.annadir(mi);
			}
			return ml;
		}
		else
			return null;//si no hay nada
	}
	
	/**
	
	 * @param le
	 * @return
	 */
	public ListaEmpleados ordenar(ListaEmpleados le)
	{
		int i,j,aux;
		ListaEmpleados ml = new ListaEmpleados();
		Especialista uno;
		Especialista dos;
		if (le.size()!=0)
		{
			for (i=0;i<=le.size()-2;i++)
			{
				for (j=0;j<=le.size()-2-i;j++)
				{
					uno = (Especialista) le.devolver(j);
					dos = (Especialista) le.devolver(j+1);
					if (uno.getDiasTrabajados()>=dos.getDiasTrabajados())
					{
						ml.annadir(uno);
						ml.annadir(dos);
					}
				}
			}
			return ml;
		}
		else
			return null;
	}
	
	/**
	 * Se utiliza para la baja y consultas menos para la alta de Especialista
	 * @param listaEmpleados
	 * @param i
	 * @param g
	 * @param l
	 */
	public EspecialistaGui(final ListaEmpleados listaEmpleados, final int i, final Gestion g, final ListaEmpleados l) {
	
		indice = 0;
		setTitle("Especialista");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 11, 46, 14);
		contentPane.add(lblDni);
		
		textFieldDniEliminar = new JTextField();
		textFieldDniEliminar.setColumns(10);
		textFieldDniEliminar.setBounds(40, 8, 84, 20);
		contentPane.add(textFieldDniEliminar);
		
		
		JLabel label = new JLabel("Fecha Fin Contratacion");
		label.setBounds(10, 208, 140, 14);
		contentPane.add(label);
		
		JLabel lblFContratacion = new JLabel("F Contratacion");
		lblFContratacion.setBounds(10, 183, 118, 14);
		contentPane.add(lblFContratacion);
		
		final JLabel label_3 = new JLabel("Apellidos");
		label_3.setBounds(10, 70, 59, 14);
		contentPane.add(label_3);
		
		final JLabel label_4 = new JLabel("Nombre");
		label_4.setBounds(165, 45, 69, 14);
		contentPane.add(label_4);
		
		final JLabel labelDni = new JLabel("Dni");
		labelDni.setBounds(10, 45, 56, 14);
		contentPane.add(labelDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(66, 39, 84, 20);
		contentPane.add(textFieldDni);
		Especialista uno;
		uno = (Especialista) listaEmpleados.get(0);

		textField_1Nombre = new JTextField();
		textField_1Nombre.setColumns(10);
		textField_1Nombre.setBounds(231, 42, 189, 20);
		contentPane.add(textField_1Nombre);
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(66, 67, 354, 20);
		contentPane.add(textFieldApell);
	
		textFieldAntigue = new JTextField();
		textFieldAntigue.setColumns(10);
		textFieldAntigue.setBounds(323, 205, 37, 20);
		contentPane.add(textFieldAntigue);
		
		
		JLabel label_6 = new JLabel("Antiguedad");
		label_6.setBounds(242, 208, 69, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Sexo");
		label_7.setBounds(242, 123, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Email");
		label_8.setBounds(10, 123, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Direccion");
		label_9.setBounds(10, 98, 59, 14);
		contentPane.add(label_9);
		
		textFieldDirecci = new JTextField();
		textFieldDirecci.setColumns(10);
		textFieldDirecci.setBounds(66, 95, 354, 20);
		contentPane.add(textFieldDirecci);
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(66, 120, 126, 20);
		contentPane.add(textFieldEmail);
		
		
		final JDateChooser dateChooserFNaci = new JDateChooser();
		dateChooserFNaci.setDateFormatString("dd/MM/yyyy");
		dateChooserFNaci.setBounds(115, 151, 95, 20);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		contentPane.add(dateChooserFNaci);
		if(listaEmpleados.size() != 0)
		{
			try
			{
				dateChooserFNaci.setDate(formato.parse(uno.getfNacimiento()));
			} 
			catch (ParseException ex)
			{
				ex.printStackTrace();
			}
		}
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(231, 157, 77, 14);
		
		contentPane.add(lblEspecialidad);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(319, 120, 101, 20);
		contentPane.add(comboBox);
		if (listaEmpleados.size()!=0)
		{
			switch (uno.getSexo())
			{
				case "HOMBRE": comboBox.setSelectedIndex(0); break;
				case "MUJER": comboBox.setSelectedIndex(1);break;
			}
		}
		
		JLabel lblFechaNacimiento = new JLabel("F Nacimiento");
		lblFechaNacimiento.setBounds(10, 155, 95, 14);
		contentPane.add(lblFechaNacimiento);
		
		final JDateChooser dateChooserFcontra = new JDateChooser();
		dateChooserFcontra.setDateFormatString("dd/MM/yyyy");
		dateChooserFcontra.setBounds(115, 177, 95, 20);
		contentPane.add(dateChooserFcontra);
		if(listaEmpleados.size() != 0)
		{
				try
				{
					dateChooserFcontra.setDate(formato.parse(uno.getFAlta()));
				}
				catch(ParseException ex)
				{
					ex.printStackTrace();
				}
			
			}
		
		
		final JDateChooser dateChooserFfinContr = new JDateChooser();
		dateChooserFfinContr.setDateFormatString("dd/MM/yyyy");
		dateChooserFfinContr.setBounds(125, 202, 95, 20);
		contentPane.add(dateChooserFfinContr);
		if(listaEmpleados.size() != 0)
		{
			try
			{
				dateChooserFfinContr.setDate(formato.parse(uno.getFBaja()));
			}
			catch (ParseException ex)
			{
				ex.printStackTrace();
			}
		}
		
		final JComboBox comboBoxEspecial = new JComboBox();
		comboBoxEspecial.setModel(new DefaultComboBoxModel(hospitalCarlos.EspecialidadEspecialista.values()));
		comboBoxEspecial.setBounds(318, 151, 101, 20);
		contentPane.add(comboBoxEspecial);
		if(listaEmpleados.size() != 0){
			//PEDIATRIA,NEUROLOGIA,OFTALMOLOGIA,RADIOLOGIA;
			switch(uno.getEspe()){
			case "PEDIATRIA":
				comboBoxEspecial.setSelectedIndex(0);
				break;
			case "NEUROLOGIA":
				comboBoxEspecial.setSelectedIndex(1);
				break;
			case "OFTALMOLOGIA":
				comboBoxEspecial.setSelectedIndex(2);
				break;
			case "RADIOLOGIA":
				comboBoxEspecial.setSelectedIndex(3);
				break;
			}
		}
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(134, 7, 84, 22);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(EspecialidadEspecialista.values()));
		comboBox_2.setBounds(230, 8, 101, 20);
		contentPane.add(comboBox_2);
		
		if (i==16)
		{
			//Tengo que ordenar ascendente o descendente.
			milista.cero();
			// Voy a ordenador de menor a mayor, si el usuario pulsa menor tengo la lista
			// directamente ordenadada y si pulsa mayor pues recorreo el arraylist de forma
			// inversa.
			milista = ordenar(listaEmpleados);
		}
		
		
		/**
		 * Boton Siguiente
		 */
		final JButton btnNewButtonAnnadir = new JButton("Siguiente");
		btnNewButtonAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Boton Siguente, Muestrar por especialidad
				 */
				if (i==16)
				{
					Especialista especialista2;
					if (milista.size()!=0)
					{
						if (indice>=0 && indice<milista.size()-1)
						{
							indice++;
							especialista2=(Especialista) milista.get(indice);
							asignarDatos(especialista2);
							
						}
						else
						{
							indice=milista.size()-1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
				}
				
				/**
				 * Boton Siguente, Mustrar por especialidad
				 */
				if (i==15)    
				{
					
					milista.cero();
					//Carga una lista con la especialidad seleccionada
					milista = cargarlista(listaEmpleados,comboBox_2.getSelectedItem().toString());
					
					if(milista != null){
						Especialista ats2 = new Especialista("a");
						int x=0;						
						//ats2 = (Especialista) milista.get(indice);
						System.out.println("lista"+milista.size());
						if(b <= milista.size()-1){
							ats2 = (Especialista) milista.get(b);
							asignarDatos(ats2);
						}
						//ats2 = (Especialista) milista.get(b);
						
						System.out.println("indice"+b);
						//Recorre la lista hasta que obtenga un Especialista con la especialidad
						while(b<milista.size()-1 && x==0){
							b++;
							ats2 = (Especialista) milista.get(b);
							if(ats2.getEspe().compareTo(comboBox_2.getSelectedItem().toString())==0){
								x=1;
								//Cuando me encuetra al especialista con la especialidad cambia el valor
								//de x para salir del bucle
							}
							
						}
						if(x==1){
							asignarDatos(ats2);
							
						}else{
							b = milista.size()-1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas Especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
						
					}else{
						JOptionPane.showMessageDialog(null,"\nNo hay mas Especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				/**
				 * Boton Siguiente, Muestra todos los Ats || Muestra la nomina de loas Ats
				 */
				if(i==14 || i==17)  {
				if(indice < listaEmpleados.size()-1){
					Especialista especialista2 = new Especialista("a");
					indice++;
					
					especialista2 = (Especialista) listaEmpleados.devolver(indice);
					
					asignarDatos(especialista2);
					if (i==17)
					{
						textField.setText(Float.toString(especialista2.nomina()));
						if (especialista2.getDiasTrabajados()>365)
						{
							JOptionPane.showMessageDialog(null,"\nEste especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
							
							textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
						}
					}
				}else{
					indice=listaEmpleados.size()-1;
					
					 JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
				}}
				/**
				 * Boton Siguente, Muestra por Sexo
				 */
				if(i == 10)
				{
					Especialista especialista2;
					especialista2 = (Especialista) listaEmpleados.devolver(indice);
					int h = 0;
					while(indice<=listaEmpleados.size()-1 && h==0)
					{
						
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_1.getSelectedItem().toString())==0)
						{
							h = 1;
							asignarDatos(especialista2);
							
						}
						indice++;	
					}
					if (indice>listaEmpleados.size()-1)
					{
						indice=listaEmpleados.size()-1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}

			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textField_1Nombre.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecci.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));//reajustarlo

				switch (especialista2.getSexo())
				{
					case "HOMBRE": comboBox.setSelectedIndex(0); break;
					case "MUJER": comboBox.setSelectedIndex(1);break;
				}
				switch(especialista2.getEspe()){
				case "PEDIATRIA":
					comboBoxEspecial.setSelectedIndex(0);
					break;
				case "NEUROLOGIA":
					comboBoxEspecial.setSelectedIndex(1);
					break;
				case "OFTALMOLOGIA":
					comboBoxEspecial.setSelectedIndex(2);
					break;
				case "RADIOLOGIA":
					comboBoxEspecial.setSelectedIndex(3);
					break;
				}
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try{
				dateChooserFNaci.setDate(formato.parse(especialista2.getfNacimiento()));
				dateChooserFcontra.setDate(formato.parse(especialista2.getFAlta()));
				dateChooserFfinContr.setDate(formato.parse(especialista2.getFBaja()));
				}catch (ParseException ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButtonAnnadir.setBounds(331, 247, 89, 23);
		contentPane.add(btnNewButtonAnnadir);
		
		
	
		
		final JButton btnNewButtonAnt = new JButton("Anterior");
		btnNewButtonAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Boton Anterior, Muestra por Antiguedad
				 */
				if (i==16)
				{
					//Tengo que ordenar ascendente o descendente.
					Especialista especialista2;
					if (milista.size()!=0)
					{
						if (indice>=0 && indice<=milista.size()-1)
						{
							indice--;
							if (indice>=0)
							{
							especialista2=(Especialista) milista.get(indice);
							asignarDatos(especialista2);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
								indice=0;
							}
							
						}
						else
						{
							indice=0;
							JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
				}
				/**
				 * Boton Anterior, Muestra por Especialidad
				 */
				if (i==15)  
				{
					milista.cero();
					milista = cargarlista(listaEmpleados,comboBox_2.getSelectedItem().toString());
					if(milista != null){
						Especialista ats2 = new Especialista("a");
						int x=0;						
						if(b <= milista.size()-1){
							ats2 = (Especialista) milista.get(b);
							asignarDatos(ats2);
						}
						
						while(b>0 && x==0){
							b--;

							ats2 = (Especialista) milista.get(b);
							if(ats2.getEspe().compareTo(comboBox_2.getSelectedItem().toString())==0){
								x=1;
							}
							
						}
						if(x==1){
							asignarDatos(ats2);
							
						}else{
							if (b<0)
							b = 0;
							JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
						
					}else{
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				/**
				 * Boton anterior, Muestra por Sexo
				 */
				if(i == 10)
				{
					Especialista especialista2;
					
					
					int h = 0;
					while(indice>0 && h==0)
					{
						indice--;
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_1.getSelectedItem().toString())==0)
						{
							h = 1;
							asignarDatos(especialista2);
							
						}
							
					}
					if (indice<=0)
					{
						indice=0;
						JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				/**
				 * Boton Anterior, 14- Muestra Todos || 17- Muestra Nomina
				 */
				if(i==14 || i==17)
				{
				if(indice > 0)
				{
					Especialista especialista2 = new Especialista("a");
					indice--;
					
					especialista2 = (Especialista) listaEmpleados.devolver(indice);
					asignarDatos(especialista2);
					if (i==17)
					{
						textField.setText(Float.toString(especialista2.nomina()));
						if (especialista2.getDiasTrabajados()>365)
						{
							JOptionPane.showMessageDialog(null,"\nEste especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
						
							textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
						}
					}
				}
				else
				{
					indice=0;
					
					 JOptionPane.showMessageDialog(null,"\nNo hay mas especialistas para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			
			}
			private void asignarDatos(Especialista especialista2) 
			{
				textFieldDni.setText(especialista2.getDni());
				textField_1Nombre.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecci.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try
				{
				dateChooserFNaci.setDate(formato.parse(especialista2.getfNacimiento()));
				dateChooserFcontra.setDate(formato.parse(especialista2.getFAlta()));
				dateChooserFfinContr.setDate(formato.parse(especialista2.getFBaja()));
				}
				catch (ParseException ex)
				{
					ex.printStackTrace();
				}
				switch (especialista2.getSexo())
				{
					case "HOMBRE": comboBox.setSelectedIndex(0); break;
					case "MUJER": comboBox.setSelectedIndex(1);break;
				}
				switch(especialista2.getEspe())
				{
				case "PEDIATRIA":
					comboBoxEspecial.setSelectedIndex(0);
					break;
				case "NEUROLOGIA":
					comboBoxEspecial.setSelectedIndex(1);
					break;
				case "OFTALMOLOGIA":
					comboBoxEspecial.setSelectedIndex(2);
					break;
				case "RADIOLOGIA":
					comboBoxEspecial.setSelectedIndex(3);
					break;
				}
			}
		});
		
		
			
		contentPane.add(comboBox_1);
		btnNewButtonAnt.setBounds(125, 247, 89, 23);
		contentPane.add(btnNewButtonAnt);
		
		/**
		 * Boton Eliminar Especialista
		 */
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista e1 = new Especialista(textFieldDniEliminar.getText());				
				if(listaEmpleados.devolverDni(textFieldDniEliminar.getText()) != null)
				{
					Especialista e2 = (Especialista) listaEmpleados.devolverDni(textFieldDniEliminar.getText());
					if (e2.getEspe().compareTo("PEDIATRIA")==0 || e2.getEspe().compareTo("NEUROLOGIA")==0 || e2.getEspe().compareTo("OFTALMOLOGIA")==0 || e2.getEspe().compareTo("RADIOLOGIA")==0)
					{
						asignarDatos(e2);
						if(JOptionPane.showOptionDialog(contentPane,"�Quieres eliminar el Especialista?", "--> Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null)==0)
						{
					
							if(listaEmpleados.eliminar(e2))
							{
								g.setModificado(true);
								resetear(comboBox, comboBoxEspecial);
							}
						}
					}
						else
							JOptionPane.showMessageDialog(null,"\nImposible eliminar","!!!",JOptionPane.WARNING_MESSAGE);
				}
				
			}

			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textField_1Nombre.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecci.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAntigue.setText(Integer.toString(especialista2.getDiasTrabajados()));//reajustarlo
				switch (especialista2.getSexo())
				{
					case "HOMBRE": comboBox.setSelectedIndex(0); break;
					case "MUJER": comboBox.setSelectedIndex(1);break;
				}
				switch(especialista2.getEspe()){
				case "PEDIATRIA":
					comboBoxEspecial.setSelectedIndex(0);
					break;
				case "NEUROLOGIA":
					comboBoxEspecial.setSelectedIndex(1);
					break;
				case "OFTALMOLOGIA":
					comboBoxEspecial.setSelectedIndex(2);
					break;
				case "RADIOLOGIA":
					comboBoxEspecial.setSelectedIndex(3);
					break;
				}
				textField.setText(Float.toString(especialista2.nomina()));
				if (especialista2.getDiasTrabajados()>365)
				{
					JOptionPane.showMessageDialog(null,"\nEste Especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
					textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
				}
				
			}
		});
		btnEliminar.setBounds(10, 247, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel label_2 = new JLabel("Especialidad");
		label_2.setBounds(147, 11, 77, 14);
		contentPane.add(label_2);
		
		JLabel lblNmina = new JLabel("N\u00F3mina");
		lblNmina.setEnabled(false);
		lblNmina.setBounds(242, 183, 46, 14);
		contentPane.add(lblNmina);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(323, 180, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCerrar_1.setBounds(115, 247, 89, 23);
		contentPane.add(btnCerrar_1);
		
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(231, 233, 91, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		
		/**
		 * Boton Guardar, Especialista
		 */
		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista uno;
				uno = (Especialista) listaEmpleados.devolverDni(textFieldDni.getText().toString());
				
				int i=0;			
				i=comprobar_campos(dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr);
				if (i==7)//Comprueba que todos los campos tienen datos
				{
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
						if (aux2!=null)
						{
							final long MILLSECS_PER_DAY = 24*60*60*1000;
							fbaja=formato.parse(aux2);
							long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
							textFieldAntigue.setText(Long.toString(diferencia));
						}
						else
						{
							fbaja=formato.parse(aux1);
							textFieldAntigue.setText("0");
						}
						
					} catch (ParseException ex)
					{
						ex.printStackTrace();
					}
					
					
					Especialista e2 = new Especialista(textFieldDni.getText(),textField_1Nombre.getText(),textFieldApell.getText(),comboBox.getSelectedItem().toString(),formato.format(fnac),textFieldDirecci.getText(),textFieldEmail.getText(),1,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAntigue.getText()),true,comboBoxEspecial.getSelectedItem().toString());
					
					listaEmpleados.eliminar(uno);
					listaEmpleados.annadir(e2);
					l.eliminar(uno);
					l.annadir(e2);
					g.setModificado(true);
					JOptionPane.showMessageDialog(null,"\n ENFERMERO MODIFICADO CORRECTAMENTE.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					btnCerrar_1.setVisible(false);
					btnNewButtonAnt.setVisible(true);
					btnNewButtonAnnadir.setVisible(true);
					btnGuardar.setVisible(false);
					Ponercampos(false);
					btnCancelar.setVisible(false);
			}
				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 */
			void Ponercampos(boolean valor)
			{
				textField_1Nombre.setEnabled(valor);
				textField_1Nombre.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecci.setEnabled(valor);
				textFieldDirecci.setEditable(valor);
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
			 * Comprueba que campos estan vacios o nulos
			 * @param uno
			 * @param dos
			 * @param tres
			 * @return
			 */
				public int comprobar_campos(JDateChooser uno,JDateChooser dos, JDateChooser tres)
				{
					
					if (textFieldDni.getText().compareTo("")==0)
						return 1;
					if (textField_1Nombre.getText().compareTo("")==0)
						return 2;
					if (textFieldApell.getText().compareTo("")==0)
						return 3;
					if (textFieldDirecci.getText().compareTo("")==0)
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
		
		
		/**
		 * Boton que sirve para modificar un Especialista
		 */
		final JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					btnNewButton.setVisible(false);
					btnGuardar.setVisible(true);
					btnNewButtonAnt.setVisible(false);
					btnNewButtonAnnadir.setVisible(false);
					btnCancelar.setVisible(true);
					
					Ponercampos(true);
				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 */
			void Ponercampos(boolean valor)
			{
				textField_1Nombre.setEnabled(valor);
				textField_1Nombre.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecci.setEnabled(valor);
				textFieldDirecci.setEditable(valor);
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
		btnNewButton.setBounds(223, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		
		//Boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				btnCancelar.setVisible(false);
				btnGuardar.setVisible(false);
				btnNewButtonAnt.setVisible(true);
				btnNewButtonAnnadir.setVisible(true);
				Ponercampos(false);
				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase.
			 * @param valor
			 */
			void Ponercampos(boolean valor)
			{
				textField_1Nombre.setEnabled(valor);
				textField_1Nombre.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecci.setEnabled(valor);
				textFieldDirecci.setEditable(valor);
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
		
		if(i==10)  // Consultar por sexo.
		{
			
			indice++;
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);		
			label_2.setVisible(false);
			comboBox_2.setVisible(false);
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
			comboBox_1.setEnabled(true);
			lblNmina.setVisible(true);
			textField.setVisible(true);
			
		}
		if(i==12){  // Baja de especialista.
			
			btnNewButton.setVisible(false);
			btnCerrar_1.setVisible(true);
			lblDni.setVisible(true);
			btnEliminar.setVisible(true);
			textFieldDniEliminar.setVisible(true);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(true);
			lblDni.setEnabled(true);
			textFieldDni.setVisible(false);
			labelDni.setVisible(false);
			btnNewButtonAnnadir.setVisible(false);
			btnNewButtonAnt.setVisible(false);
			resetear(comboBox_1,comboBoxEspecial);
			label_2.setVisible(false);
			comboBox_2.setVisible(false);
			lblNmina.setVisible(true);
			textField.setVisible(true);
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==14)  	// Consultar todos.
		{
		
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(false);
			textFieldDni.setVisible(true);
			labelDni.setVisible(true);
			btnNewButtonAnnadir.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox_1,comboBoxEspecial);
			
			label_2.setVisible(false);
			comboBox_2.setVisible(false);
			lblNmina.setVisible(false);
			textField.setVisible(false);
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==15)   // Consultar por especialidad.
		{
			
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(false);
			textFieldDni.setVisible(true);
			labelDni.setVisible(true);
			btnNewButtonAnnadir.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox_1,comboBoxEspecial);
			
			label_2.setVisible(true);
			comboBox_2.setVisible(true);
			
			lblNmina.setVisible(true);
			textField.setVisible(true);
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==16)  // Consulta por antiguedad.
		{
			
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(false);
			textFieldDni.setVisible(true);
			labelDni.setVisible(true);
			btnNewButtonAnnadir.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox_1,comboBoxEspecial);
			
			label_2.setVisible(false);
			comboBox_2.setVisible(false);
			
			lblNmina.setVisible(true);
			textField.setVisible(true);
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		if (i==17)
		{
			// Toca obtener la n�mina para cada empleado.
			// Consultar todos.
			btnCerrar_1.setVisible(false);
			lblDni.setVisible(false);
			btnEliminar.setVisible(false);
			textFieldDniEliminar.setVisible(false);
			comboBox_1.setVisible(false);
			textFieldDniEliminar.setEnabled(false);
			lblDni.setEnabled(false);
			textFieldDni.setVisible(true);
			labelDni.setVisible(true);
			btnNewButtonAnnadir.setVisible(true);
			btnNewButtonAnt.setVisible(true);
			resetear(comboBox_1,comboBoxEspecial);
			
			label_2.setVisible(false);
			comboBox_2.setVisible(false);
			
			lblNmina.setVisible(true);
			textField.setVisible(true);
			
			
			modo_edicion(comboBox,comboBox_1,comboBoxEspecial,dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr,false);
		}
		
		if (i!=12)
		{
			Especialista un;
			un = (Especialista) listaEmpleados.get(0);
			textFieldDni.setText(un.getDni());
			textField_1Nombre.setText(un.getNombre());
			textFieldApell.setText(un.getApellidos());
			textFieldDirecci.setText(un.getDireccion());
			textFieldEmail.setText(un.getEmail());
			textFieldAntigue.setText(Integer.toString(un.getDiasTrabajados()));
			//indice++;
			if(un.getSexo()=="HOMBRE")
				comboBox.setSelectedIndex(0);
			else
				comboBox.setSelectedIndex(1);
			switch(un.getEspe()){
			case "PEDIATRIA":
				comboBoxEspecial.setSelectedIndex(0);
				break;
			case "NEUROLOGIA":
				comboBoxEspecial.setSelectedIndex(1);
				break;
			case "OFTALMOLOGIA":
				comboBoxEspecial.setSelectedIndex(2);
				break;
			case "RADIOLOGIA":
				comboBoxEspecial.setSelectedIndex(3);
				break;
			}
			textField.setText(Float.toString(un.nomina()));
			if (un.getDiasTrabajados()>365)
			{
				JOptionPane.showMessageDialog(null,"\nEste especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
				textField.setText(Float.toString(((un.nomina()*25)/100)+un.nomina()));
			}
		}
		
		
		
	}
	
	/**
	 * habilita o deshabilita los campos
	 * @param uno
	 * @param dos
	 * @param tr
	 * @param un
	 * @param doses
	 * @param tres
	 * @param valor
	 */
	public void modo_edicion(JComboBox uno, JComboBox dos,JComboBox tr,JDateChooser un, JDateChooser doses, JDateChooser tres, boolean valor)
	{
		textFieldDni.setEditable(valor);
		textField_1Nombre.setEnabled(valor);
		textFieldApell.setEnabled(valor);
		textFieldDirecci.setEnabled(valor);
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
	 * Borra los campos
	 * @param uno
	 * @param dos
	 */
	public void resetear(JComboBox uno, JComboBox dos){
		textFieldDni.setText("");
		textFieldApell.setText("");
		textField_1Nombre.setText("");
		textFieldDirecci.setText("");
		textFieldEmail.setText("");
		textFieldAntigue.setText("");
		dos.setSelectedIndex(0);
		uno.setSelectedIndex(0);
		
		
	}
	
	/**
	 * Comprueba que los elementos del panel no esten vacios
	 * @param uno
	 * @param dos
	 * @param tres
	 * @return
	 */
	public int comprobar_campos(JDateChooser uno, JDateChooser dos, JDateChooser tres)
	//Tres no se comprueba porque puede ser que un empleado no tenga fecha de baja.
	{
		
		if (textFieldDni.getText().compareTo("")==0)
			return 1;//No hay datos en el campo dni
		if (textField_1Nombre.getText().compareTo("")==0)
			return 2;
		if (textFieldApell.getText().compareTo("")==0)
			return 3;
		if (textFieldDirecci.getText().compareTo("")==0)
			return 4;
		if (textFieldEmail.getText().compareTo("")==0)
			return 5;
		if (textFieldAntigue.getText().compareTo("")==0)
			return 6;
		if (uno==null)
			return 8;
		if (dos==null)
			return 9;
		return 7;//Significa que no hay ningun problema, hay datos
			
	}
	/**
	 * Se utiliza para el alta
	 * @param listaEmpleados
	 * @param g
	 */
	public EspecialistaGui(final ListaEmpleados listaEmpleados, Gestion g) {
		
		
		setTitle("Especialista");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Fecha Fin Contratacion");
		label.setBounds(10, 183, 140, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Fecha Contratacion");
		label_1.setBounds(10, 157, 118, 14);
		contentPane.add(label_1);
		
		final JLabel label_3 = new JLabel("Apellidos");
		label_3.setBounds(29, 78, 59, 14);
		contentPane.add(label_3);
		
		final JLabel label_4 = new JLabel("Nombre");
		label_4.setBounds(29, 53, 69, 14);
		contentPane.add(label_4);
		
		final JLabel labelDni = new JLabel("Dni");
		labelDni.setBounds(29, 28, 56, 14);
		contentPane.add(labelDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(116, 25, 95, 20);
		contentPane.add(textFieldDni);
		
		textField_1Nombre = new JTextField();
		textField_1Nombre.setColumns(10);
		textField_1Nombre.setBounds(116, 53, 95, 20);
		contentPane.add(textField_1Nombre);
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(116, 78, 95, 20);
		contentPane.add(textFieldApell);
		
		textFieldAntigue = new JTextField();
		textFieldAntigue.setColumns(10);
		textFieldAntigue.setBounds(291, 180, 86, 20);
		contentPane.add(textFieldAntigue);
		
		JLabel label_6 = new JLabel("Antiguedad");
		label_6.setBounds(304, 157, 69, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Sexo");
		label_7.setBounds(250, 81, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Email");
		label_8.setBounds(250, 53, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Direccion");
		label_9.setBounds(237, 28, 59, 14);
		contentPane.add(label_9);
		
		textFieldDirecci = new JTextField();
		textFieldDirecci.setColumns(10);
		textFieldDirecci.setBounds(306, 25, 99, 20);
		contentPane.add(textFieldDirecci);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(306, 50, 99, 20);
		contentPane.add(textFieldEmail);
		
		final JDateChooser dateChooserFNaci = new JDateChooser();
		dateChooserFNaci.setDateFormatString("dd/MM/yyyy");
		dateChooserFNaci.setBounds(116, 109, 95, 20);
		contentPane.add(dateChooserFNaci);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(227, 107, 77, 14);
		contentPane.add(lblEspecialidad);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(304, 75, 101, 20);
		contentPane.add(comboBox);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(29, 107, 59, 14);
		contentPane.add(lblFechaNacimiento);
		
		final JDateChooser dateChooserFcontra = new JDateChooser();
		dateChooserFcontra.setDateFormatString("dd/MM/yyyy");
		dateChooserFcontra.setBounds(116, 152, 95, 20);
		contentPane.add(dateChooserFcontra);
		
		final JDateChooser dateChooserFfinContr = new JDateChooser();
		dateChooserFfinContr.setDateFormatString("dd/MM/yyyy");
		dateChooserFfinContr.setBounds(144, 183, 95, 20);
		contentPane.add(dateChooserFfinContr);
		
		final JComboBox comboBoxEspecial = new JComboBox();
		comboBoxEspecial.setModel(new DefaultComboBoxModel(hospitalCarlos.EspecialidadEspecialista.values()));
		comboBoxEspecial.setBounds(304, 106, 101, 20);
		contentPane.add(comboBoxEspecial);
		
		/**
		 * Boton Cerrar
		 */
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCerrar.setBounds(301, 211, 89, 23);
		contentPane.add(btnCerrar);
		
		/**
		 * Boton que a�ade un Especialista
		 */
		JButton btnNewButtonAnnadir = new JButton("A\u00F1adir");
		btnNewButtonAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=0;			
				i=comprobar_campos(dateChooserFNaci,dateChooserFcontra,dateChooserFfinContr);
				if (i==7)//Hay datos 
				{
					String aux,aux1,aux2;
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					aux=formato.format(dateChooserFNaci.getDate());//Paso la fecha a String
					aux1=formato.format(dateChooserFcontra.getDate());
					if (dateChooserFfinContr.getDate()!=null){
						aux2=formato.format(dateChooserFfinContr.getDate());
					}else
						aux2=null;
					
					Date fnac= null;
					Date falta = null;
					Date fbaja= null;
					try{
						fnac=formato.parse(aux);//Paso el String a Date.
						falta=formato.parse(aux1);
						if (aux2!=null)
						{
							final long MILLSECS_PER_DAY = 24*60*60*1000;//Calcular el numero de dias entre Alta y baja
							fbaja=formato.parse(aux2);
							long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
							textFieldAntigue.setText(Long.toString(diferencia));
						}
						else
						{
							fbaja=formato.parse(aux1);
							textFieldAntigue.setText("0");
						}
						
					} catch (ParseException ex)
					{
						ex.printStackTrace();
					}
					;
					
					Especialista e1 = new Especialista(textFieldDni.getText(),textField_1Nombre.getText(),textFieldApell.getText(),comboBox.getSelectedItem().toString(),formato.format(fnac),textFieldDirecci.getText(),textFieldEmail.getText(),1,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAntigue.getText()),true,comboBoxEspecial.getSelectedItem().toString());
					if (listaEmpleados.annadir(e1))
					{
						Gestion.setModificado(true);
						JOptionPane.showMessageDialog(null,"\nEspecialista dado de alta correctamente","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"\nEl especialista ya esta dado de alta en el sistema.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					}
					try {
						this.finalize();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					//Comprueba que campo est� vacio
					switch (i)
					{
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
		btnNewButtonAnnadir.setBounds(288, 228, 89, 23);
		contentPane.add(btnNewButtonAnnadir);
		
	}
}
