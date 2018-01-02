package DocumentParser;

import DocumentParser.ElementType;
import DocumentParser.Elements.Element;
import DocumentParser.Elements.ElementFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        int lastOccurrence = -1;

        for(int i = 0; i < this.content.size(); i++){
            if(lowerType.getPattern().matcher(content.get(i)).matches()){
                if(lastOccurrence != -1) {
                    System.out.print("Początek");
                    System.out.println(content.get(0));
                    children.add(ElementFactory.createElement(lowerType, new ArrayList<>(content.subList(lastOccurrence, i))));
                    lastOccurrence = i;
                }
                else
                    lastOccurrence = i;
            }
        }
        if(lastOccurrence != -1) {
            int size = content.size();
            children.add(ElementFactory.createElement(lowerType, new ArrayList<>(content.subList(lastOccurrence, size))));
        }

        return children;
    }
}
