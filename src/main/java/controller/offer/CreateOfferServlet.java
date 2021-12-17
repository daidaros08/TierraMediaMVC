package controller.offer;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AbsoluteOffer;
import model.Attraction;
import model.AxBOffer;
import model.Offer;
import model.PercentOffer;
import model.PromotoDB;
import services.AttractionService;
import services.OfferService;

@WebServlet("/offer/createoffer.do")
public class CreateOfferServlet extends HttpServlet {

	private static final long serialVersionUID = 5808376446515773422L;
	
	private OfferService offerService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.offerService = new OfferService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/offer/createoffer.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Create offer Servlet");
		String offerClass = req.getParameter("offerClass");
		String name = req.getParameter("name");
		String tipe = req.getParameter("tipe");
		String atr1 = req.getParameter("atr1");
		String atr2 = req.getParameter("atr2");
		String freeatr = req.getParameter("freeatr");
	
		
		Integer percent = Integer.parseInt(req.getParameter("percent"));
		Integer dtoabs = Integer.parseInt(req.getParameter("abs"));
		String description = req.getParameter("description");

		System.out.println(offerClass+ name+tipe+ atr1+ atr2+ freeatr+ percent+ dtoabs+description);
		
		
		PromotoDB offer = offerService.create(-1,offerClass, name, tipe, atr1, atr2, freeatr, percent, dtoabs,description);
		 
		resp.sendRedirect("/turismo/offer/indexoffer.do");
		
		/*
		if (attraction.isValid()) {
			resp.sendRedirect("/turismo/attractions/index.do");
		} else {
			req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/attractions/create.jsp");
			dispatcher.forward(req, resp);
		}*/

	}

}
