package beans;

public class Medicos {
    
    /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/
    private int matricula;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String domicilio;
    private String especialidad;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Medicos() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Medicos(int matricula) {
        this.matricula = matricula;
    }

    /*Se crea un constructor exectuando la llave primaria*/
    public Medicos(String nombre, String apellidoP, String apellidoM, String telefono, String domicilio, String especialidad) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.especialidad = especialidad;
    }

    /*Se crea un contructor que contenga todos los atributos declarados*/
    public Medicos(int matricula, String nombre, String apellidoP, String apellidoM, String telefono, String domicilio, String especialidad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.especialidad = especialidad;
    }

    /*Todos los javaBeans se componen de un metdo get y set, se tiene que crear ambos metodos para todos los atributos de la clase que hemos creado, que tienen o     tendran como finalidad, apoyarnos para interactuar con la base de datos (tablas*/
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Medicos{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", telefono=" + telefono + ", domicilio=" + domicilio + ", especialidad=" + especialidad + '}';
    }
    
    
    
}