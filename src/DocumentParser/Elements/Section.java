package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    public String title;
    public Section(List<String> content){
        super(ElementType.Section, content);
        this.firstLine = content.get(0);
        this.title = content.get(1);
        List<String> contentToProceed = content.subList(2, content.size() - 1);

        Parser parser = new Parser(contentToProceed, this.type, this);
        parser.parse();
    }

}
