package com.iu.main.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			}else if(path.equals("/login.do")) {
				if(method.equals("POST")) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					
					memberDTO = memberDAO.login(memberDTO);
					if(memberDTO != null) {
						System.out.println("로그인 성공");
						HttpSession session = request.getSession();
						session.setAttribute("member", memberDTO);
					}else {
						System.out.println("로그인 실패");
						
					}
					flag=!flag;
					url = "../index.do";
				
					
				}else {
					url= "/WEB-INF/views/member/login.jsp";
				}
			}else if(path.equals("/logout.do")) {
				HttpSession session = request.getSession();
				//첫번째 방법 MemberDTO 값을 null
//				session.setAttribute("member", null);
				
				//두번째 방법 Member 키와 MemberDTO 삭제
//				session.removeValue("member");
				
				//세번째 방법 session 객체 소멸 시간을 0으로 만드는 메서드 
				session.invalidate();
				
				flag=false;
				url = "../index.do";			
			}else if(path.equals("/mypage.do")) {
				url = "/WEB-INF/views/member/mypage.jsp";
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
