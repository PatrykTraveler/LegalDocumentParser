package DocumentParser;

import java.util.regex.Pattern;


public enum ElementType {
    Letter("(^[a-z]+\\))\\s*(.*)"),
    Point("^(\\d+[a-z]*\\))\\s(.*)"),
    Paragraph("^(\\d+[a-z]*\\.)\\s(.*)"),
    Article("(^Art. \\d+[a-z]*)\\.\\s*(.*)"),
    Title("^([A-Z\\s?]{2,})$"),
    Chapter("(^Rozdział \\d+[a-zA-Z]*|^Rozdział [IVXCDL]+[a-zA-Z]*)\\s*.*"),
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
        return null;
    }
}
