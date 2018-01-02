package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.ArrayList;
import java.util.List;

public class ElementFactory {
    public static Element createElement(ElementType type, ArrayList<String> content){
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
                return new Paragraph(content);
            case Point:
                return new Point(content);
            case Letter:
                return new Letter(content);
            case Text:
                return new Text(content);


        }
        return null;
    }
}
