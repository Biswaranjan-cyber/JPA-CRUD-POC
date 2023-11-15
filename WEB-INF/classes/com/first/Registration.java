package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.second.User;
/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    private static EntityManagerFactory factory;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		factory = Persistence.createEntityManagerFactory("persUnit");
		EntityManager em = factory.createEntityManager();
		
		response.setContentType("text/html");
		
		String uid= request.getParameter("uid");
		String pwd= request.getParameter("pwd");
		String chkBox = request.getParameter("newUser");
				
				if("Y".equalsIgnoreCase(chkBox)) {
					
					RequestDispatcher rd1= request.getRequestDispatcher("userreg");
					rd1.forward(request, response);
				}else {
					
					//RequestDispatcher rd2= request.getRequestDispatcher("userValidate");
					User user =null;
					
					try {
						 Query q = em.createQuery("SELECT u FROM User u WHERE u.userId = :login AND u.Password = :pass");
				         q.setParameter("login", uid);
				         q.setParameter("pass", pwd);
				           				
						user = (User) q.getSingleResult();// em.createNamedQuery("User.findbyUser", User.class).getSingleResult();
					}
					catch(Exception e) {
						
						System.out.println("User Not Found");
						
						RequestDispatcher rd2= request.getRequestDispatcher("error");
						rd2.forward(request, response);
					}
					
					RequestDispatcher rd3= request.getRequestDispatcher("welcome");
					rd3.forward(request, response);
				}
		
		
		
		
	}

}
