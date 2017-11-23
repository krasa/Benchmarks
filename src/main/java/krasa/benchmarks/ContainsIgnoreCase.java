package krasa.benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)

public class ContainsIgnoreCase {

	@State(Scope.Thread)
	public static class MyState {
		public String s = "org.springframework.core.foo.bar.spring";
		public String search = "core";
		public String x = "xxx";
	}

	@Benchmark
	public boolean test1_IJ(MyState state) {
		return com.intellij.openapi.util.text.StringUtil.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test2_lang(MyState state) {
		return org.apache.commons.lang.StringUtils.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test3_lang3(MyState state) {
		return org.apache.commons.lang3.StringUtils.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test4_JDK(MyState state) {
		return state.s.toLowerCase().contains(state.search.toLowerCase());
	}

	@Benchmark
	public boolean test5_IJ(MyState state) {
		return com.intellij.openapi.util.text.StringUtil.containsIgnoreCase(state.s, state.x);
	}

	@Benchmark
	public boolean test6_lang3(MyState state) {
		return org.apache.commons.lang3.StringUtils.containsIgnoreCase(state.s, state.x);
	}

	@Benchmark
	public boolean test7_JDK(MyState state) {
		return state.s.toLowerCase().contains(state.x.toLowerCase());
	}

	@Benchmark
	public boolean test8_lang(MyState state) {
		return org.apache.commons.lang.StringUtils.containsIgnoreCase(state.s, state.x);
	}
}
