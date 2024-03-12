import java.util.Random;

class Organismo {
    protected String nombre;
    protected int[] posicion;
    protected int salud;
    protected int edad;
    protected boolean estadoReproductivo;

    public Organismo(String nombre, int[] posicion, int salud, int edad, boolean estadoReproductivo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.salud = salud;
        this.edad = edad;
        this.estadoReproductivo = estadoReproductivo;
    }

    public void mover(int[] nuevaPosicion) {
        this.posicion = nuevaPosicion;
        System.out.println(this.nombre + " se ha movido a la posición (" + nuevaPosicion[0] + ", " + nuevaPosicion[1] + ").");
    }

    public void envejecer() {
        this.edad++;
        System.out.println(this.nombre + " ha envejecido. Edad: " + this.edad);
    }

    public Organismo reproducirse() {
        if (this.estadoReproductivo) {

            System.out.println(this.nombre + " se está reproduciendo.");
            Organismo nuevoOrganismo = new Organismo(this.nombre, this.posicion, 100, 0, true);
            return nuevoOrganismo;
        }
        return null;
    }

    public void recibirDanio(int cantidad) {
        this.salud -= cantidad;
        if (this.salud <= 0) {
            System.out.println(this.nombre + " ha muerto.");
        } else {
            System.out.println(this.nombre + " ha recibido daño. Salud actual: " + this.salud);
        }
    }

    public int[] getPosicion() {
        return this.posicion;
    }

    public int getSalud() {
        return this.salud;
    }
}

class Planta extends Organismo {
    public Planta(String nombre, int[] posicion, int salud, int edad, boolean estadoReproductivo) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
    }

    public void polinizar() {

        System.out.println(this.nombre + " está siendo polinizada.");
    }
}

class Animal extends Organismo {
    public Animal(String nombre, int[] posicion, int salud, int edad, boolean estadoReproductivo) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
    }

    public void cazar(Organismo organismo) {

        System.out.println(this.nombre + " está cazando a " + organismo.nombre + ".");
        organismo.recibirDanio(20); // El organismo cazado pierde salud
    }
}

class Ambiente {
    private String clima;
    private String terreno;
    private String[] recursos;
    private Random random;

    public Ambiente(String clima, String terreno, String[] recursos) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursos = recursos;
        this.random = new Random();
    }

    public void competirPorRecursos(Organismo organismo) {

        System.out.println(organismo.nombre + " está compitiendo por recursos en el ambiente.");
    }

    public void eventoAleatorio() {

        int probabilidadEvento = random.nextInt(100);
        if (probabilidadEvento < 20) {
            System.out.println("¡Ha ocurrido un desastre natural!");

        } else if (probabilidadEvento < 40) {
            System.out.println("¡Hay un brote de enfermedad!");

        } else if (probabilidadEvento < 60) {
            System.out.println("¡Ha cambiado el clima!");

        }
    }

    public void estadisticasPoblacionales(Organismo[] poblacion) {

        int totalSalud = 0;
        for (Organismo organismo : poblacion) {
            totalSalud += organismo.getSalud();
        }
        double saludPromedio = totalSalud / poblacion.length;
        System.out.println("Salud promedio del ecosistema: " + saludPromedio);
    }
}

public class Main {
    public static void main(String[] args) {
        Planta planta1 = new Planta("Rosa", new int[]{10, 20}, 100, 0, true);
        Animal animal1 = new Animal("León", new int[]{50, 60}, 100, 0, true);
        String[] recursos = {"Agua", "Sol"};
        Ambiente ambiente = new Ambiente("Templado", "Pradera", recursos);

        Organismo[] poblacion = {planta1, animal1};

        planta1.mover(new int[]{15, 25});
        planta1.envejecer();
        Organismo nuevaPlanta = planta1.reproducirse();
        if (nuevaPlanta != null) {

            Organismo[] nuevaPoblacion = new Organismo[poblacion.length + 1];
            System.arraycopy(poblacion, 0, nuevaPoblacion, 0, poblacion.length);
            nuevaPoblacion[poblacion.length] = nuevaPlanta;
            poblacion = nuevaPoblacion;
        }

        animal1.mover(new int[]{55, 65});
        animal1.envejecer();
        animal1.reproducirse();

        ambiente.competirPorRecursos(planta1);

        ambiente.eventoAleatorio();
        ambiente.estadisticasPoblacionales(poblacion);
    }
}
