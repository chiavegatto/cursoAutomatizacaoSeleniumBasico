package com.qualityplus.automatizacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class Desafio {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//Inicia o servidor antes de executar o teste, mas só inicia se o server não estiver iniciado
		SeleniumServerStart.iniciar();
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.eliasnogueira.com/");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("1000");
	}

	@Test
	public void testDesafio1() throws Exception {
		selenium.open("/arquivos_blog/selenium/desafio/1desafio/");
		String num1 = selenium.getText("id=number1");
		String num2 = selenium.getText("id=number2");
		//Iria funcionar não não teria necessidade pois já temos os valores sendo recebidos em uma varíavel em java
		//String soma = selenium.getEval(num1 + "+" + num2);
		Integer soma = Integer.valueOf(num1)+ Integer.valueOf(num2);
		selenium.type("name=soma", String.valueOf(soma));
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("CORRETO", selenium.getText("id=resultado"));
	}
	
	@Test
	public void testDesafio2() throws Exception {
		selenium.open("/arquivos_blog/selenium/desafio/2desafio/");
		selenium.click("id=name_rg_display_section");
		selenium.type("id=nome_pessoa", "rafael");
		String nome = selenium.getValue("id=nome_pessoa");
		selenium.click("css=input[type=\"button\"]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (!selenium.isTextPresent("Salvando...")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=email_rg_display_section");
		selenium.type("id=email_value", "rafael@gmail.com");
		String email = selenium.getValue("id=email_value");
		selenium.click("css=#email_hv_editing_section > input[type=\"button\"]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (!selenium.isTextPresent("Salvando...")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=phone_rg_display_section");
		selenium.type("id=phone_value", "92 4453-8753");
		String tel = selenium.getValue("id=phone_value");
		selenium.click("css=#phone_hv_editing_section > input[type=\"button\"]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (!selenium.isTextPresent("Salvando...")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertTrue(selenium.isTextPresent(nome));
		assertTrue(selenium.isTextPresent(email));
		assertTrue(selenium.isTextPresent(tel));
		assertEquals("rafael", selenium.getText("id=name_rg_display_section"));
		assertEquals("Email: " + email, selenium.getText("id=email_rg_display_section"));
		assertEquals("Telefone: " + tel, selenium.getText("id=phone_rg_display_section"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
