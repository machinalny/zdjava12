package org.zdjavapol12.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    private LocalDate hireDate;
    @DecimalMin(value = "1500.0")
    private Double salary;
    private boolean sickLeave;
    // Dodac plec jako ENUM. Salary liczone na podstawie sickLeave, Data urodzenia
}
