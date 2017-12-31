package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.List;

public class Title extends Element {
    public String title;
    Title(List<String> content){
        super(ElementType.Title, content);
        this.title = content.get(0);

        List<String> contentToProceed = content.subList(1, content.size() - 1);
        this.children = new Parser(contentToProceed, this.type, this).parse();
    }
}
