package controller.offer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.Offer;
import model.User;
import persistence.commons.DAOFactory;
import services.BuyAttractionService;
import services.BuyOfferService;


@WebServlet("/offer/buyoffer.do")
public class BuyOfferServlet extends HttpServlet {


	private static final long serialVersionUID = -7669208808063361918L;
	
	private BuyOfferService buyOfferService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.buyOfferService = new BuyOfferService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			User user = (User) req.getSession().getAttribute("user");
			Integer offerId = Integer.parseInt(req.getParameter("id"));

			Offer offer = DAOFactory.getOfferDAO().find(offerId);

			List<Attraction> atr1 = offer.getAttractionsInclude();

			for (Attraction include : atr1) {
				
				Map<String, String> errors = buyOfferService.buy(user.getId(), include.getId());
			
				if (errors.isEmpty()) {
					req.setAttribute("flash", "¡Gracias por comprar!");
				} else {
					req.setAttribute("errors", errors);
					req.setAttribute("flash", "No ha podido realizarse la compra");
				}
			
			
			}
			
			User user2 = DAOFactory.getUserDAO().find(user.getId());
			req.getSession().setAttribute("user", user2);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/offer/indexoffer.do");
			dispatcher.forward(req, resp);
			
			
			
			
			//ArrayList<Offer> offer = DAOFactory.getOfferDAO(req.getParameter("id"));
			/*		offerreq.getParameter("id")
					.getAtraccionesPromo();
			for(int i = 0; i< atrIncluidas.size(); i++) {
				atrCon.update(atrIncluidas.get(i));
			}
		}else {
			atrCon.update(producto.getAtraccion());
		}
		
		
		
		
		
		
		Integer attractionId = Integer.parseInt(req.getParameter("id"));
		
		
		
		User user = (User) req.getSession().getAttribute("user");
		
		// a esto hay que buclearlo por cada attraction que tenga offer
		Map<String, String> errors = buyAttractionService.buy(user.getId(), attractionId);
		
		
		User user2 = DAOFactory.getUserDAO().find(user.getId());
		
		req.getSession().setAttribute("user", user2);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/attractions/index.do");
		dispatcher.forward(req, resp);*/
		
		
		
	}
}
