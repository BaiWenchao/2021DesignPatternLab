public class AcceptJobCommand implements Command{
    Job job;

    public AcceptJobCommand(Job job) {
        this.job = job;
    }

    @Override
    public void execute() {
        job.action();
    }
}
