package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.List;

public class Element {
    public List<String> content;
    public List<Element> children;
    public ElementType type;

    public Element(ElementType type, List<String> content){
        this.content = content;
        this.type = type;

        Parser parser = new Parser(this.type, content);
        children = parser.findChildren();
    }

    public ElementType getType(){
        return this.type;
    }
}
