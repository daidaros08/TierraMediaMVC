package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.User;
import services.AttractionService;
import services.UserService;

//Esta pagina toma el users.jsp y crea un nuevo usuario...en teoria
@WebServlet("/users/newuser.do")
public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/users.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Integer coins = Integer.parseInt(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));
		String prefer = req.getParameter("prefer");
		
		User user = userService.create(100,username, password, false, coins, time, prefer);
		
		resp.sendRedirect("/turismo/users/indexusers.do");
		

		//Attraction attraction = attractionService.create(name, cost, duration, capacity);
		
		/*if (attraction.isValid()) {
			resp.sendRedirect("/turismo/attractions/index.do");
		} else {
			req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/attractions/create.jsp");
			dispatcher.forward(req, resp);
		}*/

	}

}
