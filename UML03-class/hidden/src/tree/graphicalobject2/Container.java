package tree.graphicalobject2;

import java.util.HashSet;

public class Container extends GraphicalObject {
    HashSet<GraphicalObject> children = new HashSet<>();

    public Container(GraphicalObject parent) {
        super(parent);
    }
}
