package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminDeleteMembeServlet
 */
@WebServlet(name = "AdminDeleteMembe", urlPatterns = { "/adminDeleteMembe" })
public class AdminDeleteMembeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteMembeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Member m=(Member)session.getAttribute("member");
		String memberId=m.getMemberId();
		int result=new MemberService().deleteMember(memberId);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/admin.jsp");
		if(result>0) {
			request.setAttribute("msg", "탈퇴되셨습니다");
			request.setAttribute("loc", "/");
		}else {
			request.setAttribute("msg", "탈퇴실패");
			request.setAttribute("loc", "/mypage");
			
		}
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
