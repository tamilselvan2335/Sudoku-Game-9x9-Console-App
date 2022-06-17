package pro;
import java.util.Random;
import java.util.Scanner;

public class Sudoku_game {
    Scanner sc = new Scanner(System.in);
	 static String[][]sudoku= {
    {"R0C0","R0C1","R0C2", "R0C3","R0C4","R0C5",  "R0C6","R0C7","R0C8"},
	{"R1C0","R1C1","R1C2", "R1C3","R1C4","R1C5",  "R1C6","R1C7","R1C8"},                 
	{"R2C0","R2C1","R2C2", "R2C3","R2C4","R2C5",  "R2C6","R2C7","R2C8"},
				
    {"R3C0","R3C1","R3C2", "R3C3","R3C4","R3C5",  "R3C6","R3C7","R3C8"},
    {"R4C0","R4C1","R4C2", "R4C3","R4C4","R4C5",  "R4C6","R4C7","R4C8"},
    {"R5C0","R5C1","R5C2", "R5C3","R5C4","R5C5",  "R5C6","R5C7","R5C8"},
		        
    {"R6C0","R6C1","R6C2", "R6C3","R6C4","R6C5",  "R6C6","R6C7","R6C8"},
    {"R7C0","R7C1","R7C2", "R7C3","R7C4","R7C5",  "R7C6","R7C7","R7C8"},
    {"R8C0","R8C1","R8C2", "R8C3","R8C4","R8C5",  "R8C6","R8C7","R8C8"},
		        };	 
	
	 
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		Sudoku_game sudo=new Sudoku_game();
		
		int[][] num=sudo.generate_9_Num();		
		String [][] generated_sudoku= sudo.create_own_sudoku(num);
		System.out.println("sudoku game 9x9");
		sudo.easy(generated_sudoku,num);
		sudo.user_input(generated_sudoku);
		
		}//main method end
	
	private void easy(String[][] easy,int[][] num) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			for(int j=0;j<easy[i].length;j++) {
			if(i==0&&j==num[0][0]||i==0&&j==num[0][1]||i==1&&j==num[0][2]||i==0&&j==num[1][0]||
			   i==2&&j==num[1][1]||i==2&&j==num[1][2]||i==2&&j==num[2][0]||i==2&&j==num[2][1]) 
					{continue;}
				sudoku[i][j]=" "+easy[i][j]+"  ";
			  }
			}
		for(int i=3;i<6;i++) {
			for(int j=0;j<easy[i].length;j++) {
			if(i==3&&j==num[0][0]||i==4&&j==num[1][0]||i==4&&j==num[1][2]||i==4&&j==num[2][1]||
			   i==4&&j==num[0][1]||i==5&&j==num[1][1]||i==5&&j==num[2][0]||i==5&&j==num[2][2]||
			   i==5&&j==num[0][2]||i==5&&j==8) {
					continue;}
				sudoku[i][j]=" "+easy[i][j]+"  ";
			  }
			}
		for(int i=6;i<9;i++) {
			for(int j=0;j<easy[i].length;j++) {
			if(i==6&&j==num[0][0]||i==6&&j==num[1][0]||i==6&&j==num[2][1]||i==6&&j==num[2][0]||
			   i==7&&j==num[0][1]||i==7&&j==2||i==7&&j==num[1][1]||i==7&&j==7||
			   i==8&&j==num[0][2]||i==8&&j==num[1][2]||i==8&&j==num[2][2]||i==8&&j==6)
				 {continue;}
				sudoku[i][j]=" "+easy[i][j]+"  ";
			  }
			}
	}//easy() end

	private void user_input(String [][] user_in) {
		// TODO Auto-generated method stub
		int count=0;
		while(true){
		System.out.println("<---------------------------------------------->");
		System.out.println();
		
		for(int i=0;i<sudoku.length;i++) {
			for(int j=0;j<sudoku[i].length;j++) {
		      System.out.print(sudoku[i][j]+" ");
		      if(j==2||j==5) {
		      System.out.print("   ");
		      }
			}
			System.out.println();
			 if(i==2||i==5) {
		         System.out.println();}	
		}
		
		 System.out.println();
	     System.out.println("<---------------------------------------------->");
	     
         System.out.println("Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7");
         String name=sc.nextLine();
         System.out.println("Enter Value:");
         String val=sc.nextLine();
         char char1=name.charAt(1);//2
         char char2=name.charAt(3);  //1     
         int a=Integer.parseInt(String.valueOf(char1));//INT A= 2
         int b=Integer.parseInt(String.valueOf(char2));//INT b=1
		 if(val.equals(user_in[a][b])){
			 sudoku[a][b]=" "+val+"  ";
		 }
		 else {
	         System.out.println("R"+a+" C"+b+" Wrong Value:");
		 }
		 
		 for(int i=0;i<sudoku.length;i++) {
				for(int j=0;j<sudoku[i].length;j++) {
					String s=" "+user_in[i][j]+"  ";
					 if(s.equals(sudoku[i][j])) {
						count++;
					}
				}
				}

		 if(count==81) {
			 for(int i=0;i<sudoku.length;i++) {
					for(int j=0;j<sudoku[i].length;j++) {
				      System.out.print(sudoku[i][j]);
				      if(j==2||j==5) {
				      System.out.print(" ");
				      }
					}
					System.out.println();
					 if(i==2||i==5) {
				         System.out.println();}	
					}
			 System.out.println();
	         System.out.println("!!!!!!! Congratulations!!!! You Won !!!!!!!");
	         break;
		 }
		 else {count=0;}
         
						
		}//while end
	}//user_input end

	private String [][] create_own_sudoku(int[][] num) {
		// TODO Auto-generated method stub
		String[][]convert_num=new String[3][3];
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				String convert_String=String.valueOf(num[i][j]);
				convert_num[i][j]=convert_String;
			}

		}
		
	int[] index_value= {0,7,4,8,2,5,3,1,6,1,6,3,7,4,2,5,8,0,2,5,7,
				        4,8,0,1,6,3,8,0,5,2,7,3,6,4,1,4,1,6,5,0,8,
				        7,3,2,5,2,8,3,1,6,0,7,4,3,8,0,6,5,1,4,2,7,
				        7,3,1,0,6,4,2,5,8,6,4,2,1,3,7,8,0,5};
		
		String [][] own_sudoku=new String[9][9];
		int index_val=0;//1
		while(index_val<index_value.length) {
			for(int i=0;i<convert_num.length;i++) {
				for(int j=0;j<convert_num[i].length;j++) {
					for(int p=0;p<own_sudoku.length;p++) {
						own_sudoku[p][index_value[index_val]]=convert_num[i][j];//4
						index_val++;
					}
				}				
			}
		}
		return own_sudoku;
	}// create_own_sudoku end

	private int[][] generate_9_Num() {
		int[][] num=new int[3][3];
		boolean arfalse=true;
		 for(int i=0;i<num.length;i++) {
			 for(int j=0;j<num[i].length;j++) {
		   Random rand = new Random();
		   int random_number=(int) (Math.random()*(((9 - 1) + 1) )+1);

		   for(int p=0;p<num.length;p++) {
				for(int q=0;q<num[p].length;q++) {    // 4
					if(i==p&&j==q) {continue;}
					if(random_number==num[p][q]) {   // 4 01 02
						arfalse=false;               // 10 11 12
						                             // 20 21 22
					}
				  }
				 }
		   if(arfalse) {num[i][j]=random_number;
			   
		   }
		   else {j--;}
		   arfalse=true;
				}
		 }
		 return num;
	}//generate_9_Num-end
 
	
	}
			
/*
OUTPUT:
sudoku game 9x9
<---------------------------------------------->

 5   R0C1 R0C2     7    4   R0C5     3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1   R2C4  2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R0C1
Enter Value:
1
<---------------------------------------------->

 5    1   R0C2     7    4   R0C5     3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1   R2C4  2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R0C2
Enter Value:
9
<---------------------------------------------->

 5    1    9       7    4   R0C5     3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1   R2C4  2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R0C5
Enter Value:
8
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1   R2C4  2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R2C4
Enter Value:
4
R2 C4 Wrong Value:
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1   R2C4  2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R2C4
Enter Value:
5
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4   R4C1 R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R4C1
Enter Value:
8
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4    8   R4C2     3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R4C2
Enter Value:
5
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9   R3C5     7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R3C5
Enter Value:
4
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1      R5C3 R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R5C3
Enter Value:
2
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2   R5C4  5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R5C4
Enter Value:
6
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8   R5C7 R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R5C7
Enter Value:
3
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4      R8C3  8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R8C3
Enter Value:
9
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4   R7C4  6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R7C4
Enter Value:
2
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7   R6C5    R6C6 R6C7  3   
 3   R7C1 R7C2     4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R6C5
Enter Value:
1
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7    1      R6C6 R6C7  3   
 3   R7C1 R7C2     4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R7C1
Enter Value:
5
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7    1      R6C6 R6C7  3   
 3    5   R7C2     4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R7C2
Enter Value:
6
R7 C2 Wrong Value:
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7    1      R6C6 R6C7  3   
 3    5   R7C2     4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R7C2
Enter Value:
7
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9   R6C2     5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R6C2
Enter Value:
6
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9   R7C7  1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R7C7
Enter Value:
8
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3   R5C8 

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R5C8
Enter Value:
4
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7      R4C6  2   R4C8 
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R4C6
Enter Value:
6
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2   R4C8 
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R4C8
Enter Value:
9
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7 R2C8 

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R2C8
Enter Value:
8
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6 R2C7  8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R2C7
Enter Value:
9
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2      R2C6  9    8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R2C6
Enter Value:
4
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2       4    9    8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7   R8C8 

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R8C8
Enter Value:
6
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2       4    9    8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6 R6C7  3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7    6   

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R6C7
Enter Value:
4
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2       4    9    8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1      R6C6  4    3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7    6   

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R6C6
Enter Value:
2
<---------------------------------------------->

 5    1    9       7    4    8       3    6    2   
 2    4    8       6    3    9       1    5    7   
 7    6    3       1    5    2       4    9    8   

 6    3    2       8    9    4       7    1    5   
 4    8    5       3    1    7       6    2    9   
 9    7    1       2    6    5       8    3    4   

 8    9    6       5    7    1       2    4    3   
 3    5    7       4    2    6       9    8    1   
 1    2    4       9    8    3      R8C6  7    6   

<---------------------------------------------->
Enter capital [R(1-9)] & [C(1-9)]--,Like-->R2C7
R8C6
Enter Value:
5
 5   1   9    7   4   8    3   6   2  
 2   4   8    6   3   9    1   5   7  
 7   6   3    1   5   2    4   9   8  

 6   3   2    8   9   4    7   1   5  
 4   8   5    3   1   7    6   2   9  
 9   7   1    2   6   5    8   3   4  

 8   9   6    5   7   1    2   4   3  
 3   5   7    4   2   6    9   8   1  
 1   2   4    9   8   3    5   7   6  

!!!!!!! Congratulations!!!! You Won !!!!!!!

*/