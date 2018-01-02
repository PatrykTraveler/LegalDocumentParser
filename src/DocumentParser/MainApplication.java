package DocumentParser;

import DocumentParser.Elements.Element;
import DocumentParser.Elements.Root;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MainApplication {
    public static void main(String[] args){
        String filename = "uokik.txt";
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get(filename), Charset.forName("Cp1250")));
        }catch(IOException e){
            e.printStackTrace();
        }

        lines = prepareFile(lines);
        //lines.stream().filter(str -> !str.startsWith("\u00a9") && !str.matches("^\\d{4}-\\d{2}-\\d{2}\\s*")).forEach(System.out::println);
        Root root = new Root(lines);

        root.children.forEach(child -> {
            System.out.println(child.identifier);
            child.children.forEach(child1 -> {
                System.out.println(child1.identifier);
                child1.children.forEach(child2 -> System.out.println(child2.identifier));
            });
        });



    }

    public static ArrayList<String> prepareFile(ArrayList<String> lines){
        //remove lines that starts with a copyright sign
        Iterator<String> it = lines.iterator();
        while(it.hasNext()){
            if(it.next().startsWith("\\u00a9"))
                it.remove();
            if(it.next().matches("^\\d{4}-\\d{2}-\\d{2}\\.*"))
                it.remove();
        }
        for(int i = 0; i < lines.size(); i++)
            lines.get(i).replaceAll("^\\u00a9\\.*", "");
        //remove beginning of a document
        int pos = 0;
        while(!ElementType.Section.getPattern().matcher(lines.get(pos)).matches()
                && !ElementType.Chapter.getPattern().matcher(lines.get(pos)).matches())
            pos++;

        return new ArrayList<String>(lines.subList(pos, lines.size() - 1));
    }
}
