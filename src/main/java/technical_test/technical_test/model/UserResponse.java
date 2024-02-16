package technical_test.technical_test.model;

public class UserResponse {
  private String firstName;
  private String middleName;
  private String lastName1;
  private String lastName2;
  private String phone;
  private String address;
  private String city;

  public UserResponse(
    String firstName,
    String middleName,
    String lastName1,
    String lastName2,
    String phone,
    String address,
    String city
  ) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName1 = lastName1;
    this.lastName2 = lastName2;
    this.phone = phone;
    this.address = address;
    this.city = city;
  }

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName1() {
    return lastName1;
  }
  public void setLastName1(String lastName1) {
    this.lastName1 = lastName1;
  }

  public String getLastName2() {
    return lastName2;
  }
  public void setLastName2(String lastName2) {
    this.lastName2 = lastName2;
  }

  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity(){
    return city;
  }
  public void setCity(String city){
    this.city = city;
  }
}