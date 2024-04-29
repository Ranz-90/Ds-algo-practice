package array;

import java.util.Optional;

public class JumPGame {
    public static void main(String[] args){
/*        Optional<String> s = Optional.of("test");
        s.map(String::toUpperCase);
        assertEquals(Optional.of(Optional.of("STRING")),
                Optional
                        .of("string")
                        .map(s -> Optional.of("STRING")));*/

        //assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));

        //int[] input = {1, 2, 0, 3, 0, 0};
        int[] input = {1, 0, 2};
        int currentIndex = 0;
        int len = input.length;

        while(currentIndex <len){
            if(input[currentIndex] > 0){
                currentIndex = currentIndex +input[currentIndex] ;
                if(currentIndex >= len ){
                    System.out.println(1);
                }
            }
            else if (input[currentIndex] == 0){
                System.out.println(0);
                break;
            }
        }
    }
}
