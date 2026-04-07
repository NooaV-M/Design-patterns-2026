public class ComputerDirector {
    private ComputerBuilder builder;

    ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void buildComputer() {
        builder.buildOS();
        builder.buildGpu();
        builder.buildHardDrive();
        builder.buildProcessor();
        builder.buildRam();
    }
}
