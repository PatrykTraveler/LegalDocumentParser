package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Title extends Element {
    Title(ArrayList<String> content){
        super(ElementType.Title, content);
    }
}
