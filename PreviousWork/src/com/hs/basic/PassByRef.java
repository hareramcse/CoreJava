package com.hs.previouswork;

public class PassByRef {
	int i;
	public PassByRef(int i) {
		this.i=i;
	}
	public void test(PassByRef ref){
		ref.i=i+20;
	}
	
	public void finalize(){
		System.out.println("finalization called");
	}
	
	public static void main(String[] args) {
		int i=30;
		PassByRef ref=new PassByRef(i);
		ref.test(ref);
		System.out.println(ref.i);
		
		/**
	     * Runs the garbage collector.
	     * <p>
	     * Calling the <code>gc</code> method suggests that the Java Virtual
	     * Machine expend effort toward recycling unused objects in order to
	     * make the memory they currently occupy available for quick reuse.
	     * When control returns from the method call, the Java Virtual
	     * Machine has made a best effort to reclaim space from all discarded
	     * objects.
	     * <p>
	     * The call <code>System.gc()</code> is effectively equivalent to the
	     * call:
	     * <blockquote><pre>
	     * Runtime.getRuntime().gc()
	     * </pre></blockquote>
	     *
	     * @see     java.lang.Runtime#gc()
	     */
		System.gc();
		

	    /**
	     * Runs the finalization methods of any objects pending finalization.
	     * <p>
	     * Calling this method suggests that the Java Virtual Machine expend
	     * effort toward running the <code>finalize</code> methods of objects
	     * that have been found to be discarded but whose <code>finalize</code>
	     * methods have not yet been run. When control returns from the
	     * method call, the Java Virtual Machine has made a best effort to
	     * complete all outstanding finalizations.
	     * <p>
	     * The call <code>System.runFinalization()</code> is effectively
	     * equivalent to the call:
	     * <blockquote><pre>
	     * Runtime.getRuntime().runFinalization()
	     * </pre></blockquote>
	     *
	     * @see     java.lang.Runtime#runFinalization()
	     */
		System.runFinalization();
	}
}
