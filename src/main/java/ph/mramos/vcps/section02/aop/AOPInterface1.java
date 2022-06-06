package ph.mramos.vcps.section02.aop;

public interface AOPInterface1 {

	default String runBefore(String str) { throw new UnsupportedOperationException(); }

	default String runAfterReturning(String str) { throw new UnsupportedOperationException(); }

	default String runAfterThrowing(String str) { throw new UnsupportedOperationException(); }

	default String runAfter(String str) { throw new UnsupportedOperationException(); }

	default String runAround(String str) { throw new UnsupportedOperationException(); }

	default String runExecution(String str) throws IllegalStateException { throw new UnsupportedOperationException(); }

	default String runWithin(String str) { throw new UnsupportedOperationException(); }

	default String runArgs(String str, double num) { throw new UnsupportedOperationException(); }

	default String runBean(String str) { throw new UnsupportedOperationException(); }

}
