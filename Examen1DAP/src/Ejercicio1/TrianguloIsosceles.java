/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author alejandro
 */
public class TrianguloIsosceles {
    float lado;
    float base;
    float area;
    float peri;
    public TrianguloIsosceles(){
    }
   
    public void AreaTriangulo(float lado, float base){
    
    float  i=((2*lado)+base)/2;
       area= (float)Math.pow(i, 0.5);
       System.out.println("Area: "+area);
    }
    public void PeriTriangulo(float lado,float base){
     
        peri=(2*lado)+base;
        System.out.println("Perimetro: "+peri); 
    }
}
