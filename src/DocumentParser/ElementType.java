package DocumentParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum ElementType {
    Text(""),
    Letter(""),
    Point(""),
    Paragraph(""),
    Article("^(Art. )\\d+[a-z]*."),
    Title("^\\p{Lu}{2,}.+"),
    Chapter("^Rozdział ([IVCXD]*\\d*)"),
    Section("^DZIAŁ [IVCXD]+[A-Z]*\\s*"),
    Document("");

    private final Pattern pattern;

    ElementType(final String regex){
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern(){
        return this.pattern;
    }

    public ElementType getLowerType(){
        if(this.ordinal() > 0)
            return ElementType.values()[this.ordinal() - 1];
        return this;
    }
}