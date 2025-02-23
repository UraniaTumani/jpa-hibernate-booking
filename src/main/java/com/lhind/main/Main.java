package com.lhind.main;

import com.lhind.model.entity.Booking;
import com.lhind.model.entity.UserDetails;
import com.lhind.model.enums.BookingStatus;
import com.lhind.repository.BookingRepository;
import com.lhind.repository.UserDetailsRepository;
import com.lhind.repository.UserRepository;
import com.lhind.repository.impl.BookingRepositoryImpl;
import com.lhind.repository.impl.UserDetailsRepositoryImpl;
import com.lhind.repository.impl.UserRepositoryImpl;
import com.lhind.service.BookingService;
import com.lhind.service.impl.BookingServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
        public static void main(String[] args) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
            EntityManager entityManager = emf.createEntityManager();


            entityManager.getTransaction().begin();


            UserDetails userDetails = new UserDetails("uraniatumani4@gmail.com", "Doe", "gygyg","123456789");
            entityManager.persist(userDetails);


            entityManager.getTransaction().commit();

            System.out.println("UserDetails saved!");


            entityManager.close();
            emf.close();
        }
}