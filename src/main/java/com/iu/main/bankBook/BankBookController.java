package com.iu.main.bankBook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BankBookDAO bankBookDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
        this.bankBookDAO = new BankBookDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /bankbook/list.do : 상품 목록을 가져가려고하는 URL
		// /bankbook/detail.do : 상품 디테일을 보려고 하는 URL
		// /bankbook/add.do : 새로운 상품을 추가하는 URL
		// /bankbook/update.do : 상품 수정
		// /bankbook/delete.do : 상품 삭제
		try {
			
			System.out.println(request.getMethod());
			System.out.println(request.getPathInfo());
			System.out.println(request.getServletPath());
			
			String path = request.getPathInfo();
			String viewName = "/WEB-INF/views/errors/notFound.jsp";
			boolean flag = true;
			
			if(path.equals("/list.do")) {
				System.out.println("상품 목록");
				ArrayList<BankBookDTO> ar = bankBookDAO.bankBookList();
				System.out.println(ar.size());
				request.setAttribute("list", ar);
				viewName = "/WEB-INF/views/bankbook/list.jsp";
			}else if(path.equals("/detail.do")) {
				System.out.println("상세 디테일");
				String num= request.getParameter("bookNum");
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNum(Long.parseLong(num));
				bankBookDTO = bankBookDAO.bankBookDetail(bankBookDTO);
				request.setAttribute("dto", bankBookDTO);
				viewName = "/WEB-INF/views/bankbook/detail.jsp";
			}else if(path.equals("/add.do")) {
				
				String method = request.getMethod();
				if(method.equals("POST")) {
					BankBookDTO bankBookDTO = new BankBookDTO();
					bankBookDTO.setBookName(request.getParameter("bookName"));
					bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")));
					bankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
					bankBookDTO.setBookContents(request.getParameter("bookContents"));
					
					int result=bankBookDAO.bankBookAdd(bankBookDTO);
					//request.setAttribute("result", result);
					flag =false;
					viewName="./list.do";
				}else {
					viewName = "/WEB-INF/views/bankbook/add.jsp";
					
				}
				
			}else if(path.equals("/update.do")) {
				System.out.println("상품 수정");
				
				String method = request.getMethod();
				if(method.equals("POST")) {
					BankBookDTO bankBookDTO = new BankBookDTO();
					bankBookDTO.setBookName(request.getParameter("bookName"));
					bankBookDTO.setBookContents(request.getParameter("bookContents"));
					bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")));
					bankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
					bankBookDTO.setBookNum(Long.parseLong(request.getParameter("bookNum")));
					int result = bankBookDAO.bankBookUpdate(bankBookDTO);
					
					request.setAttribute("result", result);
					flag=false;
					viewName="./detail.do?bookNum="+bankBookDTO.getBookNum();
					
				}else {
				
					String bookNum = request.getParameter("bookNum");
					BankBookDTO bankBookDTO = new BankBookDTO();
					bankBookDTO.setBookNum(Long.parseLong(bookNum));
					bankBookDTO=bankBookDAO.bankBookDetail(bankBookDTO);
					request.setAttribute("dto", bankBookDTO);
					viewName = "/WEB-INF/views/bankbook/update.jsp";
				}
				
			}else if(path.equals("/delete.do")) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNum(Long.parseLong(request.getParameter("bookNum")));
				int result = bankBookDAO.bankBookDelete(bankBookDTO);
				System.out.println("상품 삭제");
				
				request.setAttribute("result", result);
				viewName="/WEB-INF/views/commons/result.jsp";
				
				
			}
			
			if(flag) {
			//forward 방식
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}else {
				//redirect
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
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
