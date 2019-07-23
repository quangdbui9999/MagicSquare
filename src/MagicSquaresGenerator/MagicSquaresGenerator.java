/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 26th, 2018
 *  Description: The DRIVE FILE (MagicSquaresGenerator class) will use
 * the methods is defined in MagicSquaresGenerator class to run the
 * application.
 */

package MagicSquaresGenerator;

import java.util.Scanner;

/**
 * DRIVE FILE
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class MagicSquaresGenerator {
    public static void main(String[] args) {
        MagicSquares matrix;
        MagicSquares.instructions();
        Scanner cin = new Scanner(System.in);
        String runAgain = "";
        
        do{
            matrix = new MagicSquares();
            System.out.println("The " + matrix.getSize() + "x" 
                    + matrix.getSize() + " matrix square: \n" + matrix);
            matrix.outputRunAgain();
            runAgain = cin.nextLine();
        }while(runAgain.equalsIgnoreCase("y") || 
                runAgain.equalsIgnoreCase("Y"));
    }
}

/*
run:
Welcome to Generating Magic Squares Application is programmed by 
the Java Programming Language.
In this application, programmers will choose a number 
in the range from 1 to 15, and this number must be an ODD Value; 
otherwise, they must be
 enter again until they enter a number correctly.
After they enter an odd value in the range [1 - 15], the 
application will construct a Square Matrix with n by n size
 (n is la odd value from 1 to 15). Next, the application 
will put the number with value 1 in the first row and 
in the middle of the column of the Square Matrix. 
The next value (number 2) will be place at the position: 
MOVE UP ONE ROW AND TO THE RIGHT ONE COLUMN.
1) In the Square Matrix, if the current value is placed at the 
first row, the next value will be place in the last row 
(that means it is "wrapping" around to the last row). 
If the current value is placed at the last column, 
the next value will be place in the first column 
(that means it is "wrapping" around the right side 
of the board to the left side of the board).
2) If the next value have been filled already (that means the 
position for the next value have been filled (up one row 
and right one column) of current value) => The next value
 will place at the DOWN ONE ROW AND DO NOT CHANGE THE 
COLUMN of the current value.
Step 1 and 2 will repeat over and over, the board will be terminated
 if all the position in the Square Matrix is filled full
 position (the value = n * n). Example, if programmer choose
 number 7, the matrix is 7x7 size, application will construct 
a Square Matrix and terminated if value = 7 * 7 = 49 (all 
position have had the value).
After the application have constructed a Square Matrix, they will 
ask the programmers do they want to run again application.
 If they choose "y" or "Y", the application will 
run again and they will choose a number to construct a Square 
Matrix; otherwise, the application will be terminated.

Programmers enter the size of the magic square [1 - 15], 
and the size must be odd value, please: 0
Programmers enter the size of the magic square [1 - 15], 
Your size entered is invalid, 
can you check and enter another size, please?
and the size must be odd value, please: -1
Programmers enter the size of the magic square [1 - 15], 
Your size entered is invalid, 
can you check and enter another size, please?
and the size must be odd value, please: 16
Your size entered is invalid, 
Programmers enter the size of the magic square [1 - 15], 
can you check and enter another size, please?
and the size must be odd value, please: Quang Bui
Programmers enter the size of the magic square [1 - 15], 
Please enter an integer number.
and the size must be odd value, please: 6
Programmers enter the size of the magic square [1 - 15], 
Your size entered is invalid, 
can you check and enter another size, please?
and the size must be odd value, please: 5
The 5x5 matrix square: 
17	24	1	8	15	

23	5	7	14	16	

4	6	13	20	22	

10	12	19	21	3	

11	18	25	2	9	

Each row, column, main diagonal, and opposite diagonal sum
 of the 5X5 matrix to the same value: 65


Do you want to run the GENERATING MAGIC SQUARES APPLICATION again?: 
Enter "Y" or "y" to run agian.
Enter any key on the keyboard to finish 
the GENERATING MAGIC SQUARES APPLICATION.
We choose the character: Y

Programmers enter the size of the magic square [1 - 15], 
and the size must be odd value, please: 9
The 9x9 matrix square: 
47	58	69	80	1	12	23	34	45	

57	68	79	9	11	22	33	44	46	

67	78	8	10	21	32	43	54	56	

77	7	18	20	31	42	53	55	66	

6	17	19	30	41	52	63	65	76	

16	27	29	40	51	62	64	75	5	

26	28	39	50	61	72	74	4	15	

36	38	49	60	71	73	3	14	25	

37	48	59	70	81	2	13	24	35	

Each row, column, main diagonal, and opposite diagonal sum
 of the 9X9 matrix to the same value: 369


Do you want to run the GENERATING MAGIC SQUARES APPLICATION again?: 
Enter "Y" or "y" to run agian.
Enter any key on the keyboard to finish 
the GENERATING MAGIC SQUARES APPLICATION.
We choose the character: y

Programmers enter the size of the magic square [1 - 15], 
and the size must be odd value, please: 8
Your size entered is invalid, 
can you check and enter another size, please?
Programmers enter the size of the magic square [1 - 15], 
and the size must be odd value, please: 7
The 7x7 matrix square: 
30	39	48	1	10	19	28	

38	47	7	9	18	27	29	

46	6	8	17	26	35	37	

5	14	16	25	34	36	45	

13	15	24	33	42	44	4	

21	23	32	41	43	3	12	

22	31	40	49	2	11	20	

Each row, column, main diagonal, and opposite diagonal sum
 of the 7X7 matrix to the same value: 175


Do you want to run the GENERATING MAGIC SQUARES APPLICATION again?: 
Enter "Y" or "y" to run agian.
Enter any key on the keyboard to finish 
the GENERATING MAGIC SQUARES APPLICATION.
We choose the character: n
BUILD SUCCESSFUL (total time: 35 seconds)
*/