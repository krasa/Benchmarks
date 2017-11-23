package com.jenkov;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Start {
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Foo.class.getSimpleName()).warmupIterations(10)// number of times the warmup iteration should take
																											// place
				.measurementIterations(10)// number of times the actual iteration should take place
				.forks(1).build();

		new Runner(opt).run();
	}
}
