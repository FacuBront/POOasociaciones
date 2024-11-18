package gestionnotas;

import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.println("Ingrese la cantidad de alumnos a cargar:");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre completo del alumno " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el legajo del alumno " + (i + 1) + ":");
            long legajo = scanner.nextLong();
            scanner.nextLine();

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.println("Ingrese la cantidad de notas para " + nombre + ":");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la cátedra de la nota " + (j + 1) + ":");
                String catedra = scanner.nextLine();

                System.out.println("Ingrese la nota del examen de " + catedra + ":");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine();

                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);
            }

            alumnos.add(alumno);
        }

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            for (Nota nota : alumno.getNotas()) {
                System.out.println("  " + nota);
            }
            System.out.printf("Promedio: %.2f\n", alumno.calcularPromedio());
        }

        scanner.close();
    }
}
