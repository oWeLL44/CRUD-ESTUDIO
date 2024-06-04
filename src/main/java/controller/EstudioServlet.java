package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Estudio;
import modelo.EstudioDao;

@WebServlet("/estudio")
public class EstudioServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("cadastro")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastro.html");
			rd.forward(request, response);

		}else if(acao.equals("mostratodos")) {
			
			EstudioDao estudioDao = new EstudioDao();
			List<Estudio> estudios = estudioDao.mostraTodos();
			
			request.setAttribute("estudios", estudios);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("exclui")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstudioDao estudioDao = new EstudioDao();
			estudioDao.excluiPorId(id);
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos");
		
		}else if(acao.equals("altera")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstudioDao estudioDao = new EstudioDao();
			Estudio estudio = estudioDao.mostraPorId(id);
			
			request.setAttribute("estudio", estudio);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/altera.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("agendarSessao")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstudioDao estudioDao = new EstudioDao();
			Estudio estudio = estudioDao.mostraPorId(id);
			String mensagem = estudio.agendarSessao();
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos&mensagem="+mensagem);
	
			
		}else if(acao.equals("mixarMusica")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstudioDao estudioDao = new EstudioDao();
			Estudio estudio = estudioDao.mostraPorId(id);
			String mensagem = estudio.mixarMusica();
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos&mensagem="+mensagem);
			
		}else if(acao.equals("calcularFaturamento")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstudioDao estudioDao = new EstudioDao();
			Estudio estudio = estudioDao.mostraPorId(id);
			String mensagem = estudio.calcularFaturamento();
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos&mensagem="+mensagem);
			
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao.equals("cadastro")) {
			String nome = request.getParameter("txtnome");
			int musicasGravadas = Integer.parseInt(request.getParameter("txtmusicasGravadas"));
			double taxaHoras = Double.parseDouble(request.getParameter("txttaxaHoras"));
			
			Estudio estudio = new Estudio(nome,musicasGravadas,taxaHoras);
			
			EstudioDao estudioDao = new EstudioDao();
			estudioDao.cadastra(estudio);
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos");
			
		}else if(acao.equals("altera")) {
			
			int id = Integer.parseInt(request.getParameter("txtid"));
			String nome = request.getParameter("txtnome");
			int musicasGravadas = Integer.parseInt(request.getParameter("txtmusicasGravadas"));
			double taxaHoras = Double.parseDouble(request.getParameter("txttaxaHoras"));
			
			Estudio estudio = new Estudio(id,nome,musicasGravadas,taxaHoras);
			
			EstudioDao estudioDao = new EstudioDao();
			estudioDao.altera(estudio);
			
			response.sendRedirect("http://localhost:8080/estudiomusical/estudio?acao=mostratodos");
		}
	}
	
	
	
	
}
