package com.iu.main.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
        this.studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String path = request.getPathInfo();
			String url = "/WEB-INF/views/errors/notFound.jsp";
			boolean flag = true;
			
			if(path.equals("/list.do")) {
				ArrayList<StudentDTO> ar = studentDAO.studentList();
				System.out.println(ar.size());
				request.setAttribute("studentList", ar);
				url = "/WEB-INF/views/student/list.jsp";
			}else if(path.equals("/detail.do")) {
				String num = request.getParameter("studNum");
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setStudNum(Long.parseLong(num));
				studentDTO = studentDAO.studentDetail(studentDTO);
				request.setAttribute("dto", studentDTO);
				
				url = "/WEB-INF/views/student/detail.jsp";
			}else if(path.equals("/add.do")) {
				
				String method = request.getMethod();
				if(method.equals("POST")) {
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setName(request.getParameter("name"));
					studentDTO.setKorean(Integer.parseInt(request.getParameter("korean")));
					studentDTO.setEnglish(Integer.parseInt(request.getParameter("english")));
					studentDTO.setMath(Integer.parseInt(request.getParameter("math")));
					studentDTO.cal();
					int result = studentDAO.studentAdd(studentDTO);
					request.setAttribute("result", result);
					url="./list.do";
				}else {
					
					url = "/WEB-INF/views/student/add.jsp";
				}
				
			}else if(path.equals("/update.do")) {
				String method = request.getMethod();
				
				if(method.equals("POST")) {
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setName(request.getParameter("name"));
					studentDTO.setKorean(Integer.parseInt(request.getParameter("korean")));
					studentDTO.setEnglish(Integer.parseInt(request.getParameter("english")));
					studentDTO.setMath(Integer.parseInt(request.getParameter("math")));
					studentDTO.setStudNum(Long.parseLong(request.getParameter("studNum")));
					studentDTO.cal();
					int result = studentDAO.studentUpdate(studentDTO);
					
					request.setAttribute("result", result);
					flag=false;
					url="./detail.do?studNum="+studentDTO.getStudNum();
				}else {
					String studNum = request.getParameter("studNum");
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setStudNum(Long.parseLong(studNum));
					studentDTO = studentDAO.studentDetail(studentDTO);
					request.setAttribute("dto", studentDTO);
					url= "/WEB-INF/views/student/update.jsp";
				}
			}else if(path.equals("/delete.do")) {
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setStudNum(Long.parseLong(request.getParameter("studNum")));
				int result = studentDAO.studentDelete(studentDTO);
				
				request.setAttribute("result", result);
				url="/WEB-INF/views/commons/result.jsp";
			}
			
			if(flag) {
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
			}else {
				response.sendRedirect(url);
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
