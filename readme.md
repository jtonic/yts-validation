
Use cases
==

#### Part 1
1. Validation at the service level using MethodValidationPostProcessor
2. Programmatically validation using the injected javax.validation.Validator
3. Controller requestBody validation with Errors
4. Custom validation

#### Part 2
1. JPA validation
2. i18n.  custom validation message
3. Multi field validation
4. Validation groups


Specifications
==
- JSR 303: Bean Validation v.1.0 
    http://beanvalidation.org/1.0/spec/
- JSR-000349 Bean Validation v.1.1
    http://beanvalidation.org/1.1/spec/


Dependencies
==
(all below are included in spring web started - spring boot)
- javax.validation:validation-api:1.1.0
- org.hibernate:hibernate-validator:5.3.5
- spring context


API
==
    spring-context
        org.springframework.validation
            @Validated
            Errors
            Validator
            BindingResults
        
    validation-api
        javax.validation
            Validator
            ValidatorContext
            ValidatorFactory
            
            ConstraintViolationException
            
            constaints
                @Min, @Max
                @NotNull
                @Pattern
                @Size
                @Null
                @Digits
                @Past
                @Future
    

    

