 function balanced_paranthesis( brackets ){
 
let count = 0;
   
   for(let i = 0 ; i < brackets.length ; ++i) {

       if( brackets[i] === ')' ) 
     
           count-- ;
      
      else 
     
          count++ ;
        
 
    }

   return count === 0 ;


 }


balanced_paranthesis ( '()()(()))' ) === 0 ? console.log( 'Paranthesis balanced ' ) : console.log( 'Paranthesis not balanced' );
