package co.edu.unicauca.fachadaServices.DTO.response;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ResponseDto<T> {
    private T data;
    private Integer status;
    private String message;

    public ResponseDto(T data, Integer status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ResponseEntity<ResponseDto<T>> of(){
        return ResponseEntity.status(this.status).body(this);
    }
}
