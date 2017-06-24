package io.github.mcaliman.algoritms;

import java.util.Stack;

public class DFS implements Visitor {

    public static void main(String[] args) {
        Node<String> rootNode = new Node<>("c");
        Node<String> leftChildLevel1 = new Node<>("i");
        Node<String> leftChildLevel2 = new Node<>("a");
        Node<String> rightChildLevel1 = new Node<>("o");
        rootNode.setLeft(leftChildLevel1);
        rootNode.setRight(rightChildLevel1);
        leftChildLevel1.setLeft(leftChildLevel2);

        Visitor visitor = new DFS();
        visitor.visit(rootNode);
        System.out.println();
    }

    @Override
    public void visit(Node r) {
        Stack<Node> S = new Stack<>();
        S.push(r);
        while (!S.isEmpty()) {
            Node u = S.pop();
            if (u != null) {
                System.out.print(u.toString());
                S.push(rightChildOf(u));
                S.push(leftChildOf(u));
            }
        }
    }

    private Node leftChildOf(Node n) {
        return n.getLeft();
    }

    private Node rightChildOf(Node n) {
        return n.getRight();
    }

}
