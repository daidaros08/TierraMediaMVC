package controller.itinerari;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerari;
import model.User;
import persistence.commons.DAOFactory;
import services.ItinerariService;
import services.UserService;


@WebServlet("/itinerario/indexitin.do")
public class ListItinerariServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	
	private ItinerariService itinerariService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerariService = new ItinerariService();
	}

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Itinerari> itinerari = itinerariService.list();
		
		req.setAttribute("itinerari", itinerari);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerari/indexitin.jsp");
		dispatcher.forward(req, resp);

	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Diego 10-12 Agrego Filtro x usuario!
		
		User user = (User) req.getSession().getAttribute("user");
		
		Integer aux = user.getId();
		
		List<Itinerari> itinerari = itinerariService.list(aux);
		
		req.setAttribute("itinerari", itinerari);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerari/indexitin.jsp");
		dispatcher.forward(req, resp);

	}

}
