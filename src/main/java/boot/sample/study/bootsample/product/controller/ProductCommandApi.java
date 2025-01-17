package boot.sample.study.bootsample.product.controller;

import boot.sample.study.bootsample.product.usecase.ProductCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Validated
public class ProductCommandApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreateUseCase create(
            @RequestBody @Validated ProductCreateUseCase productCreateUseCase
    ){
        return null;
    }
}
