package Jantar;

public class Mesa {

    private Garfo garfos[] = {new Garfo(),
         new Garfo(), new Garfo(),
         new Garfo(), new Garfo(),
         new Garfo()};

    public void colocaGarfo(int id, Garfo garfo) {
        garfos[id] = garfo;
    }

    public Garfo pegaGarfo(int id) {
        Garfo temp = garfos[id];
        garfos[id] = null;
        return temp;

    }

}
