package DocumentParser;

import DocumentParser.Elements.Element;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final ElementType type;
    private final List<String> rawText;

    public Parser(ElementType type, List<String> rawText){
        this.type = type;
        this.rawText = rawText;
    }

    public List<Element> findChildren(){
        ElementType childType = this.type.getLowerType();
        List<Element> children = new ArrayList<>();
        int lastOccurrence = -1;
        for(int i = 0; i < rawText.size(); i++){
            if(type.getPattern().matcher(rawText.get(i)).matches()){
                if(lastOccurrence != -1){
                    children.add(new Element(childType, rawText.subList(lastOccurrence, i)));
                }
                lastOccurrence = i;
            }
        }

        return null;
    }
}
