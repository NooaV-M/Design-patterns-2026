public class GamingComputerBuilder implements ComputerBuilder{

    private Computer computer;

    GamingComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("High-end Gaming Processor");
    }

    @Override
    public void buildRam() {
        computer.setProcessor("32 GB DDR4 RAM");
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB NVMe SSD");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("High-end Gaming GPU");
    }

    @Override
    public void buildOS() {
        computer.setOs("Windows 10 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
