package tree.graphicalobject2;

public class Button extends GraphicalObject {
    String text;
    String font;
    String fontColor;
    String background;

    public Button(GraphicalObject parent, String text, String font, String fontColor, String background) {
        super(parent);
        this.text = text;
        this.font = font;
        this.fontColor = fontColor;
        this.background = background;
    }
}
