package DocumentParser;

import java.util.ArrayList;

public class Parser {
    private Element element;
    public ElementType type;
    public ArrayList<String> content;

    public Parser(ArrayList<String> content, ElementType type, Element element){
        this.content = content;
        this.type = type;
        this.element = element;
    }


    public ArrayList<Element> parse(){
        ElementType lowerType = this.type.getLowerType();
        ArrayList<Element> children = new ArrayList<>();
        while(children.size() == 0) {
            Boolean addedContent = false;
            int lastOccurrence = -1;

            for (int i = 0; i < content.size(); i++) {
                if (lowerType.getPattern().matcher(content.get(i)).matches()) {
                    if (lastOccurrence != -1) {
                        children.add(new Element(lowerType, new ArrayList<>(content.subList(lastOccurrence, i))));
                        lastOccurrence = i;
                    } else
                        lastOccurrence = i;
                }
            }

            if (lastOccurrence != -1) {
                children.add(new Element(lowerType, new ArrayList<>(content.subList(lastOccurrence, content.size()))));
            }
            lowerType = lowerType.getLowerType();
        }
        return children;
    }
}
