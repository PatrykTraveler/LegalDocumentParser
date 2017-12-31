package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.List;

public class Paragraph extends Element {
    public Paragraph(List<String> content){
        super(ElementType.Paragraph, content);

    }
}
