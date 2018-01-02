package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Element {
    public Paragraph(ArrayList<String> content){
        super(ElementType.Paragraph, content);
    }
}
