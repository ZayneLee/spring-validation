package hello.itemservice.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import hello.itemservice.domain.item.Item;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class BeanValidationTest {
    
    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> validations = validator.validate(item);
        for (ConstraintViolation<Item> constraintViolation : validations) {
            System.out.println("constraintViolation : "+constraintViolation);
            System.out.println("constraintViolation message : "+constraintViolation.getMessage());
        }
    }
}
