package krasa.benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Start {
	public static void main(String[] args) throws RunnerException {
		int iter = 10;
		Options opt = new OptionsBuilder().include(ContainsIgnoreCase1.class.getSimpleName()).warmupIterations(iter)// number of times the warmup iteration
																													// should
																													// take
																											// place
				.measurementIterations(iter)// number of times the actual iteration should take place
				.forks(1)
				// .measurementTime(TimeValue.seconds(5))
				.build();

		new Runner(opt).run();
	}
}
