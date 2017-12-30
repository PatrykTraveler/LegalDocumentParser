package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.List;

public class Root extends Element {
    public Root(List<String> content){
        super(ElementType.Root, content);
        Parser parser = new Parser(content, this.type, this);
        parser.parse();
    }
}
