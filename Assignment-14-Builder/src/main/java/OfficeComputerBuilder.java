public class OfficeComputerBuilder implements  ComputerBuilder {

    private Computer computer;

    OfficeComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Mid-range Office Processor");
    }

    @Override
    public void buildRam() {
        computer.setRamSize(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("Mid-range Office Hard Drive");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("Integrated Graphics");
    }

    @Override
    public void buildOS() {
        computer.setOs("Windows 10 Home");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
