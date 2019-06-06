/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.SisTurmas;

import br.ufsc.ine5605.SisTurmas.Turma;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author 11832332993
 */
public class Controle {

    private Scanner teclado;
    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;

    public Controle() {
        teclado = new Scanner(System.in);
        turmas = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    public void inicia() {
        int opcao;

        do {
            System.out.println("--------- SISTURMAS ---------");
            System.out.println("1 - Incluir Turmas");
            System.out.println("2 - Incluir Alunos");
            System.out.println("3 - Listar Turmas");
            System.out.println("4 - Listar Alunos");
            System.out.println("5 - Matricular na Turma");
            System.out.println("0 - Encerra Sistema");
            System.out.println("-----------------------------");

            System.out.println("opcao: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    incluiTurma();
                    break;
                case 2:
                    incluiAluno();
                    break;
                case 3:
                    listaTurmas();
                    break;
                case 4:
                    listaAluno();
                    break;
                case 5:
                    matriculaAluno();
                    break;

            }
        } while (opcao != 0);
    }

    private void incluiTurma() {
        System.out.println("--------- INSERINDO TURMA ---------");
        System.out.println("Codigo: ");
        String codigoTurma = teclado.nextLine();
        Turma turma = new Turma(codigoTurma);
        turmas.add(turma);
    }

    private void incluiAluno() {
        System.out.println("--------- INSERINDO ALUNO ---------");
        System.out.println("Codigo: ");
        String matriculaAluno = teclado.nextLine();
        Aluno aluno = new Aluno(matriculaAluno);
        alunos.add(aluno);
    }

    private void listaTurmas() {
        System.out.println("--------- LISTANDO TURMAS ---------");

        for (Turma turma : turmas) {
            System.out.println("Turma: " + turma.getCodigo());
            System.out.println("Alunos da turma:");
            for (Aluno aluno : turma.getAlunos()) {
                System.out.println("Aluno: " + aluno.getMatricula());
            }

        }
    }

    private void listaAluno() {
    }

    private void matriculaAluno() {
        System.out.println("--------- MATRICULANDO NA TURMA ---------");
        //Pede matricula e codigo da turma para o usuario

        System.out.println("Entre com a matricula do aluno:");
        String matricula = teclado.nextLine();

        System.out.println("Entre com o codigo da turma:");
        String codigoTurma = teclado.nextLine();

        //Busca Aluno e Turma pelos dados informados
        Turma turmaEncontrada = buscaTurmaPeloCodigo(codigoTurma);

        Aluno alunoEncontrado = buscaAlunoPelaMatricula(matricula);

        //Matricula o aluno encontrado na turma encontrada
        if (alunoEncontrado != null && turmaEncontrada != null) {
            turmaEncontrada.addAluno(alunoEncontrado);
            alunoEncontrado.addTurma(turmaEncontrada);
        }

    }

    private Turma buscaTurmaPeloCodigo(String codigoTurma) {

        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                Turma turmaEncontrada = turma;
                return turma;
            }
        }
        return null;
    }

    private Aluno buscaAlunoPelaMatricula(String matricula) {

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                Aluno alunoEncontrado = aluno;
                return aluno;
            }
        }
        return null;
    }

}
