package tree.graphicalobject2;

public class Text extends GraphicalObject {
    String text;
    String font;
    String fontColor;
    String background;

    public Text(GraphicalObject parent,
                String text, String font, String fontColor, String background) {
        super(parent);
        this.text = text;
        this.font = font;
        this.fontColor = fontColor;
        this.background = background;
    }
}
