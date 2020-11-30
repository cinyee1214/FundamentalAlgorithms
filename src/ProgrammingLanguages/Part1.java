package ProgrammingLanguages;

import java.util.*;

class SortedList<T extends Comparable<T>> extends ArrayList<T> implements List<T>, Comparable<SortedList<T>> {

    @Override
    public int compareTo(SortedList<T> s) {
        int l = 0, r = 0;
        while (l < this.size() && r < s.size()) {
            if (this.get(l).compareTo(s.get(r)) == 0) {
                l++;
                r++;
            } else if (this.get(l).compareTo(s.get(r)) < 0) {
                return -1;
            } else return 1;
        }

        if (l == this.size() && r == s.size()) {
            return 0;
        } else if (l == this.size()) {
            return -1;
        } else return 1;
    }

    @Override
    public boolean add(T t) {
        if (this.isEmpty() || this.get(this.size() - 1).compareTo(t) <= 0) {
            this.add(this.size(), t);
            return true;
        }

        if (this.get(0).compareTo(t) > 0) {
            this.add(0, t);
            return true;
        }

        int left = 0, right = this.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (this.get(mid).compareTo(t) == 0) {
                this.add(mid + 1, t);
                return true;
            }
            if (this.get(mid).compareTo(t) < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        this.add(left + 1, t);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size(); ++i) {
            sb.append(this.get(i).toString()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}

class A implements Comparable<A> {
    Integer x;
    public A(Integer x) {
        this.x = x;
    }

    @Override
    public int compareTo(A a) {
        return this.x.compareTo(a.x);
    }

    @Override
    public String toString() {
        return "A<" + x + ">";
    }
}

class B extends A {
    Integer x, y;
    public B(Integer x, Integer y) {
        super(x + y);
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(A a) {
        return super.compareTo(a);
    }

    @Override
    public String toString() {
        return "B<" + x + "," + y + ">";
    }
}

public class Part1 {
    public static void main(String[] args) {
        test();
        // otherTest();
    }
    static void test() {
        SortedList<A> c1 = new SortedList<A>();
        SortedList<A> c2 = new SortedList<A>();

        for(int i = 35; i >= 0; i -= 5) {
            addToSortedList(c1, new A(i));
            addToSortedList(c2, new B(i + 2,i + 3));
        }
        System.out.print("c1: ");
        System.out.println(c1);

        System.out.print("c2: ");
        System.out.println(c2);

        switch (c1.compareTo(c2)) {
            case -1:
                System.out.println("c1 < c2");
                break;
            case 0:
                System.out.println("c1 = c2");
                break;
            case 1:
                System.out.println("c1 > c2");
                break;
            default:
                System.out.println("Uh Oh");
                break; }
    }

    static <T extends Comparable<T>> void addToSortedList(SortedList<T> L, T z) {
        L.add(z);
    }

    static void otherTest() {
        SortedList<A> c3 = new SortedList<A>();
        SortedList<A> c4 = new SortedList<A>();

        c3.add(new A(14));
        c3.add(new A(4));
        c3.add(new A(34));
        c3.add(new A(24));
        c3.add(new A(-4));
        c3.add(new A(11));
        c3.add(new A(14));

        c4.add(new B(14, 0));
        c4.add(new B(12, 10));
        c4.add(new B(-12, 10));
        c4.add(new B(2, 1));
        c4.add(new B(12, 20));
        c4.add(new B(12, 10));
        c4.add(new B(15, 3));
        c4.add(new B(1, 19));
        c4.add(new B(21, 1));

        System.out.print("c3: ");
        System.out.println(c3);

        System.out.print("c4: ");
        System.out.println(c4);

        switch (c3.compareTo(c4)) {
            case -1:
                System.out.println("c3 < c4");
                break;
            case 0:
                System.out.println("c3 = c4");
                break;
            case 1:
                System.out.println("c3 > c4");
                break;
            default:
                System.out.println("Uh Oh");
                break; }
    }
}
