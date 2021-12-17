package controller.offer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;
import services.OfferService;

@WebServlet("/offer/deleteoffer.do")
public class DeleteOfferServlet extends HttpServlet {

	private static final long serialVersionUID = 2903997997837550195L;
	
	private OfferService offerService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.offerService = new OfferService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String tipo = req.getParameter("offerClass");

		
		offerService.delete(id, tipo);

		resp.sendRedirect("/turismo/offer/indexoffer.do");
	}


}
