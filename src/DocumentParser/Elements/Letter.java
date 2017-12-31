package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.List;

public class Letter extends Element {
    public Letter(List<String> content) {
        super(ElementType.Letter, content);
    }
}
