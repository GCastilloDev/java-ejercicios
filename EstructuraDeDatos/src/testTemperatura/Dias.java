package testTemperatura;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class Dias implements Comparable<Dias>{

    private String dia;
    private Integer semana;
    private Integer grados;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public Integer getGrados() {
        return grados;
    }

    public void setGrados(Integer grados) {
        this.grados = grados;
    }

    


    @Override
    public String toString() {
        return "El " + dia + " de la semana " + semana + " con " + grados + 
                " grados.";
    }  

    @Override
    public int compareTo(Dias o) {
        return grados.compareTo(o.getGrados());
    }
    
}
