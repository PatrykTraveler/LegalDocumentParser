package DocumentParser;

import DocumentParser.Elements.Element;
import DocumentParser.Elements.Root;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class MainApplication {
    public static void main(String[] args){
        String filename = "uokik.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.forName("Cp1250"));
        }catch(IOException e){
            e.printStackTrace();
        }

        lines = prepareFile(lines);
        Element root = new Root(lines);
        root.children.forEach(child -> System.out.println(child.content));

    }

    public static List<String> prepareFile(List<String> lines){
        //remove lines that starts with a copyright sign
        Iterator<String> it = lines.iterator();
        while(it.hasNext()){
            if(it.next().startsWith("\u00a9"))
                it.remove();
            if(it.next().matches("^\\d{4}-\\d{2}-\\d{2}$"))
                it.remove();
        }
        //remove beginning of a document
        int pos = 0;
        while(!ElementType.Section.getPattern().matcher(lines.get(pos)).matches()
                && !ElementType.Chapter.getPattern().matcher(lines.get(pos)).matches())
            pos++;

        return lines.subList(pos, lines.size() - 1);
    }
}
