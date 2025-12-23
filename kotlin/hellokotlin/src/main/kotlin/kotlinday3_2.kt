fun main(){
  val x=listOf("A","B","C","D")
  for (i in x){
      println(i)
  }
  for(i in 0..100 step 3){
      print("$i ")
  }
   println()
    for(i in 10 downTo 0 step 1){
        print("${i/10.0} ")
    }
  println()
for (i in 5 until 98){print("$i ") }
  println()

 l1@for(i in 1..50)
     l2@for(j in 1..50) {
         print("X")
         if(i==2)continue@l1
         if(i==9)break@l1
             println("row= $i column= $j")
         print("X")
     }
repeat(10){
    println("hello world")}
}