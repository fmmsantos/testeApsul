package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

import model.Elevador;

public class Main {
	 public static void main(String[] args) throws IOException {

	        String json
	                = String.join(" ",
	                        Files.readAllLines(
	                                Paths.get("./input.json"),
	                                StandardCharsets.UTF_8)
	                );

	        Elevador elevador = new Gson().fromJson(json, Elevador.class);
	    }

}
