package FinalizeEx;

public class Finalize {
    private static class Test{
        private String name;
        private boolean isFinal;
        public Test(String name) {
            isFinal = false;
            this.name = name;
        }
        public void setFinal() {
            isFinal = true;
        }
        @Override
        protected void finalize() throws Throwable {
            if (!isFinal) {
                System.out.println("You are trying to delete not finalized object " + this);
            }
            super.finalize();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1_000_000_00; i++) {
                new Test(i+"");
        }
    }
}