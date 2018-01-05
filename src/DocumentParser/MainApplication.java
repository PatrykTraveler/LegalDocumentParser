package DocumentParser;

import com.beust.jcommander.JCommander;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class MainApplication {
    public static void main(String[] args) throws IllegalArgumentException{
        Args arguments = new Args();
        JCommander jCommander = new JCommander(arguments);
        jCommander.setProgramName("Legal document parser");

        try{
            jCommander.parse(args);
        }catch(Exception e){
            System.out.println(e.getMessage());
            jCommander.usage();
            System.exit(0);
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(arguments.getPath()), Charset.forName("Cp1250"));
        }catch(IOException e){
            e.printStackTrace();
        }

        lines = new PreParser(lines).getDocument();

        List<Element> elements = new Element(ElementType.Root, lines).streamElements().collect(Collectors.toList());

        Visualizer vis = new Visualizer(elements);

        if(arguments.getContent()){
            if(arguments.getElement() != null){
                vis.printSpecific(arguments.getElement().split(", "));
            }
            if(arguments.getRange() != null){
                String[] range = arguments.getRange().split("-");
                vis.printRange(range[0], range[1]);
            }
        }
        else{
            boolean everything = true;
            if(arguments.getElement() != null)
                everything = false;
            vis.printToc(everything, arguments.getElement());
        }
    }
}
