package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ConnectionFactory;
import model.Pais;

public class PaisDAO {
	
	public static int criar(Pais pais) {
		String sqlInsert = "INSERT INTO país(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getId();
	}

	public void atualizar(Pais pais) {
		String sqlUpdate = "UPDATE país SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM país WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Pais carregar(int id) {
        Pais pais = new Pais();
        String sqlSelect = "SELECT * FROM país WHERE país.id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    pais.setNome(rs.getString("nome"));
                    pais.setPopulacao(rs.getLong("populacao"));
                    pais.setArea(rs.getDouble("area"));
                } else {
                    pais.setId(-1);
                    pais.setNome(null);
                    pais.setPopulacao(0);
                    pais.setArea(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return pais;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaMaiorPopulacao() {
		ArrayList maiorPopulacao = new ArrayList();
		String sqlSelect = "SELECT * FROM país ORDER BY populacao DESC LIMIT 1";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							maiorPopulacao.add(rs.getString("nome"));
							maiorPopulacao.add(rs.getString("populacao"));
							maiorPopulacao.add(rs.getString("area"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return maiorPopulacao;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaMenorArea() {
		ArrayList menorArea = new ArrayList();
		String sqlSelect = "SELECT * FROM país ORDER BY area ASC LIMIT 1";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							menorArea.add(rs.getString("nome"));
							menorArea.add(rs.getString("populacao"));
							menorArea.add(rs.getString("area"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return menorArea;
	}
	
	public static Pais[] vetor3() {
		Pais pais = null;
		Pais[] vetor = new Pais[3];
		int count = 0;
		String sqlSelect = "SELECT id, nome, populacao, area FROM país limit 3";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String nome = rs.getString("nome");
					Long populacao = rs.getLong("populacao");
					Double area = rs.getDouble("area");
					pais = new Pais(id, nome, populacao, area);
					vetor[count++] = pais;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return vetor;
	}

}
	
					
					
				
				
