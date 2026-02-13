public class XMLPrinter extends PrinterDecorator{
    XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print("<message>" + message + "</message>");
    }
}
