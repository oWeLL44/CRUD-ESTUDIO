package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudioDao {

	public void cadastra(Estudio estudio) {
		
		Connection con = Conexao.obterConexao();
		
		String sql = "INSERT INTO Estudio(nome,musicasGravadas,taxaHoras) VALUES (?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, estudio.getNome());
			preparador.setInt(2, estudio.getMusicasGravadas());
			preparador.setDouble(3, estudio.getTaxaHoras());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("ESTUDIO CADASTRADO COM SUCESSO!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Estudio> mostraTodos(){
	Connection con = Conexao.obterConexao();
	List<Estudio> estudios = new ArrayList<>();
	String sql = "SELECT * FROM Estudio";
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		ResultSet resultado = preparador.executeQuery();
		
		while(resultado.next()) {
			Estudio estudio = new Estudio();
			estudio.setId(resultado.getInt("id"));
			estudio.setNome(resultado.getString("nome"));
			estudio.setMusicasGravadas(resultado.getInt("musicasGravadas"));
			estudio.setTaxaHoras(resultado.getDouble("taxaHoras"));
			
			estudios.add(estudio);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	
	
	return estudios;
		
	
	
}

public Estudio mostraPorId(int id) {
	Connection con = Conexao.obterConexao();
	Estudio estudio = null;
	String sql = "SELECT * FROM Estudio WHERE id=?";
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1,id);
		
		ResultSet resultado = preparador.executeQuery();
		
		if (resultado.next()){
			estudio = new Estudio();
			estudio.setId(resultado.getInt("id"));
			estudio.setNome(resultado.getString("nome"));
			estudio.setMusicasGravadas(resultado.getInt("musicasGravadas"));
			estudio.setTaxaHoras(resultado.getDouble("taxaHoras"));
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}

	return estudio;

}

public void excluiPorId(int id) {
	
	Connection con = Conexao.obterConexao();
	
	String sql = "DELETE FROM Estudio WHERE id=?";
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1, id);
		
		preparador.execute();
		preparador.close();
		
		System.out.println("Estudio Excluído com Sucesso!!");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}


public void altera (Estudio estudio) {
	
	Connection con = Conexao.obterConexao();
	String sql = "UPDATE Estudio SET nome=?,musicasGravadas=?,taxaHoras=? WHERE id=?";

	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1,estudio.getNome());
		preparador.setInt(2,estudio.getMusicasGravadas());
		preparador.setDouble(3,estudio.getTaxaHoras());
		preparador.setInt(4,estudio.getId());
		
		preparador.execute();
		preparador.close();
		
		System.out.println("Estudio Alterado com Sucesso!");

	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}

}
