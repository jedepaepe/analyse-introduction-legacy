package n2nself.socialnetwork;

public class DemoN2NSelf {
    public static void main(String[] args) {
        Person gudule = new Person("Gudule", "Bruxelles", "gudule@bxl.be", "1");

        Person oscar = new Person("Oscar", "Wilde", "oscar@wilde.ir", "2");
        oscar.friends.add(gudule);
        gudule.friends.add(oscar);

        Person yvette = new Person("Yvette", "Horner", "yvette@horner.fr", "3");
        yvette.friends.add(oscar);
        oscar.friends.add(yvette);

        Person raoult = new Person("Raoult", "de Godewarsvelde", "raoult.deg.fr", "4");
        raoult.friends.add(gudule);
        gudule.friends.add(raoult);
        raoult.friends.add(oscar);
        oscar.friends.add(raoult);
        raoult.friends.add(yvette);
        yvette.friends.add(raoult);

        // nous voyons que nous pouvons factoriser le code
        // en ajoutant une méthode "makeFriend(Person friend)
    }
}
