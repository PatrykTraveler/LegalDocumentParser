package DocumentParser;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class PreParser {
    private List<String> content;
    public PreParser(List<String> lines){
        this.content = lines;
        this.content = trimDocument(this.content);
        this.content = alterDocument(this.content);
        connectDocument(this.content);
    }

    private void connectDocument(List<String> lines){
        String buffer = "";
        ListIterator<String> it = lines.listIterator();
        while(it.hasNext()){
            String currentLine = it.next();
            if(buffer.length() > 0) {
                it.set(buffer + currentLine);
                buffer = "";
            }
            if(currentLine.endsWith("-")){
                String[] words = currentLine.split(" ");
                buffer = words[words.length - 1];
                it.set(currentLine.substring(0, currentLine.length() - buffer.length()));
                buffer = buffer.substring(0, buffer.length() - 1);
            }
        }
    }

    private List<String> alterDocument(List<String> lines){
        return lines.stream()
                .filter(str -> !str.startsWith("\u00a9")
                        && !str.matches("^\\d{4}-\\d{2}-\\d{2}\\s*")
                        && !str.matches("^.?uchylony.?"))
                .collect(Collectors.toList());
    }

    private List<String> trimDocument(List<String> lines){
        int pos = 0;
        while(!ElementType.Section.getPattern().matcher(lines.get(pos)).matches()
                && !ElementType.Chapter.getPattern().matcher(lines.get(pos)).matches())
            pos++;
        return lines.subList(pos, lines.size());
    }

    public List<String> getDocument(){
        return this.content;
    }
}
