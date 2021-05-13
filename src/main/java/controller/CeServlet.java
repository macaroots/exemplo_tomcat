/**
 * LEA - Live Editing Applications
 * by Renato Lenz Costalima
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
 * Permissions beyond the scope of this license may be available at macaroots@gmail.com.
 */
package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifce.mind.actions.AbstractAction;
import br.ifce.mind.Agent;

@WebServlet("/ce/*")
public class CeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Agent agent = (Agent) this.getServletContext().getAttribute("front");
        Object [] args = {request, response};
		agent.see("http", args);
	}

}
