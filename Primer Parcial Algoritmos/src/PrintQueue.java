public class PrintQueue {
    private PrintService head;
    private PrintService tail;

    public PrintQueue() {
        this.head = null;
        this.tail = null;
    }

    public void add(PrintJob printJob) {
        PrintService newPrintService = new PrintService(printJob);
        if (head == null) {
            head = newPrintService;
            tail = newPrintService;
        } else {
            tail.next = newPrintService;
            newPrintService.previous = tail;
            tail = newPrintService;
        }
    }

    public void print() {
        if (head == null)
            return;

        head = head.next;
    }

    public void ordenar(PrintService printService) {
        PrintService current = head;
        PrintService last = tail;

        if (printService.printJob.getPrioridad() == Prioridad.ALTA) {
            if (current.printJob.getPrioridad() != Prioridad.ALTA) {
                head = printService;
                printService.next = current;
                current.previous = printService;
            } else {
                while (current.next != null && current.next.printJob.getPrioridad() == Prioridad.ALTA) {
                    if (current.next.printJob.getHoraDeEnvio().isBefore(printService.printJob.getHoraDeEnvio())) {
                        current = current.next;
                    } else {
                        printService.next = current.next;
                        printService.previous = current;
                        current.next = printService;
                        return;
                    }
                }
                if (current.next.printJob.getPrioridad() != Prioridad.ALTA) {
                    printService.next = current.next;
                    printService.previous = current;
                    current.next = printService;
                    return;
                }
            }
        }

        if (printService.printJob.getPrioridad() == Prioridad.MEDIA) {
            if (current.printJob.getPrioridad() != Prioridad.MEDIA && current.printJob.getPrioridad() != Prioridad.ALTA) {
                head = printService;
                printService.next = current;
                current.previous = printService;
            } else {
                while (current.next != null && current.printJob.getPrioridad() != Prioridad.MEDIA) {
                    current = current.next;
                }
                while (current.next != null && current.next.printJob.getPrioridad() == Prioridad.MEDIA) {
                    if (current.next.printJob.getHoraDeEnvio().isBefore(printService.printJob.getHoraDeEnvio())) {
                        current = current.next;
                    } else {
                        printService.next = current.next;
                        printService.previous = current;
                        current.next = printService;
                        return;
                    }
                }
                if (current.next.printJob.getPrioridad() != Prioridad.MEDIA) {
                    printService.next = current.next;
                    printService.previous = current;
                    current.next = printService;
                    return;
                }
            }
        }

        if (printService.printJob.getPrioridad() == Prioridad.BAJA) {
            if (last.previous != null && last.printJob.getPrioridad() != Prioridad.BAJA) {
                last.next = printService;
                printService.previous = last;
                tail = printService;
                return;
            } else {
                if (last.printJob.getPrioridad() == Prioridad.BAJA) {
                    if (last.printJob.getHoraDeEnvio().isBefore(printService.printJob.getHoraDeEnvio())) {
                        last.next = printService;
                        printService.previous = last;
                        tail = printService;
                        return;
                    } else {
                        while (last.previous != null && last.printJob.getPrioridad() == Prioridad.BAJA &&
                                last.previous.printJob.getHoraDeEnvio().isAfter(printService.printJob.getHoraDeEnvio())) {
                            last = last.previous;
                        }

                    }
                }
            }
        }
    }
}
