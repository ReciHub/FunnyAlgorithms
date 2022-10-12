
//We are given rod and we need to cut the rod until we left with no size  according to the prices associated with the index of the rod at which we are making cut.

// Our task is to maximize the cut  price

let dp = [];

function maximize_cut_price( cut_prices , n ){

if(n == 0) return 0;
  
  if( dp[n-1] ) return dp[n - 1] ;
  
  let result=0;

  for( let i = 0 ;i < n ; ++i)
    
result=Math.max(result,cut_prices[i] + maximize_cut_price( cut_prices , n- i-1 ) );


  return dp[n - 1] = result;
}

let cut_prices = [1, 5, 8, 9, 10, 17, 17, 20];

let n = 8 ;
 
dp = Array( n ).fill( 0 );


let price = maximize_cut_price( cut_prices , n ) ;

console.log( price ) ; //22
