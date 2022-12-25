package beans;

public class Area {
    
    /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/
    private int id_area;
    private String descripcion;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Area() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Area(int id_area) {
        this.id_area = id_area;
    }

    /*Se crea un constructor exectuando la llave primaria*/
    public Area(String descripcion) {
        this.descripcion = descripcion;
    }

    /*Se crea un constructor que contenga todos los atributos declarados*/
    public Area(int id_area, String descripcion) {
        this.id_area = id_area;
        this.descripcion = descripcion;
    }

    /*Todos los javaBeans se componen de un metdo get y set, se tiene que crear ambos metodos para todos los atributos de la clase que hemos creado, que tienen o     tendran como finalidad, apoyarnos para interactuar con la base de datos (tablas*/
    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Area{" + "id_area=" + id_area + ", descripcion=" + descripcion + '}';
    }
    
    
    
}