package kr.co.greenuniv.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AppInfo appInfo(){
        return new AppInfo();
    }


    @Bean
    public ModelMapper modelmapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true);



        return modelMapper;

    }


}
