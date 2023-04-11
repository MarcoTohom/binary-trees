public class Principal {
    public static void main(String[] args) {
        Arbol tree = new Arbol();
        //tree.insert(0);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.printTree();
        //System.out.println(tree.size);
    }
}
