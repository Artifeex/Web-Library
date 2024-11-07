package com.sandr.web_library.web.dto.author;

import com.sandr.web_library.web.dto.validation.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.sandr.web_library.web.dto.validation.ValidationConstants.MAX_LENGTH_AUTHOR_NAME;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    @NotNull(groups = OnUpdate.class, message = "Id must be not null")
    private int id;

    @NotNull
    @NotEmpty
    @Length(max = MAX_LENGTH_AUTHOR_NAME,
            message = "Name length must be smaller than " + MAX_LENGTH_AUTHOR_NAME + " characters")
    private String name;
}
