package a.aa;

public class MyArrayList {

    /*The value is uesed for object storage;*/
    Object[] value;

    int size;

    public MyArrayList(){
        value = new Object[16];
    }

    public MyArrayList(int size){
        value = new Object[size];
    }

    public int size(){
        return size;
    }

    public void add(Object obj){
        value[size] = obj;
        size++;
        if(size >= value.length){
            //装不下了。扩容吧！
            int newCapacity = value.length*2;
            Object[] newList  = new Object[newCapacity];
            for(int i= 0;i<value.length;i++){
                newList[i] = value[i];
            }
        }
         }

   public Object get(int index){
        if(index <0||index >size -1){
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return value[index];
   }


   public int indexOf(Object obj){
        if(obj == null){
            return -1;
        }else {
            for(int i = 0;i<value.length;i++){
                if(obj == value[i]){
                    return i;
                }
            }
            return -1;
        }
   }
}
