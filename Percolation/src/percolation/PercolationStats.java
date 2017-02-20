/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 *
 * @author Rykhalskyi
 */

public class PercolationStats {

    private int _n;
    private int _trials;
    private double[] _thresholds;
    
    public PercolationStats(int i, int trials)
    {
        if (i<=0 || trials<=0)
        {
            throw new java.lang.IllegalArgumentException("Illegal arguments");
        }
        
        _n = i;
        _trials = trials;
        _thresholds = new double[_trials];
        
        MakeTrials();
    }
    
    public double mean()
    {
        return StdStats.mean(_thresholds);
    }
    
    public double stddev()
    {
        return StdStats.stddev(_thresholds);
    }
    
    public double confidenceLo() 
    {
        return mean()-(1.96*stddev())/Math.sqrt(_trials);
    }
    
    public double confidenceHi() 
    {
        return mean()+(1.96*stddev())/Math.sqrt(_trials);
    }
    
  // public double confidenceHi() 
    
    private void MakeTrials()
    {
            for (int trial=0; trial<_trials; trial++) {
                double step = 0;
                Percolation percolation = new Percolation(_n);

                while (!percolation.percolates()) {
                    int i = StdRandom.uniform(_n);
                    int j = StdRandom.uniform(_n);

                    if (percolation.open(i, j)) {
                        step++;
                    }
                }
                
                _thresholds[trial] = step / (_n*_n);
            }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
            if (args.length != 2)
            {
                throw new java.lang.IllegalArgumentException("Waiting for N, TRIALS arguments");
            }
        
            int N = Integer.parseInt(args[0]);
            int Threats = Integer.parseInt(args[1]);
            
            PercolationStats stats = new PercolationStats(N, Threats);
            
            System.out.println("mean                    = "+stats.mean());
            System.out.println("stddev                  = "+stats.stddev());
            System.out.println("95% confidence interval = "+stats.confidenceLo()+ " , "+stats.confidenceHi());
            System.out.println();
        }
    }

