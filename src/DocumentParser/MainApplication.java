package DocumentParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import DocumentParser.Elements.Element;

public class MainApplication {
    public static void main(String[] args){
        String filename = "konstytucja.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.forName("Cp1250"));
        }catch(IOException e){
            e.printStackTrace();
        }

        prepareFile(lines);

        Element root = new Element(ElementType.Document, lines);
        System.out.println(ElementType.Text.getLowerType());
    }

    public static void prepareFile(List<String> lines){
        //remove lines that starts with a copyright sign
        Iterator<String> i = lines.iterator();
        while(i.hasNext()){
            if(i.next().startsWith("\u00a9"))
                i.remove();
            if(i.next().matches("^\\d{4}-\\d{2}-\\d{2}$"))
                i.remove();
        }
    }
}
