public interface IMyList <T> {

    int getCapacity();
    void addData(T data);
    T get(int index);
    void remove(int index);
    void set(int index,T data);
    String toString();
    int indexOf(T data);
    int lastIndexOf(T data);
    boolean isEmpty();
    boolean isContain(T data);
    T[] sublist(int firstIndex,int lastIndex);
    void clear();
    T[] toArray();
}
