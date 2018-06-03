public class Data  implements java.io.Serializable {
	//Datos de la reserva
	String nombre;
	String apellidos;
	String DNI;
	String telefono;
	String direccion;

	public Data() {
		nombre="adabo";
		apellidos="Arias";
		DNI="49438942";
		telefono="63231241";
		direccion="Cfoejw";
	}

	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getDNI() {return DNI;}
	public String gettelefono() {return telefono;}
	public String getDireccion() {return direccion;}
}