import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackingSystem {
    private List<Package> packages;

    public TrackingSystem() {
        packages = new ArrayList<Package>();
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void addPackage(Package pkg) {
        for (Package p:packages) {
            if (p.getTrackingNumber().equals(pkg.getTrackingNumber())) {
                JOptionPane.showMessageDialog(null,"El TrackingNumber ya pertenece a otro paquete.");
            } else {
                packages.add(pkg);
            }
        }

    }

    public boolean removePackage(String trackingNumber) {
        for (Package pkg : packages) {
            if (pkg.getTrackingNumber().equals(trackingNumber)) {
                packages.remove(pkg);
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress(String recipientAddress) {
        for (Package pkg : packages) {
            if (pkg.getRecipientAddress().toString().equals(recipientAddress)) {
                return pkg;
            }
        }
        return null;
    }

    public Package searchByTrackingNumber(String trackingNumber) {
        //Ordeno los paquetes por su TrackingNumber
        Collections.sort(packages, (pkg1, pkg2) -> pkg1.getTrackingNumber().compareTo(pkg2.getTrackingNumber()));
        // Crea una lista de los números de seguimiento de los paquetes
        List<String> trackingNumbers = new ArrayList<>();
        for (Package pkg : packages) {
            trackingNumbers.add(pkg.getTrackingNumber());
        }
        // Ordena la lista de números de seguimiento
        Collections.sort(trackingNumbers);
        // Busca el índice del número de seguimiento en la lista utilizando búsqueda binaria
        int index = Collections.binarySearch(trackingNumbers, trackingNumber);
        // Si se encuentra el número de seguimiento, se devuelve el paquete correspondiente; de lo contrario, se devuelve null
        return index >= 0 ? packages.get(index) : null;
    }



    public List<Package> searchByCity(String city) {
        List<Package> result = new ArrayList<Package>();
        for (Package pkg : packages) {
            if (pkg.getRecipientAddress().getCity().equals(city)) {
                result.add(pkg);
            }
        }
        return result;
    }
}
