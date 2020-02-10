package main.message.mapper;

import org.mapstruct.Mapper;

import main.message.beans.RandomBean1;
import main.message.beans.RandomBean2;

@Mapper(componentModel = "spring")
abstract class Bean02FromBean01Mapping implements BaseMapping<RandomBean2,RandomBean1> {

}
