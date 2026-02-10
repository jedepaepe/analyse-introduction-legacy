package tree.graphicalobject2;

public abstract class GraphicalObject {
    GraphicalObject parent;

    public GraphicalObject(GraphicalObject parent) {
        this.parent = parent;
    }
}
