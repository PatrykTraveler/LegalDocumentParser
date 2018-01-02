package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Article extends Element {
    public Article(ArrayList<String> content){
        super(ElementType.Article, content);
    }

}
