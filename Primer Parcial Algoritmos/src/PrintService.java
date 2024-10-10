public class PrintService {
    PrintJob printJob;
    PrintService next;
    PrintService previous;

    public PrintService(PrintJob printJob) {
        this.printJob = printJob;
        this.next = null;
        this.previous = null;
    }
}
