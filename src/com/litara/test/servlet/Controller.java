package com.litara.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.litara.test.commands.ActionCommand;
import com.litara.test.commands.factory.ActionFactory;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.resource.MessageManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name="controller",urlPatterns= {"/controller"})
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	public void init() throws ServletException {

	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String page = null;
		// определение команды, пришедшей из JSP
		SessionRequestContent sessionRequest = new SessionRequestContent(request);
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(sessionRequest);
		/*
		 * вызов реализованного метода execute() и передача параметров
		 * классу-обработчику конкретной команды
		 */
		page = command.execute(sessionRequest);
		// метод возвращает страницу ответа
		// page = null; // поэксперементировать!
		sessionRequest.insertValues(request);
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			// вызов страницы ответа на запрос
			dispatcher.forward(request, response);
		} else {
			// установка страницы c cообщением об ошибке
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
