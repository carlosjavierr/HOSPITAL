package gui;

import hospitalCarlos.Fichero;
import hospitalCarlos.Gestion;
import hospitalCarlos.ListaEmpleados;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Fichers extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
		
		private ListaEmpleados concesionario = new ListaEmpleados();
		JFileChooser fileChooser; 

		public Fichers(){
//			contenedor=getContentPane();
//			contenedor.setLayout(null);
//			
//			/**
//			 * Se crea el objeto
//			 */
			fileChooser=new JFileChooser();
//			
//			setTitle("Guardar como: ");
//		
//			setSize(400,400);
//			setLocationRelativeTo(null);
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}



		/**
		 * Abre un archivo 
		 * @param concesionario1
		 * 							Representa una lista de Empleados
		 * @param nombre
		 * 							Representa un nombre
		 * @return lista de Empleados
		 * @throws ClassNotFoundException
		 * 							Si la clase no se encuentra
		 */
		ListaEmpleados abrirArchivo(ListaEmpleados concesionario1, Nombre nombre) throws ClassNotFoundException {		
			File abre;
			ListaEmpleados le=null;
			try{
				int valor=0;
				valor=fileChooser.showOpenDialog(this);
				System.out.println(valor);
				if (valor!=1){
					nombre.setNombre(fileChooser.getSelectedFile().getAbsolutePath());
					abre= new File(nombre.getNombre());
					if (abre!=null){
						abre= new File(nombre.getNombre()); 
						le = new ListaEmpleados();			
						concesionario=Fichero.abrir(abre);
					}
				}
			}
	 		catch(IOException ex){
			  JOptionPane.showMessageDialog(null,ex+"" +"\nNo se ha encontrado el archivo","!!!",JOptionPane.WARNING_MESSAGE);
			  nombre.setNombre("null");
			}
			return concesionario;
			 
		
		}
		
		/**
		 * Guardamos el archivo con extension obj en el fichero
		 */
		 void guardarArchivo(ListaEmpleados concesionario, Nombre nombre) {
			
	 		try{
				if (nombre.getNombre().compareTo("null")==0){
					String ax=".",aux="";
					while (ax.contains(".")){
						ax="";
						ax=JOptionPane.showInputDialog("Nombre de fichero (sin extensión): ");
						aux=ax;
					}
					
					ax=ax+".obj";
					nombre.setNombre(ax);
					File mio = new File(nombre.getNombre());
					nombre.setNombre(mio.getAbsolutePath());
				
					Fichero.guardar(concesionario,mio);
					Gestion.setModificado(false);
				}
				
	 		 }
	 	   catch(IOException ex){
			 JOptionPane.showMessageDialog(null, "Archivo NO Guardado","--> Error",JOptionPane.WARNING_MESSAGE);
		   }
		}
		 /**
		  * Guarda un archivo
		  * @param concesionario
		  * 						Representa una lista de Empleados
		  * @param nombre
		  * 						Representa un nombre
		  * @param g
		  */
		 void guardar(ListaEmpleados concesionario, Nombre nombre, Gestion g) {
		 	if (nombre.getNombre()!="null"){
			 	try{					
					File file = new File(nombre.getNombre());
					nombre.setNombre(file.getAbsolutePath());
					
					if (file.exists()){
						//Lo borramos y volvemos a guardarlo.
						file.delete();
					}
					Fichero.guardar(concesionario,file);
					g.setModificado(false);
		 		 }
		 	   catch(IOException ex){
				 JOptionPane.showMessageDialog(null, "Archivo NO Guardado","--> Error",JOptionPane.WARNING_MESSAGE);
				 nombre.setNombre("null");
			   }
		 	}
		 	else{
		 		String ax=".";
		 		while (ax.contains(".")){
		 			ax="";
		 			ax=JOptionPane.showInputDialog("Nombre de fichero (sin extensión): ");
		 		}
		 		ax=ax+".obj";
		 		nombre.setNombre(ax);
		 		File mio = new File(nombre.getNombre());
		 		try {
					Fichero.guardar(concesionario,mio);
					g.setModificado(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
		}
		 
		 
		 
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}