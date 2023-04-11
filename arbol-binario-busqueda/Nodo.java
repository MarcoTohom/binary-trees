
public class Nodo {
    public Nodo(Integer value, Nodo parent, Nodo left, Nodo right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Integer value;
    public Nodo parent;
    public Nodo left;
    public Nodo right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nodo other = (Nodo) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
