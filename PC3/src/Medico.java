import java.util.List;

public class Medico extends Persona{
    private int nroColegiatura;
    private String especialidad;
    private List<String> medicos;

    public Medico(String nombre, int nroColegiatura, String especialidad) {
        super(nombre);
        this.nroColegiatura = nroColegiatura;
        this.especialidad = especialidad;
    }

    public int getNroColegiatura() {
        return nroColegiatura;
    }

    public void setNroColegiatura(int nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
