package br.com.ti0523.patrimonio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ti0523.patrimonio.pojo.Patrimonio;

public class DAOPatrimonio {

	public String cadastrar(Patrimonio patrimonio) {
		
		String resp = null;
		
		//Variável para a conexão com o banco de dados
		Connection con = null;
		
		//Para executar as consultas sql, utilizaremos
		//o comando PreparedStatement associado a uma 
		//variável
		PreparedStatement pst = null;
		
		
		try {
			//Carregar o drive de comunicação com o banco 
			//de dados
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//passagem da url de conexao com o banco de dados,
			//nome de usuário, senha, e porta de comunicação
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpatrimonio?useSSL=false", "root", "");
			//Criar uma variável para utilizar o comando
			//insert into e, assim cadastrar os dados 
			//do patrimônio no banco de dados
			// Esta consulta utilizará passagem de dados por
			//parâmetro, para evitar SQLInject
			/*
			 * SQL Injection: Uma Ameaça Seria à Segurança de Dados
				O que é SQL Injection?
				SQL Injection, ou simplesmente SQLi, é um tipo de ataque cibernético que explora vulnerabilidades em aplicações web para manipular bancos de dados. Essas aplicações, como sites e sistemas, geralmente utilizam a linguagem SQL (Structured Query Language) para interagir com bancos de dados e armazenar informações.
				Como Funciona?
				Imagine um formulário de login em um site. Quando você digita seu nome de usuário e senha, a aplicação envia esses dados para o banco de dados para verificar se as informações estão corretas. O problema ocorre quando a aplicação não valida adequadamente os dados inseridos pelo usuário.
				Um hacker pode inserir código SQL malicioso junto com os dados legítimos. Por exemplo, em vez de digitar apenas um nome de usuário, ele poderia digitar algo como:
				' OR 1=1 --
			 */
			
			String consulta = "INSERT INTO tbl_patrimonio(serie,nomepatrimonio,tipo,descricao,localizacao,datafabricacao,dataaquisicao)"
					+ "VALUES(?,?,?,?,?,?,?)";
			//Preparar a consulta para ser executada.
			pst = con.prepareStatement(consulta);
			//Passagem dos dados aos parametros
			pst.setString(1, patrimonio.getSerie());
			pst.setString(2, patrimonio.getNomepatrimonio());
			pst.setString(3, patrimonio.getTipo());
			pst.setString(4, patrimonio.getDescricao());
			pst.setString(5, patrimonio.getLocalizacao());
			pst.setString(6, patrimonio.getDatafabricacao());
			pst.setString(7, patrimonio.getDataaquisicao());
			
			//Executar a consulta de inserção. A consulta pode 
			//retornar 0(zero) ou 1. Caso retorne 0, significa que 
			//os dados do patrimonio não foram cadastrados. Caso, 
			//retorne 1 , significa que cadastrou
			if(pst.executeUpdate() > 0) {
				resp = "Patrimônio cadastrado com sucesso!";
			}
			else {
				resp = "Não foi possível cadastrar o patrimônio.";
			}
			}
		catch(Exception ex) {
			resp = "Erro ao tentar cadastrar o patrimônio. "+ex.getMessage();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return resp;		
	}
	
}
