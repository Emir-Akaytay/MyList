
public class MyList<T> implements IMyList<T> {

    private int size;
    private T[] list;

    MyList() {
        this.size = 10;
        this.list = (T[]) new Object[this.size];
    }

    MyList(int size) {
        this.size = size;
        this.list = (T[]) new Object[this.size];
    }

    @Override
    public int getCapacity() {
        int counter = 0;
        for(T i : this.getList()) {
            if(i == null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void addData(T data) {
        if(whichEmpty() != -1) {
            this.getList()[whichEmpty()] = data;
        } else {
            int currentSize = this.getSize();
            duplicateSize();
            this.getList()[currentSize] = data;
        }
    }

    @Override
    public T get(int index) {
        return this.getList()[index];
    }

    @Override
    public void remove(int index) {
        this.getList()[index] = null;
        this.setList(changePlacement(index));
    }

    @Override
    public void set(int index,T data) {
        this.getList()[index] = data;
    }


    @Override
    public String toString() {
        System.out.print("[");
        for (T i : this.getList()) {
            if (i != null) {
                System.out.print(i + ",");
            }
        }
        System.out.println("]");
        return "";
    }

    @Override
    public int indexOf(T data) {
        for(int i = 0 ; i < this.getSize() ; i++) {
            if(this.getList()[i] == data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        int tempIndex = 0;
        for(int i = 0 ; i < this.getSize() ; i++) {
            if(this.getList()[i] == data) {
                tempIndex = i;
            }
        }
        return tempIndex;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for(T i : this.getList()) {
            if(i != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public boolean isContain(T data) {
        for(T i : this.getList()) {
            if(i == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] sublist(int firstIndex,int lastIndex) {
        T[] subList = (T[]) new Object[(lastIndex - firstIndex + 1)];
        int index = 0;
        for(int i = firstIndex ; i <= lastIndex ; i++ ) {
            subList[index] = this.getList()[i];
            index++;
        }
        return subList;
    }

    @Override
    public void clear() {
        for(int i = 0 ; i  < this.getSize() ; i++) {
            if(this.getList()[i] != null) {
                this.getList()[i] = null;
            }
        }
    }

    @Override
    public T[] toArray() {
        return createTemp();
    }


    private int whichEmpty() {
        for(int i = 0 ; i < this.getList().length ; i++ ) {
            if (this.getList()[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void transferData(T[] newList,T[] tempList) {
        System.arraycopy(tempList, 0, newList, 0, tempList.length);
    }

    private T[] createTemp() {
        T[] tempList = (T[]) new Object[this.getSize()];
        if (this.getSize() >= 0) System.arraycopy(this.getList(), 0, tempList, 0, this.getSize());
        return tempList;
    }

    private void duplicateSize() {
        T[] tempList = createTemp();
        this.setSize(this.getSize() * 2);
        T[] newList = (T[]) new Object[this.getSize()];
        transferData(newList,tempList);
        this.setList(newList);
    }

    private T[] changePlacement(int index) {
        T[] tempList = createTemp();
        for(int i = index + 1 ; i < tempList.length ; i++) {
            tempList[i - 1] = tempList[i];
        }
        tempList[tempList.length - 1] = null;
        return tempList;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private T[] getList() {
        return list;
    }

    private void setList(T[] list) {
        this.list = list;
    }

}