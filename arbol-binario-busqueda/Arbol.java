
public class Arbol {
    public Nodo root;

    /** Tree size. */
    public int size;

    
    public Nodo createNodo(int value, Nodo parent, Nodo left, Nodo right){
        return new Nodo(value, parent, left, right);
    }

    public Nodo search(int element) {
        Nodo Nodo = root;
        while (Nodo != null && Nodo.value != null && Nodo.value != element) {
            if (element < Nodo.value) {
                Nodo = Nodo.left;
            } else {
                Nodo = Nodo.right;
            }
        }
        return Nodo;
    }

    public Nodo insert(int element) {
        if (root == null) {
            root = createNodo(element, null, null, null);
            size++;
            return root;
        }

        Nodo insertParentNodo = null;
        Nodo searchTempNodo = root;
        while (searchTempNodo != null && searchTempNodo.value != null) {
            insertParentNodo = searchTempNodo;
            if (element < searchTempNodo.value) {
                searchTempNodo = searchTempNodo.left;
            } else {
                searchTempNodo = searchTempNodo.right;
            }
        }

        Nodo newNodo = createNodo(element, insertParentNodo, null, null);
        if (insertParentNodo.value > newNodo.value) {
            insertParentNodo.left = newNodo;
        } else {
            insertParentNodo.right = newNodo;
        }

        size++;
        return newNodo;
    }

    /**
     * Removes element if Nodo with such value exists.
     * 
     * @param element
     *                Element value to remove.
     * 
     * @return New Nodo that is in place of deleted Nodo. Or null if element for
     *         delete was not found.
     */
    public Nodo delete(int element) {
        Nodo deleteNodo = search(element);
        if (deleteNodo != null) {
            return delete(deleteNodo);
        } else {
            return null;
        }
    }

    /**
     * Delete logic when Nodo is already found.
     * 
     * @param deleteNodo
     *                   Nodo that needs to be deleted.
     * 
     * @return New Nodo that is in place of deleted Nodo. Or null if element for
     *         delete was not found.
     */
    public Nodo delete(Nodo deleteNodo) {
        if (deleteNodo != null) {
            Nodo NodoToReturn = null;
            if (deleteNodo != null) {
                if (deleteNodo.left == null) {
                    NodoToReturn = transplant(deleteNodo, deleteNodo.right);
                } else if (deleteNodo.right == null) {
                    NodoToReturn = transplant(deleteNodo, deleteNodo.left);
                } else {
                    Nodo successorNodo = getMinimum(deleteNodo.right);
                    if (successorNodo.parent != deleteNodo) {
                        transplant(successorNodo, successorNodo.right);
                        successorNodo.right = deleteNodo.right;
                        successorNodo.right.parent = successorNodo;
                    }
                    transplant(deleteNodo, successorNodo);
                    successorNodo.left = deleteNodo.left;
                    successorNodo.left.parent = successorNodo;
                    NodoToReturn = successorNodo;
                }
                size--;
            }

            return NodoToReturn;
        }
        return null;
    }

    /**
     * Put one Nodo from tree (newNodo) to the place of another (NodoToReplace).
     * 
     * @param NodoToReplace
     *                      Nodo which is replaced by newNodo and removed from tree.
     * @param newNodo
     *                      New Nodo.
     * 
     * @return New replaced Nodo.
     */
    private Nodo transplant(Nodo NodoToReplace, Nodo newNodo) {
        if (NodoToReplace.parent == null) {
            this.root = newNodo;
        } else if (NodoToReplace == NodoToReplace.parent.left) {
            NodoToReplace.parent.left = newNodo;
        } else {
            NodoToReplace.parent.right = newNodo;
        }
        if (newNodo != null) {
            newNodo.parent = NodoToReplace.parent;
        }
        return newNodo;
    }

    /**
     * @param element
     * @return true if tree contains element.
     */
    public boolean contains(int element) {
        return search(element) != null;
    }

    /**
     * @return Minimum element in tree.
     */
    public int getMinimum() {
        return getMinimum(root).value;
    }

    /**
     * @return Maximum element in tree.
     */
    public int getMaximum() {
        return getMaximum(root).value;
    }

    /**
     * Get next element element who is bigger than provided element.
     * 
     * @param element
     *                Element for whom descendand element is searched
     * @return Successor value.
     */
    // TODO Predecessor
    public int getSuccessor(int element) {
        return getSuccessor(search(element)).value;
    }

    /**
     * @return Number of elements in the tree.
     */
    public int getSize() {
        return size;
    }

    /**
     * Tree traversal with printing element values. In order method.
     */
    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    /**
     * Tree traversal with printing element values. Pre order method.
     */
    public void printTreePreOrder() {
        printTreePreOrder(root);
    }

    /**
     * Tree traversal with printing element values. Post order method.
     */
    public void printTreePostOrder() {
        printTreePostOrder(root);
    }

    /*-------------------PRIVATE HELPER METHODS-------------------*/

    private void printTreeInOrder(Nodo entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            if (entry.value != null) {
                System.out.println(entry.value);
            }
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePreOrder(Nodo entry) {
        if (entry != null) {
            if (entry.value != null) {
                System.out.println(entry.value);
            }
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePostOrder(Nodo entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
            if (entry.value != null) {
                System.out.println(entry.value);
            }
        }
    }

    public Nodo getMinimum(Nodo Nodo) {
        while (Nodo.left != null) {
            Nodo = Nodo.left;
        }
        return Nodo;
    }

    public Nodo getMaximum(Nodo Nodo) {
        while (Nodo.right != null) {
            Nodo = Nodo.right;
        }
        return Nodo;
    }

    public Nodo getSuccessor(Nodo Nodo) {
        // if there is right branch, then successor is leftmost Nodo of that
        // subtree
        if (Nodo.right != null) {
            return getMinimum(Nodo.right);
        } else { // otherwise it is a lowest ancestor whose left child is also
            // ancestor of Nodo
            Nodo currentNodo = Nodo;
            Nodo parentNodo = Nodo.parent;
            while (parentNodo != null && currentNodo == parentNodo.right) {
                // go up until we find parent that currentNodo is not in right
                // subtree.
                currentNodo = parentNodo;
                parentNodo = parentNodo.parent;
            }
            return parentNodo;
        }
    }

    // -------------------------------- TREE PRINTING
    // ------------------------------------

    public void printTree() {
        printSubtree(root);
    }

    public void printSubtree(Nodo Nodo) {
        if (Nodo.right != null) {
            printTree(Nodo.right, true, "");
        }
        printNodoValue(Nodo);
        if (Nodo.left != null) {
            printTree(Nodo.left, false, "");
        }
    }

    private void printNodoValue(Nodo Nodo) {
        if (Nodo.value == null) {
            System.out.print("<null>");
        } else {
            System.out.print(Nodo.value.toString());
        }
        System.out.println();
    }

    private void printTree(Nodo Nodo, boolean isRight, String indent) {
        if (Nodo.right != null) {
            printTree(Nodo.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodoValue(Nodo);
        if (Nodo.left != null) {
            printTree(Nodo.left, false, indent + (isRight ? " |      " : "        "));
        }
    }
}