import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        PackageInterface Interface = new PackageInterface();
        Interface.setBounds(500,100,600,600);
        Interface.setContentPane(Interface.panelPrincipal);
        Interface.setVisible(true);
        Interface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}