/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 26th, 2018
 *  Description: The MagicSquares class will create a Square Matrix, the 
 * number 1 (the first position to build the Square Matrix) will be placed
 * at the first row and in the middle column of the Square Matrix.
 * First, programmers will run application and input the number in the
 * rang [1 - 15] and must be an odd value.
 * The Rule to build a Square Matrix: MOVE UP ONE ROW AND MOVE TO THE
 * RIGHT ONE COLUMN.
 * 1) If the next position is taken, keep up the column original and
 * move down one row
 * 2) If the current row is the first row of the Square Matrix, wrapping
 * around to the last row (next position will be place in the 
 * last row and move to the right one column).
 * 3) If the current column is the last column of the Square Matrix,
 * wrapping around to the first column (next postion will be placed at
 * first column and move up one row of the Square Matrix).
 * The buildSquare() method will be terminated if the all the positions
 * in the Square Matrix (all position have value).
 * Afther the buildSquare() method finished run, the application will
 * output the Aquare Matrix and the value of the each row, column, and 
 * diagonal's sum of this Square Matrix.
 * The programmers can run a application multiple time if they want.
 */

package MagicSquaresGenerator;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 29th, 2018
 * Description: 
 */
public class MagicSquares {
    private static final int MAX = 15;
    private int[][] mSquare;
    private int level;
    private final int size;
    
    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: the initializeMatrix(), getLevel(), and inputSize()
     * methods must be defined
     * Post-condition: initialize a matrix square with the level of a
     * matrix is entered from the programmer. After that this method will
     * use the getLevel() method to get the level of a matrix and assign
     * to size variable (size: the size of the matrix). Then, create a
     * matrix with the size have been defined. This method call the
     * initializeMatrix() to create all the element in the matrix with
     * 0 value and assigned 1 to the position (first row and middle column)
     */
    public MagicSquares(){
        this.inputSize();
        size = this.getLevel();
        mSquare = new int[size][size];
        initializeMatrix();
        // put 1 in the first row at middle colum
        mSquare[0][size / 2] = 1;
    }
    
    /**
     * Muatator: initializeMatrix()
     * Pre-condition: none
     * Post-condition: initializeMatrix() to create all the element in 
     * the matrix with 0 value.
     */
    private void initializeMatrix(){
        for(int row = 0; row < mSquare.length; row++){
            for(int col = 0; col < mSquare[row].length; col++){
                mSquare[row][col] = 0;
            }
        }
    }
    
    /**
     * Muatator: inputSize()
     * Pre-condition: the checkOddValue() method must be defined
     * Post-condition: input the level of the matrix. Programmers only
     * enter the number from 1 to 15 and the level must be an odd value.
     * If not, programmers is reminded to enter again, 
     * they can not input the alphabetic or symbol character.
     */
    private void inputSize(){
        Scanner cin = new Scanner(System.in);
        boolean flag = false;
        System.out.println();
        do{
            try{
                do{
                    System.out.print("Programmers enter the size "
                            + "of the magic square [1 - 15], \nand the"
                            + " size must be odd value, please: ");
                    level = Integer.parseInt(cin.nextLine());

                    if(checkOddValue() == false){
                        System.err.println("Your size entered is "
                                + "invalid, \ncan you check and enter "
                                + "another size, please?");
                    }
                }while(checkOddValue() == false);
                flag = true;
            }catch(NumberFormatException exception){
                System.err.println("Please enter an integer number.");
                flag = false;
            }
            
        }while(flag == false);
    }
    
    /**
     * Accessor: checkOddValue()
     * Pre-condition: none
     * Post-condition: the value of level variable must be in the range
     * [1 - 15] and an odd value => checkOddValue() return true
     * Otherwise, checkOddValue() return false
     */
    private boolean checkOddValue(){
        boolean flag = false;
        
        if(1 <= level && level <= MAX){
            if(level % 2 != 0){
                flag = true;
            }
        }
        return flag;
    }
    
    /**
     * Accessor: getLevel()
     * return level;
     * Pre-condition: none
     * Post-condition: get the value of level variable and use this method
     * to assign the size of the matrix.
     */
    public final int getLevel(){
        return level;
    }
    
    /**
     * Accessor: getSize()
     * return level;
     * Pre-condition: none
     * Post-condition: get the value of size variable and use this method
     * to get the size's value in the main function.
     * Purpose: Notify the programmers what size they entered.
     */
    public final int getSize(){
        return size;
    }
    
    /**
     * Accessor: toString
     * @return out (the form of the square matrix)
     * Pre-condition: none
     * Post-condition: output the square matrix (have been built) and
     * information of the pivot value
     */
    public String toString(){
        String out = "";
        buildSquare();
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                out += mSquare[row][col] + "\t";
            }
            out += "\n\n";
        }
        out += this.tallyLogic() + "\n\n";
        return out;
    }
    
    /**
     * Mutator: buildSquare
     * Construct the Magic Square from 2 - size * size
     * Pre-condition: none
     * Post-condition: build the Magic Square
     */
    private void buildSquare(){
        int step = 1; // the value from 1 to (size * size)
        // nextRow: the next position of row in the Square Matrix
        // nextCol: the next position of column in the Square Matrix
        int nextRow, nextCol;
        int curRow = 0; // the current Row in the Square Matrix
        // the current column in the middle of the Square Matrix
        int curCol = size / 2;
        /**
         * That's mean when programmers want to build the Square Matrix,
         * the first position of the Square Matrix is at the position:
         * the first row (curRow) and in the middle column (curCol)
         */
        
        /**
         * scan all the elements in the Square Matrix from 1 to 
         * (size * size). We must scan the Square Matrix from 1 because
         * in the Default constructor, we have initialized the value 1
         * in the first row at the middle column of the Square Matrix. 
         */
        for(int i = 0; i < ((size * size) - 1); i++){
            /**
             * (step % size == 0): if the position: nextRow and nextCol
             * is stayed at the position have been taken already or the
             * value of step % size == 0.
             * At this time, you should move down one row and keep the
             * column original.
             */
            if(step % size == 0){
                // move down one row
                nextRow = curRow + 1;
                // nextCol is the curCol (nextCol is not change)
                nextCol = curCol;
            }else{ // otherwise
                /* The next postion of the Square Matrix is obey the rule:
                moveUp one row and move to the right one column.*/
                // move up one row
                nextRow = curRow - 1;
                // if curRow is the first row => nextRow is not exist
                if(nextRow == -1){
                    // nextRow is the last row of 
                    // the Square Matrix
                    nextRow = size - 1;
                }
                // move one column to the right
                nextCol = curCol + 1;
                // if curCol is the last column => nextCol is the 
                // (last column + 1) => out of bound checking
                if(nextCol == size){
                    // in this case, nextCol is the first column of 
                    // the Square Matrix
                    nextCol = 0;
                }
            }
            /* Assigned the ++step variable to nextRow and nextCol 
            position of the Square Matrix.
            ++step is similar to step = step + 1, but ++step means:
            we increament the step to 1 unit, and then we assign new value
            of step variable to mSquare[nextRow][nextCol]. */
            mSquare[nextRow][nextCol] = ++step;
            /**
             * After nextRow and nextCol is assigned to the Square Matrix.
             * We should assign the nextRow to curRow (curRow = nextRow;),
             * and we assign the nextCol to curCol (curCol = nextCol;)
             * curRow will get the value of nextRow, 
             * curCol will get the value of nextCol
             * to implement in the next loop until the loop is ended.
             */
            curRow = nextRow;
            curCol = nextCol;
        }
    }
    
    /**
     * Accessor: getPivotValue()
     * Pre-condition: none
     * Post-condition: return pivot: the value of the middle of the 
     * row and middle of column of the Square Matrix and 
     * multiple with the size of the board.
     */
    private int getPivotValue(){
        // pivot: the value of the middle of the row and middle of column
        // of the Square Matrix and multiplie with the size of the board.
        return (mSquare[size / 2][size / 2] * size);
    }
    
    /**
     * Accessor: checkLogic()
     * Pre-condition: the getPivotValue() method must be defined
     * Post-condition: the checkLogic() will use the count variable to
     * count, if the pivot is not equal to one of the sum of main diagonal,
     * opposite diagonal, the sum of each row, and sum of each column
     * the count variable will be increamented; other wise, count == 0
     * If count == 0 => checkLogic() == true, otherwise, checkLogic = false
     */
    private boolean checkLogic(){
        boolean flag = false;
        // if the pivot is not equal to one of the sum of main diagonal,
        // opposite diagonal, the sum of each row, and sum of each column,
        // the count variable will be increamented; other wise,
        // count = 0
        int count = 0;
        int sumMainDiagonal = 0, sumOppositeDiagonal = 0;
        // I create an array of rowSum type interger indicates the sum
        // of each row in the square matrix.
        int[] rowSum = new int[size];
        // I create an array of columnSum type interger indicates the sum
        // of each column in the square matrix.
        int[] columnSum = new int[size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                rowSum[row] += mSquare[row][col];
                columnSum[col] += mSquare[row][col];
                if(row == col){
                    sumMainDiagonal += mSquare[row][col];
                }
                if(row + col == size - 1){
                    sumOppositeDiagonal += mSquare[row][col];
                }
            }
        }
        // check the sum of main diagonal with pivot value
        if(sumMainDiagonal != getPivotValue()){
            count++;
        }
        // check the sum of opposite diagonal with pivot value
        if(sumOppositeDiagonal != getPivotValue()){
            count++;
        }
        // check the sum of each row with pivot value
        for(int row = 0; row < size; row++){
            if(rowSum[row] != getPivotValue()){
                count++;
            }
        }
        // check the sum of each column with pivot value
        for(int col = 0; col < size; col++){
            if(columnSum[col] != getPivotValue()){
                count++;
            }
        }
        
        if(count == 0){
            // the sum's value of each row, each column, main diagonal
            // and opposite diagonal equals to pivot value.
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
    
    /**
     * Accessor: tallyLogic()
     * @return result
     * Pre-condition: checkLogic() and getPivotValue method must be defined
     * Post-condition: if the checkLogic() == true => output the size of
     * matrix and the number of pivot value.
     * If checkLogic() == false => This is not a Magic Square
     */
    private String tallyLogic(){
        String result = "";
        if(checkLogic()== true){
            result += "Each row, column, main diagonal, and "
                    + "opposite diagonal sum\n of the " + size + "X"
                    + size + " matrix to the same value: " 
                    + getPivotValue();
        }else{
            result += "This is not a Magic Squares.";
        }
        return result;
    }
    
    /**
     * Muatator: outputRunAgain()
     * Pre-condition: none
     * Post-condition: output the information to run again the
     * application
     */
    public void outputRunAgain(){
        System.out.println("Do you want to run the GENERATING MAGIC "
                + "SQUARES APPLICATION again?: ");
        System.out.println("Enter \"Y\" or \"y\" to run agian.");
        System.out.println("Enter any key on the keyboard to "
                + "finish \nthe GENERATING MAGIC SQUARES APPLICATION.");
        System.out.print("We choose the character: ");
    }
    
    /**
     * Muatator: instructions()
     * Pre-condition: none
     * Post-condition: output the instructions() how to run the
     * Generating Magic Squares Application
     */
    public static void instructions(){
        System.out.println("Welcome to Generating Magic Squares "
                + "Application is programmed by \nthe "
                + "Java Programming Language.");
        System.out.println("In this application, programmers will choose a"
            + " number \nin the range from 1 to 15,"
            + " and this number must be "
            + "an ODD Value; \n"
            + "otherwise, they must be\n enter again until "
            + "they enter a number correctly.");
        System.out.println("After they enter an odd value in the range "
            + "[1 - 15], the \n"
                + "application will construct a Square Matrix "
            + "with n by n size\n (n is la odd value from 1 to 15). Next, "
            + "the application \nwill put the number with value 1 in the "
            + "first row and \nin the middle of the column of the Square "
            + "Matrix. \nThe next value (number 2) will be place at the "
            + "position: \nMOVE UP ONE ROW AND TO THE RIGHT ONE COLUMN.");
        System.out.println("1) In the Square Matrix, if the current value "
            + "is placed at the \nfirst row, the next value will be place "
            + "in the last row \n(that means it is \"wrapping\" around to "
            + "the last row). \nIf the current value is placed at the "
            + "last column, \nthe next value will be place in the "
            + "first column \n(that means it is \"wrapping\" around "
            + "the right side \nof the board to the left "
            + "side of the board).");
        System.out.println("2) If the next value have been filled already "
            + "(that means the \nposition for the next value have been "
            + "filled (up one row \nand right one column) of current "
            + "value) => The next value\n will place at the DOWN ONE "
            + "ROW AND DO NOT CHANGE THE \nCOLUMN of the current value.");
        System.out.println("Step 1 and 2 will repeat over and over, the "
            + "board will be terminated\n if all the position in the "
            + "Square Matrix is filled full\n position (the value = n * n)"
            + ". Example, if programmer choose\n number 7, the matrix is "
            + "7x7 size, application will construct \na Square Matrix and"
            + " terminated if value = 7 * 7 = 49 (all \nposition have "
            + "had the value).");
        System.out.println("After the application have constructed a "
            + "Square Matrix, they will \nask the programmers do they "
            + "want to run again application.\n If they choose \"y\" "
            + "or \"Y\", the application will \nrun again and they will "
            + "choose a number to construct a Square \nMatrix; otherwise, "
            + "the application will be terminated.");
    }
}
