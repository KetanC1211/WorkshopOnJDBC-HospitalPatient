public class PatientDetails {
    int id;
    String name;
    String phoneNumber;
    String Address;
    String email;

    int billAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public PatientDetails(String name, String phoneNumber, String address, String email, int billAmount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.email = email;
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "PatientDetails{" +
                "  name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                ", billAmount=" + billAmount +
                '}'+"\n";
    }
}
