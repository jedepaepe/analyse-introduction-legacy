package n2n.firmworker;

public class DemoN2N {
    public static void main(String[] args) {
        Worker helene = new Worker("matricule-1", "Hélène", "Zeus",
                "helene@troie.gr", "00991",
                new Address("Rue du Roi", "1", null, null, null,
                        23100, "Sparte", "Grèce"));

        Worker ulysse = new Worker("matricule-2", "Ulysse", "d'Ithaque",
                "ulysse@ithaque.gr", "00981",
                new Address("Rue du Palais", "1", null, null, null,
                        83100, "Vathy ", "Greece"));

        Firm zaventemAirport = new Firm("BE 0890.082.292", "Zaventem Airport",
                new Address("Boulevard Auguste Reyers", "80", null, null, null,
                        1030,"Bruxelles", "Belgique"));
        zaventemAirport.workers.add(helene);
        helene.firms.add(zaventemAirport);

        Firm epfc = new Firm("BE 0435.187.629", "EPFC",
                new Address("Avenue de l'Astronomie",  "19", null, null, null,
                        1210, "Bruxelles", "Belgique"));
        epfc.workers.add(helene);
        helene.firms.add(epfc);
        epfc.workers.add(ulysse);
        ulysse.firms.add(epfc);
    }
}
