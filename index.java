import java.util.*;

class Main {
  public static void main(String[] args) {
    TicTacToeStructure ticTacToe = new TicTacToeStructure();

    boolean isGameRunning = true;

    Scanner scanner = new Scanner(System.in);
    boolean isXLetter = true;
    
    while(isGameRunning) {
      
      boolean[][] currentPositions = ticTacToe.getPositions();
      String[][] currentData = ticTacToe.getData();
      
      for(int line=0; line < 3; line ++) {
        for(int column = 0; column < 3; column ++) {
          if(currentPositions[line][column]) {
            System.out.print(currentData[line][column] + "|");   
          } else {
            System.out.print("V|");
          }
        }
        System.out.println("");
      }
      
      System.out.println("As posicoes desse jogo vao de acordo com o seu Teclado numérico.");

      System.out.println("Digite a posicao numerica do campo:");
      int gamePosition = scanner.nextInt();

      switch(gamePosition) {
        case 7:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 0,0);
          break;
        case 8:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 0,1);
          
          break;
        case 9:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 0,2);
          
          break;
        case 4:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 1,0);
          
          break;
        case 5:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 1,1);
          
          break;
        case 6:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 1,2);
          
          break;
        case 1:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 2,0);
          
          break;
        case 2:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 2,1);
          
          break;
        case 3:
          ticTacToe.setDataAndPosition(isXLetter ? "X" : "O", 2,2);
          
          break;
        default:
          System.out.println("Posicao Invalida");
          break;
      }

      if(ticTacToe.checkIfHasAWinner()) {
        isGameRunning = false;
        System.out.println("Jogador " + (isXLetter ? "X" : "O") + "Venceu!");
      }
      isXLetter = !isXLetter;
    }
  }
}

class TicTacToeStructure {
  private boolean [][] positions;
  private String [][] data;
  
  TicTacToeStructure() {
    this.positions = new boolean[][] {
      {false, false, false},
      {false, false, false},
      {false, false, false}
    };

    this.data = new String[][] {
      {"", "", ""},
      {"", "", ""},
      {"", "", ""}
    };
  }

  public boolean checkIfHasAWinner() {
    if((this.positions[0][0] && this.positions[0][1] && this.positions[0][2]) && this.positions[0][0] == this.positions[0][1] == this.positions[0][2]) {
      return true;
    } else if((this.positions[1][0] && this.positions[1][1] && this.positions[1][2]) && (this.positions[1][0] == this.positions[1][1] == this.positions[1][2])) {
      return true;
    } else if((this.positions[2][0] && this.positions[2][1] && this.positions[2][2]) && (this.positions[2][0] == this.positions[2][1] == this.positions[2][2]) ) {
      return true;
    } else if((this.positions[0][0] && this.positions[1][0] && this.positions[2][0]) && (this.positions[0][0] == this.positions[1][0] == this.positions[2][0])) {
      return true;
    } else if((this.positions[0][1] && this.positions[1][1] && this.positions[1][1]) && (this.positions[0][1] == this.positions[1][1] == this.positions[1][1])) {
      return true;
    } else if((this.positions[0][2] && this.positions[1][2] && this.positions[1][2]) && (this.positions[0][2] == this.positions[1][2] == this.positions[1][2])) {
      return true;
    } else if((this.positions[0][0] && this.positions[0][0] && this.positions[2][2]) && (this.positions[0][0] == this.positions[0][0] == this.positions[2][2])) {
      return true;
    } else if((this.positions[0][2] && this.positions[0][0] && this.positions[2][0]) && (this.positions[0][2] == this.positions[0][0] == this.positions[2][0])) {
      return true;
    }

    return false;
  }

  public boolean[][] getPositions() {
    return this.positions;
  }

  public String[][] getData() {
    return this.data;
  }

  public void setDataAndPosition(String position, int line, int column) {
    this.positions[line][column] = true;
    this.data[line][column] = position;
  }
}
