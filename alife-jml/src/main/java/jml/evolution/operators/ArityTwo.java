/*
 * <copyright>
 *  Copyright 2004-2005 (Jonatan Gomez Solutions JG-Sol)
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the JML Open Source License as published by
 *  UN-Data Mining Group on the JML Open Source Website
 *  (http://dis.unal.edu.co/profesores/jgomez/projects/jml/index.htm).
 *
 *  THE JML SOFTWARE AND ANY DERIVATIVE SUPPLIED BY LICENSOR IS
 *  PROVIDED "AS IS" WITHOUT WARRANTIES OF ANY KIND, WHETHER EXPRESS OR
 *  IMPLIED, INCLUDING (BUT NOT LIMITED TO) ALL IMPLIED WARRANTIES OF
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE, AND WITHOUT
 *  ANY WARRANTIES AS TO NON-INFRINGEMENT.  IN NO EVENT SHALL COPYRIGHT
 *  HOLDER BE LIABLE FOR ANY DIRECT, SPECIAL, INDIRECT OR CONSEQUENTIAL
 *  DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE OF DATA OR PROFITS,
 *  TORTIOUS CONDUCT, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 *  PERFORMANCE OF THE JML SOFTWARE.
 *
 * </copyright>
 */
package jml.evolution.operators;

import java.util.Vector;

import jml.basics.Cloner;
import jml.evolution.Environment;
import jml.evolution.Individual;
import jml.evolution.Operator;
import jml.evolution.Population;
import jml.evolution.Selection;
import jml.evolution.selections.Tournament;

/**
 * <p>Title:ArityTwo</p>
 * <p>Description: A binary operator </p>
 * <p>Copyright:    Copyright (c) 2004</p>
 * <p>Company:Universidad Nacional de Colombia</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public abstract class ArityTwo extends Operator {
 /**
  * The parent selection mechanism
  */
  protected Selection selection;

  /**
   * Constructor: Create a arity-two operator with the Tournament selection strategy for
   * the parent selection (tournament size = 4) including the given individual
   */
  public ArityTwo(Environment _environment) {
    super(_environment);
    selection = new Tournament(environment, 2, true, 4);
  }

  /**
   * Constructor: Create a crossover operator with the given selection parent strategy
   */
  public ArityTwo(Environment _environment, Selection _selection) {
    super(_environment);
    selection = _selection;
    if (selection != null) { selection.setSize(2); }
  }

  /**
   * Sets the selection operator for the given two arity operator.
   * @param _selection Selection mechanism used by the operator for getting
   * the additional parent
   */
  public void setSelection(Selection _selection) {
    selection = _selection;
  }

  public Selection getSelection() { return selection; }

  /**
   * Apply the binary genetic operator over the individual
   * @param one First individual to be modified by the genetic operator
   * @param two Second individual to be modified by the genetic operator
   * @return extra information of the genetic operator
   */
  public abstract Object apply(Object one, Object two);

  /**
   * Apply the binary genetic operator over the individual
   * @param one First individual to be modified by the genetic operator
   * @param two Second individual to be modified by the genetic operator
   * @return extra information of the genetic operator
   */
  public Object apply(Individual one, Individual two) {
    return apply(one.getGenome(), two.getGenome());
  }

  /**
   * Apply the operator over the given individuals
   * @param population Source population
   * @param x Individual used as first parent
   * @return A collection of individuals generated by the operator
   */
  public Vector apply(Population population, int x) {
    Vector children = null;
    if (population != null && selection != null) {
      Vector parents = selection.choose(population, x);
      Individual child1 = (Individual) (Cloner.clone(parents.elementAt(0)));
      Individual child2 = (Individual) (Cloner.clone(parents.elementAt(1)));
      // only for two children
      apply(child1, child2);
      children = new Vector();
      children.add(child1);
      children.add(child2);
    }
    return children;
  }

  /**
   * Return the genetic operator arity
   * @return the genetic operator arity
   */
  public int getArity() { return 2; }

  public void setEnvironment(Environment _environment) {
    super.setEnvironment( _environment );
    selection.setEnvironment( environment );
  }

}