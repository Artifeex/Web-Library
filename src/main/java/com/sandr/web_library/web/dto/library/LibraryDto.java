package com.sandr.web_library.web.dto.library;

import com.sandr.web_library.web.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.sandr.web_library.web.dto.validation.ValidationConstants.MAX_LENGTH_LIBRARY_NAME;

@Data
public class LibraryDto {

    @NotNull(groups = OnUpdate.class, message = "Id must not be null")
    private Integer id;

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    @Length(max = MAX_LENGTH_LIBRARY_NAME,
            message = "Name length must be smaller than" + MAX_LENGTH_LIBRARY_NAME + " characters")
    private String name;

    @Valid
    private AddressDto address;
}
