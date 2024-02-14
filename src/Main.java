public class Main {
    public static void main(String[] arg) throws InterruptedException {
        Reader reader = new Reader();
        Thread thread = new Thread(() -> reader.print("WELCOME TO CSTAD!"));
        Thread thread1 = new Thread(() -> reader.print("*".repeat(20)));
        Thread thread2 = new Thread(() -> reader.print("Don't give up this opportunity, Do you best first!"));
        Thread thread3 = new Thread(() -> reader.print("-".repeat(20)));
        Thread thread4 = new Thread(() -> {
            reader.print("Downloading............. Finished");
            System.out.print("Download Completed 100%");
        });
        thread.start();
        thread.join();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();

    }
}

class Reader{
    public synchronized void printWord(String word) {
        for (int i = 0 ; i<word.length(); i++){
            System.out.print(word.charAt(i));
            try {
                Thread.sleep(50);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }
    public synchronized void print(String word){
        this.printWord(word);
    }
}

