package moduleNine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList <T> {
    private static final int SIZE = 8;
    Object [] data = new Object[SIZE];
    Integer index = 0;

    public void add(T a) {
        if (data.length == 0) {
            data = new Object[SIZE];
        }
        if(index == data.length) {
            int newSize = index * 2;
            Object [] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, index);
            data = newData;
        }
        data[index] = a;
        index++;
    }

    public void remove(T i) {
        Object [] beforeI = Arrays.copyOf(data, (Integer) i);
        Object [] afterI = new Object[data.length-1- beforeI.length];
        System.arraycopy(data,  (Integer)i+1, afterI,0,afterI.length);

        Object [] newData = new Object[afterI.length + beforeI.length];
        System.arraycopy(beforeI,0,newData,0,beforeI.length);
        System.arraycopy(afterI,0,newData,beforeI.length, afterI.length);
        data = newData;
        index--;
    }

    public int size(){
        return index;
    }

    public Object get(Integer index){
        return data[index];
    }

    public void clear(){
        data = new Object[0];
        index = 0;
    }

    @Override
    public String toString() {
        if (data.length == 0){
            return "[]";
        }

        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }
        return "[ " + result + " ]";
    }
}

