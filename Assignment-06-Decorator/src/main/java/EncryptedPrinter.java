public class EncryptedPrinter extends PrinterDecorator{
    EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(message.chars().map(c -> c + 1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }
}
