package DocumentParser;

import DocumentParser.Elements.Element;
import java.util.List;

public class Parser {
    private final ElementType type;
    private final List<String> rawText;

    public Parser(ElementType type, List<String> rawText){
        this.type = type;
        this.rawText = rawText;
    }

    public List<Element> findChildren(){
        ElementType type = this.type.getLowerType();
        int lastOccurrence = -1;



        return null;
    }
}
