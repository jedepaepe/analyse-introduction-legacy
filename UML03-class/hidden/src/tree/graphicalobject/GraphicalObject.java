package tree.graphicalobject;

import java.util.ArrayList;

public class GraphicalObject {
    // dans une classe réaliste, il y aurait des attributs
    // couleurs, tailles, ...

    GraphicalObject parent;
    ArrayList<GraphicalObject> children = new ArrayList<>();
}
