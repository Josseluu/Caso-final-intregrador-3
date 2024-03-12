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

    public void reproducirse() {
        if (this.estadoReproductivo) {
            // Lógica para la reproducción
            System.out.println(this.nombre + " se está reproduciendo.");
        }
    }

    public void recibirDanio(int cantidad) {
        this.salud -= cantidad;
        if (this.salud <= 0) {
            System.out.println(this.nombre + " ha muerto.");
        } else {
            System.out.println(this.nombre + " ha recibido daño. Salud actual: " + this.salud);
        }
    }
}

class Planta extends Organismo {
    public Planta(String nombre, int[] posicion, int salud, int edad, boolean estadoReproductivo) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
    }

    public void polinizar() {
        // Lógica para la polinización
        System.out.println(this.nombre + " está siendo polinizada.");
    }
}

class Animal extends Organismo {
    public Animal(String nombre, int[] posicion, int salud, int edad, boolean estadoReproductivo) {
        super(nombre, posicion, salud, edad, estadoReproductivo);
    }

    public void cazar(Organismo organismo) {
        // Lógica para la caza
        System.out.println(this.nombre + " está cazando a " + organismo.nombre + ".");
    }
}

class Ambiente {
    private String clima;
    private String terreno;
    private String[] recursos;

    public Ambiente(String clima, String terreno, String[] recursos) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursos = recursos;
    }

    public void competirPorRecursos(Organismo organismo) {

        System.out.println(organismo.nombre + " está compitiendo por recursos en el ambiente.");
    }
}

public class Main {
    public static void main(String[] args) {
        Planta planta1 = new Planta("Rosa", new int[]{10, 20}, 100, 0, true);
        Animal animal1 = new Animal("León", new int[]{50, 60}, 100, 0, true);
        String[] recursos = {"Agua", "Sol"};
        Ambiente ambiente = new Ambiente("Templado", "Pradera", recursos);

        planta1.mover(new int[]{15, 25});
        planta1.envejecer();
        planta1.reproducirse();
        planta1.polinizar();

        animal1.mover(new int[]{55, 65});
        animal1.envejecer();
        animal1.reproducirse();
        animal1.cazar(planta1);

        ambiente.competirPorRecursos(planta1);
    }
}
