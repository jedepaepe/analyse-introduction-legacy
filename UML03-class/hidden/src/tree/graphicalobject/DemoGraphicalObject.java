package tree.graphicalobject;

public class DemoGraphicalObject {
    public static void main(String[] args) {
        GraphicalObject window = new GraphicalObject();

        GraphicalObject header = new GraphicalObject();
        header.parent = window;
        window.children.add(header);
        // nous pourrions factoriser ce code

        GraphicalObject main = new GraphicalObject();
        main.parent = window;
        window.children.add(main);

        GraphicalObject footer = new GraphicalObject();
        footer.parent = window;
        window.children.add(footer);

        GraphicalObject texte = new GraphicalObject();
        texte.parent = main;
        main.children.add(texte);

        GraphicalObject zoneDeSaisie = new GraphicalObject();
        zoneDeSaisie.parent = main;
        main.children.add(zoneDeSaisie);

        GraphicalObject boutonOk = new GraphicalObject();
        boutonOk.parent = main;
        main.children.add(boutonOk);
    }
}
