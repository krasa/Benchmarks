package krasa.benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)

public class ContainsIgnoreCase1 {

	@State(Scope.Thread)
	public static class MyState {
		public String s = "org.springframework.core.foo.bar.spring";
		public String search = "core";
		public String x = "xxx";
	}

	@Benchmark
	public boolean test_IJ(MyState state) {
		return com.intellij.openapi.util.text.StringUtil.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test_lang(MyState state) {
		return org.apache.commons.lang.StringUtils.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test_lang3(MyState state) {
		return org.apache.commons.lang3.StringUtils.containsIgnoreCase(state.s, state.search);
	}

	@Benchmark
	public boolean test_JDK(MyState state) {
		return state.s.toLowerCase().contains(state.search.toLowerCase());
	}

	@Benchmark
	public boolean test_notFound_IJ(MyState state) {
		return com.intellij.openapi.util.text.StringUtil.containsIgnoreCase(state.s, state.x);
	}

	@Benchmark
	public boolean test_notFound_lang3(MyState state) {
		return org.apache.commons.lang3.StringUtils.containsIgnoreCase(state.s, state.x);
	}

	@Benchmark
	public boolean test_notFound_JDK(MyState state) {
		return state.s.toLowerCase().contains(state.x.toLowerCase());
	}

	@Benchmark
	public boolean test_notFound_lang(MyState state) {
		return org.apache.commons.lang.StringUtils.containsIgnoreCase(state.s, state.x);
	}
}
