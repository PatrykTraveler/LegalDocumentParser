package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Root extends Element {
    public Root(ArrayList<String> content){
        super(ElementType.Root, content);
    }
}
