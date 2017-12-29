package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.List;

public class ElementFactory {
    public static Element createElement(ElementType type, List<String> content){
        switch(type){
            case Section:
                return new Section(content);

        }
        return null;
    }
}
