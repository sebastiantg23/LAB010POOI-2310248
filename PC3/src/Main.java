import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Paciente paciente1 = new Paciente("Luis", 729323, "El Agustino, Mz M lt 22", 56, 34);
        Paciente paciente2 = new Paciente("Pedro", 9712994, "Los Olivos, Mz J lt 56", 77, 33);
        Paciente paciente3 = new Paciente("Andre", 903175, "Surco, Mz O lt 11", 66, 38);
        Paciente paciente4 = new Paciente("Alberto", 528492, "Chaclacayo, MZ A lt 16", 67, 35);
        Paciente paciente5 = new Paciente("Luisa", 6192846, "Rimac, MZ Ñ lt 67", 80, 35);

        Medico medico1 = new Medico("Brandom", 291023, "Oftalmologia");
        Medico medico2 = new Medico("Martha", 291023, "Gastro");
        Medico medico3 = new Medico("Joaquin", 291023, "Dermatologia");
        Medico medico4 = new Medico("Karen", 291023, "Cardiologia");
        Medico medico5 = new Medico("Manuel", 291023, "Neurologia");

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);
        pacientes.add(paciente4);
        pacientes.add(paciente5);

        List<Medico> doctores = new ArrayList<>();
        doctores.add(medico1);
        doctores.add(medico2);
        doctores.add(medico3);
        doctores.add(medico4);
        doctores.add(medico5);

        int opcion;

        do {
            System.out.println("=== Menú ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Modificar paciente");
            System.out.println("4. Mostrar peso más repetido");
            System.out.println("5. Mostrar cantidad de pacientes con peso repetido");
            System.out.println("6. Mostrar peso mayor y menor");
            System.out.println("7. Dividir rango de pesos");
            System.out.println("8. Mostrar pacientes ordenados por apellidos");
            System.out.println("9. Buscar doctor de paciente");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Operación 1: Registrar paciente
                    
                    break;
                case 2:
                    // Operación 2: Eliminar paciente
                    break;
                case 3:
                    // Operación 3: Modificar paciente
                    break;
                case 4:
                    // Operación 4: Mostrar peso más repetido
                    break;
                case 5:
                    // Operación 5: Mostrar cantidad de pacientes con peso repetido
                    break;
                case 6:
                    // Operación 6: Mostrar peso mayor y menor
                    break;
                case 7:
                    // Operación 7: Dividir rango de pesos
                    break;
                case 8:
                    // Operación 8: Mostrar pacientes ordenados por apellidos
                    break;
                case 9:
                    // Operación 9: Buscar doctor de paciente
                    break;
                case 10:
                    // Operación 10: Buscar doctores por especialidad
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}

