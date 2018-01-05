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
        String filename = "konstytucja.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.forName("Cp1250"));
        }catch(IOException e){
            e.printStackTrace();
        }

        PreParser doc = new PreParser(lines);
        lines = doc.getDocument();

        List<Element> elements = new Element(ElementType.Root, lines).streamElements().collect(Collectors.toList());
        Visualizer vis = new Visualizer(elements);
        //vis.printRange("Art. 2", "Art. 12");
        vis.printToc(false, "Rozdział I");
    }
}
