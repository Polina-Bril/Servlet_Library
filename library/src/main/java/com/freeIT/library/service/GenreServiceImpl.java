package com.freeIT.library.service;

import com.freeIT.library.dao.GenreDao;
import com.freeIT.library.exception.MyServiceException;
import com.freeIT.library.model.Genre;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreServiceImpl implements GenreService {

	private final Logger LOG = Logger.getLogger(GenreServiceImpl.class.getName());
	private final GenreDao genreDao;

	public GenreServiceImpl(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	public Genre getById(Integer id) throws MyServiceException {
		LOG.log(Level.INFO, "getById(" + id + ") method called");
		try {
			return genreDao.findById(id);
		} catch (SQLException e) {
			LOG.log(Level.WARNING, "Exception appeared while executing 'getById' with parameter id = " + id);
			throw new MyServiceException(e.getLocalizedMessage());
		}
	}

	public List<Genre> getAll() throws MyServiceException {
		LOG.log(Level.INFO, "getAll method called");
		try {
			return genreDao.findAll();
		} catch (SQLException e) {
			LOG.log(Level.WARNING, "Exception appeared while executing 'getAll' method");
			throw new MyServiceException(e.getLocalizedMessage());
		}
	}

	public Genre create(Genre genre) {
		return null;
	}

	public Genre update(Genre genre) {
		return null;
	}

	public void delete(Integer id) {

	}
}