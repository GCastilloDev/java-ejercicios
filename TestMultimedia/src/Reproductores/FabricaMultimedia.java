package Reproductores;

import Interfaces.IMultimedia;


/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class FabricaMultimedia {
    
    public static IMultimedia getTipoReproductor(String tipo){
        
        //Tipo: Discman, grabadora o mediaplayer
        if(tipo != null){
            
            if(tipo.equalsIgnoreCase("discman")){
                return new Discman();
            }else if(tipo.equalsIgnoreCase("grabadora")){
                return new Grabadora();
            }else if(tipo.equalsIgnoreCase("mediaplayer")){
                return new WindowsMediaPlayer();
            }
        }
        
        return null;
    }
}
