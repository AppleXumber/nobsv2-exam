package dev.wayron.nobsv2_exam.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);

    public ProductNotFoundException() {
        super("Product not found");
        logger.error("Exception: {} thrown", getClass());
    }
}
