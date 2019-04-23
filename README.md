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
