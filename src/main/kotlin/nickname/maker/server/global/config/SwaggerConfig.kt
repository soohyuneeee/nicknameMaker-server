package nickname.maker.server.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    companion object {
        private const val API_NAME = "NICKNAME MAKER API";
        private const val API_VERSION = "0.0.1";
        private const val API_DESCRIPTION = "made by soohyuneeee";
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("nickname.maker.server.domain"))
                .paths(PathSelectors.any())
                .build();
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
}