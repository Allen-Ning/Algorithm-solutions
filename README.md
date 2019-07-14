419. Battleships in a Board
https://blog.csdn.net/camellhf/article/details/52871104

791. Custom Sort Strin
https://leetcode.com/problems/custom-sort-string/discuss/116615/Java-5-ms-10-line-counting-solution-with-comment

421. Maximum XOR of Two Numbers in an Array
https://kingsfish.github.io/2017/12/15/Leetcode-421-Maximum-XOR-of-Two-Numbers-in-an-Array/

142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything:wq

//                  a        b 
//         start ------->-------->meeting
//                      |         |
//                      <----------
//                           c
//         assume fast and slow meets at k steps
//         k=a+b+r1(b+c) slow runs r1 cycles
//         2k=a+b+r2(b+c) fast runs r2 cycles
//         2k=a+b+r2(b+c)=2a+2b+2r1(b+c)
//         (b+c)(r2-2r1)=a+b => (b+c)n=a+b
//         a=(n-1)b+nc=(n-1)(b+c)+c which means when slow moves (n-1) cycles and c, start moves a

31. https://www.cnblogs.com/yuzhangcmu/p/4221998.html

135. https://leetcode.com/problems/candy/discuss/42774/Very-Simple-Java-Solution-with-detail-explanation (grahp on note book)

319. 1.https://blog.csdn.net/baidu_23318869/article/details/50386323
     2.https://blog.csdn.net/qq508618087/article/details/50517503

322. qustion 322 and question 279 are done by the same way

331. https://blog.csdn.net/fuxuemingzhu/article/details/79537797

421. https://kingsfish.github.io/2017/12/15/Leetcode-421-Maximum-XOR-of-Two-Numbers-in-an-Array/

Knowledge
1. change 1 bit from 0 (1) to 1 (0)
1.1
  xxxxxxxxxxxxx0xxx
^ 00000000000001000
----------------------
  xxxxxxxxxxxxx1xxx

1.2
  xxxxxxxxxxxxx1xxx
^ 00000000000001000
----------------------
  xxxxxxxxxxxxx0xxx

1.2 change 2 bits from 0s (1s) to 1s (0s)
  xxxx1xxxxxxxx0xxx
^ 00001000000001000
----------------------
  xxxx0xxxxxxxx1xxx

2. if a ^ b = x
   -> a ^ x = b;
   -> x ^ a = b;
   -> b ^ x = a;
   -> x ^ b = a;


