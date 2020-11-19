package luk.fisz.journal.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperFactory {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
