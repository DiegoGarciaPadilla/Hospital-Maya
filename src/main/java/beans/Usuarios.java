package beans;

public class Usuarios {
    
    /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/
    private int id_usuario;
    private String usuario;
    private String password;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Usuarios() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Usuarios(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /*Se crea un constructor exectuando la llave primaria*/
    public Usuarios(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    /*Se crea un constructor que contenga todos los atributos declarados*/
    public Usuarios(int id_usuario, String usuario, String password) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
    }

    /*Todos los javaBeans se componen de un metdo get y set, se tiene que crear ambos metodos para todos los atributos de la clase que hemos creado, que tienen o     tendran como finalidad, apoyarnos para interactuar con la base de datos (tablas*/
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Usuarios{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}