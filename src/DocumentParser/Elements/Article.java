package DocumentParser.Elements;

import DocumentParser.ElementType;

import java.util.List;

public class Article extends Element {
    public Article(List<String> content){
        super(ElementType.Article, content);

    }
}
