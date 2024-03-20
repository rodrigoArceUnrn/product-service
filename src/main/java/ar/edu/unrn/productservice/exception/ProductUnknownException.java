package ar.edu.unrn.productservice.exception;

public class ProductUnknownException extends Throwable {
    public ProductUnknownException(String message) {
        super(message);
    }
}