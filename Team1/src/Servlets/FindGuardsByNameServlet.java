package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Package.Guard;

import service.GuardServiceImpl;


	@WebServlet("/findGuards")
	public class FindGuardsByNameServlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException {
			// Päringust andmete saamine
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			int guards = Integer.parseInt(request.getParameter("guards"));
		

			// Tegelikkuses oleks siin mingi dependency injection süsteem
			GuardServiceImpl guardService = new GuardServiceImpl();

			List<Guard> guardsList = guardService.findGuardsByName(name);

			request.setAttribute("guardsList", guardsList);

			// Suuname töötlemise edasi JSP'le
			request.getRequestDispatcher("naitaPiiripunkte.jsp").forward(
					request, response);

		}

	}

