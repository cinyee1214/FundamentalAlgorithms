package HW1;

public class Problem6 {
    private int succ;
    private binaryNode rightmost;
    public void rotate(binaryNode T) {
        if (T == null) return;

        rightmost = null;
        succ = T.val;

        update(T);
        rightmost.val = succ;
    }

    private void update(binaryNode v) {
        if (v == null) return;

        if (v.right == null && rightmost == null) rightmost = v;

        update(v.right);
        int tmp = succ;
        succ = v.val;
        v.val = tmp;
        update(v.left);
    }
}
