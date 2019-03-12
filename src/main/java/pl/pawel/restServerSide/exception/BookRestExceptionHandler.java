package pl.pawel.restServerSide.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleEXception(BookNotFoundException exc ){
		
		BookErrorResponse error = new BookErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<BookErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleException(Exception exc){
		
		BookErrorResponse error = new BookErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<BookErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
