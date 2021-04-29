package br.com.apsul.usoelevador.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ElevadorServiceTest {
	
	IElevadorService service = new ElevadorServiceImpl();
	
	@Test
	public void testAndarMenosUtilizado() throws IOException {
		List<Integer> andares = service.andarMenosUtilizado();
		
		assertEquals(9, andares.size());
		assertArrayEquals(new Object[] {11, 12, 14, 0, 5, 6, 7, 10, 9}, andares.toArray());
	}
	
	@Test
	public void testElevadorMaisFrequentado() throws IOException {
		List<Character> elevadores = service.elevadorMaisFrequentado();
		assertEquals(1, elevadores.size());
		assertArrayEquals(new Object[] {'C'}, elevadores.toArray());
				
		
	}
	@Test
	public void testPeriodoMaiorFluxoElevadorMaisFrequentado() throws IOException {
		List<Character> turnos = service.periodoMaiorFluxoElevadorMaisFrequentado();
		assertEquals(1, turnos.size());
		assertArrayEquals(new Object[] {'M'}, turnos.toArray());
						
	}
	
	@Test
	public void testElevadorMenosFrequentado() throws IOException {
		List<Character> elevadores = service.elevadorMenosFrequentado();
		assertEquals(2, elevadores.size());
		assertArrayEquals(new Object[] {'D', 'E'}, elevadores.toArray());
						
	}

	@Test
	public void testPeriodoMenorFluxoElevadorMenosFrequentado() throws IOException {
		List<Character> periodos = service.periodoMenorFluxoElevadorMenosFrequentado();
		assertEquals(2, periodos.size());
		assertArrayEquals(new Object[] {'M', 'M'}, periodos.toArray());
						
	}
	
	@Test
	public void testPeriodoMaiorUtilizacaoConjuntoElevadores() throws IOException {
		List<Character> periodos = service.periodoMaiorUtilizacaoConjuntoElevadores();
		assertEquals(1, periodos.size());
		assertArrayEquals(new Object[] {'M'}, periodos.toArray());
						
	}
	@Test
	public void testPercentualDeUsoElevadorA() throws IOException {
		float percentual = service.percentualDeUsoElevadorA();
		assertEquals(35.0f, percentual,0);
						
	}
	@Test
	public void percentualDeUsoElevadorB() throws IOException {
		float percentual = service.percentualDeUsoElevadorB();
		assertEquals(18.0f, percentual,0);
						
	}
	@Test
	public void percentualDeUsoElevadorC() throws IOException {
		float percentual = service.percentualDeUsoElevadorC();
		assertEquals(40.0f, percentual,0);
						
	}
	@Test
	public void percentualDeUsoElevadorD() throws IOException {
		float percentual = service.percentualDeUsoElevadorD();
		assertEquals(5.0f, percentual,0);
						
	}
	@Test
	public void percentualDeUsoElevadorE() throws IOException {
		float percentual = service.percentualDeUsoElevadorE();
		assertEquals(5.0f, percentual,0);
						
	}
	
}
