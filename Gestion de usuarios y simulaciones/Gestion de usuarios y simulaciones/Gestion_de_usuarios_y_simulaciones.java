import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gestion_de_usuarios_y_simulaciones {

    private static final Map<String, String> usuariosRegistrados = new HashMap<>();
    private static final Map<String, String> actividadesRegistradas = new HashMap<>();

    public static void main(String[] args) {

        usuariosRegistrados.put("investigador1", "contrasena1");
        usuariosRegistrados.put("investigador2", "contrasena2");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        if (autenticar(usuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");


            while (true) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Iniciar simulación");
                System.out.println("2. Ver registros de actividades");
                System.out.println("3. Salir");
                System.out.print("Ingrese su opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        iniciarSimulacion(usuario);
                        break;
                    case 2:
                        verRegistrosActividades();
                        break;
                    case 3:
                        System.out.println("Sesión finalizada.");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } else {
            System.out.println("Credenciales incorrectas. Inicio de sesión fallido.");
        }
    }

    private static boolean autenticar(String usuario, String contrasena) {
        return usuariosRegistrados.containsKey(usuario) && usuariosRegistrados.get(usuario).equals(contrasena);
    }

    private static void iniciarSimulacion(String usuario) {
        System.out.println("Simulación iniciada por " + usuario);
        registrarActividad(usuario, "Inició una simulación");
    }

    private static void verRegistrosActividades() {
        if (actividadesRegistradas.isEmpty()) {
            System.out.println("No hay registros de actividades.");
        } else {
            System.out.println("--- Registros de Actividades ---");
            for (Map.Entry<String, String> entry : actividadesRegistradas.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static void registrarActividad(String usuario, String actividad) {
        actividadesRegistradas.put(usuario, actividad);
    }
}
