/**
 * ��������
 * Created by leo.cao on 2016/11/9.
 */
public class OrderArray {

    private long[] arr;
    private int nElems; // ������

    public OrderArray(int initSize) {
        nElems = 0;
        this.arr = new long[initSize];
    }

    /**
     * �������
     *
     * @param value
     */
    public void add(long value) {
        if (nElems == arr.length) {
            System.out.println("arr is Full. ignored " + value);
            return;
        }

        int i; // �������λ��
        for (i = 0; i < nElems; i++) {
            if (arr[i] > value)
                break;
        }
        // �����Ԫ�غ���
        for (int j = nElems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value; // ������ֵ
        nElems++;
    }

    /**
     * ���ֲ���
     *
     * @param searchKey
     * @return λ��
     */
    public int binarySearch(long searchKey) {

        if (searchKey < arr[0] || searchKey > arr[nElems - 1]) {
            return -1;// out range
        }

        int left = 0, right = nElems, guess;

        while (true) {
            guess = (left + right) / 2;
            if (arr[guess] == searchKey)
                return guess;
            else if (left > right)
                return -1;
            else if (arr[guess] > searchKey)
                right = guess - 1;
            else if (arr[guess] < searchKey)
                left = guess + 1;
        }

    }

    public int delete(long searchKey) {
        int location = this.binarySearch(searchKey);
        if (location == -1) {
            return -1;
        }

        if (location == nElems)
            arr[nElems - 1] = 0; // clear

        for (int i = location; i < nElems; i++) {
            arr[i] = arr[i + 1];
        }
        nElems--;

        return location;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        OrderArray oa = new OrderArray(30);
        oa.add(105);
        oa.add(34);
        oa.add(25);
        oa.add(50);
        oa.add(10);
        oa.add(65);

        oa.display();

        System.out.println("25 at " + oa.binarySearch(25));
        //System.out.println("10 at " + oa.binarySearch(10));
        //System.out.println("106 at " + oa.binarySearch(106));

        System.out.println("delete 34 at " + oa.delete(65));
        oa.display();
    }


}
