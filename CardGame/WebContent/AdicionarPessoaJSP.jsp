<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "	java.io.*,
					javax.servlet.*,
					classes.Pessoa,
					banco.PessoaDAO" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Pessoa pessoa1 = new Pessoa();
		PessoaDAO cadastroPessoa = new PessoaDAO();
		
		pessoa1.setNome(nome);
		pessoa1.setEmail(email);
		
		cadastroPessoa.adicionar(pessoa1);
		out.println("Salvo no objeto/Scriptlet");
		out.println("<br>Nome: " + pessoa1.getNome());
		out.println("<br>Email: " + pessoa1.getEmail());
	%>
	<br><br>
	
	Impresso pelo HTML:
	<br>O nome é: ${param.nome}.
	<br>O email é: ${param.email}.

</body>
</html>