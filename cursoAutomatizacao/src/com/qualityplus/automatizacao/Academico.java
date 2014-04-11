package com.qualityplus.automatizacao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Academico {
	
	private static Selenium selenium;
	
	@BeforeClass
	public static void iniciarTestes() throws Exception{
		SeleniumServerStart.iniciar();
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://lab3-rafael:8080/");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("1000");
		selenium.open("http://lab3-rafael:8080/sistema-academico/");
	}
	
	@Before
	public void inciar(){
		assertEquals("Sistema Acadêmico", selenium.getTitle());
	}
	
	
	@Test
	public void alunoAprovadoNotaMaiorQue7(){
		selenium.type("id=cadastroAluno:nota1", "9");
		selenium.type("id=cadastroAluno:nota2", "9");
		selenium.type("id=cadastroAluno:nota3", "9");
		selenium.click("id=cadastroAluno:buttonCalcular");
		selenium.waitForPageToLoad("30000");
		assertEquals("Aprovado", selenium.getText("css=li"));
	}
	
	@Test
	public void alunoReprovadoPorNotaMenorQue4(){
		selenium.type("id=cadastroAluno:nota1", "3");
		selenium.type("id=cadastroAluno:nota2", "3");
		selenium.type("id=cadastroAluno:nota3", "3");
		selenium.click("id=cadastroAluno:buttonCalcular");
		selenium.waitForPageToLoad("30000");
		assertEquals("Reprovado", selenium.getText("css=li"));
	}
	
	@Test
	public void alunoAprovadoProvaFinal(){
		selenium.type("id=cadastroAluno:nota1", "5");
		selenium.type("id=cadastroAluno:nota2", "5");
		selenium.type("id=cadastroAluno:nota3", "5");
		selenium.click("id=cadastroAluno:buttonCalcular");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=cadastroAluno:provaFinal", "5");
		selenium.click("id=cadastroAluno:buttonCalcular");
		selenium.waitForPageToLoad("30000");
		assertEquals("Aprovado Prova Final", selenium.getText("css=li"));
	}
	
	@Test
	public void alunoReprovadoProvaFinal(){
		selenium.type("id=cadastroAluno:nota1", "5");
		selenium.type("id=cadastroAluno:nota2", "5");
		selenium.type("id=cadastroAluno:nota3", "5");
		selenium.type("id=cadastroAluno:provaFinal", "2");
		selenium.click("id=cadastroAluno:buttonCalcular");
		selenium.waitForPageToLoad("30000");
		assertEquals("Reprovado Prova Final", selenium.getText("css=li"));
	}
	
	
	@AfterClass
	public static void finalizarTestes(){
		selenium.stop();
	}
	
	
}
