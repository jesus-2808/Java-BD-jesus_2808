package negocio.servicios;


import java.util.List;

import negocio.vo.Libro;

public interface BibliotecaService {
	

	List<Libro> altaLibros(Libro libro);

	List <Libro> listaLibros();

	
	List <Libro> obtenerDatosLibroGenero();
	

	boolean inserta(Libro libro);

	boolean actualizaLibro( Libro libro, String isbn);

	boolean eliminaLibro(Libro libro);
	
	boolean limpiaCatalogo();

	List<Libro> listaLibrosBuscaTitulo(String buscaTitulo);



	List<Libro> maximoPaginas();

	
	
		
		


	
}
