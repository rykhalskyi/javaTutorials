/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author Rykhalskyi
 */
enum CellType
{
    Closed ,
    Open
            
}

public class Percolation {
    
    private int _openCount = 0;
    private int _lastNode;
    private int[] _matrix;
    private int N;
    
    private WeightedQuickUnionUF _uf;
    
    public boolean open(int i, int j)
    {
       VerifyAndThrow(i,j);
       boolean closedYet = !isOpen(i,j);
       if (closedYet) 
       {
           _openCount++;
           ConnectToNeighbors(i,j);
       }
       return closedYet;
    }
 
    private boolean isOpen(int i, int j)
    {
     //   VerifyAndThrow(i,j);
        return _matrix[CellNumber(i,j)] == 1;
    }
    
    public boolean isFull(int i, int j)
    {
         VerifyAndThrow(i,j);
        
         return _openCount == N*N;
    }
    
    public boolean percolates()
    {
        return _uf.connected(0, _lastNode);
    }
    
    public Percolation(int N)
    {
        if (N<=0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        _matrix = new int[N*N+2];
        
        this.N = N;
        _uf = new WeightedQuickUnionUF(N*N+2);
        _lastNode = N*N+1;
        
        InitialOpen();
    }
    
    /*private void PrintToScreen()
    {
        for (int j=0; j<N ; j++)
        {
            for (int i=0; i < N; i++)
            {
                System.out.print(_uf.find(CellNumber(j,i))+" ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        for (int j=0; j<N ; j++)
        {
            for (int i=0; i < N; i++)
            {
                System.out.print(_matrix[CellNumber(j,i)]+" ");
            }
            System.out.println();
        }
        
        System.out.println("-------------------");
    }*/
    
    private boolean VerifyAndThrow(int i, int j)
    {
        if (i<N && j<N && i>0 && j>0)
            return true;
        
        throw new java.lang.IndexOutOfBoundsException(i+","+j);
    }
    
    private void ConnectToNeighbors(int i, int j)
    {
        if (i>0 && isOpen(i-1,j)) 
            _uf.union(CellNumber(i-1, j), CellNumber(i,j));
        if (i<N-1 && isOpen(i+1,j)) 
            _uf.union(CellNumber(i+1, j), CellNumber(i,j));
        if (isOpen(i,j-1))
            _uf.union(CellNumber(i, j-1), CellNumber(i,j));
        if (isOpen(i, j+1))
            _uf.union(CellNumber(i, j+1), CellNumber(i,j));
        
        _matrix[CellNumber(i,j)] = 1;
    }
    
    private int CellNumber(int i, int j)
    {
        int result = 0;
        if (j==N)
        {
            result = N*N+1;
        }
        else if (j>=0)
        {
            result = j*N+i+1;
        }
        return  result; 
    }

    private void InitialOpen() {
        for (int i=0; i<N; i++)
        {
            _uf.union(0, CellNumber(i,0));
            _uf.union(N*N+1, CellNumber(i,N-1));
        }
        
        _matrix[0] = 1;
        _matrix[N+1] = 1;
    }
    
}
