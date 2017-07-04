package io.github.mcaliman.algoritms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * breadth first search
 * BreadthFirstSearch
 * Created by mcaliman on 04/07/17.
 */
public class BFS implements Visitor {


    public static void main(String[] args) {
        Node<String> rootNode = new Node<>("c");
        Node<String> leftChildLevel1 = new Node<>("i");
        Node<String> rightChildLevel1 = new Node<>("a");
        Node<String> leftChildLevel2 = new Node<>("o");

        rootNode.setLeft(leftChildLevel1);
        rootNode.setRight(rightChildLevel1);
        leftChildLevel1.setLeft(leftChildLevel2);

        Visitor visitor = new BFS();
        visitor.visit(rootNode);
        System.out.println();
    }

    @Override
    public void visit(Node r) {
        Queue<Node> C = new LinkedList<>();
        print(C);
        C.add(r);
        print(C);
        while (!C.isEmpty()) {
            print(C);
            Node u = C.remove();
            print(C);
            if (u != null) {
                print(u);
                print(C);
                C.add(leftChildOf(u));
                print(C);
                C.add(rightChildOf(u));
                print(C);
            }
        }
    }

    private Node leftChildOf(Node n) {
        return n.getLeft();
    }

    private Node rightChildOf(Node n) {
        return n.getRight();
    }

    private void print(Node u) {
        //System.out.print(u);
    }

    private void print(Queue<Node> q) {
        System.out.println(q);
    }

}