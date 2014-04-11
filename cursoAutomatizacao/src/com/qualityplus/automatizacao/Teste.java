package com.qualityplus.automatizacao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste {
	private static WebDriver driver;
	static WebElement elemento = driver.findElement(By.id("txt-nome"));

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testE() throws Exception {
		driver.get("http://rafael/treinamentos/tabela.html");
		
		// Cria lista de objetos do tipo WebElement que recebe as células da tabela acima.
		List<WebElement> celulas = driver.findElements(By.tagName("td"));

		// Loop que imprime o valor de cada célula.
		for(WebElement c : celulas){
			System.out.println(c.getText());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String[] args) {
		
		// Limpa o conteúdo do elemento.
		elemento.clear();

		// Clica e, consequentemente, muda o foco da tela para o elemento.
		elemento.click();

		// Retorna o valor do atributo passado como parâmetro de dado elemento.
		elemento.getAttribute("txt-nome");

		// Retorna o valor de uma propriedade CSS passada como parâmetro de dado elemento.
		elemento.getCssValue("txt-nome");

		// Retorna o ponto da tela do canto superior esquerdo de dado elemento web.
		elemento.getLocation();

		// Retorna a dimensão do elemento (largura e altura).
		elemento.getSize();

		// Retorna o nome da tag HTML de dado elemento.
		elemento.getTagName();

		// Retorna o texto presente dentro do elemento.
		elemento.getText();

		// Retorna verdadeiro ou falso se dado elemento estiver visível ou não na tela.
		elemento.isDisplayed();

		// Retorna verdadeiro ou falso se dado elemento estiver ativo ou não na tela.
		elemento.isEnabled();

		// Retorna verdadeiro ou falso se dado elemento estiver selecionado ou não na tela.
		elemento.isSelected();

		// Insere caracteres num determinado elemento da tela.
		elemento.sendKeys();

		// Envia dados para o servidor se o elemento em questão for um formulário.
		elemento.submit();

		
	}
}




