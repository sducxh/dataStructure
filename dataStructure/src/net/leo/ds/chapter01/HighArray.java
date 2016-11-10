/**
 * Created by leo.cao on 2016/11/9.
 */
public class HighArray {

    private long[] arr;
    private int nElems; // 已有数

    public HighArray(int size) {
        arr = new long[size];
        nElems = 0;
    }

    public void add(long value) {
        if (nElems == arr.length) {
            System.out.println("arr is Full. ignored " + value);
            return;
        }

        arr[nElems] = value;

        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 查找
     *
     * @param searchKey
     * @return -1: not found else: location
     */
    public int find(long searchKey) {
        for (int i = 0; i < nElems; i++) {
            if (arr[i] == searchKey)
                return i;
        }
        return -1;
    }

    public int delete(long searchKey) {
        int location = this.find(searchKey);
        if (location == -1)
            return -1;
        for (int i = location; i < nElems - 1; i++) {
            arr[i] = arr[i + 1];
        }
        nElems--;
        return location;
    }

    public static void main(String args[]) {
        HighArray ha = new HighArray(3);
        ha.add(11);
        /*
        ha.add(22);
        ha.add(33);
        ha.add(44);
        ha.add(55);
        */
        System.out.println("44 at " + ha.find(44));

        ha.delete(33);

        ha.display();
    }

}
