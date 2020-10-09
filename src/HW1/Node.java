package HW1;

import java.util.ArrayList;
import java.util.List;

class Node {
    String clr;
    int val;
    int bic;
    List<Node> children = new ArrayList<>();

    Node(String clr, int val) {
        this.clr = clr;
        this.val = val;
    }
}
