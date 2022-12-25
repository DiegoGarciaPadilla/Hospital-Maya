package beans;

public class Paciente_Medico {
 
    /*Se declaran los atributos privados porque eso indican las reglas de los javaBean*/   
    private int id_paciente_medico;
    private int id_paciente;
    private int matricula;

    /*Se crea un constructor vacio, ya que asi lo indican las reglas (vacio quiere decir que no contendra ningun atributo de los que fueron declarados)*/
    public Paciente_Medico() {
    }

    /*Se crea un constructor solo con el atributo id, ya que cuando realizemos una BUSQUEDA este determinado constructor es de utilidad*/
    public Paciente_Medico(int id_paciente_medico) {
        this.id_paciente_medico = id_paciente_medico;
    }

    
    public Paciente_Medico(int id_paciente, int matricula) {
        this.id_paciente = id_paciente;
        this.matricula = matricula;
    }

    /*Se crea un constructor que contenga todos los atributos declarados*/
    public Paciente_Medico(int id_paciente_medico, int id_paciente, int matricula) {
        this.id_paciente_medico = id_paciente_medico;
        this.id_paciente = id_paciente;
        this.matricula = matricula;
    }

    public int getId_paciente_medico() {
        return id_paciente_medico;
    }

    public void setId_paciente_medico(int id_paciente_medico) {
        this.id_paciente_medico = id_paciente_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /*Se genera el metodo String para todos los atributos, este metodo trae consigo un @Override que quiere decir que el metodo puede sobre escribirse*/
    @Override
    public String toString() {
        return "Paciente_Medico{" + "id_paciente_medico=" + id_paciente_medico + ", id_paciente=" + id_paciente + ", matricula=" + matricula + '}';
    }
    
}