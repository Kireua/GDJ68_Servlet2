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
				url = "/WEB-INF/views/student/add.jsp";
			}
			
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
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
