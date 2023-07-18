package com.iu.main.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
        this.memberDAO = new MemberDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String path = request.getPathInfo();
			String method = request.getMethod();
			String url = "/WEB-INF/views/errors/notFound.jsp";
			boolean flag = true;
		
		
			
			if(path.equals("/join.do")) {
				if(method.equals("POST")) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setBirth(Date.valueOf(request.getParameter("birth")));
					
					int result = memberDAO.join(memberDTO);
					System.out.println(result==1);
					flag = false;
					url = "../index.do";
				}else {
					url = "/WEB-INF/views/member/join.jsp";
					
				}
			}
			
			//URL 구분 끝
			
			if(flag) {
				//Forward
				RequestDispatcher view = request.getRequestDispatcher(url);
				view.forward(request, response);
			}else {
				//Redirect
				response.sendRedirect(url);
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
