package br.com.apsul.usoelevador.service;

import java.io.IOException;
import java.util.List;

public interface IElevadorService {
	/** Deve retornar uma List contendo o(s) andar(es) menos utilizado(s). 
	 * @throws IOException */
	List<Integer> andarMenosUtilizado() throws IOException;
	
	/** Deve retornar uma List contendo o(s) elevador(es) mais frequentado(s). 
	 * @throws IOException */
	List<Character> elevadorMaisFrequentado() throws IOException;
	
	/** Deve retornar uma List contendo o período de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um). 
	 * @throws IOException */
	List<Character> periodoMaiorFluxoElevadorMaisFrequentado() throws IOException;
	
	/** Deve retornar uma List contendo o(s) elevador(es) menos frequentado(s). 
	 * @throws IOException */
	List<Character> elevadorMenosFrequentado() throws IOException;
	
	/** Deve retornar uma List contendo o período de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um). 
	 * @throws IOException */
	List<Character> periodoMenorFluxoElevadorMenosFrequentado() throws IOException;
	
	/** Deve retornar uma List contendo o(s) periodo(s) de maior utilização do conjunto de elevadores. 
	 * @throws IOException */
	List<Character> periodoMaiorUtilizacaoConjuntoElevadores() throws IOException;
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador A em relação a todos os serviços prestados. 
	 * @throws IOException */
	float percentualDeUsoElevadorA() throws IOException;
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador B em relação a todos os serviços prestados. 
	 * @throws IOException */
	float percentualDeUsoElevadorB() throws IOException;
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador C em relação a todos os serviços prestados. 
	 * @throws IOException */
	float percentualDeUsoElevadorC() throws IOException;
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador D em relação a todos os serviços prestados. 
	 * @throws IOException */
	float percentualDeUsoElevadorD() throws IOException;
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador E em relação a todos os serviços prestados. 
	 * @throws IOException */
	float percentualDeUsoElevadorE() throws IOException;

}
