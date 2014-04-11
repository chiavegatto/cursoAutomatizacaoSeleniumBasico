package com.qualityplus.automatizacao;

import java.util.Random;

public class Utils {
	public static String geraLoginUsuario() {
		int nrAleatorioVogal;
		int nrAleatorioConsoante;
		String vogal[] = { "a", "e", "i", "o", "u" };
		String nome_parte = "";
		String nome = "";
		String consoante[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l",
				"m", "n", "p", "q", "r", "s", "t", "w", "x", "y", "z" };
		Random random = new Random();
		for (int i = 0; i <= 5; i++) {
			nrAleatorioVogal = 0 + random.nextInt(4);// escolhe uma pos de 0 a 4
			nrAleatorioConsoante = 0 + random.nextInt(19);// escolhe pos de 0 a 19
			nome_parte = vogal[nrAleatorioVogal]
					+ consoante[nrAleatorioConsoante];
			nome = nome + nome_parte;
		}
		return nome;
	}

}
