package testteatro;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
class Teatro {
    
    private String nombreTeatro;
    private String direccionTeatro;
    public static Teatro teatro;
    

    private Teatro() {
    }

    
    public String getNombreTeatro() {
        return nombreTeatro;
    }

    public void setNombreTeatro(String nombreTeatro) {
        this.nombreTeatro = nombreTeatro;
    }

    public String getDireccionTeatro() {
        return direccionTeatro;
    }

    public void setDireccionTeatro(String direccionTeatro) {
        this.direccionTeatro = direccionTeatro;
    }
    
    public static Teatro getTeatro(){
        if( teatro == null){
            return teatro = new Teatro();
        }
        return teatro;
    }
    
}
