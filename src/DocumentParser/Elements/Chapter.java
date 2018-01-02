package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Chapter extends Element {
    public Chapter(ArrayList<String> content){
        super(ElementType.Chapter, content);
    }
}
