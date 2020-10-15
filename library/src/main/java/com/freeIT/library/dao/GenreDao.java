package com.freeIT.library.dao;

import com.freeIT.library.model.Genre;

import java.sql.SQLException;
import java.util.List;

public interface GenreDao {
	Genre findById(Integer id) throws SQLException;

	List<Genre> findAll() throws SQLException;

	Genre create(Genre genre);

	Genre update(Genre genre);

	void delete(Integer id);

}
