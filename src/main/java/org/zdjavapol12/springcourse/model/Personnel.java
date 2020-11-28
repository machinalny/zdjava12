package org.zdjavapol12.springcourse.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Length(min = 5, max = 25)
    private String firstName;
    private String lastName;
    private String position;
//    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    @DecimalMin(value = "1500.0")
    private Double salary;
    private boolean sickLeave;
    // Dodac plec jako ENUM. Salary liczone na podstawie sickLeave, Data urodzenia
}
