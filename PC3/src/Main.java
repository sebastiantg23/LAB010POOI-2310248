import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente1 = new Paciente("Luis", 729323, "El Agustino, Mz M lt 22", 56, 34);
        Paciente paciente2 = new Paciente("Pedro", 9712994, "Los Olivos, Mz J lt 56", 77, 33);
        Paciente paciente3 = new Paciente("Andre", 903175, "Surco, Mz O lt 11", 66, 38);
        Paciente paciente4 = new Paciente("Alberto", 528492, "Chaclacayo, MZ A lt 16", 67, 35);
        Paciente paciente5 = new Paciente("Luisa", 6192846, "Rimac, MZ Ñ lt 67", 80, 35);
        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);
        pacientes.add(paciente4);
        pacientes.add(paciente5);

        List<Medico> doctores = new ArrayList<>();
        Medico medico1 = new Medico("Brandom", 291023, "Oftalmologia", pacientes);
        Medico medico2 = new Medico("Martha", 291023, "Gastro", pacientes);
        Medico medico3 = new Medico("Joaquin", 291023, "Dermatologia", pacientes);
        Medico medico4 = new Medico("Karen", 291023, "Cardiologia", pacientes);
        Medico medico5 = new Medico("Manuel", 291023, "Neurologia", pacientes);
        doctores.add(medico1);
        doctores.add(medico2);
        doctores.add(medico3);
        doctores.add(medico4);
        doctores.add(medico5);


        while (true) {
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
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    registrarPaciente(pacientes, scanner);
                    break;
                case 2:
                    eliminarPaciente(pacientes, scanner);
                    break;
                case 3:
                    modificarPaciente(pacientes, scanner);
                    break;
                case 4:
                    mostrarPesoMasRepetido(pacientes);
                    break;
                case 5:
                    mostrarCantidadPacientesPorPeso(pacientes, scanner);
                    break;
                case 6:
                    mostrarPesoMayorMenor(pacientes);
                    break;
                case 7:
                    dividirRangoPesos(pacientes);
                    break;
                case 8:
                    mostrarListaPacientesOrdenados(pacientes);
                    break;
                case 9:
                    indicarMedicoDePaciente(pacientes, doctores, scanner);
                    break;
                case 10:
                    buscarMedicosPorEspecialidad(doctores, scanner);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
    private static void registrarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.next();
        System.out.println("Ingrese el DNI del paciente:");
        int dni = scanner.nextInt();
        System.out.println("Ingrese la dirección del paciente:");
        String direccion = scanner.next();
        System.out.println("Ingrese el peso del paciente:");
        int peso = scanner.nextInt();
        System.out.println("Ingrese la temperatura del paciente:");
        int temperatura = scanner.nextInt();

        Paciente nuevoPaciente = new Paciente(nombre, dni, direccion, peso, temperatura);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
    }
    private static void eliminarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.println("Ingrese la posición del paciente a eliminar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente pacienteEliminado = pacientes.remove(posicion);
            System.out.println("Paciente eliminado: " + pacienteEliminado.getNombre());
        } else {
            System.out.println("Posición no válida. No se eliminó ningún paciente.");
        }
    }
    private static void modificarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.println("Ingrese la posición del paciente a modificar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente paciente = pacientes.get(posicion);

            System.out.println("Ingrese el nuevo peso:");
            int nuevoPeso = scanner.nextInt();
            System.out.println("Ingrese la nueva temperatura:");
            int nuevaTemperatura = scanner.nextInt();

            paciente.setPeso(nuevoPeso);
            paciente.setTemperatura(nuevaTemperatura);

            System.out.println("Datos del paciente modificados con éxito.");
        } else {
            System.out.println("Posición no válida. No se modificó ningún paciente.");
        }
    }
    private static void mostrarPesoMasRepetido(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            Map<Integer, Long> pesoFrecuencia = pacientes.stream()
                    .collect(Collectors.groupingBy(Paciente::getPeso, Collectors.counting()));

            int pesoMasRepetido = Collections.max(pesoFrecuencia.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("El peso más repetido es: " + pesoMasRepetido);
        }
    }
    private static void mostrarCantidadPacientesPorPeso(List<Paciente> pacientes, Scanner scanner) {
        System.out.println("Ingrese el peso a buscar:");
        int pesoBuscado  = scanner.nextInt();
        long cantidad = pacientes.stream().filter(p -> p.getPeso() == pesoBuscado).count();
        System.out.println("Cantidad de pacientes con peso " + pesoBuscado + ": " + cantidad);
    }
    private static void mostrarPesoMayorMenor(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            int pesoMayor = pacientes.stream().mapToInt(Paciente::getPeso).max().getAsInt();
            int pesoMenor = pacientes.stream().mapToInt(Paciente::getPeso).min().getAsInt();
            System.out.println("Peso mayor: " + pesoMayor);
            System.out.println("Peso menor: " + pesoMenor);
        }
    }
    private static void dividirRangoPesos(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            int pesoMinimo = pacientes.stream().mapToInt(Paciente::getPeso).min().getAsInt();
            int pesoMaximo = pacientes.stream().mapToInt(Paciente::getPeso).max().getAsInt();
            int rango = (pesoMaximo - pesoMinimo) / 4;

            for (int i = pesoMinimo; i <= pesoMaximo; i += rango) {
                int rangoInicio = i;
                int rangoFin = i + rango;
                long cantidadEnRango = pacientes.stream()
                        .filter(p -> p.getPeso() >= rangoInicio && p.getPeso() < rangoFin)
                        .count();
                System.out.println("Rango " + rangoInicio + " a " + rangoFin + ": " + cantidadEnRango + " pacientes");
            }
        }
    }
    private static void mostrarListaPacientesOrdenados(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            List<Paciente> pacientesOrdenados = new ArrayList<>(pacientes);
            pacientesOrdenados.sort(Comparator.comparing(Paciente::getNombre));

            for (Paciente paciente : pacientesOrdenados) {
                System.out.println("Nombre: " + paciente.getNombre() + ", Peso: " + paciente.getPeso());
            }
        }
    }
    private static void indicarMedicoDePaciente(List<Paciente> pacientes, List<Medico> doctores, Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = scanner.next();

        Optional<Paciente> paciente = pacientes.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombrePaciente)).findFirst();
        if (paciente.isPresent()) {
            Paciente pacienteEncontrado = paciente.get();
            Medico medicoAtendiente = pacienteEncontrado.getMedicoAtendiente();

            if (medicoAtendiente != null) {
                System.out.println("El paciente " + nombrePaciente + " fue atendido por el médico " + medicoAtendiente.getNombre());
            } else {
                System.out.println("No se encontró información del médico del paciente " + nombrePaciente);
            }
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }
    private static void buscarMedicosPorEspecialidad(List<Medico> doctores, Scanner scanner) {
        System.out.println("Ingrese la especialidad a buscar:");
        String especialidad = scanner.next();

        List<Medico> medicosEncontrados = doctores.stream()
                .filter(m -> m.getEspecialidad().equalsIgnoreCase(especialidad))
                .collect(Collectors.toList());

        if (!medicosEncontrados.isEmpty()) {
            System.out.println("Médicos encontrados con especialidad " + especialidad + ":");
            for (Medico medico : medicosEncontrados) {
                System.out.println("Nombre: " + medico.getNombre() + ", Nro. de Colegiatura: " + medico.getNroColegiatura());
            }
        } else {
            System.out.println("No hay medicos con especializados en  " + especialidad);
        }
    }
}


