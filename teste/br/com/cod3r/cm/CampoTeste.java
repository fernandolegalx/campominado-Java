package br.com.cod3r.cm;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	private Campo campo = new Campo(3,3);
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
	Campo vizinho = new Campo(3,2);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertTrue(resultado);
	
	}
	@Test
	void testeVizinhoRealDistancia1Direita() {
	Campo vizinho = new Campo(3,4);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertTrue(resultado);
	
	}
	
	@Test
	void testeVizinhoRealDistancia1Cima() {
	Campo vizinho = new Campo(2,3);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertTrue(resultado);
	
	}
	
	@Test
	void testeVizinhoRealDistancia1Baixo() {
	Campo vizinho = new Campo(4,3);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertTrue(resultado);
	
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
	Campo vizinho = new Campo(2,2);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertTrue(resultado);
	
	}
	
	@Test
	void testeNãoVizinho() {
	Campo vizinho = new Campo(1,1);
	boolean resultado = campo.adicionarVizinho(vizinho);
	assertFalse(resultado);
	
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testealternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testealternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
			});
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());

	}
	
	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		assertTrue(campo22.isAberto() && !campo11.isAberto());
		
		
		

	}
}
