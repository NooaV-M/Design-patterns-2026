import java.util.ArrayList;

public class Department extends Component {

    public Department(String name) {
        super(name);
    }

    ArrayList <Component> children = new ArrayList<>();

    public int getTotalSalary(){
        int totalSalary = 0;
        for (Component c : children){
            if (c instanceof Employee){
                Employee e = (Employee) c;
                totalSalary += e.getSalary();
            } else if (c instanceof Department){
                Department d = (Department) c;
                totalSalary += d.getTotalSalary();
            }
        }
        return totalSalary;
    }

    public void printStructure(){
        System.out.println("<" + this.name + ">");
        for (Component c : children) {
            if (c instanceof Employee) {
                System.out.print("  ");
                Employee e = (Employee) c;
                System.out.println("<" + e.name + "</" + e.name + ">");
            } else if (c instanceof Department) {
                Department d = (Department) c;
                d.printStructure(1);
            }
        }
        System.out.println("</" + this.name + ">");
    }

    public void printStructure(int indentation){
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("<" + this.name + ">");
        for (Component c : children) {
            if (c instanceof Employee) {
                for (int i = 0; i < indentation + 1; i++) {
                    System.out.print("  ");
                }
                Employee e = (Employee) c;
                System.out.println("<" + e.name + "</" + e.name + ">");
            } else if (c instanceof Department) {
                Department d = (Department) c;
                d.printStructure(indentation + 1);
            }
        }
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("</" + this.name + ">");
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);
    }
}
