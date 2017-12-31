package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.List;

public class ElementFactory {
    public static Element createElement(ElementType type, List<String> content){
        switch(type){
            case Root:
                return new Root(content);
            case Section:
                return new Section(content);
            case Chapter:
                return new Chapter(content);
            case Title:
                return new Title(content);
            case Article:
                return new Article(content);
            case Paragraph:
                return null;
            case Point:
                return null;
            case Letter:
                return null;
            case Text:
                return null;


        }
        return null;
    }
}
