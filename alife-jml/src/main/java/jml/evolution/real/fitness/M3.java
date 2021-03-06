package jml.evolution.real.fitness;



/**
 * <p>Title: M3 </p>
 * <p>Description: M3 Function as defined by De Jong</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class M3 extends M1 {
  /**
   * Evaluates the fitness function in the given real value
   * @param x value used for evaluating the fitness function
   * @return The fitness function value for the given value
   */

  public double eval( double x) {
    x = Math.pow( x, 0.75 ) - 0.05;
    return super.eval(x);
  }
}
