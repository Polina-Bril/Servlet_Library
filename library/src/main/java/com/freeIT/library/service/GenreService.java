package com.freeIT.library.service;

import com.freeIT.library.exception.MyServiceException;
import com.freeIT.library.model.Genre;

import java.util.List;

public interface GenreService {

	Genre getById(Integer id) throws MyServiceException;

	List<Genre> getAll() throws MyServiceException;

	Genre create(Genre genre);

	Genre update(Genre genre);

	void delete(Integer id);
}
