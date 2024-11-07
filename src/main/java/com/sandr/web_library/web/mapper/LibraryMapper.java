package com.sandr.web_library.web.mapper;

import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.web.dto.library.LibraryDto;
import org.mapstruct.Mapper;

//чтобы при создании Mappera он был создан как Spring Bean и повесилась аннотация @Component
@Mapper(componentModel = "spring")
public interface LibraryMapper extends Mappable<Library, LibraryDto> {
}
