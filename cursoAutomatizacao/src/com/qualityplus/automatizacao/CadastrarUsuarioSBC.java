package com.qualityplus.automatizacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class CadastrarUsuarioSBC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//Inicia o servidor antes de executar o teste, mas só inicia se o server não estiver iniciado
		SeleniumServerStart.iniciar();
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://www.sbc.org.br/");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("1000");
	}

	@Test
	public void testCadastroUsuarioSBC() throws Exception {
		String login = Utils.geraLoginUsuario();
		String email = login + "@fpf.br";
		selenium.open("/");
		assertEquals("Sociedade Brasileira de Computação - SBC / Página Inicial", selenium.getTitle());
		selenium.click("link=Registrar");
		selenium.waitForPageToLoad("30000");
		assertEquals("Sociedade Brasileira de Computação - SBC / Registro", selenium.getTitle());
		selenium.type("id=firstname", "Rafael");
		selenium.type("id=lastname", "Chiavegatto");
		selenium.type("id=email", email);
		selenium.fireEvent("id=email", "blur");
		while (selenium.isElementPresent("css=span.cb_result_ok")==false){
			Thread.sleep(2000);
		}
		assertEquals("Este endereço de e-mail parece ser válido.", selenium.getText("css=span.cb_result_ok"));
		selenium.type("id=username", login);
		selenium.fireEvent("id=username", "blur");
		while (selenium.isElementPresent("css=#username__Response > span.cb_result_ok")==false){
			Thread.sleep(2000);
		}
		assertEquals("O usuário '"+login+"' está livre para registrar: você pode continuar.", selenium.getText("css=#username__Response > span.cb_result_ok"));
		selenium.type("id=password", "123456");
		selenium.type("id=password__verify", "123456");
		selenium.click("//input[@value='Registrar']");
		selenium.waitForPageToLoad("30000");
		while (selenium.isElementPresent("css=span.componentheading")==false){
			Thread.sleep(2000);
		}
		assertEquals("Registro Completado!", selenium.getText("css=span.componentheading"));
	}
	
	@Test
	public void testEfetuarLoginSiteSBC(){
		selenium.open("http://www.sbc.org.br/");
		assertEquals("Sociedade Brasileira de Computação - SBC / Página Inicial", selenium.getTitle());
		selenium.type("id=mod_login_username", "chiavegatto");
		selenium.type("id=mod_login_password", "123456");
		selenium.click("name=Submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("LOGIN DE USUÁRIO Oi, Rafael"));
	}
	
	@Test
	public void testAlterarSenhaSBC() throws Exception {
		selenium.open("http://www.sbc.org.br/");
		assertEquals("Sociedade Brasileira de Computação - SBC / Página Inicial", selenium.getTitle());
		selenium.type("id=mod_login_username", "chiavegatto");
		selenium.type("id=mod_login_password", "123456");
		selenium.click("name=Submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("LOGIN DE USUÁRIO Oi, Rafael"));
		selenium.click("xpath=(//ul[@id='sbc_menu']/li[2]/a/span)[contains(.,'Editar perfil')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Informações para contato");
		selenium.type("id=password", "123456");
		selenium.type("id=password__verify", "123456");
		selenium.click("id=cbbtneditsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=Submit");
		selenium.waitForPageToLoad("30000");
	}
	
		
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}