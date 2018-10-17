module repository {

    exports com.cognizant.sharecar.repository.spi;
    exports com.cognizant.sharecar.repository.entity;
    exports com.cognizant.sharecar.repository.specifications;

    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.data.jpa;
    requires java.persistence;
    requires commons;
}