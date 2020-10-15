package com.freeIT.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeIT.library.dao.GenreDaoImpl;
import com.freeIT.library.model.Genre;
import com.freeIT.library.service.GenreService;
import com.freeIT.library.service.GenreServiceImpl;

@SuppressWarnings("serial")
public class BooksServlet extends HttpServlet {

	GenreService genreService = null;

	@Override
	public void init() throws ServletException {
		System.out.println("Inside init method");
		genreService = new GenreServiceImpl(new GenreDaoImpl());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside processRequest method");
		System.out.println(request.getHeader("Referer"));
		System.out.println(request.getRequestURI());
		
		List<Genre> all = genreService.getAll();
		PrintWriter out = response.getWriter();
		out.write("<html><body>\n");
		all.forEach(it -> {
		out.write("<h3>ID: <i>"+it.getId()+"</i></h3>\n");
		out.write("<h2 style = 'color:red'> Genre name: "+it.getName()+"</h2>\n");
		});		
		out.write("</body></html>");
		
		out.close();

	}

	@Override
	public void destroy() {
		System.out.println("Inside destroy method");
	}

}