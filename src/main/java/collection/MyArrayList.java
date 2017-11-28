package collection;

/**
 * 手写ArrayList 有add get 迭代器方法
 * @param <E>
 */
public class MyArrayList<E> {

    Object[] elementData = {};
    int cursor;

    public MyArrayList(){
    }

    public MyArrayList(int size){
        elementData = new Object[size];
    }

    public void add(E e){
        elementData[cursor++] = e;
    }

    public E get(int index){
        return (E)elementData[index];
    }

    public Iterator<E> iterator() {
        return new Iterator();
    }

    public class Iterator<E> {
        int cursor;       //邮编
        public boolean hasNext() {
            return cursor != elementData.length;
        }

        public E next() {
            return (E)elementData[cursor++];
        }
    }

}