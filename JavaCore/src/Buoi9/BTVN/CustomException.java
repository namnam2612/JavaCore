package Buoi9.BTVN;

/**
 Class CustomException là một lớp ngoại lệ tùy chỉnh kế thừa từ RuntimeException, có hai constructor:

 Constructor không tham số với thông điệp mặc định "Custom Exception".
 Constructor với tham số để cung cấp thông điệp tùy chỉnh.
 */
public class CustomException extends RuntimeException {
    public CustomException() {
        super("Custom Exception");
    }

    public CustomException(String message) {
        super(message);
    }
}
