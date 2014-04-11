package com.qualityplus.automatizacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit {
	@BeforeClass
	public static void inicioTodosOsTestes() {
		System.out.println("Inicio todos os testes");
	}

	@Before
	public void inicioMeusTestes() {
		System.out.println("Inicio meu teste");
	}

	@AfterClass
	public static void finalizoTodosOsTestes() {
		System.out.println("Finalizo todos os testes");
	}

	@Test
	public void testExec01() {
		System.out.println("Teste 1");
	}

	@Test
	public void testExec02() {
		System.out.println("Teste 2");
	}

	@Test
	public void testExec03() {
		System.out.println("Teste 3");
	}
	
	@Test
	public void efetuoLoginNoSistema(){
		
	}

	@After
	public void finalizoMeusTestes() {
		System.out.println("finalizo meus testes");
	}

}
