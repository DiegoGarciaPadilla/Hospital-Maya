package beans;

public class Ingresos {
    
    /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/
    private int id_ingreso;
    private int id_paciente;
    private String fecha_ingreso;
    private String situacion;
    private int id_area;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Ingresos() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Ingresos(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    /*Se crea un constructor exectuando la llave primaria*/
    public Ingresos(int id_paciente, String fecha_ingreso, String situacion, int id_area) {
        this.id_paciente = id_paciente;
        this.fecha_ingreso = fecha_ingreso;
        this.situacion = situacion;
        this.id_area = id_area;
    }

    /*Se crea un constructor que contenga todos los atributos declarados*/
    public Ingresos(int id_ingreso, int id_paciente, String fecha_ingreso, String situacion, int id_area) {
        this.id_ingreso = id_ingreso;
        this.id_paciente = id_paciente;
        this.fecha_ingreso = fecha_ingreso;
        this.situacion = situacion;
        this.id_area = id_area;
    }

    /*Todos los javaBeans se componen de un metdo get y set, se tiene que crear ambos metodos para todos los atributos de la clase que hemos creado, que tienen o     tendran como finalidad, apoyarnos para interactuar con la base de datos (tablas*/
    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Ingresos{" + "id_ingreso=" + id_ingreso + ", id_paciente=" + id_paciente + ", fecha_ingreso=" + fecha_ingreso + ", situacion=" + situacion + ", id_area=" + id_area + '}';
    }
    
    
    
}