package _2_ValidationConstraints;

import _2_ValidationConstraints.model.Item;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

public class TestValidationConstraints {
    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Item item = new Item();
        item.setName("Some name");
        item.setAuctionEnd(new Date());

        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        // We have one validation error, auction end date was not in the future
        System.out.println(violations.size());

        ConstraintViolation<Item> violation = violations.iterator().next();
        String failedPropertyName =
                violation.getPropertyPath().iterator().next().getName();
        System.out.println(failedPropertyName);

        System.out.println(violation.getMessage());
    }
}
