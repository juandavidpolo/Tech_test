package technical_test.technical_test.model;

public class CustomResponse<T> {
  private boolean success;
  private String message;
  private T data;

  public CustomResponse(boolean success, String message){
    this.success = success;
    this.message = message;
    this.data = null;
  }

  public CustomResponse(boolean success, String message, T data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  public boolean getSuccess() {
    return success;
  }
  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
}