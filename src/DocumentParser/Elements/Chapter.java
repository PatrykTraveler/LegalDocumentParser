package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.List;

public class Chapter extends Element {
    public String title;
    public Chapter(List<String> content){
        super(ElementType.Chapter, content);
        this.title = content.get(1);

        List<String> contentToProceed = content.subList(2, content.size() - 1);
        this.children = new Parser(contentToProceed, this.type, this).parse();

    }
}
