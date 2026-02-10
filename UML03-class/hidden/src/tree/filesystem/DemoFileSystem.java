package tree.filesystem;

public class DemoFileSystem {
    public static void main(String[] args) {
        // c: est la racine de l'arbre => pas de parent
        // https://docs.oracle.com/javase/tutorial/collections/implementations/set.html
        Directory c2Dots = new Directory("c:", null);

        Directory data = new Directory("data", c2Dots);
        c2Dots.children.add(data);

        File readmeTxt = new File("readme.txt", c2Dots);
        c2Dots.children.add(readmeTxt);

        Directory tmp = new Directory("tmp", c2Dots);
        c2Dots.children.add(tmp);

        File infoTxt = new File("info.txt", data);
        data.children.add(infoTxt);

        File letterDocx = new File("letter.docx", data);
        data.children.add(letterDocx);
        // remarque:
        //  nous voyons toujours le même code se répéter
        //  => nous devrions factoriser
    }
}
