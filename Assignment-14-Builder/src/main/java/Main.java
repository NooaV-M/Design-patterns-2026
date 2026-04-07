public class Main {
    public static void main(String[] args) {
        GamingComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerDirector computerDirector = new ComputerDirector(gamingComputerBuilder);
        computerDirector.buildComputer();
        Computer gamingComputer = gamingComputerBuilder.getComputer();
        gamingComputer.displaySpecs();

        OfficeComputerBuilder officeComputerBuilder = new OfficeComputerBuilder();
        computerDirector.setBuilder(officeComputerBuilder);
        computerDirector.buildComputer();
        Computer officeComputer = officeComputerBuilder.getComputer();
        officeComputer.displaySpecs();

    }
}
