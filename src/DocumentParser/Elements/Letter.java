package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Letter extends Element {
    public Letter(ArrayList<String> content) {
        super(ElementType.Letter, content);
    }
}
