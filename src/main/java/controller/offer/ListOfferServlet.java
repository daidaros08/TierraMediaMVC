package controller.offer;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.Offer;
import model.User;
import services.AttractionService;
import services.OfferService;

@WebServlet("/offer/indexoffer.do")
public class ListOfferServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -481850280238809216L;
	
	private OfferService offerService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.offerService = new OfferService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//List<Attraction> attractions = attractionService.list();
		//User user = (User) req.getSession().getAttribute("user");
		//List<Attraction> sortedAttractions = user.sortAttractionsByPrefer(attractions);
		//req.setAttribute("attractions", sortedAttractions);
		
		
		List<Offer> offer = offerService.list();
		
		User user = (User) req.getSession().getAttribute("user");
		
		//List<Offer> sortedAttractions = user.sortAttractionsByPrefer(attractions);
		
		req.setAttribute("offer", offer);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/offer/indexoffer.jsp");
		dispatcher.forward(req, resp);

	}

}
