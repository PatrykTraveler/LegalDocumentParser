package DocumentParser;

public class InputHandler {
    public InputHandler(String[] args){

    try {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-f":
                    //load file
                    i++;
                    break;
                case "-m":
                    //mode
                    i++;
                    break;
                case "-e":
                    //elements to show
                    i++;
                    break;
                case "-h":
                    //help
                    i++;
                    break;
                default:
                    //show help also
                    i++;
                    break;

            }
        }
    }catch(IndexOutOfBoundsException e){
        System.out.println("Something is wrong with your input. Type [-h] for help");
    }

    }

    private void parseInput(){

    }
}
