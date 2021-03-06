package salon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import salon.service.SalonService;
import salon.vo.SalonDetails;

/**
 * Servlet implementation class SelectSalonServlet
 */
@WebServlet(name = "SelectSalon", urlPatterns = { "/selectSalon" })
public class SelectSalonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSalonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salonName = request.getParameter("salonName");
		
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
	
			SalonDetails sd = new SalonService().salonDetails(salonName,reqPage);
			
			request.setAttribute("salon", sd.getAffilate());
			
			request.setAttribute("pageNavi", sd.getAgeNavi());
			request.setAttribute("star", sd.getSatr());
			
			request.setAttribute("des", sd.getDesignerList());
			request.setAttribute("rev", sd.getReviewList());
			request.getRequestDispatcher("/WEB-INF/views/company/selectSalon.jsp?reqPage="+reqPage).forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
