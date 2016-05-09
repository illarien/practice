
public class ShutterStock {

}


////implement Stack<Integer>, implement returntMin() - O(1)
//
//
//class MinStack {
//
////   private int mMinValue;
// private Stack<Integer> mValues;
// private Stack<Integer> mMins;
// 
// public MinStack() {
//     this.mMinValue = Integer.MAX_INTEGER;
//     this.mValues = new Stack<Integer>();
//     this.mMins = new Stack<Integer>();
// }
//
// public add(Integer value) {
//     if (value == null) {
//         throw new IllegalArgumentException();
//     }
//     
//     mValues.add(value);
//     
//     if (mMins.size() > 0) {
//         if (mMins.peak() > value) {
//             mMins.add(value);
//         }
//     } else {
//         mMins.add(value);
//     }
// }
// 
// public returnMin() {
//     if (mMins.size < 1) {
//         return null;
//     }
//     return mMin.peak();
// }
//
// public Integer pop() {
//     if (mMins.size < 1 || mValues.size() < 1) {
//         return null;
//     }
// 
//     if (mMins.peak() == mValues.peak()) {
//         mMins.pop();
//     }
//     return mValues.pop();
// }
//} 
//
//
//
//
//12       
//15
//10      10
//Stack   Min
//
//
//
//Main    minstack
//pop  10            10
//push 8,10          8
//pop  10           10 
//pop  15,10        10
//push 6,15,10       6,10,15
//
//
//pop  empty
//pop  10           10
//push 15,10        10,15
//push 10           10
//
