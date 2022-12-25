package beans;

public class Pacientes {
    
   /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/
    private int id_paciente;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String domicilio;
    private int edad;
    private String sexo;
    private String estado;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Pacientes() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Pacientes(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    /*Se crea un constructor exectuando la llave primaria*/
    public Pacientes(String nombre, String apellidoP, String apellidoM, String telefono, String domicilio, int edad, String sexo, String estado) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.edad = edad;
        this.sexo = sexo;
        this.estado = estado;
    }

    /*Se crea un constructor que contenga todos los atributos declarados*/
    public Pacientes(int id_paciente, String nombre, String apellidoP, String apellidoM, String telefono, String domicilio, int edad, String sexo, String estado) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.edad = edad;
        this.sexo = sexo;
        this.estado = estado;
    }


    /*Todos los javaBeans se componen de un metdo get y set, se tiene que crear ambos metodos para todos los atributos de la clase que hemos creado, que tienen o     tendran como finalidad, apoyarnos para interactuar con la base de datos (tablas*/
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Pacientes{" + "id_paciente=" + id_paciente + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", telefono=" + telefono + ", domicilio=" + domicilio + ", edad=" + edad + ", sexo=" + sexo + ", estado=" + estado + '}';
    }
    
}