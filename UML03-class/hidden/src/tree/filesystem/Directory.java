package tree.filesystem;

import java.util.HashSet;

public class Directory extends Node {
    // nous utilisons un Set car il garantit
    // que l'objet n'est présent qu'une seule fois dans la liste
    HashSet<Node> children = new HashSet<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }
}
