package by.epam.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.logic.ParseXML;
import by.epam.parser.ParserException;
import by.epam.substances.motorcyclist.Motorcyclist;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Motorcyclist> motorcyclists;
	private Logger logger = Logger.getLogger(Servlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}

	@Override
	public void init() {
		String prefix = getServletContext().getRealPath("/");
		new DOMConfigurator().doConfigure(prefix + "resources/log4j.xml",
				LogManager.getLoggerRepository());
	}

	/**
	 * @throws ParserException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if (request.getParameter("button") != null) {
			String prefix = getServletContext().getRealPath("/");
			String fileName = prefix +"resources/bikers.xml";
			String parserName = request.getParameter("parserName")
					.toUpperCase();
			try {
				motorcyclists = ParseXML.getMotorcyclists(parserName, fileName);
				request.setAttribute("res", motorcyclists);
				request.getRequestDispatcher("/jsp/result.jsp").forward(
						request, response);
			} catch (ParserException e) {
				logger.error(e);
				String exception = e.toString();
				request.setAttribute("exception", exception);
				request.getRequestDispatcher("/jsp/error.jsp").forward(request,
						response);
			}
		}
		if (request.getParameter("startPageButton") != null) {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
		if (request.getParameter("exceptionButton") != null) {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

}
