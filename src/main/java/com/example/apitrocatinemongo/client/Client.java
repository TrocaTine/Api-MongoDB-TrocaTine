
package com.example.apitrocatinemongo.client;

import com.example.apitrocatinemongo.models.DTO.LoginDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveQuestionsProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.*;
@FeignClient(
        value = "trocatine-external-api", // updated to be a valid identifier
        url = "https://api-spring-boot-trocatine.onrender.com/",
        configuration = FeignClientProperties.FeignClientConfiguration.class
)
public interface Client {
    @GetMapping("products/find-product-id/{idProduct}")
    boolean checkProductExist(@PathVariable Long idProduct);

    @PostMapping("api/auth/login")
    StandardResponseDTO token(@RequestBody LoginDTO loginDTO);

    @GetMapping("users/id-user/{email}")
    StandardResponseDTO idUser(@PathVariable String email);
}
