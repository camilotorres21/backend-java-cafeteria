
public class Empleado {

    private String nombreUsuario;
    private String identificacion;
    private String cargo;
    private String contraseña;

    // Constructor
    public Empleado(String nombre, String identificacion, String cargo, String contraseña) {
        this.nombreUsuario = nombre;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.contraseña = contraseña;
    }

    // Getters
    public String getNombre() {
        return nombreUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombreUsuario = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setContraseña(String contraseñaAntigua, String contraseñaNueva) {
        if (this.contraseña.equals(contraseñaAntigua)) {
            this.contraseña = contraseñaNueva;
            System.out.println(nombreUsuario + " contraseña cambiada con éxito!" );
        } else {
            System.out.println("...Contraseña antigua incorrecta. No se pudo cambiar la contraseña...");
        }
    }
}
