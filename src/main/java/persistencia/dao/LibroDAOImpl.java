package persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.vo.Genero;
import negocio.vo.Libro;

public class LibroDAOImpl implements LibroDAO {
	
	//Capa que se conecta con la BD.

	@Override
	public List<Libro> obtenerDatosLibro() {
		List<Libro>lista=null;
		try {
			Connection conexion = DriverManager.getConnection( "jdbc:mysql://localhost:6033/biblioteca", "developer", "programaciondaw");
			String sql = "select * from libro order by titulo;";	
			Statement sentencia=conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			
			lista=construyeLista(rs);
			conexion.close();
		} catch (SQLException e) {
			System.out.println("error de conexion en BD");
			e.printStackTrace();
		}
		
		
		return null;
	}
	private List <Libro> construyeLista(ResultSet rs) throws SQLException{
		List <Libro>lista=new ArrayList<>();
		while(rs.next()) {
			Libro l=new Libro();
			
			l.setIsbn(rs.getString("isbn"));
			l.setAutor(rs.getString("autor"));
			l.setGenero(Genero.getGenero(rs.getString("genero")));
			l.setTitulo(rs.getString("titulo"));
			l.setPaginas(rs.getInt("paginas"));
			lista.add(l);
			
		}
		return lista;
	}
	@Override
	public List<Libro> altaLibro() {
		
		return null;
	}
	public boolean insertaLibro(Libro libro) {
		boolean insertado=false;
		try {
			Connection conexion = DriverManager.getConnection( "jdbc:mysql://localhost:6033/biblioteca", "developer", "programaciondaw");
			String sql = "Insert into libro VALUES (?,?,?,?,?);";
		
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			
			
			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, libro.getIsbn());
			sentencia.setString(3, libro.getAutor());
			sentencia.setString(4, libro.getGenero().toString());
			sentencia.setString(5, libro.getPaginas().toString());
			
			sentencia.execute();
			if (sentencia.getUpdateCount()>0)
			insertado=true;
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("");
		}
		return insertado;
		
	}
	
	public boolean actualizaLibro ( Libro libro, String isbn) {
		boolean actualizado=false;
		try {
			Connection conexion = DriverManager.getConnection( "jdbc:mysql://localhost:6033/biblioteca", "developer", "programaciondaw");
			String sql = "Update libro set titulo=?, isbn=?, genero=? , " + "autor=?, paginas=? where isbn=?;"; 
					PreparedStatement sentencia = conexion.prepareStatement(sql);
					
					sentencia.setString(1, libro.getTitulo());
					sentencia.setString(2, libro.getIsbn());
					sentencia.setString(3, libro.getGenero().toString());
					sentencia.setString(4, libro.getAutor());
					sentencia.setInt(5, libro.getPaginas());
					sentencia.setString(6, isbn);
					if(sentencia.executeUpdate(sql)==1)
						actualizado=true;
					
					sentencia.close();
					conexion.close();
		} catch (SQLException e) {
			System.out.println("error en la conexion con la BD");
			e.printStackTrace();
		}
		return actualizado;
		
	}
	private Connection getConexion() throws SQLException {
		
		return  DriverManager.getConnection( "jdbc:mysql://localhost:6033/biblioteca", "developer", "programaciondaw");
	}
	//@Override
//	public boolean actualizaLibro(Libro libro) {
		// TODO Auto-generated method stub
		//return false;
	//}
	
	@Override
	public boolean borraCatalogo() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eliminaLibro(Libro libro) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean truncateLibro() {
		boolean truncated=false;
		try {
		Connection conexion = getConexion();
		String sql = "TRUNCATE TABLE libro;";
		Statement sentencia = conexion.createStatement();
		truncated = true;
		sentencia.close();
		conexion.close();
		} catch (Exception e) {
			System.out.println("Error en la conexion con la BD");
			e.printStackTrace();
		}
		return truncated;
	}
	
}
