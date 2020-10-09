package HW3;

public class Problem2 {
    public void traverse(Node v) {
        v.shtst = Integer.MAX_VALUE;
        v.expn = 0;

        for (Node child : v.children) {
            traverse(child);
            if (child.shtst + child.len < v.shtst) {
                v.shtst = child.shtst + child.len;
                v.expn = Math.max(child.len, child.expn);
            } else if (child.shtst + child.len == v.shtst) {
                v.expn = Math.min(Math.max(child.len, child.expn), v.expn);
            }
        }

        if (v.shtst == Integer.MAX_VALUE) {
            v.shtst = 0;
        }
        System.out.println("Node n" + v.name + ": " + "v.shtsh = " + v.shtst + ", v.expn = " + v.expn);
    }
}


