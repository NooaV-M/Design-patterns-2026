public class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String gpu;
    private String os;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String cpu) {
        this.gpu = cpu;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void displaySpecs() {
        System.out.println();
        System.out.println("Processor: " + processor);
        System.out.println("RAM Size: " + ramSize + " GB");
        System.out.println("Hard Drive: " + hardDrive);
        System.out.println("CPU: " + gpu);
        System.out.println("Operating System: " + os);
        System.out.println();
    }
}
