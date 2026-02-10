package tree.graphicalobject2;

public class DemoGraphicalObject2 {
    public static void main(String[] args) {
        // window est la racine de l'arbre, il n'a donc pas de parent
        Container window = new Container(null);

        Container header = new Container(window);
        window.children.add(header);

        Container main = new Container(window);
        window.children.add(main);

        Container footer = new Container(window);
        window.children.add(footer);

        Text text = new Text(main, "super cours",
                "arial", "bleu", "bleu clair");
        main.children.add(text);

        InputText saisie = new InputText(main, "commentaire",
                "new roman", "orange", "noir");
        main.children.add(saisie);

        Button ok = new Button(main, "OK",
                "courrier", "red", "noir");
        main.children.add(ok);
    }
}
