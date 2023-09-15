package com.jwts.jwts.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;

@OpenAPIDefinition(

        info = @Info(

                contact = @Contact(

                        name = "YerriSwamy",
                        email= "yerri.kotekal@gmail.com"

                ),
                     description = "Open APi Documentation For JWTS Gateway",
                     title = "JWTS GATEWAY SPECIFICATION",
                     version = "1.0.0"

                )



)
@SecurityScheme(

        name="bearerAuth",
        description = "JWT AUTHENTICATION",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {
}
