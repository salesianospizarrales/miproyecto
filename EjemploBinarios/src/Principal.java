import java.io.*;
public class Principal {
	public static BufferedReader lector=new BufferedReader (new InputStreamReader(System.in));
	
	public static void crearFichero(File f) throws IOException
	{	FileOutputStream fos=new FileOutputStream(f);//Abrir el fichero binario para escritura
		DataOutputStream dos=new DataOutputStream(fos);//Definimos el objeto escritor
		char res='S';
		String cad;
		int n;
		double num2;
		do{ //controlamos la excepción deformato numerico --> en caso de pedir un numero e introducir letras
			try{//Todo lo que va dentro del TRY es el codigo susceptible de error
				System.out.println("Introduzca un numero:");
		        n=Integer.parseInt(lector.readLine());
		        dos.writeInt(n);
		        System.out.println("Intriduzca una cadena: ");
		        cad=lector.readLine();
		        dos.writeUTF(cad);
		        System.out.println("Introduzca un numero real");
		        num2=Double.parseDouble(lector.readLine());
		        dos.writeDouble(num2);
			    do{System.out.println("Desea introducir más elementos?(S/N)");
			       res=lector.readLine().toUpperCase().charAt(0);
			    }while(res!='S'&& res!='N');
			   }
			catch (NumberFormatException e) {//esto es lo que se ejecuta en el caso de producirse error de ejecución por formato numerico erroneo
				System.out.println("Debe introducir un numero");}
			
		  }while(res=='S');
		//cerramos
		dos.close();
		fos.close();
	}
	public static void mostrar(File f) throws IOException
	{	 int n;
	String cad;
	double n2;
		 if(f.exists())
		    {	FileInputStream fis=new FileInputStream(f);//abrimos el fichero binario para lectura
				DataInputStream dis=new DataInputStream(fis);//definimos el objeto lector
				
				try{n=dis.readInt();
				    //mientras la lectura sea correcta
						while(true)
						{ 
							System.out.println(n);
							cad=dis.readUTF();
							System.out.println(cad);
							n2=dis.readDouble();
							System.out.println(n2);
							n=dis.readInt();
						}
					}
				catch( EOFException e){}
				//cerramos 
				dis.close();
				fis.close();
		    }
		  
			
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("Binario.dat");
		crearFichero(f);
		mostrar(f);
	}

}
