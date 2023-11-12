import java.awt.*;
import java.util.List;

public class Paciente extends Persona {
    private int DNI;
    private String direccion;
    private int peso;
    private int temperatura;
    private Medico medicoAsignado;

    public Paciente(String nombre, int DNI, String direccion, int peso, int temperatura) {
        super(nombre);
        this.DNI = DNI;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }


    public Medico getMedicoAtendiente() {
        return medicoAsignado;
    }
}
