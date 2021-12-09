package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;

@WebServlet("/users/editusers.do")
public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		User user = userService.find(id);
		req.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/editusers.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Integer coins = Integer.parseInt(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));
		String prefer = req.getParameter("prefer");
		
		User user = userService.update(id,username, password, false, coins, time, prefer);

		resp.sendRedirect("/turismo/users/indexusers.do");
		
		/*if (user.isValid()) {
			resp.sendRedirect("/turismo/attractions/index.do");
		} else {
			req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
			dispatcher.forward(req, resp);
		}*/
	}
}
