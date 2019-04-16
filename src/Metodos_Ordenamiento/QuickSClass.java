package Metodos_Ordenamiento;



public class QuickSClass {
    private int array[];
    private int length;
    private int contEO=0;
    private int contMovimientos=0;
    private int contComparaciones=0;

    public int getContEO() {
        return contEO;
    }

    public int getContMovimientos() {
        return contMovimientos;
    }

    public void setContMovimientos(int contMovimientos) {
        this.contMovimientos = contMovimientos;
    }

    public int getContComparaciones() {
        return contComparaciones;
    }

    public void setContComparaciones(int contComparaciones) {
        this.contComparaciones = contComparaciones;
    }
 
    
    
    public long sort(int[] inputArr) {
        long tiempoinicio=System.currentTimeMillis();
        this.array = inputArr;
        this.contEO++;
        length = inputArr.length;
        this.contEO++;
        quickSort(0, length - 1);
        long tiempofinal=System.currentTimeMillis();
         return(tiempofinal-tiempoinicio)/1000;
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        this.contEO++;
        int j = higherIndex;
        this.contEO++;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        this.contEO+=5;
        // Divide into two arrays
        while (i <= j) {
            this.contEO++;
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                this.contComparaciones++;
                this.contEO+=2;
                i++;
                this.contEO+=2;
            }
            while (array[j] > pivot) {
                this.contComparaciones++;
                this.contEO+=2;
                j--;
                this.contEO+=2;
            }
            if (i <= j) {
                this.contEO++;
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                this.contEO+=2;
                j--;
                this.contEO+=2;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j){
            this.contEO++;
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex){
            this.contEO++;
            quickSort(i, higherIndex);
        }
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        this.contEO+=2;
        array[i] = array[j];
        this.contEO+=2;
        array[j] = temp;
        this.contEO+=2;
        this.contMovimientos+=2;
    }
}
