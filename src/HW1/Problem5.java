package HW1;

public class Problem5 {
    public int[] traverse(Node v) {
        int[] lpd = new int[2]; // [0: blue, 1: red]
        if (v.clr.equals("blue")) {
            lpd[0] = 1;
        } else {
            lpd[1] = 1;
        }
        v.bic = 0;

        for (Node child : v.children) {
            int[] cLPD = traverse(child);
            if (child.clr.equals(v.clr)) {
                if (v.clr.equals("blue")) {
                    lpd[0] = Math.max(lpd[0], cLPD[0] + 1);
                } else {
                    lpd[1] = Math.max(lpd[1], cLPD[1] + 1);
                }
                if (child.bic > 0) {
                    v.bic = Math.max(v.bic, child.bic + 1);
                }
            } else {
                if (v.clr.equals("blue")) {
                    v.bic = Math.max(v.bic, cLPD[1] + 1);
                } else {
                    v.bic = Math.max(v.bic, cLPD[0] + 1);
                }
                v.bic = Math.max(v.bic, child.bic + 1);
            }
        }
        return lpd;
    }
}
