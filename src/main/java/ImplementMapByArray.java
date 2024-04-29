public class ImplementMapByArray {

    int capacity = 1000000;
    int[] array = new int[capacity];

    void put(int key, int value){

        //assiging always +1 while returning value -1
        //other wise we have fill all values in array with default as -1
        array[key] = value+1;
    }
    int get(int key){

        return array[key] -1;
    }

    void remove(int key){

        //removing means we are removing actual value and assiging some artibarty value
        array[key] = 0;
    }
}
