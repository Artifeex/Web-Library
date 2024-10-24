package com.sandr.web_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;

@SpringBootApplication
public class WebLibraryApplication {
	private ThreadLocal<Integer> a = new ThreadLocal<>();

	public static void main(String[] args) {
		//SpringApplication.run(WebLibraryApplication.class, args);
		//Executors.newWorkStealingPool()


	}

}
