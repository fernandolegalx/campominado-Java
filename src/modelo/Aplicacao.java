package modelo;

import visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6,5,5);
		new TabuleiroConsole(tabuleiro);
		}
}
