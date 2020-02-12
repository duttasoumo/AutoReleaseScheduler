package main.message.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import main.message.beans.RandomBean0;
import main.message.beans.RandomBean1;
@Mapper(componentModel = "spring")
public abstract class Bean01FromBean00Mapping implements BaseMapping<RandomBean1,RandomBean0> {
	
	private static Bean01FromBean00Mapping INSTANCE=null;
	public static Bean01FromBean00Mapping getInstance() {
		if(INSTANCE==null) {
			INSTANCE=Mappers.getMapper( Bean01FromBean00Mapping.class );
		}
		return INSTANCE;
	}
}
