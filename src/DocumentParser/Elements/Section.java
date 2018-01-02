package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    public Section(ArrayList<String> content){
        super(ElementType.Section, content);
    }

}
