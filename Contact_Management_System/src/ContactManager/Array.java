package ContactManager;

public class Array {
    private Object []arr;
    private int count;

    public Array (int size){
        arr = new Object[size];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(Object data){
        try {
            arr[count] = data;
            count++;
        }catch (Exception e){
            System.out.println("Data full!");
        }
    }

    public Object get(int index){
        if(index >= 0 && index < count){
            return arr[index];
        }
        return null;
    }

    public Boolean isEmpty(){
        return count == 0;
    }

    public void delete(int index){
        if(index>=0 && index<count){
            for(int i=index; i<count; i++){
                arr[i] = arr[i+1];
            }
            count--;
        }else {
            System.out.println("Array index not found!");
        }
    }

    public void edit(int index, Object data){
        if(index >= 0 && index < count){
            arr[index] = data;
        }else {
            System.out.println("Array index not found!");
        }
    }
}
