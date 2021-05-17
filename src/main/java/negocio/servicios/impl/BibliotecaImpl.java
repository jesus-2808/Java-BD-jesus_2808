package negocio.servicios.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import negocio.servicios.BibliotecaService;
import negocio.vo.Genero;
import negocio.vo.Libro;
import persistencia.dao.LibroDAO;
import persistencia.dao.LibroDAOImpl;



public class BibliotecaImpl implements BibliotecaService {
	
	LibroDAO librosBD = new LibroDAOImpl();
	
	

	@Override
	public List<Libro> altaLibros(Libro libro) {
		List<Libro>catalogo=librosBD.obtenerDatosLibro();
		return catalogo;
	}



	@Override
	public boolean inserta(Libro libro) {
		
		return librosBD.insertaLibro(libro);
	}



	public boolean actualizaLibro( Libro libro, String isbn) {
		
		return librosBD.actualizaLibro(libro, isbn);
	}







	@Override
	public List<Libro> listaLibros() {
		List <Libro> catalogo = new LinkedList<>();
		Libro a = new Libro ("libr", "ajdjj", Genero.FICCION, "kerro", 89);
		catalogo.add(a);
		return catalogo;
	}






	@Override
	public boolean eliminaLibro(Libro libro) {
		// TODO Auto-generated method stub
		return librosBD.eliminaLibro(libro);
	}
	
	public boolean limpiaCatalogo() {
		return librosBD.truncateLibro();
		
	}



	




		
		
	}
	


	