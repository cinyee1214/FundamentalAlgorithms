package HW3;
import java.util.ArrayList;
import java.util.List;
class Node {
    int len, shtst, expn;
    String name;
    List<Node> children = new ArrayList<>();

    Node(int len, String name) {
        this.len = len;
//        shtst = Integer.MAX_VALUE;
//        expn = 0;
        this.name = name;
    }
}
