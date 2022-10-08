#include <bits/stdc++.h> 
using namespace std;
#define ll long long 
# define N 8

int n;

bool isValid(std::vector<std::vector<int>> &board,int row,int col)
{
    //check if a queen is in left
    for(int i=0;i<col;i++)
    {
        if(board[row][i])
          return false;
    }
    //check if a queen is in upper left diagnol
    for(int i=row, j=col; i>=0 and j>=0; i--,j--)
    {
        if(board[i][j])
          return false;
    }
    //check if a queen is in lower left diagnol
    for(int i=row, j=col; j>=0 and i<n; i++,j--)
    {
        if(board[i][j])
          return false;
    }
    return true;
}

bool solveNQueen(std::vector<std::vector<int>> &board, int col)
{
    if(col>=n)
       return true;
    for(int i=0;i<n;i++)
    {
        if(isValid(board,i,col))
        {
            board[i][col]=1;
            if(solveNQueen(board,col+1))
              return true;
            board[i][col]=0;
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int size;
	cin>>size;
	n=size;
//	int board[size][size];
	std::vector<std::vector<int>> board(size,std::vector<int>(size));
	for(int i=0;i<size;i++)
	 for(int j=0;j<size;j++)
	   board[i][j]=0;
	if(solveNQueen(board,0)==false)
	{
	    cout<<"No solution exist.";
	}
	else
	{
	    for(int i=0;i<n;i++)
	      {
	          for(int j=0;j<n;j++)
	        cout<<board[i][j]<<"\t";
	      cout<<endl;
	      }
	}
	
	
	return 0;
}