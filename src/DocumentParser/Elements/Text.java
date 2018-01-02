package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.ArrayList;
import java.util.List;

public class Text extends Element {
    public Text(ArrayList<String> content) {
        super(ElementType.Text, content);
    }
}
