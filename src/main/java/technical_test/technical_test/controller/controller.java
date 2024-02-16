package technical_test.technical_test.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import technical_test.technical_test.model.UserResponse;
import technical_test.technical_test.model.CustomResponse;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class controller {

  @GetMapping("/user")
  public ResponseEntity<CustomResponse<UserResponse>> getUser(
      @RequestParam(name ="type", defaultValue = "") String type,
      @RequestParam(name = "number", defaultValue = "") String number) {
    String firstName = "Juan";
    String middleName = "David";
    String lastName1 = "Polo";
    String lastName2 = "Mendez";
    String phone = "3167530428";
    String address = "Carrera 12 # 32 - 43";
    String city = "Neiva";

    if(type == null || type.isEmpty()){
      CustomResponse<UserResponse> response = new CustomResponse<>(false, "Type parameter is required");
      return ResponseEntity.badRequest().body(response);
    }else{
      if (!("p".equals(type) || "c".equals(type))) {
        CustomResponse<UserResponse> response = new CustomResponse<>(false, "Invalid type: must be 'p' or 'c'");
        return ResponseEntity.badRequest().body(response);
      }
    }

    if(number == null || number.isEmpty()){
      CustomResponse<UserResponse> response = new CustomResponse<>(false, "Number parameter is required");
      return ResponseEntity.badRequest().body(response);
    }else{
      try {
        Long.parseLong(number);
      } catch (NumberFormatException e) {
        CustomResponse<UserResponse> response = new CustomResponse<>(false, "Invalid number: must be numeric");
        return ResponseEntity.badRequest().body(response);
      }
    }

    if ("500".equals(number)) {
      CustomResponse<UserResponse> response = new CustomResponse<>(false, "Internal server error. Contact with the support team");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    /*
     * For real cases it must be located in the catch part of the try catch
    */

    if (("c".equals(type) && "23445322".equals(number))) {
      UserResponse UserResponse= new UserResponse(firstName, middleName, lastName1, lastName2, phone, address, city);
      CustomResponse<UserResponse> response = new CustomResponse<>(true, "The user was found", UserResponse);
      return ResponseEntity.ok(response);
    }else {
      CustomResponse<UserResponse> response = new CustomResponse<>(false, "The user was not found");
      return ResponseEntity.ok(response);
    }
  }


  @GetMapping("/*")
  public ResponseEntity<CustomResponse<UserResponse>> getError() {
    CustomResponse<UserResponse> response = new CustomResponse<>(false, "Resource not found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
