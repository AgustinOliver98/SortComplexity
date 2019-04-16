package Metodos_Ordenamiento;



public class MergeClass {
     
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private int contEO=0;
    private int contMovimientos=0;
    private int contComparaciones=0;
     
    public double sort(int inputArr[]) {
        long tiempoinicio=System.currentTimeMillis();
        this.array = inputArr;
        this.contEO++;
        this.length = inputArr.length;
        this.contEO++;
        this.tempMergArr = new int[length];
        this.contEO+=2;
        doMergeSort(0, length - 1);
        long tiempofinal=System.currentTimeMillis();
        return(tiempofinal-tiempoinicio)/1000.0;
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            this.contEO++;
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            this.contEO+=4;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            this.contEO+=4;
            tempMergArr[i] = array[i];
            this.contEO+=3;
        }
        int i = lowerIndex;
        this.contEO++;
        int j = middle + 1;
        this.contEO+=2;
        int k = lowerIndex;
        this.contEO++;
        while (i <= middle && j <= higherIndex) {
            this.contEO+=3;
            if (tempMergArr[i] <= tempMergArr[j]) {
                this.contComparaciones++;
                this.contEO+=3;
                array[k] = tempMergArr[i];
                this.contMovimientos++;
                this.contEO+=3;
                i++;
                this.contEO+=2;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
            this.contEO+=2;
        }
        while (i <= middle) {
            this.contEO++;
            array[k] = tempMergArr[i];
            this.contMovimientos++;
            this.contEO+=3;
            k++;
            this.contEO+=2;
            i++;
            this.contEO+=2;
        }
 
    }

    public int getContEO() {
        return contEO;
    }

    public int[] getArray() {
        return array;
    }

    public int getContMovimientos() {
        return contMovimientos;
    }

    public int getContComparaciones() {
        return contComparaciones;
    }
    
    

}
