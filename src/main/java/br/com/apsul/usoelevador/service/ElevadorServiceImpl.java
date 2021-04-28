package br.com.apsul.usoelevador.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.apsul.usoelevador.Main;
import br.com.apsul.usoelevador.model.UsoElevador;

public class ElevadorServiceImpl implements IElevadorService {

	private List<UsoElevador> buscarUsoElevador() throws IOException {
		InputStream json = Main.class.getResourceAsStream("/input.json");

		String j = org.apache.commons.io.IOUtils.toString(json);

		Type tipoLista = new TypeToken<List<UsoElevador>>() {
		}.getType();
		List<UsoElevador> lista = new Gson().fromJson(j, tipoLista);
		return lista;

	}

	public List<Integer> andarMenosUtilizado() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();
		
		Map<Integer, Integer> andaresQtdUso = new LinkedHashMap<Integer, Integer>();

		for (UsoElevador uso : usos) {
			if (andaresQtdUso.containsKey(uso.getAndar())) {
				Integer qtdAtual = andaresQtdUso.get(uso.getAndar());
				andaresQtdUso.put(uso.getAndar(), qtdAtual + 1);
			} else {
				andaresQtdUso.put(uso.getAndar(), 1);
			}
		}

		Integer menorQtdUso = Integer.MAX_VALUE;
		for (Integer qtdUso : andaresQtdUso.values()) {
			if (qtdUso < menorQtdUso) {
				menorQtdUso = qtdUso;
			}
		}

		List<Integer> andaresMenosUtilizados = new ArrayList<>();
		for (Entry<Integer, Integer> entry : andaresQtdUso.entrySet()) {
			if (entry.getValue().equals(menorQtdUso)) {
				andaresMenosUtilizados.add(entry.getKey());
			}
		}

		return andaresMenosUtilizados;
	}

	public List<Character> elevadorMaisFrequentado() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();
		
		Map<Character, Integer> elevadores = new LinkedHashMap<Character, Integer>();

		for (UsoElevador uso : usos) {
			if (elevadores.containsKey(uso.getElevador())) {
				Integer quantAtual = elevadores.get(uso.getElevador());
				elevadores.put(uso.getElevador(), quantAtual + 1);
			} else {
				elevadores.put(uso.getElevador(), 1);
			}
		}

		Integer maxQtdUso = Integer.MIN_VALUE;
		for (Integer qtdUso : elevadores.values()) {
			if (qtdUso > maxQtdUso) {
				maxQtdUso = qtdUso;
			}
		}

		List<Character> elevadorMaisFrequentado = new ArrayList<>();
		for (Entry<Character, Integer> entry : elevadores.entrySet()) {
			if (entry.getValue().equals(maxQtdUso)) {
				elevadorMaisFrequentado.add(entry.getKey());
			}

		}

		return elevadorMaisFrequentado;
	}

	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		List<Character> elevadores = elevadorMaisFrequentado();
		List<Character> usosDosElevadores = new ArrayList<>();

		for (Character elevador : elevadores) {
			Map<Character, Integer> fluxo = new LinkedHashMap<>();

			for (UsoElevador turno : usos) {
				if (turno.getElevador().equals(elevador)) {
					if (fluxo.containsKey(turno.getTurno())) {
						int quantTurno = fluxo.get(turno.getTurno());
						fluxo.put(turno.getTurno(), quantTurno + 1);
					} else {
						fluxo.put(turno.getTurno(), 1);
					}
				}
			}

			Integer maiorFluxo = Integer.MIN_VALUE;
			for (Integer maiorFlx : fluxo.values()) {
				if (maiorFlx > maiorFluxo) {
					maiorFluxo = maiorFlx;
				}
			}
			for (Entry<Character, Integer> entry : fluxo.entrySet()) {
				if (entry.getValue().equals(maiorFluxo)) {
					usosDosElevadores.add(entry.getKey());

				}

			}

		}

		return usosDosElevadores;
	}

	public List<Character> elevadorMenosFrequentado() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();
		
		Map<Character, Integer> elevadores = new LinkedHashMap<Character, Integer>();

		for (UsoElevador uso : usos) {
			if (elevadores.containsKey(uso.getElevador())) {
				Integer quantAtual = elevadores.get(uso.getElevador());
				elevadores.put(uso.getElevador(), quantAtual + 1);
			} else {
				elevadores.put(uso.getElevador(), 1);
			}
		}

		Integer maxQtdUso = Integer.MAX_VALUE;
		for (Integer qtdUso : elevadores.values()) {
			if (qtdUso < maxQtdUso) {
				maxQtdUso = qtdUso;
			}
		}

		List<Character> elevadorMenosFrequentado = new ArrayList<>();
		for (Entry<Character, Integer> entry : elevadores.entrySet()) {
			if (entry.getValue().equals(maxQtdUso)) {
				elevadorMenosFrequentado.add(entry.getKey());
			}

		}

		return elevadorMenosFrequentado;
	}

	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		List<Character> elevadores = elevadorMenosFrequentado();
		List<Character> usosDosElevadores = new ArrayList<>();

		for (Character elevador : elevadores) {
			Map<Character, Integer> fluxo = new LinkedHashMap<>();

			for (UsoElevador turno : usos) {
				if (turno.getElevador().equals(elevador)) {
					if (fluxo.containsKey(turno.getTurno())) {
						int quantTurno = fluxo.get(turno.getTurno());
						fluxo.put(turno.getTurno(), quantTurno + 1);
					} else {
						fluxo.put(turno.getTurno(), 1);
					}
				}
			}

			Integer maiorFluxo = Integer.MAX_VALUE;
			for (Integer maiorFlx : fluxo.values()) {
				if (maiorFlx < maiorFluxo) {
					maiorFluxo = maiorFlx;
				}
			}
			for (Entry<Character, Integer> entry : fluxo.entrySet()) {
				if (entry.getValue().equals(maiorFluxo)) {
					usosDosElevadores.add(entry.getKey());

				}

			}

		}

		return usosDosElevadores;
	}

	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		Map<Character, Integer> turnos = new LinkedHashMap<>();

		for (UsoElevador elevador : usos) {
			if (turnos.containsKey(elevador.getTurno())) {
				int quantPeriodo = turnos.get(elevador.getTurno());
				turnos.put(elevador.getTurno(), quantPeriodo + 1);
			} else {
				turnos.put(elevador.getTurno(), 1);
			}

		}
		Integer maiorTurno = Integer.MIN_VALUE;
		for (Integer maiorFlx : turnos.values()) {
			if (maiorFlx > maiorTurno) {
				maiorTurno = maiorFlx;
			}
		}
		List<Character> maiorFluxoTurno = new ArrayList<>();
		for (Entry<Character, Integer> entry : turnos.entrySet()) {
			if (entry.getValue().equals(maiorTurno)) {
				maiorFluxoTurno.add(entry.getKey());
			}

		}

		return maiorFluxoTurno;
	}

	public float percentualDeUsoElevadorA() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		float quantDeElevadorA = 0f;
		for (UsoElevador elevador : usos) {
			if (elevador.getElevador().equals('A')) {
				quantDeElevadorA = quantDeElevadorA + 1;
			}
		}

		int quantElevador = usos.size();
		float percentualDeUsoElevadorA = (quantDeElevadorA / quantElevador) * 100;

		return percentualDeUsoElevadorA;
	}

	public float percentualDeUsoElevadorB() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		float quantDeElevadorB = 0f;
		for (UsoElevador elevador : usos) {
			if (elevador.getElevador().equals('B')) {
				quantDeElevadorB = quantDeElevadorB + 1;
			}
		}

		int quantElevador = usos.size();
		float percentualDeUsoElevadorB = (quantDeElevadorB / quantElevador) * 100;

		return percentualDeUsoElevadorB;
	}

	public float percentualDeUsoElevadorC() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		float quantDeElevadorC = 0f;
		for (UsoElevador elevador : usos) {
			if (elevador.getElevador().equals('C')) {
				quantDeElevadorC = quantDeElevadorC + 1;
			}
		}

		int quantElevador = usos.size();
		float percentualDeUsoElevadorC = (quantDeElevadorC / quantElevador) * 100;

		return percentualDeUsoElevadorC;
	}

	public float percentualDeUsoElevadorD() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		float quantDeElevadorD = 0f;
		for (UsoElevador elevador : usos) {
			if (elevador.getElevador().equals('D')) {
				quantDeElevadorD = quantDeElevadorD + 1;
			}
		}

		int quantElevador = usos.size();
		float percentualDeUsoElevadorD = (quantDeElevadorD / quantElevador) * 100;

		return percentualDeUsoElevadorD;
	}

	public float percentualDeUsoElevadorE() throws IOException {
		List<UsoElevador> usos = buscarUsoElevador();

		float quantDeElevadorE = 0f;
		for (UsoElevador elevador : usos) {
			if (elevador.getElevador().equals('E')) {
				quantDeElevadorE = quantDeElevadorE + 1;
			}
		}

		int quantElevador = usos.size();
		float percentualDeUsoElevadorE = (quantDeElevadorE / quantElevador) * 100;

		return percentualDeUsoElevadorE;
	}
}
