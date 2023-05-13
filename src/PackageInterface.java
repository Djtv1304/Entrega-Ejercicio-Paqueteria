import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PackageInterface {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textFieldEstimedTIme;
    private JButton agregarPaqueteButton;
    private JTextField textFieldNumeroRemover;
    private JButton removerPaqueteButton;
    private JButton insertarDatosQuemadosButton;
    private JTextArea textArea1;
    private JButton imprimirPaquetesButton;
    private JTextField textFieldBusquedaCiudad;
    private JTextField textFieldBusquedaSeguimiento;
    private JTextField textFieldBusquedaDestinatario;
    private JTextField textFieldStreetSender;
    private JTextField textFieldCitySender;
    private JTextField textFieldStateSender;
    private JTextField textFieldZipCodeSender;
    private JTextField textFieldStreetRecipient;
    private JTextField textFieldCityRecipient;
    private JTextField textFieldStateRecipient;
    private JTextField textFieldZipCodeRecipient;
    private JButton buscarPorDestinatarioButton;
    private JButton buscarPorSeguimientoButton;
    private JButton buscarPorCiudadButton;
    private TrackingSystem System;
public PackageInterface() {

    System = new TrackingSystem();

    agregarPaqueteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Address Sender = new Address(textFieldStreetSender.getText(),textFieldCitySender.getText(), textFieldStateSender.getText(),textFieldZipCodeSender.getText());
            Address Recipient = new Address(textFieldStreetRecipient.getText(),textFieldCityRecipient.getText(), textFieldStateRecipient.getText(),textFieldZipCodeRecipient.getText());

            Package Paquete = new Package(Sender,Recipient, textFieldEstimedTIme.getText());

            System.addPackage(Paquete);

        }
    });
    removerPaqueteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!System.getPackages().isEmpty()) {
                boolean confirmacion = System.removePackage(textFieldNumeroRemover.getText());
                if (confirmacion) {
                    JOptionPane.showMessageDialog(null,"Eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null,"Error al eliminar el paquete");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La lista de paquetes esta vacia.");
            }
        }
    });
    imprimirPaquetesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!System.getPackages().isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (Package p : System.getPackages()) {
                    sb.append(p.toString());
                }
                textArea1.setText(sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "La lista de paquetes esta vacia.");
            }
        }
    });
    insertarDatosQuemadosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Address Sender = new Address("Diego Toscano","Quito","Pichincha","170409");
            Address Recipient = new Address("Rommel Toscano","Queens", "New York","123456");

            Address Sender2 = new Address("Angelica Toscano","Cayambe","Cayambe","654321");
            Address Recipient2 = new Address("Josue Toscano","Quito", "Pichincha","007890");

            Package Paquete2 = new Package(Sender2,Recipient2,"4/7/2023");
            Package Paquete = new Package(Sender,Recipient,"3/6/2023");

            System.addPackage(Paquete);
            System.addPackage(Paquete2);

        }
    });
    buscarPorDestinatarioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!System.getPackages().isEmpty()) {
                Package Destinatario = System.searchByRecipientAddress(textFieldBusquedaDestinatario.getText());
                JOptionPane.showMessageDialog(null,"El destinatario tiene los siguientes datos:\n" + Destinatario.toString());
            } else {
                JOptionPane.showMessageDialog(null, "La lista de paquetes esta vacia.");
            }
        }
    });
    buscarPorSeguimientoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!System.getPackages().isEmpty()) {
                Package PaqueteEncontrado = System.searchByTrackingNumber(textFieldBusquedaSeguimiento.getText());
                JOptionPane.showMessageDialog(null,"El paquete con el tracking deseado tiene los siguientes datos:\n" + PaqueteEncontrado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "La lista de paquetes esta vacia.");
            }
        }
    });
    buscarPorCiudadButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int contador = 1;
            if (!System.getPackages().isEmpty()) {
                List<Package> PaquetesPorCiudad = System.searchByCity(textFieldBusquedaCiudad.getText());
                for (Package P : PaquetesPorCiudad) {
                    JOptionPane.showMessageDialog(null,"El paquete encontrado numero " + contador +" tiene los siguientes datos:\n" + P.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "La lista de paquetes esta vacia.");
            }
        }
    });
}
}
