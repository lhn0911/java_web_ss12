package com.rikkei.ss12.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class StudentDTO {
    private int id;
    @NotBlank(message = "Tên không được để trống!")
    private String name;
    @Email(
            message = "Email không hợp lệ!")
    private String email;
    @Past(message = "Ngày sinh phải ngày quá khứ!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
}
