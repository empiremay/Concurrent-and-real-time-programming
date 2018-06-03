public class Libro {
	private String titulo;
	private String autor;
	private String numero_paginas;
	private String fecha_publicacion;

	public Libro() {}

	public Libro(String t, String a, String n, String f) {
		titulo=t;
		autor=a;
		numero_paginas=n;
		fecha_publicacion=f;
	}

	public String get_titulo() {return titulo;}
	public String get_autor() {return autor;}
	public String get_paginas() {return numero_paginas;}
	public String get_fecha() {return fecha_publicacion;}

	public void set_titulo(String t) {titulo=t;}
	public void set_autor(String a) {autor=a;}
	public void set_paginas(String n) {numero_paginas=n;}
	public void set_fecha(String f) {fecha_publicacion=f;}
}