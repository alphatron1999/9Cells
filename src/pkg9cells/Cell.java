/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cells;

/**
 *
 * @author Alphatron99
 */
public class Cell {
    int data[][]=new int[3][3];
    final static int AISeed=1;
    final static int OpSeed=2;
    Cell()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                data[i][j]=0;
            }
        }
    }
    boolean isEmpty(int row,int col)
    {
       return data[row][col]==0;
    }
    void insert(int[] place,int player)
    {
        data[place[0]][place[1]]=player;
    }
    int EvaluateLine(int r1,int c1,int r2,int c2,int r3,int c3)
    {
        int score=0;
        //First pair check
        if(data[r1][c1]==AISeed)
        {
            score=1;
        }
        else if(data[r1][c1]==OpSeed)
        {
            score=-1;
        }
        //Second pair check
        if(score>0)
        {
            if(data[r2][c2]==AISeed) score=10;
            else if(data[r2][c2]==OpSeed) return 0;
        }
        else if(score<0)
        {
            if(data[r2][c2]==OpSeed) score=-10;
            else if(data[r2][c2]==AISeed) return 0;
        }
        else
        {
            if(data[r2][c2]==AISeed)
            {
                score=1;
            }
            else if(data[r2][c2]==OpSeed)
            {
                score=-1;
            }
        }
        //Third pair check
        if(score>0)
        {
            if(data[r3][c3]==AISeed) score*=10;
            else if(data[r3][c3]==OpSeed) return 0;
        }
        else if(score<0)
        {
            if(data[r3][c3]==OpSeed) score*=10;
            else if(data[r3][c3]==AISeed) return 0;
        }
        else
        {
            if(data[r3][c3]==AISeed)
            {
                score=1;
            }
            else if(data[r3][c3]==OpSeed)
            {
                score=-1;
            }
        }
        return score;
    }
    boolean hasWon(int player)
    {
        int check=0;
        if(player==AISeed)
        {
            check=100;
        }
        else if(player==OpSeed)
        {
            check=-100;
        }
        return ((check==EvaluateLine(0,0,1,0,2,0))||(check==EvaluateLine(0,1,1,1,2,1))||(check==EvaluateLine(0,2,1,2,2,2))||(check==EvaluateLine(0,0,0,1,0,2))||(check==EvaluateLine(1,0,1,1,1,2))||(check==EvaluateLine(2,0,2,1,2,2))||(check==EvaluateLine(0,0,1,1,2,2))||(check==EvaluateLine(2,0,1,1,0,2)));
    }
}
