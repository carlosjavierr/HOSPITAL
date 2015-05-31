package gui;



import hospitalCarlos.Especialista;
import hospitalCarlos.Gestion;
import hospitalCarlos.ListaEmpleados;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ayuda ayuda;
	private Acercade acercade;
	private ListaEmpleados listaEmpleados = new ListaEmpleados();
	 JFileChooser fileChooser;
	private Gestion gestion;
	private Fichers fichers = new Fichers();
	private Nombre nombre= new Nombre("null");
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	/**
	 * Devuelve una listaEmpleados unicamente con los Ats
	 * @param le
	 * @return
	 */
	public ListaEmpleados Dame_Ats(ListaEmpleados le)
	{
		// Esta funcion me devuelve una listaEmpleados unicamente con los ats
		// Recorre la lista de empleados y si el empleado su especialidad es urgencias o nourgencias se añade a la lista que se retorna
		Especialista un;
		ListaEmpleados ats = new ListaEmpleados();		
		for (int ind=0;ind<=le.size()-1;ind++)
		{
			un = (Especialista) le.get(ind);
			if (un.getEspe().compareTo("URGENCIAS")==0 || un.getEspe().compareTo("NOURGENCIAS")==0)
				ats.annadir(un);
		}
		return ats;
	}
	/**
	 * Devuelve una listaEmpleados unicamente con los especialistas
	 * @param le
	 * @return
	 */
	public ListaEmpleados Dame_Especialista(ListaEmpleados le){

		Especialista un;
		ListaEmpleados esp = new ListaEmpleados();		
		for (int ind=0;ind<le.size();ind++)
		{
			un = (Especialista) le.get(ind);
			if (un.getEspe().compareTo("PEDIATRIA")==0 || un.getEspe().compareTo("NEUROLOGIA")==0 ||
					un.getEspe().compareTo("OFTALMOLOGIA")==0 || un.getEspe().compareTo("RADIOLOGIA")==0)
				esp.annadir(un);
		}
		return esp;
	}
	/**
	 *  Devuelve una listaEmpleados unicamente con los enfermeros
	 * @param le
	 * @return
	 */
	public ListaEmpleados Dame_enfermero(ListaEmpleados le){
		Especialista un;
		ListaEmpleados enf = new ListaEmpleados();		
		for (int ind=0;ind<=le.size()-1;ind++){
			un = (Especialista) le.get(ind);
			if (un.getEspe().compareTo("null")==0)
				enf.annadir(un);
		}
		return enf;
	}
	/**
	 * Pone titulo a la ventana principal . Si no hay fichero abierto(el valor es nulo) abrega "sin_fichero" y en caso de haber
	 * fichero abierto escribe en el tiutlo el nombre del fichero abierto
	 * @param nf
	 */
	void ponernombre(Nombre nf){
		if (nf.getNombre()=="null"){
			this.setTitle("Gestion Empleados Hospital || GEH 1.0  --> Sin fichero");
		}
		else
			this.setTitle("Gestion Empleados Hospital || GEH 1.0  -->"+nf.getNombre());
	}
	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ponernombre(nombre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ficheros");
		menuBar.add(mnNewMenu);
		
		ListaEmpleados l=Dame_Especialista(listaEmpleados);
		ListaEmpleados l1=Dame_enfermero(listaEmpleados);
		ListaEmpleados l2=Dame_Ats(listaEmpleados);
		
		/**
		 * Boton Crea un nuevo fichero
		 */
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Comprobamos si hay datos en la listaEmpleados.
				int op=0;
				if (listaEmpleados.size()!=0)
				{
					// Comprobamos si el fichero ha sido modificado.
					if (gestion.getModificado()==true)
					{
						
						op = JOptionPane.showConfirmDialog(null,"\nGuardar los datos que hay abiertos?.","!!!Advertencia",JOptionPane.YES_NO_CANCEL_OPTION);
						if (op==0)
						{
							//Proceder a guardar los datos.
							fichers.guardar(listaEmpleados, nombre, gestion);
						}
					}
					if (op==0)//El usuario ha elegido que si
					{
						//Llegados a este punto, si habia datos cargados estos han sido o bien guardados o no (decisión tomada)
						// por el usuario.
						// A continuación procedemos a limpiar la lista.
						listaEmpleados.cero();//Elimina la lista
						nombre.setNombre("null");
						ponernombre(nombre);//Para poner nombre a la ventana
						JOptionPane.showMessageDialog(null,"\nPrograma preparado para crear nuevas listas!!!","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
				
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNuevo);
		/**
		 * Boton Abrir fichero
		 */
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaEmpleados.size()!=0){
					if (Gestion.getModificado()==true){
						// Estamos en el caso de que se ha abierto un fichero y se ha modificado y ahora se quiere abrir otro fichoro
						// preguntamos al usuario si quiere guardar datos o no.
						if (JOptionPane.showConfirmDialog(null,"\nGuardar los datos que hay abiertos?.","!!!Advertencia",JOptionPane.YES_NO_CANCEL_OPTION)==0){
							//Proceder a guardar los datos.
							fichers.guardar(listaEmpleados, nombre, gestion);	
						}
						//Borramos la lista.
						listaEmpleados.cero();
					}
					
				}
				//Legados a este punto tenemos controlado que si hubiera datos cargados han sido guardados o no por el usuario.
				// ahora nos toca poner el codigo para abrir un nuevo fichero.
				// Unicamente dejamos abrir archivos con la extensión *.geh
						try {
							listaEmpleados=fichers.abrirArchivo(listaEmpleados, nombre);
							if (listaEmpleados==null){//Crear una nueva lista de empleados
								listaEmpleados=new ListaEmpleados();
							}
							ponernombre(nombre);
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmAbrir);
		/**
		 * Boton Guardar
		 */
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					Fichers fichers = new Fichers();
					fichers.guardar(listaEmpleados, nombre, gestion);
					ponernombre(nombre);
				}
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmGuardar);
		/**
		 * Boton Guardar como
		 */
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					Fichers fichers = new Fichers();
					fichers.guardarArchivo(listaEmpleados, nombre);
					ponernombre(nombre);
				}
				
				
				
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnNewMenu.add(mntmGuardarComo);
		/**
		 * Boton salir
		 */
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Mirar si hay datos cargados.
				if (listaEmpleados.size()!=0){
					if (gestion.getModificado()==true){
						int op=0;
						// Hay datos guardados, tenemos que preguntar si queremos guardarlos.
						op=JOptionPane.showConfirmDialog(null,"\nGuardar los datos que hay abiertos?.","!!!Advertencia",JOptionPane.YES_NO_CANCEL_OPTION);
						if (op==0){
							// Significa que quiere guardar los cambios en un fichero.
							fichers.guardar(listaEmpleados, nombre, gestion);
							System.exit(0);
						}
						else{
							if (op==-1) // Corresponde con el NO
								System.exit(0);
						}
					}
					else{
						fichers.guardar(listaEmpleados, nombre, gestion);
						System.exit(0);
						//System.exit(1);
					}
				}else{
					System.exit(0);
				}
				
				
			}
		});
		mnNewMenu.add(mntmSalir);
		
		JMenu mnMedicos = new JMenu("Persona");
		menuBar.add(mnMedicos);
		
		JMenu mnEspecialista = new JMenu("Especialista");
		mnMedicos.add(mnEspecialista);
		/**
		 * Boton Especialista, Alta
		 */
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EspecialistaGui especialista = new EspecialistaGui(listaEmpleados,gestion);
				especialista.setTitle("Alta de nuevo Especialista");
				especialista.setVisible(true);
				
			}

			
		});
		mnEspecialista.add(mntmAlta);
		/**
		 * Boton Especialista, Baja
		 */
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)//comprueba que se puede eliminar
				{
					//ListaEmpleados lista_especialista = new ListaEmpleados();
					//lista_especialista=Dame_Especialista(listaEmpleados);//Nos devuelve una lista unicamente de especialistas
//					if (lista_especialista.size()!=0)
//					{
						EspecialistaGui especialista = new EspecialistaGui(listaEmpleados,12,gestion,listaEmpleados);
						especialista.setTitle("Baja de Especialista");
						especialista.setVisible(true);
						
//					}
//					else
//						JOptionPane.showMessageDialog(null,"\nNo hay datos para eliminar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para eliminar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}

			
		});
		mnEspecialista.add(mntmBaja);
		
		JMenu mnEnfermero = new JMenu("Enfermero");
		mnMedicos.add(mnEnfermero);
		/**
		 * Boton Enfermero, Alta
		 */
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnfermeroGui enfermero = new EnfermeroGui(listaEmpleados,gestion);
				enfermero.setTitle("Alta de Enfermero");
				enfermero.setVisible(true);
				
					
			}

			
		});
		mnEnfermero.add(mntmAlta_1);
		/**
		 * Boton Enfermero, Baja
		 */
		JMenuItem mntmBaja_1 = new JMenuItem("Baja");
		mntmBaja_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
						EnfermeroGui enf = new EnfermeroGui(listaEmpleados,12,gestion,listaEmpleados);
						enf.setTitle("Baja de Enfermero");
						enf.setVisible(true);
						
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para eliminar, agrege antes un enfermero.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}

			
		});
		mnEnfermero.add(mntmBaja_1);
		
		JMenu mnAts = new JMenu("Ats");
		mnMedicos.add(mnAts);
		/**
		 * Boton Ats, Alta
		 */
		JMenuItem mntmAlta_2 = new JMenuItem("Alta");
		mntmAlta_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmAlta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtsGui ats = new AtsGui(listaEmpleados,gestion);
				ats.setTitle("Alta de Ats");
				ats.setVisible(true);
				
				
			}

			
		});
		mnAts.add(mntmAlta_2);
		/**
		 * Boton Ats, Baja
		 */
		JMenuItem mntmBaja_2 = new JMenuItem("Baja");
		mntmBaja_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmBaja_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
//					ListaEmpleados lista_ats = new ListaEmpleados();
//					lista_ats=Dame_Ats(listaEmpleados);
//					if (lista_ats.size()!=0)
//					{
						AtsGui ats = new AtsGui(listaEmpleados,12,gestion,listaEmpleados);
						ats.setTitle("Baja de Ats");
						ats.setVisible(true);
						
					
//					else
//						JOptionPane.showMessageDialog(null,"\nNo hay datos para eliminar, agrege antes un Ats..","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para eliminar, agrege antes un Ats.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}

			
		});
		mnAts.add(mntmBaja_2);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenu mnEspecialista_1 = new JMenu("Especialista");
		mnBuscar.add(mnEspecialista_1);
		/**
		 * Boton Especialista, Buscar por Antiguedad
		 */
		JMenuItem mntmPorAo = new JMenuItem("por Antiguedad");
		mntmPorAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					lista_especialistas=Dame_Especialista(listaEmpleados);//Crea una lista de solo especialistas
					if (lista_especialistas.size()!=0)
					{
						EspecialistaGui especialista = new EspecialistaGui(lista_especialistas,16,gestion,listaEmpleados);
						especialista.setTitle("Consultar Especialistas por Antiguedad");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);	
				}
			}
		});
		mnEspecialista_1.add(mntmPorAo);
		mntmPorAo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		/**
		 * Boton Especialista, Mostrar Todos
		 */
		JMenuItem mntmMostrarTodo = new JMenuItem("Todos");
		mntmMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaEmpleados.size()!=0){
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					Especialista uno;
					uno = (Especialista) listaEmpleados.get(0);
					System.out.println(uno.getDni());
					lista_especialistas=Dame_Especialista(listaEmpleados);
					if (lista_especialistas.size()!=0){
						EspecialistaGui especialista = new EspecialistaGui(lista_especialistas,14,gestion,listaEmpleados);////Muestra todos los especialistas
						especialista.setTitle("Consultar Todos los Especialistas");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnEspecialista_1.add(mntmMostrarTodo);
		mntmMostrarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		/**
		 * Especialista, Mostrar por Sexo
		 */
		JMenuItem mntmPorSexo = new JMenuItem("por Sexo");
		mntmPorSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					lista_especialistas=Dame_Especialista(listaEmpleados);
					
					
					EspecialistaGui especialistaGui2 = new EspecialistaGui(lista_especialistas,10,gestion,listaEmpleados);
					especialistaGui2.setTitle("Consultar Especialistas por Sexo");
					especialistaGui2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}
		});
		mnEspecialista_1.add(mntmPorSexo);
		mntmPorSexo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		/**
		 * Especialista, Mostrar por Especialidad
		 */
		JMenuItem mntmPorEspecialidad = new JMenuItem("por Especialidad");
		mntmPorEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listaEmpleados.size()!=0)
				{
					EspecialistaGui especialistaGui2 = new EspecialistaGui(listaEmpleados,15,gestion,listaEmpleados);
					especialistaGui2.setTitle("Consultar Especialistas por Especialidad");
					especialistaGui2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}
		});
		mnEspecialista_1.add(mntmPorEspecialidad);
		mntmPorEspecialidad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		/**
		 * Especialista, Obtener Nomina
		 */
		JMenuItem mntmObtenerNminas = new JMenuItem("Obtener N\u00F3minas");
		mntmObtenerNminas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Listado de empleados por nómina.
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					lista_especialistas=Dame_Especialista(listaEmpleados);
					if (lista_especialistas.size()!=0)
					{
						EspecialistaGui especialista = new EspecialistaGui(lista_especialistas,17,gestion,listaEmpleados);
						especialista.setTitle("Obtener nóminas de todos los especialistas");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un especialista.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mntmObtenerNminas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnEspecialista_1.add(mntmObtenerNminas);
		
		JMenu mnEnfermero_1 = new JMenu("Enfermero");
		mnBuscar.add(mnEnfermero_1);
		/**
		 * Enfermero, Mostrar por Antiguedad.
		 */
		JMenuItem menuItem = new JMenuItem("por Antiguedad");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_enfermeros = new ListaEmpleados();
					lista_enfermeros=Dame_enfermero(listaEmpleados);
					if (lista_enfermeros.size()!=0)
					{
						EnfermeroGui especialista = new EnfermeroGui(lista_enfermeros,16,gestion,listaEmpleados);
						especialista.setTitle("Consultar Enfermero por Antiguedad");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un enfermero.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un enfermero.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);	
				}
			}
		});
		mnEnfermero_1.add(menuItem);
		/**
		 * Enfermero, Mostrar Todos
		 */
		JMenuItem menuItem_1 = new JMenuItem("Todos");
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados enfermeros = new ListaEmpleados();
					enfermeros=Dame_enfermero(listaEmpleados);
					if (enfermeros.size()!=0)
					{
						EnfermeroGui enf = new EnfermeroGui(enfermeros,14,gestion,listaEmpleados);
						enf.setTitle("Consultar Enfermeros por antiguedad");
						enf.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay enfermeros para listar, agrege antes un enfermero.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					
			}
			else
				JOptionPane.showMessageDialog(null,"\nNo hay enfermeros para listar, agrege antes un enfermero.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}
		});
		mnEnfermero_1.add(menuItem_1);
		/**
		 * Enfermero, Mostrar por Sexo
		 */
		JMenuItem menuItem_2 = new JMenuItem("por Sexo");
		menuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0){
					ListaEmpleados listaenfermeros= new ListaEmpleados();
					listaenfermeros=Dame_enfermero(listaEmpleados);
					EnfermeroGui especialistaGui2 = new EnfermeroGui(listaenfermeros,10,gestion,listaEmpleados);
					especialistaGui2.setTitle("Consultar Enfermeros por Sexo");
					especialistaGui2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ENFERMERO.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		});
		mnEnfermero_1.add(menuItem_2);
		/**
		 * Enfermero, Obtener Nomina
		 */
		JMenuItem mntmObtenerNminas_1 = new JMenuItem("Obtener n\u00F3minas");
		mntmObtenerNminas_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmObtenerNminas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Listado de empleados por nómina.
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					lista_especialistas=Dame_enfermero(listaEmpleados);
					if (lista_especialistas.size()!=0)
					{
						EnfermeroGui especialista = new EnfermeroGui(lista_especialistas,17,gestion,listaEmpleados);
						especialista.setTitle("Obtener nóminas de todos los enfermeros.");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ENFERMERO.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ENFERMERO.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnEnfermero_1.add(mntmObtenerNminas_1);
		
		JMenu mnAts_1 = new JMenu("Ats");
		mnBuscar.add(mnAts_1);
		/**
		 * Ats, boton mostrar por Antiguedad
		 */
		JMenuItem menuItem_4 = new JMenuItem("por Antiguedad");
		menuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_ats = new ListaEmpleados();
					lista_ats=Dame_Ats(listaEmpleados);
					if (lista_ats.size()!=0)
					{
						AtsGui especialista = new AtsGui(lista_ats,16,gestion,listaEmpleados);
						especialista.setTitle("Consultar ATS por Antiguedad");
						especialista.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);	
				}
			
			}
		});
		mnAts_1.add(menuItem_4);
		
		/**
		 * Ats, boton mostrar Todos
		 */
		JMenuItem menuItem_5 = new JMenuItem("Todos");
		menuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados ats = new ListaEmpleados();
					ats=Dame_Ats(listaEmpleados);
					
					if (ats.size()!=0)
					{
						AtsGui atsGui = new AtsGui(ats,14,gestion,listaEmpleados);
						atsGui.setVisible(true);
						atsGui.setTitle("Consultar todos los ATS.");
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay enfermeros para listar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
					
			}
			else
				JOptionPane.showMessageDialog(null,"\nNo hay enfermeros para listar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			
			}
		});
		mnAts_1.add(menuItem_5);
		/**
		 * Ats, boton Mostrar por Sexo
		 */
		JMenuItem menuItem_6 = new JMenuItem("por Sexo");
		menuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados ats = new ListaEmpleados();
					ats = Dame_Ats(listaEmpleados);
					AtsGui atsGui2 = new AtsGui(ats,10,gestion,listaEmpleados);
					atsGui2.setTitle("Consultar Ats por Sexo");
					atsGui2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ats."
							,"!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		mnAts_1.add(menuItem_6);
		/**
		 * Ats, boton mostrar por especialidad
		 */
		JMenuItem menuItem_7 = new JMenuItem("por Especialidad");
		menuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados listaAts = new ListaEmpleados();
					listaAts = Dame_Ats(listaEmpleados);
					AtsGui atsGui = new AtsGui(listaAts,15,gestion,listaEmpleados);
					atsGui.setTitle("Consultar Ats por Especialidad");
					atsGui.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);

			}
		});
		mnAts_1.add(menuItem_7);
		/**
		 * Ats, Boton obtener Nómina
		 */
		JMenuItem mntmObtenerNminas_2 = new JMenuItem("Obtener N\u00F3minas");
		mntmObtenerNminas_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmObtenerNminas_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEmpleados.size()!=0)
				{
					ListaEmpleados lista_especialistas = new ListaEmpleados();
					lista_especialistas=Dame_Ats(listaEmpleados);
					if (lista_especialistas.size()!=0)
					{
						AtsGui ats = new AtsGui(lista_especialistas,17,gestion,listaEmpleados);
						ats.setTitle("Obtener nóminas de todos los ats.");
						ats.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"\nNo hay datos para consultar, agrege antes un ATS.","!!!Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnAts_1.add(mntmObtenerNminas_2);
		
		
		/**
		 * Nominas de Todos los Empleados
		 */
		JMenuItem mntmNminasGenerales = new JMenuItem("N\u00F3minas Generales");
		mntmNminasGenerales.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNminasGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Trabajar con objeto
				
				if (listaEmpleados.size()!=0)
				{
					int i=0;
					int contador=0;
					float nomina=0;
					Especialista mio = new Especialista("a");
					while (i<=listaEmpleados.size()-1)
					{
						mio = (Especialista) listaEmpleados.get(i);
						if (mio.getDiasTrabajados()>365)
						
						{
							
							nomina = ((mio.nomina()*25)/100)+mio.nomina();
							contador++;
						}
						else
							nomina = nomina + mio.nomina();
						i++;
					}
					JOptionPane.showMessageDialog(null,"\nLa cantidad que se paga en nóminas es: "+nomina +
							"\n Y hay " + contador +" empleados con 25% en nómina","!!!",JOptionPane.OK_OPTION);
				}
				
			}
		});
		mnBuscar.add(mntmNminasGenerales);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		/**
		 * Boton Menu, Ayuda
		 */
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
				
				///////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		mnAyuda.add(mntmAyuda);
		/**
		 * Boton Menu, Acerca de
		 */
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercade = new Acercade();
				acercade.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		

	}

	
}
