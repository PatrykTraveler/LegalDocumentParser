package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    public List<String> content;
    public ElementType type;
    public String firstLine;

    public List<Element> children = new ArrayList<>();

    public Element(ElementType type, List<String> content){
        this.type = type;
    }

    public void addChild(Element child){
        this.children.add(child);
    }

    public Element getChild(int index){
        return this.children.get(index);
    }

}
