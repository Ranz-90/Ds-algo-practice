public class PrintOddEvenUsingThread  {

    static class Oddeven{
        public volatile int counter = 1;
        public int N;

        public Oddeven(int size) {
            this.N = size;
        }

        public synchronized void printOdd(){


                while(counter < N){
                    while(counter%2==0){
                        try{
                            wait();
                        }
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }
                    System.out.print(counter);
                    counter++;
                    notify();
                }
        }
        public synchronized void printEven(){

                while(counter < N){
                    while(counter%2 !=0){
                        try{
                            wait();
                        }
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }
                    System.out.print(counter);
                    counter++;
                    notify();
                }
        }

    }



    public static void main(String[] args){
        int size = 10;
        Oddeven obj = new Oddeven(size);

        Thread t1= new Thread(() -> obj.printEven());

        Runnable t3 = () ->{

        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                System.out.println();
            }
        };



        Thread t2 = new Thread(() -> obj.printOdd());

        t1.start();
        t2.start();
    }

}
