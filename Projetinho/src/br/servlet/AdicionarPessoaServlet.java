package br.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.PessoaDAO;
import classes.Pessoa;

/**
 * Servlet implementation class AdicionarPessoaServlet
 */
@WebServlet("/adicionarPessoa")
public class AdicionarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Pessoa pessoa1 = new Pessoa();
		PessoaDAO cadastroPessoa = new PessoaDAO();
		
		pessoa1.setNome(nome);
		pessoa1.setEmail(email);
		
		cadastroPessoa.adicionar(pessoa1);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Adicionar Pessoa no Projetinho do Edimo</title>");
		out.println("<body>");
		out.println("<h1>O cadastro: </h1>");
		out.println("Nome: "+nome);
		out.println("Email: "+email);
		out.println("</body>");
		out.println("</html>");
	}

}
