import java.util.ArrayList;
import java.util.List;

public class CloudComputingSystem {
    List<Command>commandList;

    public CloudComputingSystem() {
        this.commandList = new ArrayList<Command>();
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void doit(int index){
        commandList.get(index).execute();
    }

}
