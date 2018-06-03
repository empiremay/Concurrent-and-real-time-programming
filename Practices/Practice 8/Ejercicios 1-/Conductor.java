/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/
/**
* Clase Conductor
*/
public class Conductor {
	private String nombre;
	private String primer_apellido;
	private String telefono;
	private String dni;
	private String tipo_permiso;
	private String puntos;
	/**
	* constructor nulo de la clase
	*/
	public Conductor() {}
	/**
	* Constructor de la clase
	* @param nom nombre
	* @param primer primer apellido
	* @param telef telefono
	* @param dn dni
	* @param tipo tipo de permiso
	* @param ptos numero de puntos
	*/
	public Conductor(String nom, String primer, String telef, String dn, String tipo, String ptos) {
		nombre=nom;
		primer_apellido=primer;
		telefono=telef;
		dni=dn;
		tipo_permiso=tipo;
		puntos=ptos;
	}
	/**
	* Metodos modificadores
	*/
	/**
	* metodo Set_nombre
	* @param nom
	*/
	public void Set_nombre(String nom) {nombre=nom;}
	/**
	* metodo Set_primer_apellido
	* @param primer
	*/
	public void Set_primer_apellido(String primer) {primer_apellido=primer;}
	/**
	* metodo Set_telefono
	* @param telef
	*/
	public void Set_telefono(String telef) {telefono=telef;}
	/**
	* metodo Set_dni
	* @param dn
	*/
	public void Set_dni(String dn) {dni=dn;}
	/**
	* metodo Set_tipo_permiso
	* @param tipo
	*/
	public void Set_tipo_permiso(String tipo) {tipo_permiso=tipo;}
	/**
	* metodo Set_puntos
	* @param ptos
	*/
	public void Set_puntos(String ptos) {puntos=ptos;}
	/**
	* Metodos observadores
	*/
	/**
	* metodo Get_nombre
	* @return nombre
	*/
	public String Get_nombre() {return nombre;}
	/**
	* metodo Get_primer_apellido
	* @return primer_apellido
	*/
	public String Get_primer_apellido() {return primer_apellido;}
	/**
	* metodo Get_telefono
	* @return telefono
	*/
	public String Get_telefono() {return telefono;}
	/**
	* metodo Get_dni
	* @return dni
	*/
	public String Get_dni() {return dni;}
	/**
	* metodo Get_tipo_permiso
	* @return tipo_permiso
	*/
	public String Get_tipo_permiso() {return tipo_permiso;}
	/**
	* metodo Get_puntos
	* @return puntos
	*/
	public String Get_puntos() {return puntos;}
}