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
import hospitalCarlos.AtsEspecialidad;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class AtsGui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNomb;
	private JTextField textFieldApell;
	private JTextField textFieldDirecc;
	private JTextField textFieldEmail;
	private JTextField textFieldAnti;
	private int indice;
	private int a=0;
	ListaEmpleados atsaux = new ListaEmpleados();
	private int indice_aux_1=0;
	private JTextField textFieldDniEliminar;
	private JTextField textField;
	private ListaEmpleados milista = new ListaEmpleados();
	int indice_aux=0;
	/**
	 * Devuelve una lista de empleados dependiendo de su especialidad que coincida con aux(especialidad)
	 * @param le
	 * 				Rerpesenta la lista de Empleados
	 * @param aux	
	 * 				Representa la Especialidad
	 * @return un arrayList de empleados
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
			return null;
	}
	
	
	/**
	 * Devuelve una lista de empleados ordenada de menor a mayor; En caso de no poder ordenar devuelve nulo.
	 * @param le
	 * 				Representa la lista de empleados
	 * @return lista de empleados
	 */
	public ListaEmpleados ordenar(ListaEmpleados le)
	{
		int i,j,aux;
		ListaEmpleados ml = new ListaEmpleados();
		Especialista uno;
		Especialista dos;
		if (le.size()!=0)
		{
			for (i=0;i<=le.size()-1;i++)
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
	 * Constructor de AtsGui
	 * @param listaEmpleados
	 * 						Representa la lista de empleados
	 * @param i
	 * 						Representa
	 * @param gestion
	 * 						Representa si se ha modifica do o no 
	 * @param l
	 * 						Representa la lista de empleados
	 * 
	 */
	public AtsGui(final ListaEmpleados listaEmpleados, final int i, final Gestion gestion, final ListaEmpleados l) {
		indice =0;
		setTitle("Ats");
		
		setBounds(100, 100, 476, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(201, 56, 220, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 78, 63, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(22, 53, 60, 14);
		contentPane.add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 106, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 131, 60, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(233, 130, 60, 14);
		contentPane.add(lblSexo);
		
		JLabel lblNewLabel_1 = new JLabel("Antiguedad");
		lblNewLabel_1.setBounds(273, 210, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(80, 47, 100, 20);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
	
		textFieldNomb = new JTextField();
		textFieldNomb.setColumns(10);
		textFieldNomb.setBounds(259, 53, 162, 20);
		contentPane.add(textFieldNomb);
		
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(80, 75, 341, 20);
		contentPane.add(textFieldApell);
		
		textFieldDirecc = new JTextField();
		textFieldDirecc.setColumns(10);
		textFieldDirecc.setBounds(80, 103, 341, 20);
		contentPane.add(textFieldDirecc);
		

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(80, 128, 118, 20);
		contentPane.add(textFieldEmail);
		
		
		textFieldAnti = new JTextField();
		textFieldAnti.setColumns(10);
		textFieldAnti.setBounds(342, 207, 44, 20);
		contentPane.add(textFieldAnti);
		

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setModel(new DefaultComboBoxModel(AtsEspecialidad.values()));
		comboBox_1.setBounds(303, 154, 118, 20);
		contentPane.add(comboBox_1);
		
		JLabel label = new JLabel("Fecha Nacimiento");
		label.setBounds(10, 160, 100, 14);
		contentPane.add(label);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(118, 159, 95, 20);
		contentPane.add(dateChooser);
		
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(118, 187, 95, 20);
		contentPane.add(dateChooser_1);
		
		
		JLabel label_1 = new JLabel("Fecha Contratacion");
		label_1.setBounds(10, 188, 118, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Fecha Fin Contratacion");
		label_2.setBounds(10, 210, 140, 14);
		contentPane.add(label_2);
		
		final JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("dd/MM/yyyy");
		dateChooser_2.setBounds(138, 210, 95, 20);
		contentPane.add(dateChooser_2);
		
		indice_aux_1= listaEmpleados.size()-1;
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(303, 127, 118, 22);
		contentPane.add(comboBox);
		
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(233, 157, 46, 14);
		contentPane.add(lblTipo);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox_2.setBounds(233, 10, 118, 22);
		contentPane.add(comboBox_2);
			
		contentPane.add(comboBox);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(AtsEspecialidad.values()));
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(246, 11, 118, 20);
		contentPane.add(comboBox_3);
		
		final JButton btnNewButtonAnnadir = new JButton("Siguiente");
		btnNewButtonAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (i==16)                                               // Mostrar por antiguedad.
				{
					atsaux=ordenar(listaEmpleados);
					
					if (atsaux!=null)
					{

						if (indice_aux<=atsaux.size()-1){
							
						
						Especialista aux=new Especialista("a");
						
						aux = (Especialista) atsaux.devolver(indice_aux);
						indice_aux++;
						asignarDatos(aux);
						}
						
					}
					
					
					if (indice_aux>atsaux.size()-1)
					{
						indice_aux=atsaux.size()-1;
						a=1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
					
					
					
				}
				if(i == 10)  { 															 // Mostrar por Sexo

					Especialista especialista2;
					indice++;
					int h = 0;
					
					while(indice<=listaEmpleados.size()-1 && h==0){
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_2.getSelectedItem().toString())==0)
						{
							h = 1;
							asignarDatos(especialista2);
							
						}
						else
							indice++;	
					}
					
					if (indice>listaEmpleados.size()-1)
					{
						indice=listaEmpleados.size()-1;
						a=1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				if (i==15){    															// Mostrar por Especialidad
				
					
					milista.cero();
					milista = cargarlista(listaEmpleados,comboBox_3.getSelectedItem().toString());
					
					if(milista != null){
						Especialista ats2 = new Especialista("a");
						int x=0;
						if(indice <= milista.size()){
							ats2 = (Especialista) milista.get(indice);
							asignarDatos(ats2);

						}
						while(indice<milista.size()-1 && x==0){
							indice++;
												ats2 = (Especialista) milista.get(indice);
							if(ats2.getEspe().compareTo(comboBox_3.getSelectedItem().toString())==0){
								x=1;
							}
							
						}
						if(x==1){
							asignarDatos(ats2);
							
						}else{
							indice = milista.size()-1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
						
					}else{
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				if(i==14 || i==17)
				{                                                      					//Muestra Todos
					if(indice < listaEmpleados.size()-1)
					{
						
						
						Especialista ats2 = new Especialista("a");
						indice++;
						ats2 = (Especialista) listaEmpleados.devolver(indice);
						
						
						resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
						asignarDatos(ats2);
						textField.setText(Float.toString(ats2.nomina()));
						if (ats2.getDiasTrabajados()>365)
						{
							JOptionPane.showMessageDialog(null,"\nEste ats tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
							textField.setText(Float.toString(((ats2.nomina()*25)/100)+ats2.nomina()));
						}
						else
							textField.setText(Float.toString(ats2.nomina()));
						
					
					}
					else
					{
					
						indice=listaEmpleados.size()-1;
						a=1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
				/**
				 *  Asignar a los textField, comboBox  y dateChooser los datos que contiene ats2
				 * @param ats2
				 * 				Representa un ats
				 */
				private void asignarDatos(Especialista ats2) {
					textFieldDni.setText(ats2.getDni());
					textFieldNomb.setText(ats2.getNombre());
					textFieldApell.setText(ats2.getApellidos());
					textFieldDirecc.setText(ats2.getDireccion());
					textFieldEmail.setText(ats2.getEmail());
					textFieldAnti.setText(Integer.toString(ats2.getDiasTrabajados()));
					switch(ats2.getSexo()){
					case "HOMBRE":
						comboBox.setSelectedIndex(0);
						break;
					case "MUJER":
						comboBox.setSelectedIndex(1);
						break;
				
					}
					switch(ats2.getEspe()){
					case "URGENCIAS":
						comboBox_1.setSelectedIndex(0);
						break;
					case "NOURGENCIAS":
						comboBox_1.setSelectedIndex(1);
						break;
				
					}
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					try{
					dateChooser.setDate(formato.parse(ats2.getfNacimiento()));
					dateChooser_1.setDate(formato.parse(ats2.getFAlta()));
					dateChooser_2.setDate(formato.parse(ats2.getFBaja()));
					}catch (ParseException ex){
						ex.printStackTrace();
					}
				
				}
		
			});
		btnNewButtonAnnadir.setBounds(352, 238, 89, 23);
		contentPane.add(btnNewButtonAnnadir);
		
		
		
		
		final JButton btnNewButtonAnt = new JButton("Anterior");
		btnNewButtonAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaEmpleados atsaux = new ListaEmpleados();
				
				if (i==16)                                               // Mostrar por antiguedad.
				{
					
					atsaux=ordenar(listaEmpleados);
					System.out.println(listaEmpleados.size());
					System.out.println(atsaux.size());
					System.out.println("Tama�o "+atsaux.size());
					if (atsaux!=null)
					{
						System.out.println("Indice: "+indice_aux_1);
						if (indice_aux_1>0){
							indice_aux_1--;	
//							if (a==1)
//							{
//								indice_aux_1--;
//								a=0;
//							}
							Especialista aux;
							
							aux = (Especialista) atsaux.devolver(indice_aux_1);
							
							asignarDatos(aux);
							
							
						
						
						}
						else
						{
							System.out.println(indice_aux);
							indice_aux_1=0;
							Especialista aux;
							
							aux = (Especialista) atsaux.devolver(indice_aux_1);
							
							asignarDatos(aux);
							indice_aux=0;
							a=1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
						
					}
					
					
					
					
					
					
				}
					
				
				if (i==15) {															 // Mostrar por especialidad   - 15
					milista.cero();
					milista = cargarlista(listaEmpleados,comboBox_3.getSelectedItem().toString());
					
					if(milista != null){
						Especialista ats2 =  new Especialista("a");
						int x=0;						
						if(indice>=0){
							ats2 = (Especialista) milista.get(indice);
							asignarDatos(ats2);
						}
						while(indice>0 && x==0){
							indice--;
							ats2 = (Especialista) milista.get(indice);
							if(ats2.getEspe().compareTo(comboBox_3.getSelectedItem().toString())==0){
								x=1;
							}
						}
						if(x==1){
							asignarDatos(ats2);	
						}else{
							if (indice<0)
							indice = 0;
							JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				if(i == 10){  																	// Mostrar por Sexo   -   10
					Especialista especialista2;
					indice--;
					int h = 0;
					while(indice>=0 && h==0){	
						especialista2 = (Especialista) listaEmpleados.devolver(indice);
						if(especialista2.getSexo().compareTo(comboBox_2.getSelectedItem().toString())==0){
							h = 1;
							asignarDatos(especialista2);	
						}
						else
							indice--;	
					}
					if (indice<0){
						indice=0;
						a=1;
						JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
					}
				}
				if(i == 14 || i==17){
						if(indice > 0){
							indice--;
							Especialista ats2 = new Especialista("a");
							ats2 = (Especialista) listaEmpleados.devolver(indice);
							resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
							asignarDatos(ats2);
							textField.setText(Float.toString(ats2.nomina()));
							if (ats2.getDiasTrabajados()>365){
								JOptionPane.showMessageDialog(null,"\nEste ats tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);	
								textField.setText(Float.toString(((ats2.nomina()*25)/100)+ats2.nomina()));
							}
							else
								textField.setText(Float.toString(ats2.nomina()));
						}
						else{
							indice=0;
							a=1;
							JOptionPane.showMessageDialog(null,"\nNo hay mas ats para mostrar","!!!",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			
			/**
			 *  Asignar a los textField, comboBox  y dateChooser los datos que contiene ats2
			 * @param ats2
			 * 				Representa un ats
			 */
			private void asignarDatos(Especialista ats2) {
				textFieldDni.setText(ats2.getDni());
				textFieldNomb.setText(ats2.getNombre());
				textFieldApell.setText(ats2.getApellidos());
				textFieldDirecc.setText(ats2.getDireccion());
				textFieldEmail.setText(ats2.getEmail());
				textFieldAnti.setText(Integer.toString(ats2.getDiasTrabajados()));//reajustarlo
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try{
				dateChooser.setDate(formato.parse(ats2.getfNacimiento()));
				dateChooser_1.setDate(formato.parse(ats2.getFAlta()));
				dateChooser_2.setDate(formato.parse(ats2.getFBaja()));
				}catch (ParseException ex){
					ex.printStackTrace();
				}
				switch(ats2.getSexo()){
					case "HOMBRE":
						comboBox.setSelectedIndex(0);
						break;
					case "MUJER":
						comboBox.setSelectedIndex(1);
						break;
				}
				switch(ats2.getEspe()){
					case "URGENCIAS":
						comboBox_1.setSelectedIndex(0);
						break;
					case "NOURGENCIAS":
						comboBox_1.setSelectedIndex(1);
						break;
					}
			}
		});
		btnNewButtonAnt.setBounds(119, 244, 89, 23);
		contentPane.add(btnNewButtonAnt);
		
		textFieldDniEliminar = new JTextField();
		textFieldDniEliminar.setBounds(92, 11, 86, 20);
		contentPane.add(textFieldDniEliminar);
		textFieldDniEliminar.setColumns(10);
		
		JButton btnEliminarrrrr = new JButton("Eliminar");
		btnEliminarrrrr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista e1 = new Especialista(textFieldDniEliminar.getText());				
				if(listaEmpleados.devolverDni(textFieldDniEliminar.getText()) != null){
				Especialista e2 = (Especialista) listaEmpleados.devolverDni(textFieldDniEliminar.getText());
				if (e2.getEspe().compareTo("URGENCIAS")==0 || e2.getEspe().compareTo("NOURGENCIAS")==0){
					asignarDatos(e2);
					if(JOptionPane.showOptionDialog(contentPane,"�Quieres eliminar el Ats?", "--> Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null)==0){
						listaEmpleados.eliminar(e2);	
							gestion.setModificado(true);
							resetear(comboBox, comboBox_1,dateChooser,dateChooser_1,dateChooser_2);	
					}
				}
				else
				 JOptionPane.showMessageDialog(null,"\nImposible eliminar","!!!",JOptionPane.WARNING_MESSAGE);
				}
			}
			/**
			 *  Asignar a los textField, comboBox  y dateChooser los datos que contiene especialista2
			 * @param especialista2
			 * 						Representa un ats
			 */
			private void asignarDatos(Especialista especialista2) {
				textFieldDni.setText(especialista2.getDni());
				textFieldNomb.setText(especialista2.getNombre());
				textFieldApell.setText(especialista2.getApellidos());
				textFieldDirecc.setText(especialista2.getDireccion());
				textFieldEmail.setText(especialista2.getEmail());
				textFieldAnti.setText(Integer.toString(especialista2.getDiasTrabajados()));
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try{
					dateChooser.setDate(formato.parse(especialista2.getfNacimiento()));
					dateChooser_1.setDate(formato.parse(especialista2.getFAlta()));
					dateChooser_2.setDate(formato.parse(especialista2.getFBaja()));
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
				switch(especialista2.getEspe()){
				case "URGENCIAS":
					comboBox_1.setSelectedIndex(0);
					break;
				case "NOURGENCIAS":
					comboBox_1.setSelectedIndex(1);
					break;
				}
				if (especialista2.getDiasTrabajados()>365)
				{
					JOptionPane.showMessageDialog(null,"\nEste especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
					textField.setText(Float.toString(((especialista2.nomina()*25)/100)+especialista2.nomina()));
				}
				else
					textField.setText(Float.toString(especialista2.nomina()));
				
				
			}
			
		});
		btnEliminarrrrr.setBounds(10, 244, 91, 23);
		contentPane.add(btnEliminarrrrr);
		
		JLabel lblNmina = new JLabel("Nomina");
		lblNmina.setBounds(233, 185, 46, 14);
		contentPane.add(lblNmina);
		
		textField = new JTextField();
		textField.setBounds(303, 179, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCerrar_1.setBounds(119, 244, 89, 23);
		contentPane.add(btnCerrar_1);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(233, 244, 91, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		
		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialista uno;
				uno = (Especialista) listaEmpleados.devolverDni(textFieldDni.getText().toString());
				int i=0;			
				i=comprobar_campos(dateChooser,dateChooser_1,dateChooser_2);
				if (i==7)
				{
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
						if (aux2!=null)
						{
							final long MILLSECS_PER_DAY = 24*60*60*1000;
							fbaja=formato.parse(aux2);
							long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
							textFieldAnti.setText(Long.toString(diferencia));
						}
						else{
							fbaja=formato.parse(aux1);
							textFieldAnti.setText("0");
						}
						
					} catch (ParseException ex){
						ex.printStackTrace();
					}
					
					
					
					Especialista e2 = new Especialista(textFieldDni.getText(),textFieldNomb.getText(),textFieldApell.getText(),comboBox.getSelectedItem().toString(),formato.format(fnac),textFieldDirecc.getText(),textFieldEmail.getText(),1,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAnti.getText()),true,comboBox_1.getSelectedItem().toString());
					listaEmpleados.eliminar(uno);
					listaEmpleados.annadir(e2);
					l.eliminar(uno);
					l.annadir(e2);
					gestion.setModificado(true);
					JOptionPane.showMessageDialog(null,"\n ATS MODIFICADO CORRECTAMENTE.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
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
			 * 				Representa el estado Enable o Editable(true / false)
			 */
			void Ponercampos(boolean valor){
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAnti.setEditable(valor);
				textFieldAnti.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooser.setEnabled(valor);
				dateChooser_1.setEnabled(valor);
				dateChooser_2.setEnabled(valor);
			}
			/**
			 * Comprueba que campos estan vacios o nulos
			 * @param uno
			 * 				Representa la fecha de nacimiento
			 * @param dos
			 * 				Representa la fecha de Alta
			 * @param tres
			 * 				Representa la fecha de fin de Contratacion
			 * @return Devuelve un entero dependiendo de que campo est� vacio
			 */
				public int comprobar_campos(JDateChooser uno,JDateChooser dos, JDateChooser tres)
				{
					
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
					if (textFieldAnti.getText().compareTo("")==0)
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
					btnNewButtonAnnadir.setVisible(false);
					btnCancelar.setVisible(true);
					
					Ponercampos(true);
				
			}
			/**
			 * Pone los campos que queremos enabledo o editable de pendiendo de lo que se pase
			 * @param valor
			 * 					Representa el estado Enbale o editable de los textField y combobox(true/false)
			 * 			
			 */
			void Ponercampos(boolean valor){
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAnti.setEditable(valor);
				textFieldAnti.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooser.setEnabled(valor);
				dateChooser_1.setEnabled(valor);
				dateChooser_2.setEnabled(valor);
			}
		});
		btnNewButton.setBounds(239, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(350, 265, 91, 23);
		contentPane.add(btnNewButton_1);
		
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
			 * 				Representa el estado Enbale o editable de los textField y combobox(true/false)
			 */
			void Ponercampos(boolean valor){
				textFieldNomb.setEnabled(valor);
				textFieldNomb.setEditable(valor);
				textFieldApell.setEnabled(valor);
				textFieldApell.setEditable(valor);
				textFieldDirecc.setEnabled(valor);
				textFieldDirecc.setEditable(valor);
				textFieldEmail.setEnabled(valor);
				textFieldEmail.setEditable(valor);
				textFieldAnti.setEditable(valor);
				textFieldAnti.setEnabled(valor);
				comboBox.setEditable(valor);
				comboBox.setEnabled(valor);
				dateChooser.setEnabled(valor);
				dateChooser_1.setEnabled(valor);
				dateChooser_2.setEnabled(valor);
			}
		});
		
		
		switch (i){
			case 10: btnCerrar_1.setVisible(false);	comboBox_3.setVisible(false);btnEliminarrrrr.setVisible(false);
			  		 textFieldDniEliminar.setVisible(false);btnNewButtonAnnadir.setVisible(true);
			  		 btnNewButtonAnt.setVisible(true);resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
			  		 label_2.setVisible(true);modo_edicion(comboBox,comboBox_1,comboBox_2,dateChooser,dateChooser_1,dateChooser_2,false);
			  		 comboBox_1.setVisible(true);comboBox_2.setVisible(true);comboBox_2.setEnabled(true);textField.setEnabled(false);
			  		 textField.setEditable(false); break;
			case 12: btnNewButton.setVisible(false);btnCerrar_1.setVisible(true);comboBox_3.setVisible(false);lblDni.setVisible(true);
					 btnEliminarrrrr.setVisible(true);textFieldDniEliminar.setVisible(true);textFieldDniEliminar.setEnabled(true);
					 lblDni.setEnabled(true);textFieldDni.setVisible(false);btnNewButtonAnnadir.setVisible(false);
					 btnNewButtonAnt.setVisible(false);	resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
					 comboBox_1.setVisible(true);textField.setEditable(false);textField.setEnabled(false);
					 modo_edicion(comboBox,comboBox_1,comboBox_2,dateChooser,dateChooser_1,dateChooser_2,false);
					 comboBox_2.setVisible(false);label_2.setVisible(true);break;
			case 14: btnCerrar_1.setVisible(false);comboBox_3.setVisible(false);lblDni.setVisible(true);btnEliminarrrrr.setVisible(false);
			 		 textFieldDniEliminar.setVisible(false);comboBox_1.setVisible(true);textFieldDniEliminar.setEnabled(false);
			 		 lblDni.setEnabled(false);textFieldDni.setVisible(true);btnNewButtonAnnadir.setVisible(true);
			 		 btnNewButtonAnt.setVisible(true);resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
			 		 comboBox_2.setVisible(false);label_2.setVisible(true);textField.setVisible(true);textField.setEnabled(false);
			 		 modo_edicion(comboBox,comboBox_1,comboBox,dateChooser,dateChooser_1,dateChooser_2,false);
			 		 break;
			case 15: btnCerrar_1.setVisible(false);lblDni.setVisible(false);comboBox_2.setVisible(false);comboBox_3.setVisible(true);
					 btnEliminarrrrr.setVisible(false);textFieldDniEliminar.setVisible(false);comboBox_1.setVisible(true);
					 textFieldDniEliminar.setEnabled(false);lblDni.setEnabled(false);textFieldDni.setVisible(true);
					 btnNewButtonAnnadir.setVisible(true);btnNewButtonAnt.setVisible(true);	
					 resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);label_2.setVisible(true);
					 lblNmina.setVisible(true);textField.setVisible(true);textField.setEnabled(false);
					 modo_edicion(comboBox,comboBox_1,comboBox_2,dateChooser,dateChooser_1,dateChooser_2,false);
					 textField.setEditable(false);
					 break;
			case 16: btnCerrar_1.setVisible(false);textFieldDniEliminar.setVisible(false);comboBox_1.setVisible(true);
					 textFieldDni.setVisible(true);lblDni.setVisible(true);btnNewButtonAnnadir.setVisible(true);
					 btnNewButtonAnt.setVisible(true);resetear(comboBox,comboBox_1,dateChooser,dateChooser_1,dateChooser_2);
					 btnEliminarrrrr.setVisible(false);comboBox_3.setVisible(false);lblTipo.setVisible(true);
					 label_2.setVisible(true);comboBox_2.setVisible(false);btnNewButtonAnnadir.setVisible(true);
					 btnNewButtonAnt.setVisible(true);lblNmina.setVisible(true);textField.setVisible(true);
					 textField.setEnabled(false);textField.setEditable(false);
					 modo_edicion(comboBox,comboBox_1,comboBox,dateChooser,dateChooser_1,dateChooser_2,false);
					 break;
			case 17: btnCerrar_1.setVisible(false);comboBox_3.setVisible(false);textFieldDniEliminar.setVisible(false);
					 btnEliminarrrrr.setVisible(false);comboBox_2.setVisible(false);comboBox_3.setVisible(false);
					 textField.setVisible(true);textField.setEnabled(false);textField.setEditable(false);
		   			 modo_edicion(comboBox,comboBox_1,comboBox,dateChooser,dateChooser_1,dateChooser_2,false);
		   			 break;
		}
		// Si no vamos a eliminar a un ATS procedemos a cargar los datos del ATS primero de la lista.
		if (i!=12)
		{
			Especialista un;
			un = (Especialista) listaEmpleados.get(0);
			textFieldDni.setText(un.getDni());
			textFieldNomb.setText(un.getNombre());
			textFieldApell.setText(un.getApellidos());
			textFieldDirecc.setText(un.getDireccion());
			textFieldEmail.setText(un.getEmail());
			textFieldAnti.setText(Integer.toString(un.getDiasTrabajados()));
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try{
				dateChooser.setDate(formato.parse(un.getfNacimiento()));
				dateChooser_1.setDate(formato.parse(un.getFAlta()));
				dateChooser_2.setDate(formato.parse(un.getFBaja()));
			}catch (ParseException ex){
				ex.printStackTrace();
			}
			if (un.getDiasTrabajados()>365){
				JOptionPane.showMessageDialog(null,"\nEste especialista tiene en n�mina +25%","!!!",JOptionPane.WARNING_MESSAGE);
				
				textField.setText(Float.toString(((un.nomina()*25)/100)+un.nomina()));
			}
			else
				textField.setText(Float.toString(un.nomina()));
			if(un.getSexo().compareTo("HOMBRE")==0)
				comboBox.setSelectedIndex(0);
			else
			comboBox.setSelectedIndex(1);
			switch(un.getEspe()){
				case "URGENCIAS":
					comboBox_1.setSelectedIndex(0);
					break;
				case "NOURGENCIAS":
					comboBox_1.setSelectedIndex(1);
					break;
		
			}
		}
	}
	
	
	/**
	 * Borra los campos
	 * @param uno
	 * 				Representa el sexo
	 * @param dos
	 * 				Representa la especialidad
	 * @param tres
	 * 				Representa la fecha de fin de contratacion
	 * 
	 * @param doss
	 * 				Representa la fecha de alta
	 * @param unoo
	 * 				Representa la fecha de nacimiento
	 */
	public void resetear(JComboBox uno, JComboBox dos, JDateChooser tres, JDateChooser doss, JDateChooser unoo){
		textFieldDni.setText("");
		textFieldApell.setText("");
		textFieldNomb.setText("");
		textFieldDirecc.setText("");
		textFieldEmail.setText("");
		textFieldAnti.setText("");
		dos.setSelectedIndex(0);
		uno.setSelectedIndex(0);
		tres.setDate(null);
		doss.setDate(null);
		unoo.setDate(null);
		
		
	}
	/**
	 * Habilita o Deshabilita los campos
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
		textFieldAnti.setEnabled(valor);
		uno.setEnabled(valor);
		dos.setEnabled(valor);
		tr.setEnabled(valor);
		un.setEnabled(valor);
		doses.setEnabled(valor);
		tres.setEnabled(valor);
	}
	/**
	 * Comprueba que los elementos del panel no esten vacios
	 * @param uno
	 * 				Representa la fecha de nacimiento
	 * @param dos
	 * 				Representa la fecha de Alta
	 * @param tres
	 * 				Representa la fecha de Fin de Contratacion
	 * @return	Devuelve un entero 
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
		if (textFieldAnti.getText().compareTo("")==0)
			return 6;
		if (uno==null)
			return 8;
		if (dos==null)
			return 9;
		return 7;
			
	}
	/**
	 * Constructor, se utiliza para el alta de un ATS
	 * @param listaEmpleados
	 * 							Representa una lista de empleados
	 * @param gestion
	 * 							Representa el estado(true/false)
	 */
	public AtsGui(final ListaEmpleados listaEmpleados, final Gestion gestion) {
		setTitle("Ats");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 43, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel tipo = new JLabel("Tipo");
		tipo.setBounds(250, 100, 101, 20);
		contentPane.add(tipo);
		
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
		
		final JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBoxSexo.setBounds(304, 75, 101, 20);
		contentPane.add(comboBoxSexo);
	
		
		
		
		
		textFieldAnti = new JTextField();
		textFieldAnti.setColumns(10);
		textFieldAnti.setBounds(287, 170, 86, 20);
		contentPane.add(textFieldAnti);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(AtsEspecialidad.values()));
		comboBox.setBounds(304, 100, 101, 20);
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
						fnac=formato.parse(aux);
						falta=formato.parse(aux1);
						if (aux2!=null){
							final long MILLSECS_PER_DAY = 24*60*60*1000;
							fbaja=formato.parse(aux2);
							long diferencia = (fbaja.getTime() - falta.getTime())/ MILLSECS_PER_DAY;
							textFieldAnti.setText(Long.toString(diferencia));
						}else{
							fbaja=formato.parse(aux1);
							textFieldAnti.setText("0");
						}
						
					} catch (ParseException ex){
						ex.printStackTrace();
					}
					
					try {
						listaEmpleados.comprobar_dni(textFieldDni.getText());
						 listaEmpleados.comprobar_correo(textFieldEmail.getText());
						Especialista e1 = new Especialista(textFieldDni.getText(),textFieldNomb.getText(),textFieldApell.getText(),comboBoxSexo.getSelectedItem().toString(),formato.format(fnac),textFieldDirecc.getText(),textFieldEmail.getText(),1,formato.format(falta),formato.format(fbaja),Integer.parseInt(textFieldAnti.getText()),true,comboBox.getSelectedItem().toString());
						if (listaEmpleados.annadir(e1)){
							gestion.setModificado(true);
							JOptionPane.showMessageDialog(null,"\n Ats dado de alta correctamente","!!!Advertencia",JOptionPane.WARNING_MESSAGE);	
						}
						else{
							JOptionPane.showMessageDialog(null,"\nEl Ats ya esta dado de alta en el sistema.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
						}
					}catch (DniNoValidoException  | CorreoNoValidoException e1) {	
						;
					}
					try {
						this.finalize();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
	}
}
