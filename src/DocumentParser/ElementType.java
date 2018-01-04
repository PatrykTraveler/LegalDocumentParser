package DocumentParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum ElementType {
    Text("(?s).*"),
    Letter("(^[a-z]+\\))\\s*(.*)"),
    Point("^(\\d+\\p{L}*\\))\\s(.*)"),
    Paragraph("^(\\d+[a-z]*\\.)\\s(.*)"),
    Article("(^Art. \\d+[a-z]*)\\.\\s*(.*)"),
    Title("^\\p{Lu}{2,}.+"),
    Chapter("(^Rozdział \\d+[a-zA-Z]*)|(^Rozdział [IVXCDL]+[a-zA-Z]*)\\s*.*"),
    Section("(^DZIAŁ [IVXCD]+[A-Z]*)\\s*.*"),
    Root("Just nothing");

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
