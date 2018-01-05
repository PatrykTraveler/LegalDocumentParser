package DocumentParser;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Visualizer {
    public List<Element> content;

    public Visualizer(List<Element> content){
        this.content = content;
    }

    //print specific element of article
    public void printSpecific(String[] args){
        List<Element> output = null;
        List<Element> contentCopy = this.content;

        for (int i = 0; i < args.length; i++) {
            try {
            final int pos = i;
            output = contentCopy.stream()
                    .filter(e -> e.identifier.equals(args[pos]))
                    .findFirst()
                    .get()
                    .streamElements()
                    .collect(Collectors.toList());
            contentCopy = output;
            }catch(NoSuchElementException e){
                System.out.println("Something went wrong. That is the most specific element I was able to find:");
            }
        }
        if(output != null)
            output.forEach(e -> {
                System.out.println(e.identifier);
                e.content.forEach(System.out::println);
            });
        else
            System.out.println("Element not found.");
    }
    //prints range of articles
    public void printRange(String from, String to){
        int begin = -1, end = -1;
        for(int i = 0; i < content.size(); i++){
            if(content.get(i).identifier.equals(from))
                begin = i;
            if(content.get(i).identifier.equals(to))
                end = i;
        }

        try {
            content.subList(begin, end).stream()
                    .filter(e -> e.type != ElementType.Chapter && e.type != ElementType.Section && e.type != ElementType.Title)
                    .collect(Collectors.toList())
                    .forEach(e -> {
                        System.out.println(e.identifier);
                        e.content.forEach(System.out::println);
                    });
        }catch(IllegalArgumentException e){
            System.out.println("Something is wrong with range. Possible problems:\n- You are searching for article that doesn't exist\n- Articles are placed in a wrong order");
        }
    }
    //prints table of contents
    public void printToc(boolean everything, String identifier){
        try {
            if (everything) {
                content.stream()
                        .filter(e -> e.type == ElementType.Chapter
                                || e.type == ElementType.Section
                                || e.type == ElementType.Title)
                        .forEach(e -> {
                            System.out.println(e.identifier + " - " + e.title);
                        });
            } else {
                content.stream()
                        .filter(e -> e.identifier.equals(identifier))
                        .findFirst()
                        .get()
                        .streamElements()
                        .filter(e -> e.type == ElementType.Chapter
                                || e.type == ElementType.Section
                                || e.type == ElementType.Title)
                        .forEach(e -> {
                            System.out.println(e.identifier + " - " + e.title);
                        });
            }
        }catch(NoSuchElementException e){
            System.out.println("Element not found.");
        }
    }
}
