package com.sandr.web_library.web.dto.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.sandr.web_library.web.dto.validation.ValidationConstants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotNull(message = "Country must not be null")
    @NotEmpty(message = "Country must not be empty")
    @Length(max = MAX_LENGTH_COUNTY,
            message = "Country length must be smaller than" + MAX_LENGTH_COUNTY + " characters")
    private String country;

    @NotNull(message = "City must not be null")
    @NotEmpty(message = "City must not be empty")
    @Length(max = MAX_LENGTH_CITY,
            message = "City length must be smaller than" + MAX_LENGTH_CITY + " characters")
    private String city;

    @NotNull(message = "Street must not be null")
    @NotEmpty(message = "Street must not be empty")
    @Length(max = MAX_LENGTH_STREET,
            message = "Street length must be smaller than" + MAX_LENGTH_STREET + " characters")
    private String street;

    @NotNull(message = "Street must not be null")
    @NotEmpty(message = "Street must not be empty")
    @Length(min = LENGTH_POSTAL_CODE, max = LENGTH_POSTAL_CODE,
            message = "Postal code length must be " + LENGTH_POSTAL_CODE + " characters")
    private String postalCode;
}
