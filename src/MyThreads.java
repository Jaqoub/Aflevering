public class MyThreads {

        static int i = 0;
        static int num = 0;
        static int count = 0;
        static String primeNumbers = "";
        public static synchronized void main(String[] args) {

            Thread t = new Thread(() -> {

                for( i = 1; i <= 100; i++){
                    count = 0;
                    for(num = i; num >= 1; num--){
                        if(i%num==0){
                            count = count +1;
                        }
                    }

                    if(count == 2){
                        primeNumbers = primeNumbers + i + " ";
                    }

                    add();

                }

            });

            Thread t2 = new Thread(() -> {
                synchronized (t) {

                }
                for(int i = 0; i < 100; i++) {
                    add();
                }
            });
            t.start();
            t2.start();
            System.out.println(count);
        }


        public static void add(){
            count++;
           System.out.println("Prime numbers from 1 to 100 are: ");
            System.out.println(primeNumbers + count);

        }





}
