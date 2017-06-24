package io.github.mcaliman.algoritms;

public class DFSrec implements Visitor {

    public static void main(String[] args) {
        Node<String> rootNode = new Node<>("c");
        Node<String> leftChildLevel1 = new Node<>("i");
        Node<String> leftChildLevel2 = new Node<>("a");
        Node<String> rightChildLevel1 = new Node<>("o");
        rootNode.setLeft(leftChildLevel1);
        rootNode.setRight(rightChildLevel1);
        leftChildLevel1.setLeft(leftChildLevel2);

        Visitor visitor = new DFSrec();
        visitor.visit(rootNode);
        System.out.println();
    }

    @Override
    public void visit(Node r) {
        if (r == null) {
            return;
        }
        System.out.print(r.toString());
        visit(leftChildOf(r));
        visit(rightChildOf(r));
    }

    private Node leftChildOf(Node n) {
        return n.getLeft();
    }

    private Node rightChildOf(Node n) {
        return n.getRight();
    }

}
