package DocumentParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Stream;

public class Element {
    public List<String> content = new ArrayList<>();

    public ElementType type;
    public String identifier;
    public String title;

    public ArrayList<Element> children = new ArrayList<>();

    public Element(ElementType type, List<String> content){
        this.type = type;
        Matcher matcher = this.type.getPattern().matcher(content.get(0));
        matcher.find();
        ArrayList<String> text = new ArrayList<>();

        if(this.type == ElementType.Root){
            this.identifier = "";
            this.title = "";
            text = new ArrayList<>(content);
        }
        if(this.type == ElementType.Title){
            this.identifier = "";
            this.title = content.get(0);
            text = new ArrayList<>(content.subList(1, content.size()));
        }
        if(this.type == ElementType.Section || this.type == ElementType.Chapter){
            this.identifier = matcher.group(1);
            this.title = content.get(1);
            text = new ArrayList<>(content.subList(2, content.size()));
        }
        if(this.type == ElementType.Article){
            this.identifier = matcher.group(1);
            this.title = "";
            text = new ArrayList<>(content.subList(1, content.size()));
            if(matcher.group(2).length() > 0)
                text.add(0, matcher.group(2));
        }
        if(this.type == ElementType.Letter || this.type == ElementType.Point || this.type == ElementType.Paragraph){
            this.identifier = matcher.group(1);
            this.title = "";
            text = new ArrayList<>(content.subList(1, content.size()));
            text.add(0, matcher.group(2));
        }

        this.children = new Parser(text, this.type, this).parse();
    }

    //recursively flattens whole structure of a document
    public Stream<Element> streamElements(){
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(Element::streamElements));
    }
}
