package DocumentParser;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;

import java.util.ArrayList;
import java.util.List;

public class Args {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = {"-f", "--file"}, description = "Load file by typing path to it -f [Path to file]", arity = 1, required = true)
    private String path;
    @Parameter(names = {"-e", "--element"}, description = "[Optional] Element you want to print, example:\n for content mode: -e \"Art. 1, 1., 1)\"" +
            "\nfor table of content mode: -e \"Rozdział X\"", arity = 1)
    private String elements;
    @Parameter(names = {"-r","--range"}, description = "[Optional][ONLY FOR CONTENT MODE] Choose range of articles to print, example: -e \"Art. 5.-Art. 10.\"", arity = 1)
    private String range;
    @Parameter(names = {"-c","--content"}, description = "[Optional]Table of content mode by default, -c false to switch to content mode")
    private Boolean content = false;
    @Parameter(names = {"-h", "--help"}, description = "Remember to use quotation marks for arguments that contain white spaces", help = false)
    private boolean help = false;

    public String getPath(){
        return path;
    }

    public String getElement(){ return elements; }

    public String getRange(){
        return range;
    }

    public Boolean getContent(){
        return content;
    }




}
