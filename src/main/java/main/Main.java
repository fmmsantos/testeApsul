package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

import src.main.java.model.UsoElevador;

public class Main {
	public static void main(String[] args) {

		// --- convertendo para json --- //
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("input.json"));
		UsoElevador[] cliente = gson.fromJson(br, UsoElevador[].class);

		// --- exibindo json --- //
		for (UsoElevador uso : lista) {
			System.out.println(uso);
		}

	}
}
