package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.List;

public class Root extends Element {
    public Root(List<String> content){
        super(ElementType.Root, content);
        this.children = new Parser(content, this.type, this).parse();
    }
}
