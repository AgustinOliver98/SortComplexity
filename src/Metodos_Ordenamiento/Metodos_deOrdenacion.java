/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_Ordenamiento;

/**
 *
 * @author PC
 */

//Agustin: como no puedo retornar mas de una variable, hay que llamar a los metodos getter de los atributos de clase antes de volver 
//a usar un metodo de ordenamiento (porque cada metodo resetea los valores)

public class Metodos_deOrdenacion {
    private int contEO=0;
    private int contComparaciones=0;
    private int contMovimientos=0;
    
    public double bubbleSort(int[] v){
        long tiempoinicio=System.currentTimeMillis();
        this.contEO=0;
        this.contComparaciones=0;
        this.contMovimientos=0;
        int[] arr=v;
        this.contEO++;
        int temp=0;
        this.contEO++;
        for(int i=0; i<arr.length; i++){
            this.contEO+=3;
            for(int j=1; j<arr.length-1; j++){
                this.contEO+=3;
                if(arr[j-1] > arr[j]){  
                    this.contEO+=3;
                    this.contComparaciones++;
                    temp = arr[j-1];  
                    this.contEO+=3;
                    arr[j-1] = arr[j];  
                    this.contEO+=4;
                    arr[j] = temp;  
                    this.contEO+=2;
                    this.contMovimientos++;
                }  
            }
        }
        /*for(int k=0;k<arr.length;k++){
            System.out.println(arr[k]);
        }*/
        long tiempofinal=System.currentTimeMillis();
        
        return(tiempofinal-tiempoinicio)/1000.0;
    }
    
    public double selectionSort(int[] arr){
        long tiempoinicio=System.currentTimeMillis();
        this.contEO=0;
        this.contComparaciones=0;
        this.contMovimientos=0;
        for (int i = 0; i < arr.length - 1; i++){
            this.contEO+=4;
            int index = i;
            this.contEO++;
            this.contEO+=2;
            for (int j = i + 1; j < arr.length; j++){
                this.contEO+=3;
                if (arr[j] < arr[index]){
                    this.contComparaciones++;
                    this.contEO+=3;
                    index = j;
                    this.contEO++;
                }
            }
      
            int smallerNumber = arr[index];  
            this.contEO+=2;
            arr[index] = arr[i];
            this.contEO+=3;
            arr[i] = smallerNumber;
            this.contEO+=2;
            this.contMovimientos+=2;
        }
        /*for(int k=0;k<arr.length;k++){
            System.out.println(arr[k]);
        }*/
        long tiempofinal=System.currentTimeMillis();
        return(tiempofinal-tiempoinicio)/1000.0;
        
    }
    
    public double insertionSort(int[] v){
        long tiempoinicio=System.currentTimeMillis();
        this.contEO=0;
        this.contComparaciones=0;
        this.contMovimientos=0;
        int[] input=v;
        this.contEO++;
        int temp;
        this.contEO++;
        for (int i = 1; i < input.length; i++) {
                this.contEO+=3;
            for(int j = i ; j > 0 ; j--) {
                this.contEO+=4;
                if(input[j] < input[j-1]) {
                    this.contComparaciones++;
                    this.contEO+=4;
                    temp = input[j];
                    this.contEO+=2;
                    input[j] = input[j-1];
                    this.contEO+=4;
                    input[j-1] = temp;
                    this.contEO+=2;
                    this.contMovimientos+=2;
                }
            }
        }
        /*for(int k=0;k<input.length;k++){
            System.out.println(input[k]);
        }*/
        long tiempofinal=System.currentTimeMillis();
         return(tiempofinal-tiempoinicio)/1000.0;
    }
    
    public double shellSort(int[] v){
        long tiempoinicio=System.currentTimeMillis();
        this.contEO=0;
        this.contComparaciones=0;
        this.contMovimientos=0;
        int[] array=v;
        int inner, outer;
        int temp;
        int h = 1;
        this.contEO++;
        while (h <= array.length / 3) {
            this.contEO+=2;
            h = h * 3 + 1;
            this.contEO+=3;
        }
        while (h > 0) {
            this.contEO++;
            for (outer = h; outer < array.length; outer++) {
                this.contEO+=4;
                temp = array[outer];
                this.contEO+=2;
                inner = outer;
                this.contEO++;
 
                while (inner > h - 1 && array[inner - h] >= temp) {
                    this.contComparaciones++;
                    this.contEO+=6;
                    array[inner] = array[inner - h];
                    this.contMovimientos++;
                    this.contEO+=4;
                    inner -= h;
                    this.contEO+=2;
                }
            array[inner] = temp;
            this.contMovimientos++;
            this.contEO+=2;
            }
            h = (h - 1) / 3;
            this.contEO+=3;
        }
       /* for(int k=0;k<array.length;k++){
            System.out.println(array[k]);
        }*/
        long tiempofinal=System.currentTimeMillis();
         return(tiempofinal-tiempoinicio)/1000.0;
    }

    public int getContEO() {
        return contEO;
    }

    public int getContComparaciones() {
        return contComparaciones;
    }

    public int getContMovimientos() {
        return contMovimientos;
    }
    
    
    
}
