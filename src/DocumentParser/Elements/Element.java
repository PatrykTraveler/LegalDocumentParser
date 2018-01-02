package DocumentParser.Elements;

import DocumentParser.ElementType;
import DocumentParser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public abstract class Element {
    public ArrayList<String> content = new ArrayList<>();
    public ElementType type;

    public String identifier;
    public String title;

    public List<Element> children = new ArrayList<>();

    public Element(ElementType type, ArrayList<String> content){
        this.type = type;
        //Matcher matcher = this.type.getPattern().matcher(content.get(0));
        //matcher.find();
        ArrayList<String> text = new ArrayList<>();
        if(this.type == ElementType.Root){
            this.identifier = "";
            this.title = "";
            text = new ArrayList<>(content);
        }
        if(this.type == ElementType.Title){
            this.identifier = content.get(0);
            this.title = content.get(0);
            text = new ArrayList<>(content.subList(1, content.size()));
        }
        if(this.type == ElementType.Section || this.type == ElementType.Chapter){
            this.identifier = content.get(0);
            this.title = content.get(1);
            text = new ArrayList<>(content.subList(2, content.size()));
        }
        if(this.type == ElementType.Article){
            this.identifier = content.get(0);
            this.title = "";
            text = new ArrayList<>(content.subList(1, content.size()));
            text.add("dupa");
        }
        if(this.type == ElementType.Letter || this.type == ElementType.Point || this.type == ElementType.Paragraph){
            this.identifier = content.get(0).substring(0, 3);
            this.title = "";
            text = new ArrayList<>(content.subList(1, content.size()));
            text.add(0, content.get(0).substring(3, content.get(0).length()));
        }
        if(this.type == ElementType.Text){
            this.identifier = "";
            this.title = "";
            text = new ArrayList<>(content);
        }

        Parser parser = new Parser(text, this.type, this);

        ElementType tempType = this.type;
        while(parser.parse().size() == 0){
            parser = new Parser(text, tempType.getLowerType(), this);
            tempType = tempType.getLowerType();
        }
        this.children = parser.parse();
    }
}
