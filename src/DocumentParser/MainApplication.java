package DocumentParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        lines = new ArrayList<>(lines.stream()
                .filter(str -> !str.startsWith("\u00a9") && !str.matches("^\\d{4}-\\d{2}-\\d{2}\\s*"))
                .collect(Collectors.toList()));

        Element root = new Element(ElementType.Root, lines);
        List<Element> elements = root.streamElements().collect(Collectors.toList());
        /*elements.forEach(element -> {
            System.out.println(element.identifier);
            element.content.forEach(System.out::println);
        });*/
    }

    public static ArrayList<String> prepareFile(ArrayList<String> lines){
        int pos = 0;
        while(!ElementType.Section.getPattern().matcher(lines.get(pos)).matches()
                && !ElementType.Chapter.getPattern().matcher(lines.get(pos)).matches())
            pos++;

        //connect split words
        /*String buffer = "";
        for(String str : lines){
            if(str.endsWith("-")){
                int i;
                for(i = str.length() - 1; i >= 0; i--)
                    if(str.charAt(i) == ' ')
                        break;
                buffer = str.substring(i + 1, str.length() - 1);
                str = str.substring(0, i);
            }
        }*/
        return new ArrayList<String>(lines.subList(pos, lines.size() - 1));
    }

    public static void printFunction(ArrayList<Element> children, int iter){
        if(children.size() > 0){
            printFunction(children.get(iter).children, iter);
        }
        children.forEach(child -> System.out.println(child.identifier));
        if(iter++ < 0);
    }
}
