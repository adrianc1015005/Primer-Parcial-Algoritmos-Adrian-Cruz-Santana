import java.time.LocalTime;

public class PrintJob {
    private String nombre;
    private LocalTime horaDeEnvio;
    private Prioridad prioridad;

    public PrintJob(String nombre, LocalTime horaDeEnvio, Prioridad prioridad) {
        this.nombre = nombre;
        this.horaDeEnvio = horaDeEnvio;
        this.prioridad = Prioridad.MEDIA;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHoraDeEnvio() {
        return horaDeEnvio;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoraDeEnvio(LocalTime horaDeEnvio) {
        this.horaDeEnvio = horaDeEnvio;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
}
