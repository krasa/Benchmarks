package krasa.benchmarks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

public class CompareTo {
	/** much faster */
	protected static final Comparator<String> compareToIgnoreCase = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	};
	protected static final Comparator<String> toLowerCase = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.toLowerCase().compareTo(o2.toLowerCase());
		}
	};

	@State(Scope.Thread)
	public static class MyState {
		public String[] args = { "org.springframework : spring-context", "org.springframework : spring-beans", "com.fasterxml.jackson.core : jackson-databind",
				"commons-beanutils : commons-beanutils", "commons-io : commons-io", "com.fasterxml.jackson.core : jackson-core",
				"org.springframework : spring-aop", "com.fasterxml.jackson.core : jackson-annotations", "org.springframework : spring-beans",
				"org.easymock : easymock", "org.springframework : spring-expression", "org.springframework : spring-context",
				"org.springframework : spring-context", "commons-codec : commons-codec", "org.springframework : spring-core",
				"commons-logging : commons-logging", "org.springframework : spring-core", "org.apache.httpcomponents : httpclient",
				"org.tuckey : urlrewritefilter", "org.apache.httpcomponents : httpcore", "org.springframework.ws : spring-ws-core",
				"org.springframework : spring-core", "org.springframework : spring-core", "org.springframework : spring-beans",
				"org.springframework : spring-core", "org.apache.httpcomponents : httpcore", "commons-logging : commons-logging",
				"commons-logging : commons-logging", "org.springframework : spring-beans", "org.springframework : spring-aop",
				"org.springframework.ws : spring-xml", "org.springframework : spring-beans", "org.springframework : spring-web", "org.slf4j : slf4j-api",
				"org.hamcrest : hamcrest-core", "org.springframework : spring-core", "io.netty : netty-all", "net.sf.trove4j : trove4j",
				"io.vertx : vertx-platform", "org.objenesis : objenesis", "org.apache.commons : commons-lang3", "junit : junit", "org.aspectj : aspectjweaver",
				"org.apache.httpcomponents : httpcore", "org.springframework : spring-core", "org.springframework : spring-context",
				"com.github.krasa.laboratory : commons-test", "javax.servlet : javax.servlet-api", "org.springframework : spring-core", "io.vertx : vertx-core",
				"org.slf4j : jcl-over-slf4j", "org.hamcrest : hamcrest-core", "cglib : cglib-nodep", "commons-collections : commons-collections",
				"org.apache.httpcomponents : httpasyncclient", "org.slf4j : slf4j-api", "org.springframework : spring-web", "org.springframework : spring-core",
				"org.mockito : mockito-core", "org.springframework : spring-core", "org.apache.httpcomponents : httpcore-nio", "ch.qos.logback : logback-core",
				"commons-logging : commons-logging", "log4j : log4j", "aopalliance : aopalliance", "org.slf4j : slf4j-api",
				"org.springframework : spring-webmvc", "commons-logging : commons-logging", "com.google.guava : guava", "org.tuckey : urlrewritefilter",
				"org.objenesis : objenesis", "org.mockito : mockito-core", "org.springframework : spring-expression", "ch.qos.logback : logback-classic",
				"org.springframework : spring-context-support", "com.fasterxml.jackson.core : jackson-core", "org.apache.httpcomponents : httpclient",
				"commons-logging : commons-logging", "org.springframework : spring-test", "org.springframework : spring-oxm",
				"org.springframework : spring-beans", "org.springframework : spring-aop" };
	}

	@Benchmark
	public List<String> compareToIgnoreCase(MyState state) {
		List<String> list = Arrays.asList(state.args);
		Collections.sort(list, compareToIgnoreCase);
		return list;
	}

	@Benchmark
	public List<String> toLowerCase(MyState state) {
		List<String> list = Arrays.asList(state.args);
		Collections.sort(list, toLowerCase);
		return list;
	}
}
