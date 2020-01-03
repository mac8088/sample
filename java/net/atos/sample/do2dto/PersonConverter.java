package net.atos.sample.do2dto;

import org.mapstruct.Mapper;

import java.util.List;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonConverter {
	PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

	@Mappings({ @Mapping(source = "birthday", target = "birth"),
			@Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
			@Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
			@Mapping(source = "user.age", target = "age"), @Mapping(target = "email", ignore = true) })
	PersonDTO domain2dto(Person person);

	List<PersonDTO> domain2dto(List<Person> people);
}
