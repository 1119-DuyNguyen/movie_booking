package com.tech_symfony.movie_booking.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadOrder {

	private static final Logger log = LoggerFactory.getLogger(LoadOrder.class);

	@Bean
	CommandLineRunner initDatabase(OrderRepository orderRepository) {

		return args -> {

			orderRepository.save(new Order("MacBook Pro", OrderStatus.COMPLETED));
			orderRepository.save(new Order("iPhone", OrderStatus.IN_PROGRESS));

			orderRepository.findAll().forEach(order -> {
				log.info("Preloaded " + order);
			});

		};
	}
}