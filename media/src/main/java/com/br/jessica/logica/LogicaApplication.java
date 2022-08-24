package com.br.jessica.logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.jessica.models.Student;

@SpringBootApplication
public class LogicaApplication {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static List<Student> students = new ArrayList<>();

	public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {
		
		while (true) {
			clearScreen();

			System.out.println("---------- CADASTRO DE ALUNOS ----------");
			System.out.println("Digite um número de acordo com a opção desejada: ");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Exibir relatório");
			System.out.println("3 - Sair");

			int option = 0;

			try {
				option = Integer.parseInt(reader.readLine());
			} catch (Exception e) { }

			clearScreen();

			var exit = false;

			switch (option) {
				case 1:
					registerStudent();
					break;
				case 2:
					showStudents();
					break;
				case 3:
					exit = true;
					break;
				default:
					invalidOption();
					break;
			}
			if (exit) break;
		}
	}

	private static void invalidOption() throws InterruptedException {
		message("Opção inválida!");
	}

	private static void showStudents() throws InterruptedException {
		if(students.size() == 0){
			message("Nenhum aluno cadastrado!");
			return;
		}
		
		System.out.println("------ Relatório de alunos ------");
		for(Student student: students) {
			System.out.println("Nome: " + student.getNome());
			String notes = "";
			for(float note: student.getNotas()) {
				notes += note + ", ";
			}

			System.out.println("Notas: " + notes);
			System.out.println("Média: " + student.media());
			System.out.println("Situação: " + student.situacao());
			System.out.println("-------------------------------");
		}
		time(8);
		clearScreen();
	}

	private static void registerStudent() throws InterruptedException, NumberFormatException, IOException {
		var student = new Student();
		System.out.println("Digite o nome do aluno: ");
		student.setNome(reader.readLine());

		captureStudentGrades(student);

		students.add(student);

		message("Aluno cadastrado com sucesso!");
	}

	private static void captureStudentGrades(Student student) throws NumberFormatException, IOException, InterruptedException {
		System.out.println("Digite a nota do(a) " + student.getNome());
		if(student.getNotas() == null) student.setNotas(new ArrayList<Float>());

		try{
			student.getNotas().add(Float.parseFloat(reader.readLine()));
		}
		catch(Exception e){
			message("Nota inválida");
			captureStudentGrades(student);
		}

		try{
			System.out.println("Digite 1 para cadastrar mais notas ou 0 para finalizar o cadastro");
			int opcao = Integer.parseInt(reader.readLine());
			if(opcao == 1) captureStudentGrades(student);
			return;
		}
		catch(Exception e) {
			message("Opção inválida! ...Iniciando novo cadastro de nota");
			captureStudentGrades(student);
		}
	}

	private static void message(String string) throws InterruptedException {
		clearScreen();
		System.out.println(string);
		time(2);
		clearScreen();
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void time(int secconds) throws InterruptedException {
		Thread.sleep(secconds*1000);
	}

}
