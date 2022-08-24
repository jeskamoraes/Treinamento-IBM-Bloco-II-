package com.br.jessica.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogicaApplication {

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(LogicaApplication.class, args);
		// System.out.println("Hello world");
		String nomes[] = new String[5];
		/*
		 * BufferedReader reader = new BufferedReader(
		 * new InputStreamReader(System.in));
		 */
		Scanner leitor = new Scanner(System.in);

		System.out.println("===== [ Programa que recebe 5 nomes e imprime ] =======");

		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Digite o " + (i + 1) + "º nome: ");
			nomes[i] = leitor.nextLine();
		}
		System.out.println("****************************");
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}

		/*
		 * System.out.println("Digite o seu nome:");
		 * String nome = reader.readLine();
		 */

		// SpringApplication.run(LogicaApplication.class, args);
		leitor.close();
	}

}
