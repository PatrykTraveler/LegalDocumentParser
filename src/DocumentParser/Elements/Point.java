package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Point extends Element {
    public Point(ArrayList<String> content) {
        super(ElementType.Point, content);
    }
}
