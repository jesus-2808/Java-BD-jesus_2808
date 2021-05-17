package persistencia.dao;

import java.util.List;

import negocio.vo.Libro;

public interface LibroDAO {

		List <Libro> obtenerDatosLibro();
		
		List <Libro> altaLibro();
		
		boolean insertaLibro(Libro libro);
		
		boolean borraCatalogo();

	

		boolean actualizaLibro(Libro libro, String isbn);


	

		boolean eliminaLibro(Libro libro);

		boolean truncateLibro();
}
