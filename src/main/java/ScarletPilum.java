public class ScarletPilum {
    public static void main(String[] args){
        try {
            System.out.println("Scarlet Pilum: Starting Application.");
            view.StartScreenView gui = new view.StartScreenView();
            gui.start();
            System.out.println(" GUI Started.");
        } catch (Exception e) {
            System.err.println("Critical Error occurred.");
            e.printStackTrace();
            throw e;
        }

        /*try {
            new view.StartScreenView().start();
        } catch (Exception e) {
            System.err.println("Critical Error occurred.");
        }*/
    }
}



