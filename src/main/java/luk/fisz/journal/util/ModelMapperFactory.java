package luk.fisz.journal.util;

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
