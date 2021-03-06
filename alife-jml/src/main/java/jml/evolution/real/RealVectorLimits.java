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
package jml.evolution.real;

/**
 * <p>Title: double[]GenomeLimits</p>
 * <p>Description: Class representing the genome information of a double[]</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class RealVectorLimits {
  /**
   * Minimum values that can take a double[] (per component)
   */
  public double[] min = null;

  /**
   * Maximum values that can take a double[] (per component)
   */
  public double[] max = null;
  /**
   * Maximum genes
   */
  public int max_genes;
  /**
   * Returns max_genes
   * @return Maximum genes
   */
  public int getMaxGenes() { return max_genes; }
  /**
   * Minimum genes
   */
  public int min_genes;
  /**
   * Returns min_genes
   * @return Minimum genes
   */
  public int getMinGenes() { return min_genes; }
  /**
   * Creates A double[] genome information object with genomes of fixed length
   * @param min Minimum values that can take a double[] (per component)
   * @param max Maximum values that can take a double[] (per component)
   * @param max_genes Maximum genes
   * @param min_genes Minimun genes
   */
  public RealVectorLimits(double[] min, double[] max, int  max_genes, int min_genes) {
    this.min = min;
    this.max = max;
    this.max_genes = max_genes;
    this.min_genes = min_genes;
  }
  /**
   * Copy constructor
   * @param source Creates a Genome information object with the same information of
   * the object given
   */
  public RealVectorLimits(RealVectorLimits source) {
    min = source.min;
    max = source.max;
    max_genes = source.max_genes;
    min_genes = source.min_genes;
  }

  /**
   * Save the Genome information to a String
   * @return String with the information of the genome
   */
  public String toString() {
    StringBuffer sb = new StringBuffer();
    if( min != null && max != null ){
      sb.append("[min] " + min.toString() + "\n");
      sb.append("[max] " + max.toString() + "\n");
      sb.append("[max genes] " + max_genes + "\n");
      sb.append("[min genes] " + min_genes + "\n");
    }
    return sb.toString();
  }
}
