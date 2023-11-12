import java.util.List;

public class Medico extends Persona{
    private int nroColegiatura;
    private String especialidad;
    private List<Paciente> pacientesTratados;

    public Medico(String nombre, int nroColegiatura, String especialidad, List<Paciente> pacientesTratados) {
        super(nombre);
        this.nroColegiatura = nroColegiatura;
        this.especialidad = especialidad;
        this.pacientesTratados = pacientesTratados;
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

    public void registrarPaciente(Paciente paciente){
        pacientesTratados.add(paciente);
    }
    public void eliminarPaciente(Paciente paciente) {
        pacientesTratados.remove(paciente);
    }
    public void modificarDatosPaciente(Paciente paciente, int nuevoPeso, int nuevaTemperatura) {
        paciente.setPeso(nuevoPeso);
        paciente.setTemperatura(nuevaTemperatura);
    }

}
