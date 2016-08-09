/**
Design  a snake game that is played on a devide with screen size = width * height. 
The snake is initially positioned at the top of the left corner (0,0) withlength - 1
you are given a list of foods positions in row-column order.
When a snake eats its length and games score both increase by 1
Each food appears one by one on the screen
**/

/**
Idea of the snake game
Snake should be represented as a form of bounded queue in 2 dimenstional space
- Dequeue of coord would do
But Dequeue doesnt provide with effecient look up of coods where the body of snake is
- so additional set of coord
The game space can be represented as 2d grid
**/
public class SnakeGame{

  Set<Integer> set; //store hash of coord instead of coord 
  Dequeue<Integer> body;
  int score;
  int[][] food; 
  int width;
  int height;
  public SnakeGame(int w, int h, int[][] food){
    width = w;
    height = h;
    this.food = food;
    set = new HashSet<>();
    body = new LinkedList<>();
    body.offerLast(0);
  }
  
  int move(String direction){
     if(score == -1){
      return -1; // game is over
     }
     
     int rowHead = body.peekFirst()/width;
     int colHead = body.peekFirst()%width;
     switch(direction){
      case "U": rowHead--;
              break;
      case "D": rowHead++;
              break;
      case "L": colHead--;
              break;
      default: colHead++;
     }
     
     int head = rowHead*width+colHead; //using maximum of row to store coord in one integer
                                       // intelligent hash
     set.remove(body.peekLast()); // the snake moved forward. so remove last position
     if(rowHead < 0 || rowHead == height || colHead <0|| colHead == width || set.contains(head)) return -1; //conditions for game over
     
     set.add(head); //add new position
     body.offerFirst(head);
     
     
     //find food. 
     // food appear row col order
     // one appears only after other is done
     if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]){
      set.add(body.peekLast()); // if it eats food, it grows by 1. so move head nad keep tail
      foodIndex++;
      return ++score;
      }
      
      body.pollLast(); //  move the tail. as it hasnt eaten food
      return score;
     
  }
  
  
}
