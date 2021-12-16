package org.acme;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import com.github.javafaker.Faker;

@Entity
public class FakePerson extends PanacheEntity{
        
        @Column(length = 20)
        public String name;

        @Column(length = 50)
        public String surname;

        @Column(length = 50)
        public String pesel;

        @Column(length = 50)
        public String date-of-birth;

        @Column(length = 50)
        public String email;

        @Column(length = 50)
        public String telephone;

        @Column(length = 50)
        public String address;

        @Column(length = 50)
        public String postal-code;

        @Column(length = 50)
        public String city;

        @Column(length = 50)
        public String country;

public FakePerson() {

        Faker faker = new Faker(new Locale("pl-PL"));

        this.name = faker.name().firstName();
        this.surname = faker.name().lastName();
        this.pesel = faker.idNumber().validSvSeSsn();
        this.date-of-birth = faker.backToTheFuture().date();
        this.email = faker.internet().emailAddress();
        this.telephone = faker.phoneNumber().cellPhone();
        this.address = faker.address().streetAddress();
        this.postal-code = faker.address().zipCode();
        this.city = faker.address().cityName();
        this.country = "Polska";
}
public String toStringFakePerson() {
        return this.name +" "+ this.surname +" "+ this.pesel +" "+ this.date-of-birth +" "+ 
               this.email +" "+ this.telephone +" "+ this.address +" "+ this.postal-code +" "+ 
               this.city +" "+ this.country;
}        

}
