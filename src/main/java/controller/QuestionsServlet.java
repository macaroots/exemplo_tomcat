/**
 * LEA - Live Editing Applications
 * by Renato Lenz Costalima
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
 * Permissions beyond the scope of this license may be available at macaroots@gmail.com.
 */
package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Object []> questions = (List<Object []>) this.getServletContext().getAttribute("questions");
			for (Object [] question: questions) {
				response.getWriter().println(question[0] + ": " + question[1]);
			}
		} catch (IOException e) {}
	}

}
