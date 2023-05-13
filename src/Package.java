import java.time.LocalDate;
public class Package {
    private static int nextTrackingNumber = 1;
    private String trackingNumber;
    private Address senderAddress;
    private Address recipientAddress;
    private String estimatedDeliveryDate;

    public Package(Address senderAddress, Address recipientAddress, String estimatedDeliveryDate) {
        this.trackingNumber = "AS" + String.format("%03d", nextTrackingNumber);
        nextTrackingNumber++;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(Address recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String toString() {
        return "Tracking number: " + trackingNumber + "\n" +
                "Sender address: " + senderAddress + "\n" +
                "Recipient address: " + recipientAddress + "\n" +
                "Estimated delivery date: " + estimatedDeliveryDate+ "\n";
    }
}