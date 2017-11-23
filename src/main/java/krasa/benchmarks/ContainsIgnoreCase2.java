package krasa.benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)

public class ContainsIgnoreCase2 {

	@State(Scope.Thread)
	public static class MyState {
		public String[] args = { "org.aspectj : aspectjweaver", "commons-beanutils : commons-beanutils", "commons-collections : commons-collections",
				"commons-logging : commons-logging", "commons-io : commons-io", "org.apache.commons : commons-lang3",
				"com.github.krasa.laboratory : commons-test", "org.easymock : easymock", "cglib : cglib-nodep", "org.objenesis : objenesis", "junit : junit",
				"org.hamcrest : hamcrest-core", "org.mockito : mockito-core", "org.springframework : spring-test", "org.springframework : spring-core",
				"org.tuckey : urlrewritefilter", "com.google.guava : guava", "org.apache.httpcomponents : httpasyncclient", "commons-logging : commons-logging",
				"org.apache.httpcomponents : httpclient", "org.apache.httpcomponents : httpcore", "org.apache.httpcomponents : httpcore-nio",
				"org.apache.httpcomponents : httpcore", "org.apache.httpcomponents : httpclient", "commons-codec : commons-codec",
				"commons-logging : commons-logging", "org.apache.httpcomponents : httpcore", "javax.servlet : javax.servlet-api", "org.slf4j : jcl-over-slf4j",
				"org.slf4j : slf4j-api", "ch.qos.logback : logback-classic", "ch.qos.logback : logback-core", "org.mockito : mockito-core",
				"org.hamcrest : hamcrest-core", "org.objenesis : objenesis", "org.slf4j : slf4j-api", "org.springframework : spring-aop",
				"aopalliance : aopalliance", "org.springframework : spring-beans", "org.springframework : spring-core", "org.springframework : spring-context",
				"org.springframework : spring-aop", "org.springframework : spring-beans", "org.springframework : spring-core",
				"org.springframework : spring-expression", "org.springframework : spring-core", "org.springframework : spring-context-support",
				"org.springframework : spring-beans", "org.springframework : spring-context", "org.springframework : spring-core",
				"org.springframework : spring-core", "commons-logging : commons-logging", "org.springframework : spring-oxm",
				"org.springframework : spring-beans", "org.springframework : spring-core", "org.springframework : spring-core",
				"org.springframework : spring-web", "org.springframework : spring-aop", "org.springframework : spring-beans",
				"org.springframework : spring-context", "org.springframework : spring-core", "org.springframework : spring-webmvc",
				"org.springframework : spring-beans", "org.springframework : spring-context", "org.springframework : spring-core",
				"org.springframework : spring-expression", "org.springframework : spring-web", "org.springframework.ws : spring-ws-core",
				"commons-logging : commons-logging", "org.springframework.ws : spring-xml", "commons-logging : commons-logging", "net.sf.trove4j : trove4j",
				"org.tuckey : urlrewritefilter", "io.vertx : vertx-platform", "io.vertx : vertx-core", "com.fasterxml.jackson.core : jackson-core",
				"com.fasterxml.jackson.core : jackson-databind", "com.fasterxml.jackson.core : jackson-annotations",
				"com.fasterxml.jackson.core : jackson-core", "log4j : log4j", "io.netty : netty-all", "org.slf4j : slf4j-api" };

		public String[] searches = { "c", "co", "cor", "core", "xxx" };
	}

	@Benchmark
	public int test1_IJ(MyState state) {
		int x = 0;
		String[] args = state.args;
		String[] searches = state.searches;
		for (int i = 0, sLength = args.length; i < sLength; i++) {
			String arg = args[i];
			for (int j = 0, searchLength = searches.length; j < searchLength; j++) {
				String search = searches[j];
				if (com.intellij.openapi.util.text.StringUtil.containsIgnoreCase(arg, search)) {
					x++;
				}
			}
		}
		return x;
	}

	@Benchmark
	public int test2_lang(MyState state) {
		int x = 0;
		String[] args = state.args;
		String[] searches = state.searches;
		for (int i = 0, sLength = args.length; i < sLength; i++) {
			String arg = args[i];
			for (int j = 0, searchLength = searches.length; j < searchLength; j++) {
				String search = searches[j];
				if (org.apache.commons.lang.StringUtils.containsIgnoreCase(arg, search)) {
					x++;
				}
			}
		}
		return x;
	}

	@Benchmark
	public int test3_lang3(MyState state) {
		int x = 0;
		String[] args = state.args;
		String[] searches = state.searches;
		for (int i = 0, sLength = args.length; i < sLength; i++) {
			String arg = args[i];
			for (int j = 0, searchLength = searches.length; j < searchLength; j++) {
				String search = searches[j];
				if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(arg, search)) {
					x++;
				}
			}
		}
		return x;
	}

	@Benchmark
	public int test4_JDK(MyState state) {
		int x = 0;
		String[] args = state.args;
		String[] searches = state.searches;
		for (int i = 0, sLength = args.length; i < sLength; i++) {
			String arg = args[i];
			for (int j = 0, searchLength = searches.length; j < searchLength; j++) {
				String search = searches[j];
				if (arg.toLowerCase().contains(search.toLowerCase())) {
					x++;
				}
			}
		}
		return x;
	}

	@Benchmark
	public int test4_JDK_notLowercase(MyState state) {
		int x = 0;
		String[] args = state.args;
		String[] searches = state.searches;
		for (int i = 0, sLength = args.length; i < sLength; i++) {
			String arg = args[i];
			for (int j = 0, searchLength = searches.length; j < searchLength; j++) {
				String search = searches[j];
				if (arg.contains(search)) {
					x++;
				}
			}
		}
		return x;
	}
}
