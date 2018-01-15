package br.com.censo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> _messages = new ArrayList<>();
    private List<String> _errors = new ArrayList<>();

    @JsonIgnore
    public List<String> getMessages() {
        return _messages;
    }

    public void setMessages(List<String> _messages) {
        this._messages = _messages;
    }

    @JsonIgnore
    public List<String> getErrors() {
        return this._errors;
    }

    public void setErrors(List<String> _errors) {
        this._errors = _errors;
    }

    public void addError(String error) {
        this.getErrors().add(error);
    }

    public void addMessage(String message) {
        this.getMessages().add(message);
    }

    public Boolean hasErrors() {
        return this.getErrors() != null && (this.getErrors() == null || this.getErrors().size() != 0);
    }

    public boolean validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<AbstractEntity>> constraintViolations = validator.validate(this);

        for (ConstraintViolation<AbstractEntity> constraintViolation : constraintViolations) {
            this.addError(constraintViolation.getMessage());
        }

        return !this.hasErrors();
    }


}
