package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;


@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> listaUsuarios;
       
    public Formulario() {
    	this.listaUsuarios = new ArrayList<Usuario>();
    	listaUsuarios.add(new Usuario("julio", "pass123"));
    	listaUsuarios.add(new Usuario("javier", "pass"));
    	listaUsuarios.add(new Usuario("paula", "perrorojo"));
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		int flag = 0;
		for(int i=0; i < listaUsuarios.size();i++) {
			if(usuario.equals(listaUsuarios.get(i).getUsuario()) && password.equals(listaUsuarios.get(i).getPassword())) {
				flag = 1;
			}
		}
		
		if(flag == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("acceso.jsp");
			request.setAttribute("usuario", usuario);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			request.setAttribute("usuario", usuario);
			rd.forward(request, response);		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
