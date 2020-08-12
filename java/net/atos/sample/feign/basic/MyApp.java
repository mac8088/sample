package net.atos.sample.feign.basic;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

public class MyApp {

	public static void main(String[] args) {
		GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

	    // Fetch and print a list of the contributors to this library.
	    List<Contributor> contributors = github.contributors("OpenFeign", "feign");
	    for (Contributor contributor : contributors) {
	      System.out.println(contributor.login + " (" + contributor.contributions + ")");
	    }
	    
	}

}
