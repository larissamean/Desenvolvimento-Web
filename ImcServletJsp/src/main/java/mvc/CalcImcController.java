package main.java.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.mvc.CalcImcModel.Sexo;

@WebServlet("/CalcImcController")
public class CalcImcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Double peso = Double.parseDouble(req.getParameter("peso"));
		Double altura = Double.parseDouble(req.getParameter("altura"));
		Sexo sexo = Sexo.valueOf(req.getParameter("sexo"));

		String resultadoCalculo = CalcImcModel.calcularResultado(peso, altura, sexo);

		req.setAttribute("resultado", resultadoCalculo);

		req.getRequestDispatcher("CalcImcView.jsp").forward(req, resp);
	}
}
