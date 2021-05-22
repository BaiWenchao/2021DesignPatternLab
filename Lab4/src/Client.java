public class Client {
    public static void main(String[] args) {
        CloudComputingSystem cloudComputingSystem = new CloudComputingSystem();
        // find the largest prime number
        FindTheLargestPrimeNumber findTheLargestPrimeNumber = new FindTheLargestPrimeNumber();
        AcceptJobCommand acceptJobCommand1 = new AcceptJobCommand(findTheLargestPrimeNumber);
        cloudComputingSystem.addCommand(acceptJobCommand1);
        cloudComputingSystem.doit(cloudComputingSystem.getCommandList().indexOf(acceptJobCommand1));
        // process images
        ProcessImage processImage = new ProcessImage();
        AcceptJobCommand acceptJobCommand2 = new AcceptJobCommand(processImage);
        cloudComputingSystem.addCommand(acceptJobCommand2);
        cloudComputingSystem.doit(cloudComputingSystem.getCommandList().indexOf(acceptJobCommand2));
        // sort a list
        SortAList sortAList = new SortAList();
        AcceptJobCommand acceptJobCommand3 = new AcceptJobCommand(sortAList);
        cloudComputingSystem.addCommand(acceptJobCommand3);
        cloudComputingSystem.doit(cloudComputingSystem.getCommandList().indexOf(acceptJobCommand3));
    }
}
