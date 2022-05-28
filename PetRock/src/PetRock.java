public class PetRock {
    private String name;
    private boolean happy = false;

    private String pet = null;


    public PetRock(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPet() {
        return this.pet;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage(){
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }
    public int getFavNumber(){
        return 42;
    }

    public void waitTilHappy(){
        while (happy){

        }
    }

}
