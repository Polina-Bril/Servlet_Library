package com.freeIT.library.dao;

import com.freeIT.library.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {

	private final String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&&serverTimezone=UTC&characterEncoding=UTF-8";
	private final String USER = "root";
	private final String PASS = "Polinka2012";

	public Genre findById(Integer id) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement ps = conn.prepareStatement("select  * from genres where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Genre> genres = createGenre(rs);
		conn.close();
		return genres.isEmpty() ? null : genres.get(0);
	}

	public List<Genre> findAll() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select  * from genres");
		List<Genre> genres = createGenre(rs);
		conn.close();
		return genres;
	}

	public Genre create(Genre genre) {
		throw new UnsupportedOperationException("���� �� ��������");
	}

	public Genre update(Genre genre) {
		throw new UnsupportedOperationException("���� �� ��������");
	}

	public void delete(Integer id) {
		throw new UnsupportedOperationException("���� �� ��������");
	}

	private List<Genre> createGenre(ResultSet rs) throws SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		while (rs.next()) {
			Genre g = new Genre();
			g.setId(rs.getInt("id"));
			g.setName(rs.getString("name"));

			genres.add(g);
		}
		return genres;
	}
}
