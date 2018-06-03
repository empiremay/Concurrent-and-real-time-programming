/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
* clase paciente
* @param nombre
* @param compania
* @param direccion
* @param dni
* @param telefono
*/

public class Paciente {
	private static String nombre;
	private static String compania;
	private static String direccion;
	private static int dni;
	private static int telefono;

	//Constructores:
	/**
	* Constructor nulo
	*/
	public Paciente(){} //constructor nulo
	/**
	* Constructor de la clase paciente
	* @param n
	* @param c
	* @param d
	* @param dn
	* @param tel
	*/
	public Paciente(String n, String c, String d, int dn, int tel) {
		nombre=n;
		compania=c;
		direccion=d;
		dni=dn;
		telefono=tel;
	}

	//Metodos observadores:
	/**
	* @return nombre
	* @return compania
	* @return direccion
	* @return dni
	* @return telefono
	*/
	public String getnombre() {return nombre;}
	public String getcompania() {return compania;}
	public String getdireccion() {return direccion;}
	public int getdni() {return dni;}
	public int gettelefono() {return telefono;}

	//Metodos modificadores:
	/**
	* @return n
	* @return c
	* @return d
	* @return dn
	* @return tel
	*/
	public void setnombre(String n) {nombre=n;}
	public void setcompania(String c) {compania=c;}
	public void setdireccion(String d) {direccion=d;}
	public void setdni(int dn) {dni=dn;}
	public void settelefono(int tel) {telefono=tel;}
}