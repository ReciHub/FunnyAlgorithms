fn main(){
    /*
    let mut a: Vec<char> = vec!['a', 'c', 'b'];
    let _b = a.sort();
    println!("{}", &(_b));
    for i in &_b {
        println!("{}", i);
    }
    */
/*
    let v = vec!['a', 'c', 'b'];
    for i in &v {
        println!("{}", i);
    }*/

    
    let mut vec = vec!['a', 'b', 'f', 'd', 'p'];
    
    vec.sort();

    assert_eq!(vec, vec!['b', 'a', 'f', 'd', 'p']);
}