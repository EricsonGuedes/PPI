package PPI.PROJETO.PAÍS;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Pais {

	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	//Construtores
	
	public Pais() {
		
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	//Banco de dados
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager
		.getConnection("jdbc:mysql://localhost:3306/mundo?useTimezone=true&serverTimezone=UTC", "root", "7849516230Ee");
	}

	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public double getArea() {
		return area;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	
	//Aplicando os métodos CRUD (Create, Read, Update and Delete)
	
	public void criar() {
		String sqlInsert = "INSERT INTO país(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM país WHERE país.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	
	public void atualizar() {
		String sqlUpdate = "UPDATE país SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		String sqlDelete = "DELETE FROM país WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void maiorPopulacao() {
		String sqlSelect = "SELECT * FROM país ORDER BY populacao DESC LIMIT 0,1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
		
	public void menorArea() {
		String menorArea = "SELECT * FROM país ORDER BY area ASC LIMIT 0,1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(menorArea);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
		
	public void vetorTresPaises() {
		String sqlSelect = "SELECT * FROM país LIMIT 0,3";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (area == 0) {
			if (other.area != 0)
				return false;
		} 
		if (populacao == 0) {
			if (other.populacao != 0)
				return false;
		} 
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}
}
