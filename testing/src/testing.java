import java.util.LinkedList;

public class testing {


    public static void main(String [] args){
//        int[] array = {3,1,5,3,6,7};
//        int temp;
//        boolean redo = true;
//        if(redo = true){
//            for(int i = 0; i < array.length-1; i++){
//                if(array[i] > array[i+1]){
//                    temp = array[i+1];
//                    array[i+1] = array[i];
//                    array[i] = temp;
//                    redo = true;
//                }
//                else {
//                    redo = false;
//                }
//            }
//            for(int j = 0; j < array.length; j++){
//                System.out.println(array[j]);
//            }
//        }
        int i, j, row = 6;
//Outer loop work for rows
        for (i=0; i<row; i++)
        {
//inner loop work for space
            for (j=row-i; j>1; j--)
            {
//prints space between two stars
                System.out.print(" ");
            }
//inner loop for columns
            for (j=0; j<=i; j++ )
            {
//prints star
                System.out.print("* ");
            }
//throws the cursor in a new line after printing each line
            System.out.println();
        }

    }
}
